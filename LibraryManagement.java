import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Book class to represent library books
class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;
    private LocalDate publishDate;
    
    public Book(String isbn, String title, String author, String genre, LocalDate publishDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
        this.isAvailable = true;
    }
    
    // Getters and setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return isAvailable; }
    public LocalDate getPublishDate() { return publishDate; }
    
    public void setAvailable(boolean available) { isAvailable = available; }
    
    @Override
    public String toString() {
        return String.format("ISBN: %s | Title: %s | Author: %s | Genre: %s | Available: %s", 
                           isbn, title, author, genre, isAvailable ? "Yes" : "No");
    }
}

// Member class to represent library members
class Member {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private LocalDate joinDate;
    private List<String> borrowedBooks;
    private static final int MAX_BOOKS = 5;
    
    public Member(String memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.joinDate = LocalDate.now();
        this.borrowedBooks = new ArrayList<>();
    }
    
    // Getters and setters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public LocalDate getJoinDate() { return joinDate; }
    public List<String> getBorrowedBooks() { return borrowedBooks; }
    
    public boolean canBorrowMore() {
        return borrowedBooks.size() < MAX_BOOKS;
    }
    
    public void borrowBook(String isbn) {
        if (canBorrowMore()) {
            borrowedBooks.add(isbn);
        }
    }
    
    public boolean returnBook(String isbn) {
        return borrowedBooks.remove(isbn);
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s | Books Borrowed: %d/%d", 
                           memberId, name, email, borrowedBooks.size(), MAX_BOOKS);
    }
}

// Transaction class to track borrowing/returning
class Transaction {
    private String transactionId;
    private String memberId;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String type; // "BORROW" or "RETURN"
    
    public Transaction(String transactionId, String memberId, String isbn, String type) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.type = type;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusWeeks(2); // 2 weeks borrowing period
    }
    
    // Getters and setters
    public String getTransactionId() { return transactionId; }
    public String getMemberId() { return memberId; }
    public String getIsbn() { return isbn; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public String getType() { return type; }
    
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    
    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("Transaction: %s | Member: %s | Book: %s | Type: %s | Date: %s | Due: %s", 
                           transactionId, memberId, isbn, type, borrowDate.format(formatter), 
                           dueDate.format(formatter));
    }
}

// Main Library Management System class
class LibraryManagementSystem {
    private Map<String, Book> books;
    private Map<String, Member> members;
    private List<Transaction> transactions;
    private Scanner scanner;
    
    public LibraryManagementSystem() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        initializeSampleData();
    }
    
    private void initializeSampleData() {
        // Add sample books
        addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch", "Programming", LocalDate.of(2017, 12, 6)));
        addBook(new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman", "Programming", LocalDate.of(2004, 10, 25)));
        addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin", "Programming", LocalDate.of(2008, 8, 1)));
        addBook(new Book("978-1449355739", "Learning Java", "Patrick Niemeyer", "Programming", LocalDate.of(2013, 6, 20)));
        
        // Add sample members
        addMember(new Member("M001", "John Doe", "john.doe@email.com", "+1-555-0123"));
        addMember(new Member("M002", "Jane Smith", "jane.smith@email.com", "+1-555-0124"));
        addMember(new Member("M003", "Bob Johnson", "bob.johnson@email.com", "+1-555-0125"));
    }
    
    // Book management methods
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }
    
    public Book findBook(String isbn) {
        return books.get(isbn);
    }
    
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        
        System.out.println("\n=== ALL BOOKS ===");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
    
    public void searchBooks(String searchTerm) {
        List<Book> results = new ArrayList<>();
        String term = searchTerm.toLowerCase();
        
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(term) ||
                book.getAuthor().toLowerCase().contains(term) ||
                book.getGenre().toLowerCase().contains(term)) {
                results.add(book);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("No books found matching: " + searchTerm);
        } else {
            System.out.println("\n=== SEARCH RESULTS ===");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }
    
    // Member management methods
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }
    
    public Member findMember(String memberId) {
        return members.get(memberId);
    }
    
    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        
        System.out.println("\n=== ALL MEMBERS ===");
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }
    
    // Transaction methods
    public boolean borrowBook(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = findBook(isbn);
        
        if (member == null) {
            System.out.println("Member not found!");
            return false;
        }
        
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Book is not available!");
            return false;
        }
        
        if (!member.canBorrowMore()) {
            System.out.println("Member has reached maximum borrowing limit!");
            return false;
        }
        
        // Process borrowing
        book.setAvailable(false);
        member.borrowBook(isbn);
        
        String transactionId = "T" + System.currentTimeMillis();
        Transaction transaction = new Transaction(transactionId, memberId, isbn, "BORROW");
        transactions.add(transaction);
        
        System.out.println("Book borrowed successfully!");
        System.out.println("Due date: " + transaction.getDueDate());
        return true;
    }
    
    public boolean returnBook(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = findBook(isbn);
        
        if (member == null) {
            System.out.println("Member not found!");
            return false;
        }
        
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        
        if (!member.getBorrowedBooks().contains(isbn)) {
            System.out.println("This book was not borrowed by this member!");
            return false;
        }
        
        // Process return
        book.setAvailable(true);
        member.returnBook(isbn);
        
        // Find and update the borrow transaction
        for (Transaction t : transactions) {
            if (t.getMemberId().equals(memberId) && t.getIsbn().equals(isbn) && 
                t.getType().equals("BORROW") && t.getReturnDate() == null) {
                t.setReturnDate(LocalDate.now());
                break;
            }
        }
        
        String transactionId = "T" + System.currentTimeMillis();
        Transaction returnTransaction = new Transaction(transactionId, memberId, isbn, "RETURN");
        transactions.add(returnTransaction);
        
        System.out.println("Book returned successfully!");
        return true;
    }
    
    public void displayOverdueBooks() {
        System.out.println("\n=== OVERDUE BOOKS ===");
        boolean hasOverdue = false;
        
        for (Transaction t : transactions) {
            if (t.isOverdue()) {
                Member member = findMember(t.getMemberId());
                Book book = findBook(t.getIsbn());
                System.out.println("Member: " + member.getName() + " | Book: " + book.getTitle() + 
                                 " | Due: " + t.getDueDate() + " | Days Overdue: " + 
                                 (LocalDate.now().toEpochDay() - t.getDueDate().toEpochDay()));
                hasOverdue = true;
            }
        }
        
        if (!hasOverdue) {
            System.out.println("No overdue books.");
        }
    }
    
    public void displayTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        
        System.out.println("\n=== TRANSACTION HISTORY ===");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
    
    public void generateReport() {
        System.out.println("\n=== LIBRARY REPORT ===");
        System.out.println("Total Books: " + books.size());
        System.out.println("Available Books: " + books.values().stream().mapToInt(b -> b.isAvailable() ? 1 : 0).sum());
        System.out.println("Borrowed Books: " + books.values().stream().mapToInt(b -> !b.isAvailable() ? 1 : 0).sum());
        System.out.println("Total Members: " + members.size());
        System.out.println("Total Transactions: " + transactions.size());
        
        long overdueCount = transactions.stream().filter(Transaction::isOverdue).count();
        System.out.println("Overdue Books: " + overdueCount);
    }
    
    // Main menu system
    public void displayMenu() {
        System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
        System.out.println("1. Display All Books");
        System.out.println("2. Search Books");
        System.out.println("3. Add New Book");
        System.out.println("4. Display All Members");
        System.out.println("5. Add New Member");
        System.out.println("6. Borrow Book");
        System.out.println("7. Return Book");
        System.out.println("8. Display Overdue Books");
        System.out.println("9. Transaction History");
        System.out.println("10. Generate Report");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
    
    public void run() {
        System.out.println("Welcome to Library Management System!");
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    System.out.print("Enter search term: ");
                    String searchTerm = scanner.nextLine();
                    searchBooks(searchTerm);
                    break;
                case 3:
                    addNewBook();
                    break;
                case 4:
                    displayAllMembers();
                    break;
                case 5:
                    addNewMember();
                    break;
                case 6:
                    borrowBookInteractive();
                    break;
                case 7:
                    returnBookInteractive();
                    break;
                case 8:
                    displayOverdueBooks();
                    break;
                case 9:
                    displayTransactionHistory();
                    break;
                case 10:
                    generateReport();
                    break;
                case 0:
                    System.out.println("Thank you for using Library Management System!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private void addNewBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        if (findBook(isbn) != null) {
            System.out.println("Book with this ISBN already exists!");
            return;
        }
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publish date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        
        try {
            LocalDate publishDate = LocalDate.parse(dateStr);
            Book book = new Book(isbn, title, author, genre, publishDate);
            addBook(book);
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid date format!");
        }
    }
    
    private void addNewMember() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        
        if (findMember(memberId) != null) {
            System.out.println("Member with this ID already exists!");
            return;
        }
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        
        Member member = new Member(memberId, name, email, phone);
        addMember(member);
        System.out.println("Member added successfully!");
    }
    
    private void borrowBookInteractive() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        borrowBook(memberId, isbn);
    }
    
    private void returnBookInteractive() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        returnBook(memberId, isbn);
    }
}

// Main class to run the application
public class LibraryManagement {
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.run();
    }
}