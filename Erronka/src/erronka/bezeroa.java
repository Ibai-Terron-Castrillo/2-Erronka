package erronka;

import java.util.ArrayList;
import java.util.List;

public class bezeroa extends pertsona {
    private int idBezeroa;
    private List<eskaera> eskaerak;

    public  bezeroa(String izena, String abizenak, String erabiltzailea, String pasahitza, String email, String telefonoa, String nan, int idBezeroa) {
        super(izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan);
        this.idBezeroa = idBezeroa;
        this.eskaerak = new ArrayList<>();
    }

    public void addEskaera(eskaera eskaera) {
        eskaerak.add(eskaera);
    }

    // Getters y setters
}
