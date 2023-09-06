import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookStore {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public BookStore(ArrayList<Book> books, ArrayList<User> users) {
        this.books = books;
        this.users = users;
    }

    public int getUserIndex(String email) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }
    public ArrayList<User> getUsers(){
        return this.users;
    }
    public ArrayList<Book> getBooks(){
        return this.books;
    }
    public ArrayList<Book> searchBooksByName(String query) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getTitle().toLowerCase().contains(query)) {
                result.add(books.get(i));
            }
        }
        return result;
    }
    public ArrayList<Book> searchBookByAuthor(String query){
        ArrayList<Book> result = new ArrayList<Book>();
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getAuthor().toLowerCase().contains(query)) {
                result.add(books.get(i));
            }
        }
        return result;
    }
    public ArrayList<Book> searchBookByIsbn(String query){
        ArrayList<Book> result = new ArrayList<Book>();
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getIsbn().contains(query)) {
                result.add(books.get(i));
            }
        }
        return result;
    }
    public ArrayList<Book> searchBooks() {
        ArrayList<Book> result = new ArrayList<Book>();
        Scanner in = new Scanner(System.in);
        System.out.println("\n----------------------\n1. Search by Title.\n2. Search by Author\n3. Search by ISBN\n----------------------");

        int input = -1;
        while(input == -1) {
            System.out.print("Number: ");
            try {
                input = in.nextInt();
                if(input < 1 || input > 3) {
                    System.out.println("Number must be between 1 to 3");
                    input = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Must enter number");
                in.nextLine();
            }
        }
        in.nextLine();
        switch(input) {
            case 1:
                System.out.print("Enter Name: ");
                String nameInput = in.nextLine();
                nameInput = nameInput.toLowerCase();
                result = this.searchBooksByName(nameInput);

                break;
            case 2:
                System.out.print("Enter Author name: ");
                String authorInput = in.nextLine();
                authorInput = authorInput.toLowerCase();
                result = this.searchBookByAuthor(authorInput);
                break;
            case 3:
                System.out.print("Enter ISBN number: ");
                String isbnInput = in.nextLine();

                result = this.searchBookByIsbn(isbnInput);
                break;
        }
        return result;
    }
}
