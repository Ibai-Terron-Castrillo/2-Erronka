package formularioak;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import klaseak.Eskaera;
import mantenimendua.EskaerakKudeatu;
public class EskaeraEguneratu extends JDialog {

	private JTextField txtData, txtHelbidea, txtEskaeraEgoera, txtIdBezeroa, txtIdGarraiolaria;
    private JPasswordField txtPasahitza;
    private EskaerakKudeatu dao;
    private Eskaera Eskaera;

    public EskaeraEguneratu(JFrame parent, EskaerakKudeatu dao, Eskaera Eskaera) {
        super(parent, "Eskaera Eguneratu", true);
        this.dao = dao;
        this.Eskaera = Eskaera;

        setLayout(new GridLayout(8, 2));
        setSize(400, 350);
        setLocationRelativeTo(parent);

        Date fechaSQL = Eskaera.getData();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String fechaTexto = dateFormat.format(fechaSQL);
        
        add(new JLabel("     Data:"));
        txtData = new JTextField(fechaTexto);
        add(txtData);

        add(new JLabel("     Helbidea:"));
        txtHelbidea = new JTextField(Eskaera.getHelbidea());
        add(txtHelbidea);

        add(new JLabel("     Eskaera Egoera:"));
        txtEskaeraEgoera = new JTextField(Eskaera.getEskaeraEgoera());
        add(txtEskaeraEgoera);

        add(new JLabel("     IdBezeroa:"));
        txtIdBezeroa = new JTextField(String.valueOf(Eskaera.getIdBezeroa()));
        add(txtIdBezeroa);

        add(new JLabel("     IdGarraiolaria:"));
        txtIdGarraiolaria = new JTextField(String.valueOf(Eskaera.getIdGarraiolaria()));
        add(txtIdGarraiolaria);

        JButton btnSave = new JButton("Eguneratu");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	    try {
        	        java.util.Date fechaUtil = dateFormat.parse(txtData.getText());

        	        java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

        	        Eskaera.setData(fechaSQL);
        	    } catch (ParseException e1) {
        	        e1.printStackTrace();
        	        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Usa yyyy-MM-dd.");
        	        return;
        	    }

        	    Eskaera.setHelbidea(txtHelbidea.getText());
        	    Eskaera.setEskaeraEgoera(txtEskaeraEgoera.getText());
        	    Eskaera.setIdBezeroa(Integer.parseInt(txtIdBezeroa.getText()));
        	    Eskaera.setIdGarraiolaria(Integer.parseInt(txtIdGarraiolaria.getText()));

        	    dao.eguneratuEskaera(Eskaera);
        	    JOptionPane.showMessageDialog(EskaeraEguneratu.this, "Eskaera eguneratu da!");
        	    dispose();
        	}

        });
        add(btnSave);

        setVisible(true);
    }
}

