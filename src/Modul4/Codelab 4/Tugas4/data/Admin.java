package data;
import util.IMenu;


import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements IMenu {
    public Admin(String name) {
        super(name);
    }

    public void addStudent(ArrayList<Student> userStudent) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("NIM tidak ada. NIM harus 15 digit.");
            addStudent(userStudent);
            return;
        }
        System.out.print("Dari Fakultas Apa: ");
        String faculty = scanner.nextLine();
        System.out.print("Program Studi Apa: ");
        String program = scanner.nextLine();

        Student newStudent = new Student(name, nim, faculty, program);
        userStudent.add(newStudent);
        System.out.println("Mahasiswa Berhasil ditambahkan.");
    }

    public void inputBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Buku : ");
        String bookId = scanner.nextLine();
        System.out.print("Masukkan Judul: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan Author: ");
        String author = scanner.nextLine();
        System.out.print("Masukkan Kategori Buku (History, Text, or Story): ");
        String category = scanner.nextLine();
        System.out.print("Masukkan Stok Buku: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        String bookType = category;

        super.addBook(bookId, title, author, category, stock, bookType);
    }

    @Override
    public void menu() {

    }
}