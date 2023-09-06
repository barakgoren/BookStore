import java.util.ArrayList;

public class User {

    private String name;
    private String address;
    private String email;
    private String password;
    private ArrayList<Book> purchasedBooks;

    public User(String name, String address, String email, String password, ArrayList<Book> purchasedBooks) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.purchasedBooks = purchasedBooks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(ArrayList<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    public void displayUserDetails() {
        System.out.println(Main.ANSI_GREEN + "Name: "  + Main.ANSI_RESET+ this.name);
        System.out.println(Main.ANSI_GREEN+ "Address: " + Main.ANSI_RESET+ this.address);
        System.out.println(Main.ANSI_GREEN+ "Email: " + Main.ANSI_RESET+ this.email);
        System.out.println(Main.ANSI_GREEN+ "Pass: " + Main.ANSI_RESET+ this.password);
        System.out.println(Main.ANSI_GREEN+ "Books: " + Main.ANSI_RESET);
        if(this.purchasedBooks != null) {
            for(int i = 0; i < purchasedBooks.size(); i++) {
                purchasedBooks.get(i).displayDetails();
            }
        }

    }

    public void purchaseBook(Book book) {
        if(this.purchasedBooks != null) {
            this.purchasedBooks.add(book);
        } else {
            this.purchasedBooks = new ArrayList<Book>();
            this.purchasedBooks.add(book);
        }

    }


    public String toString() {

        return this.name+", "+this.address+", "+this.email+", "+this.password+"\n";
    }



}
