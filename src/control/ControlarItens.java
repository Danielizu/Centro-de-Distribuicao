package control;

import boundary.FrmConsultaNF;
import entity.Item;
import entity.Motorista;
import javax.swing.*;
import java.io.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class ControlarItens {

	public FrmConsultaNF form;
	Item item = new Item();
	
	
	public int SalvarItem(Item item) throws IOException
    {
        File arquivoItem = new File("Item.csv");        
        StringBuffer sb = new StringBuffer();
        
        sb.append(item.getCliente());
        sb.append(";");
        sb.append(item.getNota());
        sb.append(";");
        sb.append(item.getData());
        sb.append(";");
        sb.append("\r\n");          
        
	try {                   
            FileWriter Arquivo = new FileWriter(arquivoItem,true); 
            PrintWriter grava = new PrintWriter(Arquivo,true);
	
            grava.write(sb.toString());                  
            grava.flush();
            grava.close();
            return 1;
            
        } catch (IOException e) {
            return 0;
        }
    }
	
	public Item PesquisarItem(String pesquisa) {

		String arquivoCSV = "Item.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));

			int verificador = 0;
			while ((linha = br.readLine()) != null) {

				String[] itemcadastrado= linha.split(csvDivisor);
				if (itemcadastrado[0].equals(pesquisa)) {

					item.setCliente(itemcadastrado[0]);
					item.setNota(itemcadastrado[1]);
					item.setData(itemcadastrado[2]);
									verificador++;
				} 

			}
			if (verificador < 1) {
				JOptionPane.showMessageDialog(null, "Item não encontrado.");
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
		return item;
	}
	
	
	public void LimparCampos(JTextField texto) {
		texto.setText(null);
	}

	public void LimparCampos(JDateChooser dataCadastro) {
		dataCadastro.setToolTipText(null);
	}
}
