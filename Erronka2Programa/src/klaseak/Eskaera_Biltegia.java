package klaseak;

public class Eskaera_Biltegia {
	private int idEskaera;
	private int ProduktuId;
	private int Kantitatea;
	private double GuztiraPrezioa;

	public Eskaera_Biltegia(int idEskaera, int produktuId, int kantitatea, double guztiraPrezioa) {
		this.idEskaera = idEskaera;
		ProduktuId = produktuId;
		Kantitatea = kantitatea;
		GuztiraPrezioa = guztiraPrezioa;
	}

	public int getIdEskaera() {
		return idEskaera;
	}

	public void setIdEskaera(int idEskaera) {
		this.idEskaera = idEskaera;
	}

	public int getProduktuId() {
		return ProduktuId;
	}

	public void setProduktuId(int produktuId) {
		ProduktuId = produktuId;
	}

	public int getKantitatea() {
		return Kantitatea;
	}

	public void setKantitatea(int kantitatea) {
		Kantitatea = kantitatea;
	}

	public double getGuztiraPrezioa() {
		return GuztiraPrezioa;
	}

	public void setGuztiraPrezioa(double guztiraPrezioa) {
		GuztiraPrezioa = guztiraPrezioa;
	}
	
}
