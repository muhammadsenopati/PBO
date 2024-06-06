package com.main;

import data.Admin;
import data.Student;
import exception.custom.IllegalAdminAccess;

import java.util.Scanner;


public class LibrarySystem {

    //===================================== MAIN METHOD  =====================================
    public static void main(String[] args) {
        menu();

    }

    //======================================== ATRIBUT =======================================

    //Scanner yang dipakai khusus untuk switch case.
    static Scanner inputpilihan = new Scanner(System.in);

    //Scanner yang dipakai untuk menerima berbagai input dari user.
    static Scanner inputuser = new Scanner(System.in);

    public static String NIM;

    //====================================== METHOD LAINNYA ===================================

    //Method yang berfungsi untuk menerima input NIM.
    public static void inputNIM() {
        System.out.println("Masukkan NIM: ");
        NIM = inputuser.nextLine();
    }

    //Method untuuk tampilan menu LibrarySystem.
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

                // pilihan 1, masuk ke menu Mahasiswa.
                case 1:
                    try {
                        studentObj.isStudents();
                    }catch (IllegalAdminAccess message){
                        System.err.println(message.getMessage());
                    }
                    break;

                //Pilihan 2, masuk ke menu admin
                case 2:
                    try{
                        adminObj.isAdmin();
                    } catch (IllegalAdminAccess message) {

                        System.err.println(message.getMessage());
                    }
                    break;

                //Pilihan 3, menu untuk memberhentikan loop sehingga program terhenti.
                case 3:
                    menuloop = false;
                    break;

                default:
                    System.out.println(">>> Pilih 1-3 <<<\n");
            }

        }
    }
}
