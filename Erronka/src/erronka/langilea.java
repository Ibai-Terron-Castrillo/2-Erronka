package erronka;

public class langilea extends pertsona {
    private int idLangilea;

    public langilea(String izena, String abizenak, String erabiltzailea, String pasahitza, String email, String telefonoa, String nan, int idLangilea) {
        super(izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan);
        this.idLangilea = idLangilea;
    }

    // Getters y setters
    public int getIdLangilea() {
        return idLangilea;
    }

    public void setIdLangilea(int idLangilea) {
        this.idLangilea = idLangilea;
    }
}
