import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {

    public static User displayLoginMenu(BookStore bookstore) {
        return LoginManager.login(bookstore);
    }


    public static void displayMainMenu(User user, BookStore bookstore) {
        Scanner in = new Scanner(System.in);
        System.out.println("----------------------\nHello " +Main.ANSI_GREEN+ user.getName()+Main.ANSI_RESET + ", select the action you would like to perform:\n");
        System.out.println("1. Search for a book.\n2. View user details\n3. Purchase a book.\n4. Logout\n----------------------");

        int input = -1;
        while(input == -1) {
            System.out.print("Number: ");
            try {
                input = in.nextInt();
                if(input < 1 || input > 4) {
                    System.out.println("Number must be between 1 to 4");
                    input = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Must enter number");
                in.nextLine();
            }
        }

        switch(input) {
            case 1:
                System.out.println("You select to search a book");
                ArrayList<Book> resultList = bookstore.searchBooks();
                System.out.println("----------------Search result----------------");
                purchaseMenu(resultList, user);
                System.out.println("\nPress any button to continue\n--------------------");
                String nextAction1 = in.next();
                break;
            case 2:
                System.out.println("--------------------\nYou select to view your details");
                user.displayUserDetails();
                System.out.println("\nPress any button to continue\n--------------------");
                String nextAction2 = in.next();
                break;
            case 3:
                System.out.println("You select to purchase a book");
                purchaseMenu(bookstore.getBooks(), user);
                break;
            case 4:
                System.out.println("Goodbye " + user.getName());
                user.setName("ERROR USER");
        }
    }
    public static void purchaseMenu(ArrayList<Book> books, User user) {
        for(int i = 0; i < books.size(); i++) {
            System.out.println((i+1) +" "+books.get(i).toString());
        }
        System.out.println("Do you want to buy a book from the search result? y/n");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("y") || input.equals("Y")) {
            System.out.print("Choose book number: ");
            int bookIndex = in.nextInt() - 1;
            System.out.println("You bought the book: "+books.get(bookIndex).getTitle());
            FileHandler.updateUserPurchaseFile(user.getEmail(), books.get(bookIndex).getIsbn());
            user.purchaseBook(books.get(bookIndex));
        } else if(input.equals("n") || input.equals("N")) {
            System.out.println("OK");
        } else {
            System.out.println("Must choose Y or N");
        }
    }
}
