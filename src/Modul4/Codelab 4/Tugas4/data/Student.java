package data;

import books.Book;
import util.IMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements IMenu {
    public String nim;
    public String faculty;
    public String program;

    public Student(String name, String nim, String faculty, String program) {
        super(name);
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
    }

    public void borrowBook(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Buku yang ingin dipinjam: ");
        String bookId = scanner.nextLine();
        System.out.print("Ingin meminjam berapa lama?( contoh: 7, 14, 30): ");
        int durationDays = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                found = true;
                book.borrowBook(durationDays);
                break;
            }
        }
        if (!found) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan.");
        }
    }
    public void choiceBook(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Daftar Buku =====");
        System.out.printf("|| %-15s || %-25s || %-25s || %-20s || %-10s ||\n", "ID Buku", "Judul", "Penulis", "Kategori", "Tersedia");

        for (Book book : bookList) {
            System.out.printf("|| %-15s || %-25s || %-25s || %-20s || %-10s ||\n", book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), (book.isAvailable() ? "Ya" : "Tidak"));
        }

        System.out.print("\nPilih ID Buku yang ingin dipinjam (atau ketik 'kembali' untuk kembali ke menu utama): ");
        String bookId = scanner.nextLine();

        if (bookId.equalsIgnoreCase("kembali")) {
            return;
        }

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                found = true;
                if (book.isAvailable()) {
                    System.out.print("Ingin meminjam berapa lama?( contoh: 7, 14, 30): ");
                    int durationDays = scanner.nextInt();
                    scanner.nextLine();
                    book.borrowBook(durationDays);
                } else {
                    System.out.println("Maaf, buku tersebut sudah dipinjam.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan.");
        }
    }

    public void returnBook(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID buku yang ingin dikembalikan: ");
        String bookId = scanner.nextLine();

        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                found = true;
                book.returnBook();
                break;
            }
        }
        if (!found) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan atau tidak dipinjam oleh anda.");
        }
    }

    public void showBorrowedBook(ArrayList<Book> bookList) {
        System.out.println("\n===== Borrowed Books =====");
        boolean hasBorrowedBooks = false;
        for (Book book : bookList) {
            if (book.getBorrowedCount() > 0) {
                hasBorrowedBooks = true;
                System.out.printf("|| %-15s || %-25s || %-25s || %-20s || %-10s || %-10s ||\n", book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getBorrowedDate(), "Due in " + book.getDurationDays() + " days");
            }
        }
        if (!hasBorrowedBooks) {
            System.out.println(" Kamu belum ada meminjam buku apapun.");
        }
    }

    @Override
    public void menu() {

    }
}
