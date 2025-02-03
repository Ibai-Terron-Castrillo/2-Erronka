package klaseak;

public class Bezeroa extends pertsona {
	private int idBezeroa;

	
	public Bezeroa(int idBezeroa, String izena, String abizenak, String erabiltzailea, String pasahitza, String email,
			String telefonoa, String nan) {
		super(izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan);
		this.idBezeroa = idBezeroa;
	}


	public int getIdBezeroa() {
		return idBezeroa;
	}


	public void setIdBezeroa(int idBezeroa) {
		this.idBezeroa = idBezeroa;
	}
}
