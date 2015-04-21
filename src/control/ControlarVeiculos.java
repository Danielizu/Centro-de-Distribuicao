package control;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import boundary.FrmControleDeVeiculos;
import entity.Veiculo;

/** @version 04/04/2015 */
public class ControlarVeiculos implements limparTela {

	Veiculo veiculo = new Veiculo();

	/** METODO DE SALVAR VEICULO */
	public int SalvarVeiculo(Veiculo veiculo) throws IOException {
		File arquivoVeiculo = new File("Veiculo.csv");
		StringBuffer sb = new StringBuffer();

		sb.append(veiculo.getPlaca());
		sb.append(";");
		sb.append(veiculo.getMarca());
		sb.append(";");
		sb.append(veiculo.getCapMax());
		sb.append(";");
		sb.append(veiculo.getCor());
		sb.append(";");
		sb.append(veiculo.getTipo());
		sb.append(";");
		sb.append(veiculo.getCarroceria());
		sb.append(";");
		sb.append(veiculo.getQtdPaletes());
		sb.append(";");
		sb.append(veiculo.getDatacadastro());
		sb.append(";");
		sb.append(veiculo.getCNH());
		sb.append("\r\n");

		try {
			FileWriter Arquivo = new FileWriter(arquivoVeiculo, true); // true =
																		// adiciona
																		// novas
																		// linhas
																		// sem
																		// substituir
			PrintWriter grava = new PrintWriter(Arquivo, true);

			grava.write(sb.toString());
			grava.flush();
			grava.close();
			return 1;

		} catch (IOException e) {
			return 0;
		}
	}

	public void Excluir() {

	}

	/** METODO PARA LIMPAR CAMPOS JTEXTFIELD */
	public void LimparCampos(JTextField texto) {
		texto.setText(null);
	}
	
	/** METODO PARA LIMPAR CAMPOS JTEXTAREA */
	public void LimparTextArea(JTextArea texto) {
		texto.setText(null);
	}

	public Veiculo PesquisarPlaca(String pesquisa) {

		String arquivoCSV = "Veiculo.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));

			int verificador = 0;
			while ((linha = br.readLine()) != null) {

				String[] veiculocadastrado = linha.split(csvDivisor);
				// System.out.println(pesquisa);
				if (veiculocadastrado[0].equals(pesquisa)) {

					veiculo.setPlaca(veiculocadastrado[0]);
					veiculo.setMarca(veiculocadastrado[1]);
					veiculo.setCapMax(Integer.valueOf(veiculocadastrado[2]));
					veiculo.setCor(veiculocadastrado[3]);
					veiculo.setTipo(veiculocadastrado[4]);
					veiculo.setCarroceria(veiculocadastrado[5]);
					veiculo.setQtdPaletes(Integer
							.parseInt(veiculocadastrado[6]));
					veiculo.setDatacadastro(veiculocadastrado[7]);
					verificador++;
					
				} 

			}
			if (verificador < 1) {
				JOptionPane.showMessageDialog(null, "Veiculo não encontrado.");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return veiculo;
	}

	/** METODO PARA LIMPAR CAMPOS JCOMBOBOX */
	public void LimparComboBox(JComboBox combo) {
		combo.setSelectedItem(null);
	}

	/** METODO PARA PREENCHER O COMBOBOX */
	public void AdicionarValoresCB(JComboBox combo, String[] lista) {
		for (int i = 0; i < lista.length; i++) {
			combo.addItem(lista[i]);
		}
	}

	/** METODO PARA INSERIR A DATA ATUAL */
	public void InserirData(JTextField data) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		String DataAtual = s.format(c.getTime());
		data.setText(DataAtual);
	}

	public void Alterar() {

	}

}
