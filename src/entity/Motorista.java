package entity;

public class Motorista {
	
	private String nome;
	private String cnh;
	private String tipo;
	private String vencimento;
	private String datacadastro;
	
	public Motorista() {
		this("", " ", "", "", "");
	}


	/**
	 * Metodo construtor da classe Veiculo
	 * 
	 * @param nome
	 *            é o nome do Motorista
	 * @param cnh
	 *            numero do CNH do Motorista
	 * @param tipo
	 *            é o tipo de documento do Motorista
	 * @param vencimento
	 *            do documento
	 * @param datacadastro
	 *            do motorista no sistema
	 */
	
	public Motorista(String nome, String cnh, String tipo, String vencimento,
			String datadecadastro) {

		this.nome = nome;
		this.cnh = cnh;
		this.tipo = tipo;
		this.vencimento = vencimento;
		this.datacadastro = datacadastro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCnh() {
		return cnh;
	}


	public void setCnh(String cnh) {
		this.cnh = cnh;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getVencimento() {
		return vencimento;
	}


	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}


	public String getDatacadastro() {
		return datacadastro;
	}


	public void setDatacadastro(String datacadastro) {
		this.datacadastro = datacadastro;
	}
	
	
	

}
