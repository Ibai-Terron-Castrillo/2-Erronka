package erronka;

import java.util.Date;

public class eskaera {
    private int idEskaera;
    private Date data;
    private String helbidea;
    private String eskaeraEgoera;
    private int idGarraiolaria;

    public int getIdEskaera() {
        return idEskaera;
    }

    public void setIdEskaera(int idEskaera) {
        this.idEskaera = idEskaera;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHelbidea() {
        return helbidea;
    }

    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    public String getEskaeraEgoera() {
        return eskaeraEgoera;
    }

    public void setEskaeraEgoera(String eskaeraEgoera) {
        this.eskaeraEgoera = eskaeraEgoera;
    }

    public int getIdGarraiolaria() {
        return idGarraiolaria;
    }

    public void setIdGarraiolaria(int idGarraiolaria) {
        this.idGarraiolaria = idGarraiolaria;
    }

    public eskaera(int idEskaera, Date data, String helbidea, String eskaeraEgoera, int idGarraiolaria) {
        this.idEskaera = idEskaera;
        this.data = data;
        this.helbidea = helbidea;
        this.eskaeraEgoera = eskaeraEgoera;
        this.idGarraiolaria = idGarraiolaria;
    }

    // Getters y setters
}
