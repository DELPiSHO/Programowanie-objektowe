import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        isbn = isbn.replaceAll("([^\\d])", "");
        if (sprawdzISBN(isbn))
            System.out.println("Numer jest poprawny");
            else
            System.out.println("Numer nie jest poprawny");
    }

        public static boolean sprawdzISBN(String isbn){
             isbn = isbn.replaceAll("-", "");
            int suma = 0;
            //int cyfra;
            for (int i = 0; i < isbn.length()-1; i++) {
                //cyfra = Integer.parseInt(isbn.substring(i,i + 1));
                if (i % 2 == 0) {
                    suma += 1 * Integer.parseInt(isbn.valueOf(isbn.charAt(i)));
                } else
                    suma += 3 * Integer.parseInt(isbn.valueOf(isbn.charAt(i)));
            }
//          128 = 128 % 10 = 8 - 10 = -2 => 2
            int sprawdz = 10 - (suma % 10);

            if ( sprawdz == 10 )
            {
                sprawdz = 0;
            }

            return (sprawdz == Integer.parseInt(isbn.valueOf(isbn.charAt(12))));
            //int sprawdz = 10 - (suma % 10);
            /*
            if (Integer.parseInt(isbnTrue.valueOf(isbnTrue.charAt(isbnTrue.length()))) == (10 - suma % 10))
                return true;
            else
                return false;
              //  return sprawdz == Integer.parseInt(isbnTrue.substring(12));
*/
            //return (Integer.parseInt(isbnTrue.valueOf(isbnTrue.charAt(13))) == (10 - suma % 10));
    }
}
