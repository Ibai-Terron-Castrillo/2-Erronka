package klaseak;

import java.sql.Date;

public class Eskaera {
	private int idEskaera;
    private Date data;
    private String helbidea;
    private String eskaeraEgoera;
    private int idBezeroa;
    private int idGarraiolaria;
	public Eskaera(int idEskaera, Date data, String helbidea, String eskaeraEgoera, int idBezeroa, int idGarraiolaria) {
		this.idEskaera = idEskaera;
		this.data = data;
		this.helbidea = helbidea;
		this.eskaeraEgoera = eskaeraEgoera;
		this.idBezeroa = idBezeroa;
		this.idGarraiolaria = idGarraiolaria;
	}
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
	public int getIdBezeroa() {
		return idBezeroa;
	}
	public void setIdBezeroa(int idBezeroa) {
		this.idBezeroa = idBezeroa;
	}
	public int getIdGarraiolaria() {
		return idGarraiolaria;
	}
	public void setIdGarraiolaria(int idGarraiolaria) {
		this.idGarraiolaria = idGarraiolaria;
	}
	
}
