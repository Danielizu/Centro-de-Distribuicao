package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import entity.Cliente;

public class ControlarClientes {

	Cliente cliente = new Cliente();

	/** METODO DE SALVAR PESSOA FISICA */
	public int SalvarPessoaFisica(Cliente cliente) throws IOException {
		File arquivoCliente = new File("Cliente.txt");
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
		File arquivoCliente = new File("Cliente.txt");
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

}
