import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.print.Book;
import java.util.Random;
import java.util.Scanner;

public class Aplication {


    public static void main(String[] args) {
         FactoryLibrary booksView = new FactoryLibrary();
         Scanner in = new Scanner(System.in);

        System.out.println("Enter autor id: ");
        int autorId = in.nextInt();


        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();


        Book books[] = booksView.getBooksByAutorId(autorId).toArray(new Book[0]);
        for(int i=0;i<books.length;i++){

            System.out.println(gson.toJson(books[i]));

        }

    }
}
