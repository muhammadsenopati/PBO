import java.util.Scanner;

public class LibrarySystem {
    private static String adminUsername = "admin";
    private static String adminPassword = "nimda";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean loggedInAsAdmin = false;

        while (!loggedInAsAdmin) {
            System.out.println("\n==== Library System ====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3) : ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM (15 digits): ");
                    String nim = scan.next();
                    if (nim.length() == 15) {
                        loginAsStudent();
                    } else {
                        System.out.println("NIMnya Tidak ada. Masukkan 15 Digit Angka.");
                    }
                    break;
                case 2:
                    System.out.print("Enter your username (admin): ");
                    String inputAdminUsername = scan.next();
                    System.out.print("Enter your password (admin) : ");
                    String inputAdminPassword = scan.next();
                    loggedInAsAdmin = loginAsAdmin(inputAdminUsername, inputAdminPassword);
                    if (loggedInAsAdmin) {
                        System.out.println("Successful login as Admin");
                    } else {
                        System.out.println("Admin User Tidak Ketemu, Coba Lagi");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Library System...");
                    System.exit(0);
                default:
                    System.out.println("Pilihannya Ga ada. Pilih (1-3).");
            }
        }
    }

    private static void loginAsStudent() {
        System.out.println("Successful login as Student");
    }

    private static boolean loginAsAdmin(String username, String password) {
        return adminUsername.equals(username) && adminPassword.equals(password);
    }
}
