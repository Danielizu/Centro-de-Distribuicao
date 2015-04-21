package control;

import boundary.FrmConsultaNF;
import entity.Item;

import java.io.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;


public class ControlarItens {

	public FrmConsultaNF form;
	Item item = new Item();
	
	
	public void LimparCampos(JTextField texto) {
		texto.setText(null);
		
	}
}
