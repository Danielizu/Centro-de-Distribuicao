package control;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import boundary.FrmControleDeVeiculos;
import entity.Veiculo;

/** @version 04/04/2015 */
public class ControlarVeiculos implements limparTela {

	//public FrmControleDeVeiculos form;
	Veiculo veiculo = new Veiculo();

	/** METODO DE SALVAR VEICULO */
	public void Salvar() throws IOException {
		String FileName = "RegistroVeiculos.txt";
		veiculo = new Veiculo();
		
		

		BufferedWriter writer = new BufferedWriter(new FileWriter(FileName));
		// veiculo.setPlaca();
		
		
	//	writer.write(veiculo.setPlaca(form.txtPlaca.getText()););
		
	}

	public void Excluir() {

	}

	public void LimparCampos(JTextField texto) {
		texto.setText(null);
	}

	public void LimparComboBox(JComboBox combo) {
		combo.setSelectedItem(null);
	}

	public void AdicionarValoresCB(JComboBox combo, String[] lista) {

		for (int i = 0; i < lista.length; i++) {
			combo.addItem(lista[i]);
		}
	}

	public void InserirData(JTextField data) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		String DataAtual = s.format(c.getTime());
		data.setText(DataAtual);
	}

	public void Alterar() {

	}
	

}
