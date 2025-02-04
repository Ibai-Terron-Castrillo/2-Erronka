package klaseak;

import java.sql.Date;

public class Erosketa {
	private int idErosketa;
	private int ProduktuKantitatea;
	private Date data;
	private double ProduktuPrezioa;
	private String ProduktuIrudia;
	private String ProduktuEgoera; 
	private String ProduktuMota; 
	private String ProduktuIzena;
	private int idHornitzailea;
	
	public Erosketa(int idErosketa, int produktuKantitatea, Date data, double produktuPrezioa, String produktuIrudia,
			String produktuEgoera, String produktuMota, String produktuIzena, int idHornitzailea) {
		this.idErosketa = idErosketa;
		ProduktuKantitatea = produktuKantitatea;
		this.data = data;
		ProduktuPrezioa = produktuPrezioa;
		ProduktuIrudia = produktuIrudia;
		ProduktuEgoera = produktuEgoera;
		ProduktuMota = produktuMota;
		ProduktuIzena = produktuIzena;
		this.idHornitzailea = idHornitzailea;
	}

	public int getIdErosketa() {
		return idErosketa;
	}

	public void setIdErosketa(int idErosketa) {
		this.idErosketa = idErosketa;
	}

	public int getProduktuKantitatea() {
		return ProduktuKantitatea;
	}

	public void setProduktuKantitatea(int produktuKantitatea) {
		ProduktuKantitatea = produktuKantitatea;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getProduktuPrezioa() {
		return ProduktuPrezioa;
	}

	public void setProduktuPrezioa(double produktuPrezioa) {
		ProduktuPrezioa = produktuPrezioa;
	}

	public String getProduktuIrudia() {
		return ProduktuIrudia;
	}

	public void setProduktuIrudia(String produktuIrudia) {
		ProduktuIrudia = produktuIrudia;
	}

	public String getProduktuEgoera() {
		return ProduktuEgoera;
	}

	public void setProduktuEgoera(String produktuEgoera) {
		ProduktuEgoera = produktuEgoera;
	}

	public String getProduktuMota() {
		return ProduktuMota;
	}

	public void setProduktuMota(String produktuMota) {
		ProduktuMota = produktuMota;
	}

	public String getProduktuIzena() {
		return ProduktuIzena;
	}

	public void setProduktuIzena(String produktuIzena) {
		ProduktuIzena = produktuIzena;
	}

	public int getIdHornitzailea() {
		return idHornitzailea;
	}

	public void setIdHornitzailea(int idHornitzailea) {
		this.idHornitzailea = idHornitzailea;
	}
}
