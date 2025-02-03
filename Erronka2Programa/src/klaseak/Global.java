package klaseak;

public class Global {
	private int eskaeraID;
    private String bezeroa;
    private String email;
    private String telefonoa;
    private String eskaeraData;
    private String helbidea;
    private String produktuak;
    private String guztira;
    private String garraiolaria;
    private String eskaeraEgoera;
	
	public Global(int eskaeraID, String bezeroa, String email, String telefonoa, String eskaeraData, String helbidea,
			String produktuak, String guztira, String garraiolaria, String eskaeraEgoera) {
		this.eskaeraID = eskaeraID;
		this.bezeroa = bezeroa;
		this.email = email;
		this.telefonoa = telefonoa;
		this.eskaeraData = eskaeraData;
		this.helbidea = helbidea;
		this.produktuak = produktuak;
		this.guztira = guztira;
		this.garraiolaria = garraiolaria;
		this.eskaeraEgoera = eskaeraEgoera;
	}

	public int getEskaeraID() {
		return eskaeraID;
	}

	public void setEskaeraID(int eskaeraID) {
		this.eskaeraID = eskaeraID;
	}

	public String getBezeroa() {
		return bezeroa;
	}

	public void setBezeroa(String bezeroa) {
		this.bezeroa = bezeroa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public String getEskaeraData() {
		return eskaeraData;
	}

	public void setEskaeraData(String eskaeraData) {
		this.eskaeraData = eskaeraData;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public String getProduktuak() {
		return produktuak;
	}

	public void setProduktuak(String produktuak) {
		this.produktuak = produktuak;
	}

	public String getGuztira() {
		return guztira;
	}

	public void setGuztira(String guztira) {
		this.guztira = guztira;
	}

	public String getGarraiolaria() {
		return garraiolaria;
	}

	public void setGarraiolaria(String garraiolaria) {
		this.garraiolaria = garraiolaria;
	}

	public String getEskaeraEgoera() {
		return eskaeraEgoera;
	}

	public void setEskaeraEgoera(String eskaeraEgoera) {
		this.eskaeraEgoera = eskaeraEgoera;
	}
    
}
