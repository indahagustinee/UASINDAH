package entity;

public class KamarInfo {
    private int noKamar;
    private String jenisBed;
    private double hargaPerMalam;
    private String namaTamu;

    public KamarInfo(int noKamar, String jenisBed, double hargaPerMalam) {
        this.noKamar = noKamar;
        this.jenisBed = jenisBed;
        this.hargaPerMalam = hargaPerMalam;
        this.namaTamu = "";  // Default to an empty string for namaTamu
    }

    public int getNoKamar() {
        return noKamar;
    }

    public String getJenisBed() {
        return jenisBed;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public void setJenisBed(String jenisBed) {
        this.jenisBed = jenisBed;
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        this.hargaPerMalam = hargaPerMalam;
    }

    public void setNamaTamu(String namaTamu) {
        this.namaTamu = namaTamu;
    }
}
