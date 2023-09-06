
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        BookStore bookstore = new BookStore(FileHandler.readBooksFromFile("/Users/barakgoren/IntelliJ/Amazon/src/books.txt"), FileHandler.readUsersFromFile("/Users/barakgoren/IntelliJ/Amazon/src/users.txt", FileHandler.readBooksFromFile("/Users/barakgoren/IntelliJ/Amazon/src/books.txt")));
        User enteringUser = null;

        System.out.println("What would you like to do?:\n1. Login \n2. Register");
        Scanner in = new Scanner(System.in);
        if(in.nextLine().equals("Show books")) {
            for(Book book : FileHandler.readBooksFromFile("books.txt")) {
                System.out.println(book.getTitle());
            }
        }
        if(in.nextInt() == 1) {
            while(true) {
                while(enteringUser == null || enteringUser.getName().equals("ERROR USER")) {
                    enteringUser = MenuManager.displayLoginMenu(bookstore);
                }
                MenuManager.displayMainMenu(enteringUser, bookstore);

            }
        } else {
            LoginManager.register(bookstore);
        }
    }

}
