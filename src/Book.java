
public class Book {
    private String title;
    private String author;
    private double price;
    private String isbn;

    public Book(String title, String author, double price, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public void displayDetails() {
        System.out.println("------------------------");
        System.out.println(Main.ANSI_YELLOW +"Book Title: " + this.title+ Main.ANSI_RESET);
        System.out.println(Main.ANSI_YELLOW +"Book Author: " + this.author+ Main.ANSI_RESET);
        System.out.println(Main.ANSI_YELLOW +"Book Price: " + this.price+ Main.ANSI_RESET);
        System.out.println(Main.ANSI_YELLOW +"ISBN Number: " + this.isbn+ Main.ANSI_RESET);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return Main.ANSI_YELLOW + "Book Title: "+ Main.ANSI_RESET + title
                + Main.ANSI_YELLOW+", Author: " + Main.ANSI_RESET + author
                + Main.ANSI_YELLOW+", Price: " + Main.ANSI_RESET + price
                + Main.ANSI_YELLOW+", ISBN: " + Main.ANSI_RESET+ isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }




}
