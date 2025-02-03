package klaseak;

public class langilea extends pertsona {
	private int Id;
	private String Helbidea;
	private int LangileKodea;
	private boolean Admin;

	public langilea(int Id, String Izena, String Abizenak, String Erabiltzailea, String Pasahitza, String email, String telefonoa, String Nan, String Helbidea, int LangileKodea, boolean Admin
) {
		super(Izena, Abizenak, Erabiltzailea, Pasahitza, email, telefonoa, Nan);
		this.Id = Id;
		this.Helbidea = Helbidea;
		this.LangileKodea = LangileKodea;
		this.Admin = Admin;
	}

	public langilea() {
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		this.Admin = admin;
	}

	public int getIdLangilea() {
		return Id;
	}

	public void setIdLangilea(int idLangilea) {
		this.Id = idLangilea;
	}

	public String getHelbidea() {
		return Helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.Helbidea = helbidea;
	}

	public int getLangileKodea() {
		return LangileKodea;
	}

	public void setLangileKodea(int langileKodea) {
		this.LangileKodea = langileKodea;
	}

}
