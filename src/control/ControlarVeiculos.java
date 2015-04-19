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
	public int SalvarVeiculo(Veiculo veiculo) throws IOException
    {
        File arquivoVeiculo = new File("Veiculo.txt");        
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
        sb.append(veiculo.getDatacadastro());
        sb.append(";");
        sb.append("\r\n");          
        
	try {                   
            FileWriter Arquivo = new FileWriter(arquivoVeiculo,true); // true = adiciona novas linhas sem substituir
            PrintWriter grava = new PrintWriter(Arquivo,true);
            
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
