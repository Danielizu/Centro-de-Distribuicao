package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import entity.Veiculo;

public class CrudVeiculo {
	
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
        sb.append(veiculo.getCombustivel());
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

}
