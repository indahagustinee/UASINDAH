package model;
import entity.KamarInfo;
import java.util.ArrayList;
import java.util.List;

public class KamarInfoModel {
    private List<KamarInfo> kamarInfos;

    public KamarInfoModel() {
        this.kamarInfos = new ArrayList<>();
    }

    public void tambahKamar(int noKamar, String jenisBed, double hargaPerMalam) {
        KamarInfo kamar = new KamarInfo(noKamar, jenisBed, hargaPerMalam);
        kamarInfos.add(kamar);
    }

    public int jumlahKamar() {
        return kamarInfos.size();
    }

    public KamarInfo lihatKamar(int index) {
        return kamarInfos.get(index);
    }

    public void editDataKamar(int index, int noKamarBaru, String jenisBedBaru, double hargaPerMalamBaru) {
        KamarInfo kamar = kamarInfos.get(index);
        kamar.setJenisBed(jenisBedBaru);
        kamar.setHargaPerMalam(hargaPerMalamBaru);
    }

    public void hapusKamar(int index) {
        kamarInfos.remove(index);
    }

    public void reservasiKamar(int index, String namaTamu) {
        if (!kamarInfos.isEmpty() && index >= 0 && index < kamarInfos.size()) {
            KamarInfo kamar = kamarInfos.get(index);
            kamar.setNamaTamu(namaTamu);
        } else {
            System.out.println("Invalid index for reservation. Please choose a valid room.");
        }
    }

    public void detailReservasi(int index) {
        KamarInfo kamarInfo = kamarInfos.get(index);
        double totalHarga = kamarInfo.getHargaPerMalam();
        System.out.println("Detail Reservasi:");
        System.out.println("Nama Tamu: " + kamarInfo.getNamaTamu());
        System.out.println("No Kamar: " + kamarInfo.getNoKamar());
        System.out.println("Jenis Bed: " + kamarInfo.getJenisBed());
        System.out.println("Harga per Malam: " + kamarInfo.getHargaPerMalam());
        System.out.println("Total Harga: " + totalHarga);
    }

    public void checkOut(int index) {
        KamarInfo kamarInfo = kamarInfos.get(index);
        kamarInfo.setNamaTamu("");  // Clear guest name during check-out
        System.out.println("Check-out berhasil. Terima kasih!");
    }

    public void informasiKamarTersedia() {
        System.out.println("Jumlah kamar yang tersedia: " + (jumlahKamar() - kamarInfos.stream().filter(k -> !k.getNamaTamu().isEmpty()).count()));
    }

    public void lihatDataTamu() {
        System.out.println("Data Tamu:");
        kamarInfos.stream()
                .filter(k -> !k.getNamaTamu().isEmpty())
                .forEach(k -> System.out.println("Nama Tamu: " + k.getNamaTamu() + ", No Kamar: " + k.getNoKamar()));
    }
}
