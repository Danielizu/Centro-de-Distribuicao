package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.Motorista;
import entity.Veiculo;
import boundary.FrmControleDeMotoristas;

public class ControlarMotorista implements limparTela {

	public FrmControleDeMotoristas form;
	Motorista motorista = new Motorista();
	
	/** METODO DE SALVAR MOTORISTA */
	public int SalvarMotorista(Motorista motorista) throws IOException
    {
        File arquivoMotorista = new File("Motorista.csv");        
        StringBuffer sb = new StringBuffer();
        
        sb.append(motorista.getNome());
        sb.append(";");
        sb.append(motorista.getCnh());
        sb.append(";");
        sb.append(motorista.getTipo());
        sb.append(";");
        sb.append(motorista.getVencimento());
        sb.append(";");
        sb.append(motorista.getDatacadastro());
        sb.append(";");
        sb.append("\r\n");          
        
	try {                   
            FileWriter Arquivo = new FileWriter(arquivoMotorista,true); // true = adiciona novas linhas sem substituir
            PrintWriter grava = new PrintWriter(Arquivo,true);
            
            grava.write(sb.toString());                  
            grava.flush();
            grava.close();
            return 1;
            
        } catch (IOException e) {
            return 0;
        }
    }

	public Motorista PesquisarCNH(String pesquisa) {

		String arquivoCSV = "Motorista.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));

			int verificador = 0;
			while ((linha = br.readLine()) != null) {

				String[] motoristacadastrado = linha.split(csvDivisor);
				if (motoristacadastrado[1].equals(pesquisa)) {

					motorista.setNome(motoristacadastrado[0]);
					motorista.setCnh(motoristacadastrado[1]);
					motorista.setTipo(motoristacadastrado[2]);
					motorista.setVencimento(motoristacadastrado[3]);
					motorista.setDatacadastro(motoristacadastrado[4]);
					verificador++;
				} 

			}
			if (verificador < 1) {
				JOptionPane.showMessageDialog(null, "Motorista não encontrado.");
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
		return motorista;
	}
	
	@Override
	public void LimparCampos(JTextField texto) {
		texto.setText(null);

	}

	@Override
	public void LimparComboBox(JComboBox combo) {
		combo.setSelectedItem(null);

	}

	public boolean ValidadorCNH(String CNH) {
		CNH = desformatar(CNH);

		if (!CNH.matches("[0-9]{11}")) {
			return false;
		}

		if (CNH.equals("11111111111") || CNH.equals("22222222222")
				|| CNH.equals("33333333333") || CNH.equals("44444444444")
				|| CNH.equals("55555555555") || CNH.equals("66666666666")
				|| CNH.equals("77777777777") || CNH.equals("88888888888")
				|| CNH.equals("99999999999") || CNH.equals("00000000000")) {
			return false;
		}

		int[] fracao = new int[9];
		int acumulador = 0;
		int inc = 2;
		for (int i = 0; i < 9; i++) {
			fracao[i] = (Math.abs(Integer.parseInt(CNH.substring(i, 1)))) * inc;
			acumulador += fracao[i];
			inc++;
		}

		int resto = acumulador % 11;
		int digito1 = 0;
		if (resto > 1) {
			digito1 = 11 - resto;
		}
		acumulador = digito1 * 2;
		inc = 3;
		for (int i = 0; i < 9; i++) {
			fracao[i] = (Math.abs(Integer.parseInt(CNH.substring(i, 1)))) * inc;
			acumulador += Math.abs(fracao[i]);
			inc++;
		}

		resto = acumulador % 11;
		int digito2 = 0;
		if (resto > 1) {
			digito2 = 11 - resto;
		}
		if (digito1 == Math.abs(Integer.parseInt(CNH.substring(9, 1)))
				&& digito2 == Math.abs(Integer.parseInt(CNH.substring(10, 1)))) {
			return true;
		}

		return false;
	}

	private static String desformatar(String valor) {
		String str = "";
		String caracter = "";
		for (int i = 0; i < valor.length(); i++) {
			caracter = valor.substring(i, i + 1);
			if (ehNumero(caracter)) {
				str += caracter;
			}
		}
		return str;
	}

	private static boolean ehNumero(String caracter) {
		for (int i = 0; i <= 9; i++) {
			if (caracter.equals("" + i)) {
				return true;
			}
		}

		return false;
	}

	/** METODO PARA PREENCHER O COMBOBOX */
	public void AdicionarValoresCB(JComboBox combo, String[] lista) {
		for (int i = 0; i < lista.length; i++) {
			combo.addItem(lista[i]);
		}
	}
}
