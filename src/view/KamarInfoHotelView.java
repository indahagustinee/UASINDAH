package view;

import controller.KamarInfoController;
import entity.KamarInfo;
import java.util.Scanner;
import javax.swing.*;


public class KamarInfoHotelView extends JFrame {
    private KamarInfoController kamarInfoController;
    private Scanner inp;

    public KamarInfoHotelView() {
        kamarInfoController = new KamarInfoController();
        inp = new Scanner(System.in);
    }

    public void viewKamarInfoHotel() {
        int pilih;
        do {
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Lihat Informasi Kamar");
            System.out.println("3. Edit Data Kamar");
            System.out.println("4. Hapus Kamar");
            System.out.println("5. Reservasi Kamar");
            System.out.println("6. Detail Reservasi");
            System.out.println("7. Check-out");
            System.out.println("8. Informasi Kamar Tersedia");
            System.out.println("9. Lihat Data Tamu");
            System.out.println("0. Exit");
            System.out.print("Pilih = ");
            pilih = inp.nextInt();
            switch (pilih) {
                case 1:
                    tambahKamarView();
                    break;
                case 2:
                    lihatInformasiKamar();
                    break;
                case 3:
                    editDataKamar();
                    break;
                case 4:
                    hapusKamar();
                    break;
                case 5:
                    reservasiKamar();
                    break;
                case 6:
                    detailReservasi();
                    break;
                case 7:
                    checkOut();
                    break;
                case 8:
                    informasiKamarTersedia();
                    break;
                case 9:
                    lihatDataTamu();
                    break;
            }
        } while (pilih != 0);
    }

    public void tambahKamarView() {
        inp.nextLine();
        System.out.print("No Kamar = ");
        int noKamar = inp.nextInt();
        inp.nextLine();  // Consume the newline character
        System.out.print("Jenis Bed = ");
        String jenisBed = inp.nextLine();
        System.out.print("Harga per Malam = ");
        double hargaPerMalam = inp.nextDouble();

        kamarInfoController.tambahKamar(noKamar, jenisBed, hargaPerMalam);
        System.out.println("Berhasil menambahkan kamar.");
    }

    public void lihatInformasiKamar() {
        for (int i = 0; i < kamarInfoController.jumlahKamar(); i++) {
            System.out.println("\nInformasi Kamar Ke-" + (i + 1));
            KamarInfo kamarInfo = kamarInfoController.lihatKamar(i);
            System.out.println("No Kamar: " + kamarInfo.getNoKamar());
            System.out.println("Jenis Bed: " + kamarInfo.getJenisBed());
            System.out.println("Harga per Malam: " + kamarInfo.getHargaPerMalam());
        }
    }

    public void editDataKamar() {
        lihatInformasiKamar();
        System.out.println("\nSistem Edit Data Kamar");
        System.out.print("Pilih = ");
        int pilih = inp.nextInt();
        pilih = pilih - 1;
        inp.nextLine();  // Consume the newline character
        System.out.print("No Kamar Baru = ");
        int noKamarBaru = inp.nextInt();
        inp.nextLine();  // Consume the newline character
        System.out.print("Jenis Bed Baru = ");
        String jenisBedBaru = inp.nextLine();
        System.out.print("Harga per Malam Baru = ");
        double hargaPerMalamBaru = inp.nextDouble();

        kamarInfoController.editDataKamar(pilih, noKamarBaru, jenisBedBaru, hargaPerMalamBaru);
        System.out.println("Berhasil edit data kamar.\n");
    }

    private void hapusKamar() {
        lihatInformasiKamar();
        System.out.println("\nSistem Hapus Kamar");
        System.out.print("Pilih = ");
        int pilih = inp.nextInt();

        // Memeriksa apakah indeks pilih berada dalam rentang yang valid
        if (pilih > 0 && pilih <= kamarInfoController.jumlahKamar()) {
            kamarInfoController.hapusKamar(pilih - 1);
            System.out.println("Berhasil hapus kamar.");
        } else {
            System.out.println("Pilihan tidak valid. Harap pilih kamar yang sesuai.");
        }
    }

    private void reservasiKamar() {
        lihatInformasiKamar();
        System.out.println("\nSistem Reservasi Kamar");
        System.out.print("Pilih Kamar untuk Reservasi = ");
        int pilih = inp.nextInt();
        pilih = pilih - 1;
        inp.nextLine();  // Consume the newline character
        System.out.print("Nama Tamu = ");
        String namaTamu = inp.nextLine();

        kamarInfoController.reservasiKamar(pilih, namaTamu);
        System.out.println("Reservasi berhasil. Selamat datang, " + namaTamu + "!");
    }

    private void detailReservasi() {
        lihatInformasiKamar();
        System.out.println("\nSistem Detail Reservasi");
        System.out.print("Pilih Kamar untuk Detail Reservasi = ");
        int pilih = inp.nextInt();
        pilih = pilih - 1;

        kamarInfoController.detailReservasi(pilih);
    }

    private void checkOut() {
        lihatInformasiKamar();
        System.out.println("\nSistem Check-out");
        System.out.print("Pilih Kamar untuk Check-out = ");
        int pilih = inp.nextInt();
        pilih = pilih - 1;

        kamarInfoController.checkOut(pilih);
        System.out.println("Check-out berhasil. Terima kasih!");
    }

    private void informasiKamarTersedia() {
        kamarInfoController.informasiKamarTersedia();
    }

    private void lihatDataTamu() {
        kamarInfoController.lihatDataTamu();
    }
}
