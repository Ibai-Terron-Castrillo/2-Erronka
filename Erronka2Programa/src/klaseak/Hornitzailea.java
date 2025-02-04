package klaseak;

public class Hornitzailea {
	private int idHornitzailea;
	private String Izena;
	private String Deskripzioa; 
	private String Telefonoa; 
	private String Email;
	
	public Hornitzailea(int idHornitzailea, String izena, String deskripzioa, String telefonoa, String email) {
		this.idHornitzailea = idHornitzailea;
		Izena = izena;
		Deskripzioa = deskripzioa;
		Telefonoa = telefonoa;
		Email = email;
	}

	public int getIdHornitzailea() {
		return idHornitzailea;
	}

	public void setIdHornitzailea(int idHornitzailea) {
		this.idHornitzailea = idHornitzailea;
	}

	public String getIzena() {
		return Izena;
	}

	public void setIzena(String izena) {
		Izena = izena;
	}

	public String getDeskripzioa() {
		return Deskripzioa;
	}

	public void setDeskripzioa(String deskripzioa) {
		Deskripzioa = deskripzioa;
	}

	public String getTelefonoa() {
		return Telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		Telefonoa = telefonoa;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
