package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import entity.Catalogo;
import entity.Cliente;

public class ControlarCatalogo {

	public boolean notFound = false;
	Catalogo catalogo = new Catalogo();

	/** METODO DE SALVAR PESSOA CATALOGO */
	public int SalvarCatalogo(Catalogo catalogo) throws IOException {
		File arquivoCatalogo = new File("Catalogo.txt");
		StringBuffer sb = new StringBuffer();

		sb.append(catalogo.getCodProduto());
		sb.append(";");
		sb.append(catalogo.getNome());
		sb.append(";");
		sb.append(catalogo.getFornecedor());
		sb.append(";");
		sb.append(catalogo.getCNPJ());
		sb.append(";");
		sb.append(catalogo.getTelefone());
		sb.append(";");
		sb.append(catalogo.getDataCadastro());
		sb.append(";");
		sb.append(catalogo.getPeso());
		sb.append(";");
		sb.append(catalogo.getVolume());
		sb.append(";");
		sb.append(catalogo.getDescricao());
		sb.append(";");
		sb.append("\r\n");

		try {
			FileWriter Arquivo = new FileWriter(arquivoCatalogo, true);
			PrintWriter grava = new PrintWriter(Arquivo, true);
			grava.write(sb.toString());
			grava.flush();
			grava.close();
			return 1;

		} catch (IOException e) {
			return 0;
		}
	}

	/** METODO PARA CONSULTA DE PRODUTOS */
	public Catalogo PesquisarCatalogo(String pesquisa) {

		String arquivoCSV = "Catalogo.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			int verificador = 0;
			while ((linha = br.readLine()) != null) {

				String[] produtoCadastrado = linha.split(csvDivisor);
				if (produtoCadastrado[1].equals(pesquisa)) {
					catalogo.setCodProduto(Integer
							.valueOf(produtoCadastrado[0]));
					catalogo.setNome(produtoCadastrado[1]);
					catalogo.setFornecedor(produtoCadastrado[2]);
					catalogo.setCNPJ(produtoCadastrado[3]);
					catalogo.setTelefone(produtoCadastrado[4]);
					catalogo.setDataCadastro(produtoCadastrado[5]);
					catalogo.setPeso(Integer.valueOf(produtoCadastrado[6]));
					catalogo.setVolume(Integer.valueOf(produtoCadastrado[7]));
					catalogo.setDescricao(produtoCadastrado[8]);
					verificador++;
					notFound = true;
				}
			}
			if (verificador < 1) {
				JOptionPane.showMessageDialog(null, "Produto não encontrado.");
				notFound = false;
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
		return catalogo;
	}
}
