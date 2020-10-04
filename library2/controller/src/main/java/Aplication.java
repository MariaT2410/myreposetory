import java.util.Random;
import java.util.Scanner;

public class Aplication {


    public static void main(String[] args) {
         FactoryLibrary booksView = new FactoryLibrary();
         Scanner in = new Scanner(System.in);

        System.out.println("Enter autor id: ");
        int autorId = in.nextInt();
        booksView.getBooksByAutorId(autorId);


    }
}
