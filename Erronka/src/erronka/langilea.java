package erronka;

public class langilea extends pertsona {
    private int idLangilea;

    public langilea(String izena, String abizenak, String erabiltzailea, String pasahitza, String email, String telefonoa, String nan, int idLangilea) {
        super(izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan);
        this.idLangilea = idLangilea;
    }

    // Getters y setters
    public int getIdLangilea() {
        return idLangilea;
    }

    public void setIdLangilea(int idLangilea) {
        this.idLangilea = idLangilea;
    }

    // Método para iniciar sesión
    public boolean login(String erabiltzaileaSartu, String pasahitzaSartu) {
        // Verifica si el nombre de usuario y la contraseña coinciden
        if (this.getErabiltzailea().equals(erabiltzaileaSartu) && this.getPasahitza().equals(pasahitzaSartu)) {
            System.out.println("Ongi etorri, " + this.getIzena() + " " + this.getAbizenak() + "!");
            return true; // Inicio de sesión exitoso
        } else {
            System.out.println("Erabiltzailea edo pasahitza okerrak.");
            return false; // Inicio de sesión fallido
        }
    }
    	private String getIzena() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getAbizenak() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getPasahitza() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getErabiltzailea() {
		// TODO Auto-generated method stub
		return null;
	}
}