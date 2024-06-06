package data;

import books.*;

import java.util.Scanner;

public class User {


    static  String idBukuYangDipinjam;
    static  Scanner inputuser = new Scanner(System.in);
    String pilihan, cetak;


    public void choiceBooks() {
        Book bookObj = new Book();
        Student studentObj = new Student();

        boolean validasi = false;
        int loop = 0;

        System.out.println("\n=========================================================================================================================");
        System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Stok");
        System.out.println("\n=========================================================================================================================");

        for (Book i : Book.arr_bookList) {
            System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s  ||\n", i.getBookId(), i.getTitle(), i.getAuthor(), i.getCategory(), i.getStock());
        }

        System.out.print("=========================================================================================================================");

        System.out.println("\n>> Input ID buku yang ingin dipinjam");
        System.out.print(">  ID: ");

        idBukuYangDipinjam = inputuser.nextLine();
        for (Book i : Book.arr_bookList) {
            if (i.getBookId().equals(idBukuYangDipinjam)) {
                if (i.getStock() > 0) {

                    int a = i.getStock();
                    a--;
                    i.setStock(a);

                    do{
                        System.out.println("\n>> Berapa lama buku ingin dipinjam? (maksimal 14 hari)");
                        System.out.print(">  Berapa hari ? : ");

                        int inputwaktuPinjaman = inputuser.nextInt();

                        if(inputwaktuPinjaman < 15) {
                            bookObj.setDuration(inputwaktuPinjaman);
                            Book.arr_borrowedBook.add(new Book(idBukuYangDipinjam, i.getStock(), bookObj.getDuration()));
                            validasi = true;
                            loop = 1;
                            break;
                        }else{
                            System.out.println("Max 14 hari");
                        }
                    }while(loop == 0);
                }else if (i.getStock() == 0){
                    System.out.print("== Stok buku habis! ==");
                    studentObj.menu();
                }

            }
        }
    if(validasi){
        System.out.print("==== Buku berhasil dipinjam! ====");
    }else{
        System.out.print("== ID tidak ditemukan! ==");
    }

    }

    public void inputBook() {
        Admin adminObj       = new Admin();

        Book  bookObj        = new Book();
        Book  textBookObj    = new TextBook();
        Book  storyBookObj   = new StoryBook();
        Book  historyBookObj = new HistoryBook();

        System.out.println("\n==== Tambah Buku ====");
        System.out.println("Pilih kategori buku :\n1. History Book\n2. Story Book\n3. Text Book");
        System.out.print("Pilih 1-3: ");
        pilihan = inputuser.nextLine();
        switch (pilihan){
            case "1":
                Book historyBookObjWithParameter = new HistoryBook("=== History Book ====");
                System.out.println(historyBookObjWithParameter);
                cetak ="1";
                break;

            case "2":
                Book storyBookObjWithParameter = new StoryBook("=== Story Book ===");
                System.out.println(storyBookObjWithParameter);
                cetak = "2";
                break;

            case "3":
                Book textBookObjWithParameter = new TextBook("=== Text Book ===");
                System.out.println(textBookObjWithParameter);
                cetak = "3";
                break;

            default:
                System.out.println("pilih 1 - 3");
        }

        String idBuku = adminObj.generateId();

        System.out.print("Masukkan judul Buku       : ");
        String judulBuku = inputuser.nextLine();

        System.out.print("Masukkan Nama Penulis     : ");
        String penulisBuku = inputuser.nextLine();

        System.out.print("Masukkan Jumlah Stok Buku : ");
        String stokBuku = inputuser.nextLine();
        int stokint =Integer.parseInt(stokBuku);
        bookObj.setBookId(idBuku);
        bookObj.setTitle(judulBuku);
        bookObj.setAuthor(penulisBuku);
        bookObj.setStock(stokint);

        switch (cetak){
            case "1":
            historyBookObj.setCategory("History Book");
            Book.arr_bookList.add(new Book(bookObj.getBookId(), bookObj.getTitle(), bookObj.getAuthor(), historyBookObj.getCategory(), bookObj.getStock()));
            break;

            case "2":
            storyBookObj.setCategory("Story Book");
            Book.arr_bookList.add(new Book(bookObj.getBookId(), bookObj.getTitle(), bookObj.getAuthor(), storyBookObj.getCategory(), bookObj.getStock()));
            break;

            case "3":
            textBookObj.setCategory("Text Book");
            Book.arr_bookList.add(new Book(bookObj.getBookId(), bookObj.getTitle(), bookObj.getAuthor(), textBookObj.getCategory(), bookObj.getStock()));
            break;
        }
        System.out.println("==== Buku berhasil ditambahkan ====");
    }
}


