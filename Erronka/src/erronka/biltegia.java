package erronka;

public class biltegia {
    public void setProduktuId(int produktuId) {
        this.produktuId = produktuId;
    }

    public void setProduktuIzena(String produktuIzena) {
        this.produktuIzena = produktuIzena;
    }

    public void setProduktuMota(String produktuMota) {
        this.produktuMota = produktuMota;
    }

    public void setProduktuEgoera(String produktuEgoera) {
        this.produktuEgoera = produktuEgoera;
    }

    public void setProduktuIrudia(String produktuIrudia) {
        this.produktuIrudia = produktuIrudia;
    }

    public void setProduktuPrezioa(double produktuPrezioa) {
        this.produktuPrezioa = produktuPrezioa;
    }

    public void setProduktuKantitatea(int produktuKantitatea) {
        this.produktuKantitatea = produktuKantitatea;
    }

    private int produktuId;
    private String produktuIzena;
    private String produktuMota;
    public String getProduktuIzena() {
        return produktuIzena;
    }

    public String getProduktuMota() {
        return produktuMota;
    }

    public String getProduktuEgoera() {
        return produktuEgoera;
    }

    public String getProduktuIrudia() {
        return produktuIrudia;
    }

    public double getProduktuPrezioa() {
        return produktuPrezioa;
    }

    public int getProduktuKantitatea() {
        return produktuKantitatea;
    }

    private String produktuEgoera;
    private String produktuIrudia;
    private double produktuPrezioa;
    private int produktuKantitatea;

    public biltegia(int produktuId, String produktuIzena, String produktuMota, String produktuEgoera, String produktuIrudia, double produktuPrezioa, int produktuKantitatea) {
        this.produktuId = produktuId;
        this.produktuIzena = produktuIzena;
        this.produktuMota = produktuMota;
        this.produktuEgoera = produktuEgoera;
        this.produktuIrudia = produktuIrudia;
        this.produktuPrezioa = produktuPrezioa;
        this.produktuKantitatea = produktuKantitatea;
    }

    // Getters y setters
    public int getProduktuId() {
        return produktuId;
    }
}
