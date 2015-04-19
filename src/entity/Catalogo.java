package entity;

public class Catalogo {
	private int codProduto;
	private String nome;
	private String fornecedor;
	private String CNPJ;
	private String telefone;
	private String dataCadastro;
	private int peso;
	private int volume;
	private String descricao;

	public Catalogo() {
		this(0, "", "", "", "", "", 0, 0, "");
	}

	public Catalogo(int codProduto, String nome, String fornecedor,
			String CNPJ, String telefone, String dataCadastro, int peso,
			int volume, String descricao) {
		this.codProduto = codProduto;
		this.nome = nome;
		this.fornecedor = fornecedor;
		this.CNPJ = CNPJ;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.peso = peso;
		this.volume = volume;
		this.descricao = descricao;
	}

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
