package entity;

public class Cliente {
	// Atributos do cliente
	private String nome;
	private String cpf;
	private String cnpj;
	private String telefone;
	private String endereco;
	private int numero;
	private int cep;
	private String complemento;

	// Construtor da classe cliente
	public Cliente() {
		this("", "", "", "", "", 0, 0, "");
	}

	/**
	 * Metodo construtor da classe Cliente
	 * 
	 * @param nome
	 *            nome do cliente
	 * @param cpf
	 *            cpf do cliente
	 * @param telefone
	 *            telefone do cliente
	 * @param endereco
	 *            endereco do cliente
	 * @param numero
	 *            numero da casa do cliente
	 * @param cep
	 *            cep da residencia da cliente
	 * @param complemento
	 *            complemento da residencia do cliente(nao obrigatorio)
	 */
	public Cliente(String nome, String cnpj, String cpf, String telefone,
			String endereco, int numero, int cep, String complemento) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
