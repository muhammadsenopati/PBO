package com.main;

import data.User;
import data.Student;
import data.Admin;
import util.IMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem implements IMenu {
    private ArrayList<Student> userStudent;
    private Scanner scanner;
    static Scanner inputuser = new Scanner(System.in);

    static String adminusername = "seno", adminpassword = "seno";
    private Admin admin;
    private User user;

    public LibrarySystem() {
        userStudent = new ArrayList<>();
        scanner = new Scanner(System.in);
        admin = new Admin("Admin");
        user = new User("User", admin.bookList);
    }

    public static void main(String[] args) {
        LibrarySystem main = new LibrarySystem();
        main.menu();
    }


    @Override
    public void menu() {
        System.out.println("\n===== Library System =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                inputNim();
                break;
            case 2:
                loginadmin();
                menuAdmin();
                break;
            case 3:
                System.out.println("Terimakasih!!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Try again.");
                menu();
        }
    }

    private void inputNim() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        if (checkNim(nim)) {
            Student currentStudent = getUserByNim(nim);
            menuStudent(currentStudent);
        } else {
            System.out.println("NIM tidak valid. Silakan coba lagi.");
            inputNim();
        }
    }

    private boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.nim.equals(nim)) {
                return true;
            }
        }
        return false;
    }

    private Student getUserByNim(String nim) {
        for (Student student : userStudent) {
            if (student.nim.equals(nim)) {
                return student;
            }
        }
        return null;
    }

    static void loginadmin() {
        int adminloop;
        do {
            System.out.println("\n==== Login ====");
            System.out.print("Enter Username: \n");
            String username = inputuser.nextLine();

            System.out.print("Enter Password: \n");
            String password = inputuser.nextLine();

            if (username.equals(adminusername) && password.equals(adminpassword)) {
                System.out.println("==== Login Successful ====\n");
                adminloop = 1;
            } else {
                System.out.println("==== Admin not found ====");
                adminloop = 0;
            }
        } while (adminloop == 0);
    }

    private void menuAdmin() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Input Book");
            System.out.println("2. Display Books");
            System.out.println("3. Add Student");
            System.out.println("4. Display Registered Students");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    admin.inputBook();
                    break;
                case 2:
                    admin.displayBooks();
                    break;
                case 3:
                    admin.addStudent(userStudent);
                    break;
                case 4:
                    displayStudent();
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void menuStudent(Student currentStudent) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Student Dashboard =====");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Borrowed Books");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user.displayBooks();
                    break;
                case 2:
                    currentStudent.borrowBook(user.bookList);
                    break;
                case 3:
                    currentStudent.showBorrowedBook(user.bookList);
                    break;
                case 4:
                    currentStudent.returnBook(user.bookList);
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void displayStudent() {
        System.out.println("\n===== Registered Students =====");
        for (Student student : userStudent) {
            System.out.println("Nama: " + student.name);
            System.out.println("NIM: " + student.nim);
            System.out.println("Fakultas: " + student.faculty);
            System.out.println("Program Studi: " + student.program);
            System.out.println();
        }
    }


}
