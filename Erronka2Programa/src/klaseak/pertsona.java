package klaseak;

public class pertsona {
	private String Izena;
	private String Abizenak;
	private String Erabiltzailea;
	private String Pasahitza;
	private String email;
	private String telefonoa;
	private String Nan;

	public pertsona(String izena, String abizenak, String erabiltzailea, String pasahitza, String email,
			String telefonoa, String nan) {
		this.Izena = izena;
		this.Abizenak = abizenak;
		this.Erabiltzailea = erabiltzailea;
		this.Pasahitza = pasahitza;
		this.email = email;
		this.telefonoa = telefonoa;
		this.Nan = nan;
	}

	public pertsona() {
	}

	public String getIzena() {
		return Izena;
	}

	public void setIzena(String izena) {
		this.Izena = izena;
	}

	public String getAbizenak() {
		return Abizenak;
	}

	public void setAbizenak(String abizenak) {
		this.Abizenak = abizenak;
	}

	public String getErabiltzailea() {
		return Erabiltzailea;
	}

	public void setErabiltzailea(String erabiltzailea) {
		this.Erabiltzailea = erabiltzailea;
	}

	public String getPasahitza() {
		return Pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.Pasahitza = pasahitza;
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

	public String getNan() {
		return Nan;
	}

	public void setNan(String nan) {
		this.Nan = nan;
	}

}
