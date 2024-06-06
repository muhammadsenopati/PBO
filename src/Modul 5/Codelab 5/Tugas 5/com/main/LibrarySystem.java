
package com.main;

import data.Admin;
import data.Student;
import exception.custom.IllegalAdminAccess;

import java.util.Scanner;


public class LibrarySystem {


    public static void main(String[] args) {
        menu();

    }


    static Scanner inputpilihan = new Scanner(System.in);


    static Scanner inputuser = new Scanner(System.in);

    public static String NIM;



    public static void inputNIM() {
        System.out.println("Masukkan NIM Anda: ");
        NIM = inputuser.nextLine();
    }


    public static void menu() {
        boolean menuloop = true;
        Admin adminObj = new Admin();
        Student studentObj = new Student();

        while(menuloop) {
            System.out.println("\n==== Library System ====");
            System.out.print("\n1. Login as student\n2. Login as admin\n3. Exit\n");
            System.out.print("Choose option (1-3): ");

            int pilihan = inputpilihan.nextInt();


            switch (pilihan) {


                case 1:
                    try {
                        studentObj.isStudents();
                    }catch (IllegalAdminAccess message){
                        System.err.println(message.getMessage());
                    }
                    break;

                case 2:
                    try{
                        adminObj.isAdmin();
                    } catch (IllegalAdminAccess message) {

                        System.err.println(message.getMessage());
                    }
                    break;


                case 3:
                    menuloop = false;
                    break;

                default:
                    System.out.println(">>> Pilih 1-3 <<<\n");
            }

        }
    }
}
