package control;

import boundary.FrmConsultaNF;
import entity.Item;
import java.io.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class ControlarItens {

	public FrmConsultaNF form;
	Item item = new Item();
	
	
	public void LimparCampos(JTextField texto) {
		texto.setText(null);
	}
	public void LimparData (JDateChooser texto){
		texto.setToolTipText(null);
	
	}
}
