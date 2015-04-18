package entity;

import java.util.Date;

/** @version 04/04/2015 */
public class Veiculo {
	// /ATRIBUTOS DO VEICULO
	private String placa;
	private String marca;
	private int CapMax;
	private String cor;
	private String tipo;
	private String combustivel;
	private Date datacadastro;

	/** Metodo construtor da classe Veiculo - vazio */

	public Veiculo() {
		this("","",0,"","","", null);
	}

	/**
	 * Metodo construtor da classe Veiculo
	 * 
	 * @param placa
	 *            e a identificacao do veiculo
	 * @param marca
	 *            do veiculo
	 * @param CapMax
	 *            e a capacidade maxima de materiais suportadas no veiculo
	 * @param cor
	 *            do veiculo
	 * @param tipo
	 *            do veiculo (caminhao, motos ou outros)
	 * @param combustivel
	 *            e o tipo de combustivel rodado no veiculo (diesel, gasolina ou
	 *            outros)
	 * @param datacadastro
	 *            e a data de registro do veiculo
	 */
	public Veiculo(String placa, String marca, int CapMax, String cor,
			String tipo, String combustivel, Date datacadastro) {
		this.placa = placa;
		this.marca = marca;
		this.CapMax = CapMax;
		this.cor = cor;
		this.tipo = tipo;
		this.combustivel = combustivel;
		this.datacadastro = datacadastro;
	}

	// /GETTERS E SETTERS--------------------------------------------------
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCapMax() {
		return CapMax;
	}

	public void setCapMax(int capMax) {
		CapMax = capMax;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
}
