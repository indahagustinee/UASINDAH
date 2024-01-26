package entity;

public class Tamu {
    private String nama;
    private int noKamar;

    public Tamu(String nama, int noKamar) {
        this.nama = nama;
        this.noKamar = noKamar;
    }

    public String getNama() {
        return nama;
    }

    public int getNoKamar() {
        return noKamar;
    }
}
