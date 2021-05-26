import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.awt.*;
import java.lang.*;
import java.util.logging.Logger;
import java.lang.Class<ImagePainter>;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class Chessboard extends JFrame implements MouseListener, MouseMotionListener
{

    JLayeredPane layeredPane;
    JPanel board;
    JLabel chessPiece;
    Container originalParent = null;
    int xAdjustment;
    int yAdjustment;
    private Integer from,to;
    private Map map = new HashMap();
    private String[] coordinates = new String[]{
            "A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8",
            "A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7",
            "A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6",
            "A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5",
            "A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4",
            "A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3",
            "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2",
            "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1",
    };




    public Chessboard(){


        setIconImage(new ImageIcon((this.getClass().getResource("/game/board/nmegill.gif"))).getImage());

        Dimension boardSize = new Dimension(600, 600);

//  Use a Layered Pane for this application
        layeredPane = new JLayeredPane();
        layeredPane.setName("JLayeredPane1");
        getContentPane().add(layeredPane);
        getContentPane().setName("ContentPane1");

        layeredPane.setPreferredSize( boardSize );
        layeredPane.addMouseListener( this );
        layeredPane.addMouseMotionListener( this );


//  Add a chess board to the Layered Pane
        board = new JPanel();
        board.setName("JPanel-board1");
        layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
        board.setLayout( new GridLayout(8, 8) );
        board.setPreferredSize( boardSize );
        board.setBounds(0, 0, boardSize.width, boardSize.height);



        for (int i=0; i<64; i++)
        {
            JPanel panel = new JPanel( new BorderLayout() );
            panel.setName("JPanel-panel1");
            board.add(panel);
            ImagePainter blackSquare =null;
            ImagePainter whiteSquare =null;
            try{

                java.net.URL url = this.getClass().getResource("b.gif");
                blackSquare = new ImagePainter((new ImageIcon(url)).getImage());
                String name1 = "BlackEmptySquare" + "_" + (new Integer(i)).toString();
                blackSquare.setName(name1);

                url = this.getClass().getResource("w.gif");
                whiteSquare = new ImagePainter((new ImageIcon(url)).getImage());
                String name2 = "WhiteEmptySquare" + "_" + (new Integer(i)).toString();
                whiteSquare.setName(name2);
            }catch (Exception e){
            }

            int row = (i / 8) % 2;
            int rowNumber = Math.abs(i/8);
            String pos = null;

            JPanel square = (JPanel) board.getComponent(i);

            if (row == 0){

                if(i%2 == 0){
                    square.add(blackSquare);
                }else{
                    square.add(whiteSquare);
                }
            }else{

                if(i%2 == 0){
                    square.add(whiteSquare);
                }else{
                    square.add(blackSquare);
                }
            }
            map.put(new Integer(i),coordinates[i]);
            board.add(square, i);
        }//end for loop

    }


    private ImagePainter loadQueen(int type, int pos){
        final int BLACK_QUEEN = 1;
        final int WHITE_QUEEN = 2;
        ImagePainter square = null;

        if(type == BLACK_QUEEN){
            java.net.URL url = this.getClass().getResource("Qb.gif");
            square = new ImagePainter((new ImageIcon(url)).getImage());
            String name = "BlackQueenSquare" + "_" + (new Integer(pos)).toString();
            square.setName(name);
        }else if (type == WHITE_QUEEN){
            java.net.URL url = this.getClass().getResource("Qw.gif");
            square = new ImagePainter((new ImageIcon(url)).getImage());
            String name = "WhiteQueenSquare" + "_" + (new Integer(pos)).toString();
            square.setName(name);
        }
        return square;
    }

    private Integer getComponentPosition( Component c ){


        String name = c.getParent().getName();
        Point parentLocation = c.getParent().getLocation();
        int column = parentLocation.x/c.getParent().getWidth();
        int row = parentLocation.y/c.getParent().getHeight();
        int pos = row*8 + column;
        return new Integer(pos);
    }


    /*
    **  Add the selected chess piece to the dragging layer so it can be moved
    */
    public void mousePressed(MouseEvent e)
    {
        final String METHOD_NAME = "mousePressed";
        chessPiece = null;

        Component c =  board.findComponentAt(e.getX(), e.getY());

        originalParent = c.getParent();

        String name = c.getParent().getName();


        Point parentLocation = c.getParent().getLocation();


        xAdjustment = parentLocation.x - e.getX();


        yAdjustment = parentLocation.y - e.getY();


        chessPiece = (JLabel)c;

        String squareName = chessPiece.getName();


        chessPiece.setLocation(e.getX()+xAdjustment, e.getY()+yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());

        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);

        to=getComponentPosition(chessPiece);

    }//end method






    /*
    **  Drop the chess piece back onto the chess board
    */
    public void mouseReleased(MouseEvent e){

        final int BLACK_QUEEN = 1;
        final int WHITE_QUEEN = 2;

        JLabel newChessPiece = null;
        chessPiece.setVisible(false);
        Component c =  board.findComponentAt(e.getX(), e.getY());

        String squareName = chessPiece.getName();
        Container parent = c.getParent();

        if (c instanceof JPanel){


            String name = c.getParent().getName();

            parent.remove(0);

            int start = chessPiece.getName().indexOf("_");
            String posStr = chessPiece.getName().substring(start+1);

            int pos = new Integer(posStr).intValue();


            if(squareName.startsWith("BlackEmptySquare")){

                chessPiece = loadQueen(BLACK_QUEEN, pos);
            }else if(squareName.startsWith("WhiteEmptySquare")){

                chessPiece = loadQueen(WHITE_QUEEN, pos);
            }
            parent.add(chessPiece, pos);
//originalParent.add(chessPiece);
        }else{
            parent.add(chessPiece);
        }
        chessPiece.setVisible(true);
    }//end method


    public void mouseDragged(MouseEvent e){}
    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args){
        JFrame frame = new Chessboard();
        frame.setName("fame1");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("Queen's_Eight");
        frame.pack();
        frame.setResizable( false );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//end method

}//end class





public class ImagePainter extends JLabel {


    private Image image;


    public ImagePainter(Image image){
        final String METHOD_NAME = "ImagePainter";
        this.image=image;

        setScaledSize(75,75);

        try{
            Thread.sleep(2);
        }catch(Exception ex){
         //   logger.error(METHOD_NAME + "Exception caught", ex);
        } //needed
    }
    public void setScaledSize(int w, int h){
        final String METHOD_NAME = "setScaledSize";
        image = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
    }
    public void paintComponent(Graphics g) {
        final String METHOD_NAME = "paintComponent";
        super.paintComponent(g);
        Rectangle r = g.getClipBounds();
        g.drawImage(image, r.x, r.y, r.width+r.x, r.height+r.y,
                r.x, r.y, r.width+r.x, r.height+r.y, null);
    }
}
