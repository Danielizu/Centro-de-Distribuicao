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

import entity.Catalogo;

public class ControlarCatalogo {

	public String str;
	public String[] linhas;
	public String[] codProduto;
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

	// Metodo que faz a leitura de todos o dados dos produtos
	public void lerCatalogo() throws IOException {
		try {
			// Localizando arquivo para leitura
			BufferedReader lerArq = new BufferedReader(new FileReader(
					"Catalogo.txt"));
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

	// Metodo para alimentar o vetor com o codigo do produto
	public void alimentarCodProduto() throws IOException {
		FileInputStream stream = new FileInputStream("Catalogo.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String linha = br.readLine();

		int numLinhas = 0;
		// Try catch que faz a contagem do numero de linhas do documento, ou
		// seja, quantos registros
		try {
			// Coletando arquivo txt
			File arquivoLeitura = new File("Catalogo.txt");
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
		codProduto = new String[numLinhas];
		// enquanto as linhas náo forem nulas sera alimentado o vetor com o nome
		// dos clientes.
		for (int i = 0; linha != null; i++) {
			// Coleta somente o nome antes do ponto e virgula
			String cod = linha.substring(0, linha.indexOf(';'));
			// Alimente o vetor nomeCliente com o nome
			codProduto[i] = cod;
			linha = br.readLine();
		}
		br.close();
	}
}
