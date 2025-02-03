package klaseak;

import java.sql.Date;

public class Garraiolaria {
    private int IdGarraiolaria;
    private String Izena;
    private String Helbidea;
    private String Abizenak;
    private String Nan;
    private String Telefonoa;
    private String Enpresa;

    public Garraiolaria(int IdGarraiolaria, String Izena, String Helbidea, String Abizenak, String Nan, String Telefonoa, String Enpresa) {
        this.IdGarraiolaria = IdGarraiolaria;
        this.Izena = Izena;
        this.Helbidea = Helbidea;
        this.Abizenak = Abizenak;
        this.Nan = Nan;
        this.Telefonoa = Telefonoa;
        this.Enpresa = Enpresa;
    }

    public int getIdGarraiolaria() {
        return IdGarraiolaria;
    }

    public String getIzena() {
        return Izena;
    }

    public String getHelbidea() {
        return Helbidea;
    }

    public String getAbizenak() {
        return Abizenak;
    }

    public String getNan() {
        return Nan;
    }

    public String getTelefonoa() {
        return Telefonoa;
    }

    public String getEnpresa() {
        return Enpresa;
    }
}

