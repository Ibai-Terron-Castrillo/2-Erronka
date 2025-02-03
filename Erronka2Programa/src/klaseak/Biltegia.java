package klaseak;

public class Biltegia {
	private int ProduktuId;
	private String ProduktuIzena;
	private String ProduktuMota;
	private String ProduktuEgoera;
	private String ProduktuIruId;
	private double ProduktuPrezioa;
	private int ProduktuKantitatea;
	
	public Biltegia(int produktuId, String produktuIzena, String produktuMota, String produktuEgoera,
			String produktuIruId, double produktuPrezioa, int produktuKantitatea) {
		ProduktuId = produktuId;
		ProduktuIzena = produktuIzena;
		ProduktuMota = produktuMota;
		ProduktuEgoera = produktuEgoera;
		ProduktuIruId = produktuIruId;
		ProduktuPrezioa = produktuPrezioa;
		ProduktuKantitatea = produktuKantitatea;
	}
	public int getProduktuId() {
		return ProduktuId;
	}
	public void setProduktuId(int produktuId) {
		ProduktuId = produktuId;
	}
	public String getProduktuIzena() {
		return ProduktuIzena;
	}
	public void setProduktuIzena(String produktuIzena) {
		ProduktuIzena = produktuIzena;
	}
	public String getProduktuMota() {
		return ProduktuMota;
	}
	public void setProduktuMota(String produktuMota) {
		ProduktuMota = produktuMota;
	}
	public String getProduktuEgoera() {
		return ProduktuEgoera;
	}
	public void setProduktuEgoera(String produktuEgoera) {
		ProduktuEgoera = produktuEgoera;
	}
	public String getProduktuIruId() {
		return ProduktuIruId;
	}
	public void setProduktuIruId(String produktuIruId) {
		ProduktuIruId = produktuIruId;
	}
	public double getProduktuPrezioa() {
		return ProduktuPrezioa;
	}
	public void setProduktuPrezioa(double produktuPrezioa) {
		ProduktuPrezioa = produktuPrezioa;
	}
	public int getProduktuKantitatea() {
		return ProduktuKantitatea;
	}
	public void setProduktuKantitatea(int produktuKantitatea) {
		ProduktuKantitatea = produktuKantitatea;
	}
	
}
