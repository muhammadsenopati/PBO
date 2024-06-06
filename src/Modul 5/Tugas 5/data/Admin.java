package data;
import com.main.LibrarySystem;
import java.util.Random;
import java.util.Scanner;
import exception.custom.IllegalAdminAccess;
import util.iMenu;

public class Admin extends User implements iMenu {

    static String adminusername = "admin";
    static String adminpassword = "senoganteng";
    static String username, password;
    static Scanner inputpilihan = new Scanner(System.in);
    static Scanner inputuser = new Scanner(System.in);
    static String NIM;

    @Override
    public void menu() {
        try {
            System.out.println("\n==== Admin Menu ====");
            System.out.println("\n1. Tambah Mahasiswa\n2. Daftar Mahasiswa\n3. Tambah Buku\n4. Logout");
            System.out.print("Choose option (1-4): ");

            int pilihan = inputpilihan.nextInt();
            switch (pilihan) {
                case 1:
                    Admin.addstudent();
                    menu();
                    break;
                case 2:
                    Admin.displaystudent();
                    menu();
                    break;
                case 3:
                    inputBook();
                    menu();
                    break;
                case 4:
                    LibrarySystem.menu();
                    break;
                default:
                    System.out.print("Pilih 1-4");
                    menu();
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Silakan coba lagi.");
            inputpilihan.nextLine(); // Membersihkan buffer scanner
            menu();
        }
    }


    public static void addstudent() {
        int loop;
        System.out.println("\n==== Tambah Mahasiswa ====");
        System.out.print("Masukkan Nama Mahasiswa:");
        String nama = inputuser.nextLine();

        do {
            System.out.print("Masukkan NIMnya:");
            NIM = inputuser.nextLine();
            if (NIM.length() != 15) {
                System.out.println("\n> NIMnya harus 15 digit");
                loop = 0;
            } else {
                loop = 1;
            }
        } while (loop == 0);
        System.out.print("Dari Fakultas Apa?");
        String fakultas = inputuser.nextLine();

        System.out.print("Jurusannya Apa?");
        String jurusan = inputuser.nextLine();

        Student.arr_userStudent.add(new Student.UserStudent(nama, NIM, fakultas, jurusan));

        System.out.println("==== Sudah Terdaftar Ya!! ====");
    }


    @Override
    public void inputBook() {
        super.inputBook();
    }


    public static void displaystudent() {
        System.out.println("\n==== Daftar Mahasiswa ====");
        for (Student.UserStudent i : Student.arr_userStudent) {
            System.out.print("Nama     : "+ i.nama +"\n" );
            System.out.print("NIM      : " + i.nim + "\n");
            System.out.print("Fakultas : " + i.fakultas + "\n");
            System.out.print("Prodi    : " + i.prodi + "\n");
            System.out.println("============================");
        }
    }


    public boolean isAdmin() throws IllegalAdminAccess {
        System.out.println("\n==== Login ====");
        System.out.print("Masukkan Username: \n");
        username = inputuser.nextLine();

        System.out.print("Massukkan Password: \n");
        password = inputuser.nextLine();

        if (username.equals(adminusername) && password.equals(adminpassword)) {
            System.out.println("==== Login Berhasil ====\n");
            menu();
        } else {
            throw new IllegalAdminAccess("==== Invalid Credentials ====");
        }
        return false;
    }

    public String generateId() {
        Random random = new Random();
        StringBuilder idTengah = new StringBuilder();
        StringBuilder idAkhir = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idTengah.append(random.nextInt(10));
            idAkhir.append(random.nextInt(10));
        }
        return ("UMM-" + idTengah + "-" + idAkhir);
    }
}
