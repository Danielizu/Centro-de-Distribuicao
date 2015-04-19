package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import entity.Catalogo;

public class ControlarCatalogo {

	Catalogo catalogo = new Catalogo();
	
	/** METODO DE SALVAR PESSOA CATALOGO*/
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
	
}
