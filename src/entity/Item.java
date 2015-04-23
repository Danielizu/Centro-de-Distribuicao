package entity;

public class Item {

	private String cliente;
	private String nota;
	private String data;
	
	public Item (){
		this ("", "", "");
	}
	public Item (String cliente, String nota, String data){
		this.cliente = cliente;
		this.nota = nota;
		this.data = data;
		
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
	
	
	
}
