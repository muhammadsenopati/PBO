import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main (String[]args){
        System.out.println("\n==== CODELAB MODUL 5 ====");
        inputName();
        displayName();

    }

    static ArrayList<String> arrNama = new ArrayList<>();
    static Scanner inputUser = new Scanner(System.in);




    public static void inputName() {

                for (int i = 1; i > 0; i++) {
                   System.out.print("-> Masukkan Nama Ke-" + i + ": ");
                   String nama = inputUser.nextLine();

                   try {
                    if(nama.equals("selesai")) {
                        break;

                    } else if (nama.isEmpty()) {
                        i--;
                        throw new IllegalArgumentException("\n>>> Namanya harus diisi, gaboleh kosong! <<<\n");

                    } else {
                        arrNama.add(nama);

                    }
                 } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());

                   }
                }
    }


        public static void displayName () {

            System.out.println("\n-> Daftar mahasiswa yang diinputkan:");
            for (Object i : arrNama) {
                System.out.println("- "+i);
            }
        }
}
