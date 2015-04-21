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
	private String carroceria;
	private int qtdPaletes;
	private String datacadastro;
	private String CNH;

	/** Metodo construtor da classe Veiculo - vazio */

	public Veiculo() {
		this("","",0,"","","", "");
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
			String tipo, String combustivel, String datacadastro) {
		this.placa = placa;
		this.marca = marca;
		this.CapMax = CapMax;
		this.cor = cor;
		this.tipo = tipo;
		this.carroceria = carroceria;
		this.qtdPaletes = qtdPaletes;
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

	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}
	

	public int getQtdPaletes() {
		return qtdPaletes;
	}

	public void setQtdPaletes(int qtdPaletes) {
		this.qtdPaletes = qtdPaletes;
	}

	public String getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(String datacadastro) {
		this.datacadastro = datacadastro;
	}
	
	public String getCNH() {
		return CNH;
	}

	public void setCNH(String cNH) {
		CNH = cNH;
	}
}
