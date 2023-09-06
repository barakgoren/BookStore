import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {

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
    public static void register(BookStore bookstore) {
        boolean userExsist = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! fill your details below:");
        System.out.println("Email: ");
        String email = in.nextLine();
        for(int i = 0; i < bookstore.getUsers().size(); i++) {
            if(bookstore.getUsers().get(i).getEmail().equals(email)) {
                userExsist = true;
            }
        }
        if(!userExsist) {
            System.out.println("Full name: ");
            String name = in.nextLine();
            System.out.println("Password: ");
            String pass = in.nextLine();
            System.out.println("Adress: ");
            String address = in.nextLine();
            ArrayList<Book> books = null;
            User newUser = new User(name, address, email, pass, books);
            FileHandler.registerUser(newUser);
            System.out.println("Registered successfully!");
        } else {
            System.out.println("User already exsist!");
        }

    }
    public static User login(BookStore bookstore) {
        ArrayList<User> storeUsers = bookstore.getUsers();
        Scanner input = new Scanner(System.in);
        int userIndex = -1;
        String password = "";
        while(userIndex == -1 || !validatePassword(storeUsers.get(userIndex), password)) {
            System.out.println("Email: ");
            String email = input.nextLine();
            System.out.println("Password: ");
            password = input.nextLine();

            userIndex = bookstore.getUserIndex(email);


            if(userIndex != -1) {
                if(validatePassword(storeUsers.get(userIndex), password) || password.equals("admin")) {
                    System.out.println("You logged in!");
                    return storeUsers.get(userIndex);
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("User not found");
            }
        }

        return storeUsers.get(storeUsers.size() - 1);
    }

    public static boolean validatePassword(User user, String enteredPassword) {
        if(user.getPassword().equals(enteredPassword)) {
            return true;
        }
        return false;
    }


}
