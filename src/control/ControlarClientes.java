package control;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import entity.Cliente;
import entity.Veiculo;

public class ControlarClientes {

	public String str;
	public String[] linhas;
	public String[] nomeClientes;
	Cliente cliente = new Cliente();

	/** METODO DE SALVAR PESSOA FISICA */
	public int SalvarPessoaFisica(Cliente cliente) throws IOException {
		File arquivoCliente = new File("Cliente.csv");
		StringBuffer sb = new StringBuffer();

		sb.append(cliente.getNome());
		sb.append(";");
		sb.append(cliente.getCpf());
		sb.append(";");
		sb.append(cliente.getTelefone());
		sb.append(";");
		sb.append(cliente.getEndereco());
		sb.append(";");
		sb.append(cliente.getNumero());
		sb.append(";");
		sb.append(cliente.getCep());
		sb.append(";");
		sb.append(cliente.getComplemento());
		sb.append(";");
		sb.append("\r\n");

		try {
			FileWriter Arquivo = new FileWriter(arquivoCliente, true);
			PrintWriter grava = new PrintWriter(Arquivo, true);

			grava.write(sb.toString());
			grava.flush();
			grava.close();
			return 1;

		} catch (IOException e) {
			return 0;
		}
	}

	/** METODO DE SALVAR PESSOA JURIDICA */
	public int SalvarPessoaJuridica(Cliente cliente) throws IOException {
		File arquivoCliente = new File("Cliente.csv");
		StringBuffer sb = new StringBuffer();

		sb.append(cliente.getNome());
		sb.append(";");
		sb.append(cliente.getCnpj());
		sb.append(";");
		sb.append(cliente.getTelefone());
		sb.append(";");
		sb.append(cliente.getEndereco());
		sb.append(";");
		sb.append(cliente.getNumero());
		sb.append(";");
		sb.append(cliente.getCep());
		sb.append(";");
		sb.append(cliente.getComplemento());
		sb.append(";");
		sb.append("\r\n");

		try {
			FileWriter Arquivo = new FileWriter(arquivoCliente, true);
			PrintWriter grava = new PrintWriter(Arquivo, true);

			grava.write(sb.toString());
			grava.flush();
			grava.close();
			return 1;

		} catch (IOException e) {
			return 0;
		}
	}

	public Cliente PesquisarCliente(String pesquisa) {

		String arquivoCSV = "Cliente.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));

			int verificador = 0;
			while ((linha = br.readLine()) != null) {

				String[] clienteCadastrado = linha.split(csvDivisor);
				// System.out.println(pesquisa);
				if (clienteCadastrado[1].equals(pesquisa)) {

					cliente.setNome(clienteCadastrado[0]);
					cliente.setCpf((clienteCadastrado[1]));
					cliente.setTelefone(clienteCadastrado[2]);
					cliente.setEndereco(clienteCadastrado[3]);
					cliente.setNumero(Integer.valueOf(clienteCadastrado[4]));
					cliente.setCep(Integer.valueOf(clienteCadastrado[5]));
					cliente.setComplemento(clienteCadastrado[6]);
					verificador++;
				} 

			}
			if (verificador < 1) {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
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
		return cliente;
	}
}
