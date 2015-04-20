package control;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import entity.Cliente;

public class ControlarClientes {

	public String str;
	public String[] linhas;
	public String[] nomeClientes;
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

	// Metodo que faz a leitura de todos o dados dos clientes
	public void lerCliente() throws IOException {
		try {
			// Localizando arquivo para leitura
			BufferedReader lerArq = new BufferedReader(new FileReader(
					"Cliente.txt"));
			// Enquanto a linha nao for nula ele fara a leitura
			while ((str = lerArq.readLine()) != null) {
				// Quebrando a linha caso encontre um ponto e virgula
				linhas = str.split(";");
				// Ate chegar ao tamanho do vetor das linhas exibe o conteudo
				for (String cell : linhas) {
					System.out.println("Conteudo: " + cell);
				}
			}
			System.out.println(linhas);
			lerArq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
	}

	public void alimentarNomeCliente() throws IOException {
		FileInputStream stream = new FileInputStream("Cliente.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();
		
		int numLinhas = 0;
		// Try catch que faz a contagem do numero de linhas do documento, ou
		// seja, quantos registros
		try {
			// Coletando arquivo txt
			File arquivoLeitura = new File("Cliente.txt");
			// Declarando variavel long que conta o numero de linhas
			long tamanhoArquivo = arquivoLeitura.length();
			FileInputStream fs = new FileInputStream(arquivoLeitura);
			DataInputStream in = new DataInputStream(fs);

			@SuppressWarnings("resource")
			LineNumberReader lineRead = new LineNumberReader(
					new InputStreamReader(in));
			lineRead.skip(tamanhoArquivo);

			// Soma a quantidade de linhas
			numLinhas = lineRead.getLineNumber();	
		} catch (IOException e) {

		}
		// Dizendo que o vetor nomeCliente sera do tamanho do numero de
		// registros
		nomeClientes = new String[numLinhas];
		// enquanto as linhas náo forem nulas sera alimentado o vetor com o nome
		// dos clientes.
		for (int i = 0; linha != null; i++) {
			// Coleta somente o nome antes do ponto e virgula
			String nome = linha.substring(0, linha.indexOf(';'));
			// Alimente o vetor nomeCliente com o nome
			nomeClientes[i] = nome;
			linha = br.readLine();
		}
		br.close();
	}
}
