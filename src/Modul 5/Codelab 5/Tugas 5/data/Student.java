package data;

import books.Book;
import com.main.LibrarySystem;
import exception.custom.IllegalAdminAccess;
import util.iMenu;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements iMenu{

    Scanner inputpilihan = new Scanner(System.in);
    static Scanner inputuser = new Scanner(System.in);
    static ArrayList<UserStudent> arr_userStudent = new ArrayList<>();

    static class UserStudent {
        String nama, nim, fakultas, prodi;
        public UserStudent(String nama, String nim, String fakultas, String prodi) {
            this.nama = nama;
            this.nim = nim;
            this.fakultas = fakultas;
            this.prodi = prodi;
        }
    }

    @Override
    public void menu() {
        Student studentObject = new Student();
        Student.displayInfo();

        try {
            System.out.println("\n==== Student Menu ====");
            System.out.print("\n1. Buku Terpinjam\n2. Pinjam buku\n3. Kembalikan buku\n4. Logout");
            System.out.println("\nChoose option (1-4): ");

            int pilihan = inputpilihan.nextInt();
            switch (pilihan) {
                case 1:
                    Student.showBorrowedBooks();
                    menu();
                    break;
                case 2:
                    studentObject.choiceBooks();
                    menu();
                    break;
                case 3:
                    Student.showBorrowedBooks();
                    Student.returnBooks();
                    menu();
                    break;
                case 4:
                    Student.logout();
                    break;
                default:
                    System.out.print("Pilih 1-4");
                    LibrarySystem.menu();
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Silakan coba lagi.");
            inputpilihan.nextLine();
            menu();
        }
    }

    public static void displayInfo() {
        for (UserStudent i : arr_userStudent) {
            if (LibrarySystem.NIM.equals(i.nim)) {
                System.out.println("\n");
                System.out.print("> Nama: " + i.nama);
                System.out.println("\n> NIM : " + i.nim);
                break;
            }
        }
    }

    public static void showBorrowedBooks() {
        System.out.println("=======================================  Informasi Buku Yang Dipinjam  ==================================================");
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Durasi");
        System.out.println("\n=========================================================================================================================");

        for (Book a : Book.arr_borrowedBook) {
            for (Book i : Book.arr_bookList) {
                if (i.getBookId().equals(a.getBookId())) {
                    System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-5s  ||\n", i.getBookId(), i.getTitle(), i.getAuthor(), i.getCategory(), a.getDuration());
                }
            }
        }

        System.out.print("=========================================================================================================================");
    }

    @Override
    public void choiceBooks() {
        super.choiceBooks();
    }

    // Method untuk kembali ke menu tampilan awal yaitu menu library system.
    public static void logout() {
        LibrarySystem.menu();
    }

    public static void returnBooks() {
        boolean validasiReturnBooks = false;

        System.out.println("\n● Inputkan ID buku yang ingin dikembalikan.");
        System.out.print("> ID : ");

        String idBukuYangDipinjam = inputuser.nextLine();

        for (int i = 0; i < Book.arr_borrowedBook.size(); i++) {
            if (Book.arr_borrowedBook.get(i).getBookId().equals(idBukuYangDipinjam)) {
                for (Book book : Book.arr_bookList) {
                    if (book.getBookId().equals(idBukuYangDipinjam)) {
                        int returnBook = book.getStock();
                        returnBook++;
                        book.setStock(returnBook);

                        Book.arr_borrowedBook.remove(i);

                        validasiReturnBooks = true;
                    }
                }
            }
        }
        if (validasiReturnBooks) {
            System.out.print("Buku Berhasil dikembalikan");
        } else {
            System.out.print(">>> Buku tidak ditemukan. <<<");
        }
    }

    public boolean validasiLogin() {
        LibrarySystem.inputNIM();
        if (LibrarySystem.NIM.length() == 15) {
            for (UserStudent i : arr_userStudent) {
                if (i.nim.equals(LibrarySystem.NIM)) {
                    return true;
                }
            }
        } else {
            System.out.println(">>> NIMnya harus 15 digit ! <<<\n");
            validasiLogin();
        }

        return false;
    }

    public void isStudents() throws IllegalAdminAccess {
        if (validasiLogin()) {
            System.out.println("==== Login berhasil ====\n");
            menu();
        } else {
            throw new IllegalAdminAccess(">>> NIM tidak terdaftar <<<");
        }
    }
}
