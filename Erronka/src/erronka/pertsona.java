package erronka;

public class pertsona {
    protected String izena;
    protected String abizenak;
    protected String erabiltzailea;
    protected String pasahitza;
    protected String email;
    protected String telefonoa;
    protected String nan;

    public pertsona(String izena, String abizenak, String erabiltzailea, String pasahitza, String email, String telefonoa, String nan) {
        this.izena = izena;
        this.abizenak = abizenak;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
        this.email = email;
        this.telefonoa = telefonoa;
        this.nan = nan;
    }

    // Métodos getters
    public String getIzena() {
        return izena;
    }

    public String getAbizenak() {
        return abizenak;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    // Getters para otros campos si es necesario
    public String getEmail() {
        return email;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public String getNan() {
        return nan;
    }
}


