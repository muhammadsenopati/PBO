import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> mahasiswaList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int counter = 1;

        while (true) {
            System.out.println("Masukkan Nama Ke-" + counter + ":");
            input = scanner.nextLine();
            if (input.equals("selesai")) {
                break;
            }
            if (input.isEmpty()) {

                try {
                    throw new IllegalArgumentException("Nama tidak boleh kosong!");
                }catch (Exception e){
                    String errorMessage = e.getMessage();
                    System.out.println(errorMessage);

                }
            } else {
                mahasiswaList.add(input);
                counter++;
            }
        }
        System.out.println("Daftar Mahasiswa Yang diinputkan: ");
        for (String mahasiswa : mahasiswaList) {
            System.out.println("- " + mahasiswa);
        }
    }
}