package erronka;

public class EskaeraProduktua {
    private int produktuId;
    private int idEskaera;
    private int kantitatea;
    public int getProduktuId() {
        return produktuId;
    }

    public void setProduktuId(int produktuId) {
        this.produktuId = produktuId;
    }

    public int getIdEskaera() {
        return idEskaera;
    }

    public void setIdEskaera(int idEskaera) {
        this.idEskaera = idEskaera;
    }

    public int getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    public double getGuztiraPrezioa() {
        return guztiraPrezioa;
    }

    public void setGuztiraPrezioa(double guztiraPrezioa) {
        this.guztiraPrezioa = guztiraPrezioa;
    }

    private double guztiraPrezioa;

    public EskaeraProduktua(int produktuId, int idEskaera, int kantitatea, double guztiraPrezioa) {
        this.produktuId = produktuId;
        this.idEskaera = idEskaera;
        this.kantitatea = kantitatea;
        this.guztiraPrezioa = guztiraPrezioa;
    }

    // Getters y setters
}