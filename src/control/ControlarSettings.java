package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ControlarSettings {

	public int AdicionarCor(String entrada) {

		{
			String listacor = "Cores.txt";
			StringBuffer sb = new StringBuffer();

			sb.append(entrada);
			sb.append("\r\n");

			try {
				FileWriter Arquivo = new FileWriter(listacor, true); // true =
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
	}

	public int AdicionarMarca(String entrada) {

		{
			String listamarca = "Marcas.txt";
			StringBuffer sb = new StringBuffer();

			sb.append(entrada);
			sb.append("\r\n");

			try {
				FileWriter Arquivo = new FileWriter(listamarca, true); // true =
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
	}

	public int AdicionarTipo(String entrada) {

		{
			String listatipo = "Tipos.txt";
			StringBuffer sb = new StringBuffer();

			sb.append(entrada);
			sb.append("\r\n");

			try {
				FileWriter Arquivo = new FileWriter(listatipo, true); // true =
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
	}
	
	public int AdicionarCarroceria(String entrada) {

		{
			String listacarroceria = "Carroceria.txt";
			StringBuffer sb = new StringBuffer();

			sb.append(entrada);
			sb.append("\r\n");

			try {
				FileWriter Arquivo = new FileWriter(listacarroceria, true); // true =
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
	}
}
