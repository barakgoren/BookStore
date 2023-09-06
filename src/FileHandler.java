import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    public static String encryptPass(String password, int key) {
        String encryptedPassword = "";
        for(int i = 0; i < password.length(); i++) {
            encryptedPassword += (char)(password.charAt(i) + key);
        }
        return encryptedPassword;
    }

    public static void registerUser(User newUser) {
        File users = new File("/Users/barakgoren/IntelliJ/BookStore/src/users.txt");
        try {
            FileWriter writer = new FileWriter(users, true);
            writer.append(newUser.toString());
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static ArrayList<Book> readUsersBooks(String userEmail, ArrayList<Book> fromBooks){
        File purchases = new File("/Users/barakgoren/IntelliJ/BookStore/Purchases/"+userEmail+"_purchases.txt");
        ArrayList<Book> books = new ArrayList<Book>();

        try {
            Scanner input = new Scanner(purchases);
            while(input.hasNextLine()) {
                String isbn = input.nextLine();
                for(int i = 0; i < fromBooks.size(); i++) {
                    if(fromBooks.get(i).getIsbn().equals(isbn)) {
                        books.add(fromBooks.get(i));
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            books = null;
        }
        return books;
    }
    public static ArrayList<User> readUsersFromFile(String filename, ArrayList<Book> allBooks) {
        File myFile = new File(filename);
        String data;
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("Name", "Author", 9.99, "ISBN"));

        try {
            Scanner input = new Scanner(myFile);

            while(input.hasNextLine()) {
                data = input.nextLine();
                String[] splittedData = splitString(data, ',', 4);
                books = readUsersBooks(splittedData[2], allBooks);
                users.add(new User(splittedData[0], splittedData[1], splittedData[2], splittedData[3], books));
            }
            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(Main.ANSI_RED + "Users didnt loaded!" + Main.ANSI_RESET);
        }
        return users;
    }
    public static ArrayList<Book> readBooksFromFile(String filename){
        File myFile = new File(filename);
        String data;
        ArrayList<Book> books = new ArrayList<Book>();


        try {
            Scanner input = new Scanner(myFile);

            while(input.hasNextLine()) {
                data = input.nextLine();
                String[] splittedData = splitString(data, ',', 4);
                books.add(new Book(splittedData[0], splittedData[1], Double.parseDouble(splittedData[2]), splittedData[3]));
            }
            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(Main.ANSI_RED + "Books didnt loaded!" + Main.ANSI_RESET);
            String compilerPath = System.getProperty("java.home") + "/bin/javac";
            System.out.println("Compiler path: " + compilerPath);
        }
        return books;
    }
    public static String[] splitString(String string, char stopper, int detailsAmount) {
        String[] data = new String[detailsAmount];
        int charIndex = 0;
        for(int i = 0; i < data.length; i++) {
            data[i]= "";
        }
        for(int i = 0; i < data.length; i++) {
            for(;charIndex < string.length() && string.charAt(charIndex) != stopper; charIndex++) {
                data[i] += string.charAt(charIndex);
            }
            charIndex+=2;
        }

        return data;
    }
    public static void updateUserPurchaseFile(String email, String isbn) {
        File purchases = new File("/Users/barakgoren/IntelliJ/BookStore/Purchases/"+email+"_purchases.txt");
        try {
            FileWriter writer = new FileWriter(purchases, true);
            writer.append(isbn + "\n");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Couldnt update purchases file");

        }

    }
    public static String encrypt(String data) {
        String result = "";
        for(int i = 0; i < data.length(); i++) {
            result += (char)(data.charAt(i)+data.length());
        }
        return result;
    }
    public static String decrypt(String hashedData) {
        String result = "";
        for(int i = 0; i < hashedData.length(); i++) {
            result += (char)(hashedData.charAt(i)-hashedData.length());
        }
        return result;
    }
}
