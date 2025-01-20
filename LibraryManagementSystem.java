import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Library {
    private String customerName;
    private long customerPhone;
    private ArrayList<String> issuedBooks = new ArrayList<>();
    private ArrayList<String> availableBooks = new ArrayList<>();

    Library(String customerName, long customerPhone) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public long getCustomerPhone() {
        return customerPhone;
    }

    public void addSingleBook(String book) {
        availableBooks.add(book);
        System.out.println(book + "added to the library");
    }

    public void addMultipleBooks(String[] books) {
        for (String book : books) {
            availableBooks.add(book);
        }
        System.out.println(Arrays.toString(books) + " added to the library");
    }

    public void issueBook(String[] books) {
        for (String book : books) {
            if (availableBooks.contains(book)) {
                availableBooks.remove(book);
                issuedBooks.add(book);
                System.out.println(books + " Issued Successfully!");
            } else if (issuedBooks.contains(book)) {
                System.out.println("You have already issued the book/books");
            } else {
                System.out.println("The book is not available in the library");
            }
        }
    }

    public void returnBook(String[] books) {
        for (String book : books) {
            if (issuedBooks.contains(book)) {
                issuedBooks.remove(book);
                availableBooks.add(book);
                System.out.println("Book/books returned successfully!");
            } else {

                System.out.println("Book/books was not issued");
            }
        }
    }

    public void availableBooks() {
        if (availableBooks.isEmpty()) {
            System.out.println("Currently there are no books available in the library");
        } else {
            for (String book : availableBooks) {
                System.out.println("The available books are as follows: ");
                System.out.println(book);
            }
        }
    }

    public void issuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("Currently you have not issued any books");
        } else {
            for (String book : issuedBooks) {
                System.out.println("The issued books are as follows: ");
                System.out.println(book);
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String customerName = myScanner.nextLine();

        System.out.println("Enter your phone number: ");
        long customerPhone = myScanner.nextLong();
        Library myLibrary = new Library(customerName, customerPhone);

        int choice;
        do {
            System.out.println("---------- LIBRARY MANAGEMENT SYSTEM ----------");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show Available Books");
            System.out.println("5. Show Issued Books");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            choice = myScanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Add one book");
                    System.out.println("2. Add multiple books");
                    System.out.println("Enter your choice: ");
                    int howManyBooks = myScanner.nextInt();

                    if (howManyBooks == 1) {
                        System.out.println("Enter the name of the book: ");
                        String bookToAdd = myScanner.nextLine();
                        myLibrary.addSingleBook(bookToAdd);
                    } else if (howManyBooks == 2) {
                        System.out.println("How many books do you wanna add: ");
                        int noOfBooks = myScanner.nextInt();
                        myScanner.nextLine(); // Consume newline left by nextInt()
                        String[] booksToAdd = new String[noOfBooks];
                        for (int i = 0; i < noOfBooks; i++) {
                            System.out.println("Enter name of book " + (i + 1) + ": ");
                            booksToAdd[i] = myScanner.nextLine();
                        }
                        myLibrary.addMultipleBooks(booksToAdd);
                    } else {
                        System.out.println("Invalid Choice!");
                    }

                    break;

                case 2:
                    System.out.println("How many books do you want to issue?");
                    int noOfBooksToIssue = myScanner.nextInt();
                    myScanner.nextLine(); // Consume the leftover newline
                    String[] booksToIssue = new String[noOfBooksToIssue];
                    for (int i = 0; i < noOfBooksToIssue; i++) {
                        System.out.println("Enter the name of book " + (i + 1) + ": ");
                        booksToIssue[i] = myScanner.nextLine();

                    }
                    myLibrary.issueBook(booksToIssue);
                    break;

                case 3:
                    System.out.println("How many books do you want to return?");
                    int noOfBooksToReturn = myScanner.nextInt();
                    myScanner.nextLine(); // Consume the leftover newline
                    String[] booksToReturn = new String[noOfBooksToReturn];

                    for (int i = 0; i < noOfBooksToReturn; i++) {
                        System.out.println("Enter the name of book " + (i + 1) + ": ");
                        booksToReturn[i] = myScanner.nextLine();

                    }
                    myLibrary.returnBook(booksToReturn);
                    break;

                case 4:
                    myLibrary.availableBooks();
                    break;

                case 5:
                    myLibrary.issuedBooks();
                    break;

                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Enter a valid choice please");
                    break;
            }

        } while (choice != 6);

        myScanner.close();
    }
}