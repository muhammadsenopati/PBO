import java.util.Scanner;

public class Balok extends BangunRuang{
        private double panjang;
        private double lebar;
        private double tinggi;
        Scanner scanner = new Scanner(System.in);

        Balok (String name){
            super(name);
        }

        @Override
        public void inputNilai() {
            super.inputNilai();
        System.out.println("Input Panjang: ");
        panjang = scanner.nextDouble();
        System.out.println("Input Lebar: ");
        lebar = scanner.nextDouble();
        System.out.println("Input Tinggi:");
        tinggi = scanner.nextDouble();
    }

        @Override
        public void luasPermukaan() {
            super.luasPermukaan();
            double hasil = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar* tinggi));
            System.out.println("Hasil luas permukaan balok: "+ hasil);
        }

        @Override
        public void volume() {
            super.volume();
            double hasil = panjang*lebar*tinggi;
            System.out.println("Hasil volume balok: "+ hasil);
        }
    }

