package controller;

import entity.KamarInfo;
import model.KamarInfoModel;

public class KamarInfoController {
    private KamarInfoModel kamarInfoModel;

    public KamarInfoController() {
        this.kamarInfoModel = new KamarInfoModel();
    }

    public void tambahKamar(int noKamar, String jenisBed, double hargaPerMalam) {
        kamarInfoModel.tambahKamar(noKamar, jenisBed, hargaPerMalam);
    }

    public int jumlahKamar() {
        return kamarInfoModel.jumlahKamar();
    }

    public KamarInfo lihatKamar(int index) {
        return kamarInfoModel.lihatKamar(index);
    }

    public void editDataKamar(int index, int noKamarBaru, String jenisBedBaru, double hargaPerMalamBaru) {
        kamarInfoModel.editDataKamar(index, noKamarBaru, jenisBedBaru, hargaPerMalamBaru);
    }

    public void hapusKamar(int index) {
        kamarInfoModel.hapusKamar(index);
    }

    public void reservasiKamar(int index, String namaTamu) {
        kamarInfoModel.reservasiKamar(index, namaTamu);
    }

    public void detailReservasi(int index) {
        kamarInfoModel.detailReservasi(index);
    }

    public void checkOut(int index) {
        kamarInfoModel.checkOut(index);
    }

    public void informasiKamarTersedia() {
        kamarInfoModel.informasiKamarTersedia();
    }

    public void lihatDataTamu() {
        kamarInfoModel.lihatDataTamu();
    }
}
