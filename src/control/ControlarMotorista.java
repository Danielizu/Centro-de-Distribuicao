package control;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import boundary.FrmControleDeMotoristas;

public class ControlarMotorista implements limparTela {

	public FrmControleDeMotoristas form;

	@Override
	public void LimparCampos(JTextField texto) {
		texto.setText(null);

	}

	@Override
	public void LimparComboBox(JComboBox combo) {
		combo.setSelectedItem(null);

	}

	public boolean ValidadorCNH(String CNH) {
		CNH = desformatar(CNH);

		if (!CNH.matches("[0-9]{11}")) {
			return false;
		}

		if (CNH.equals("11111111111") || CNH.equals("22222222222")
				|| CNH.equals("33333333333") || CNH.equals("44444444444")
				|| CNH.equals("55555555555") || CNH.equals("66666666666")
				|| CNH.equals("77777777777") || CNH.equals("88888888888")
				|| CNH.equals("99999999999") || CNH.equals("00000000000")) {
			return false;
		}

		int[] fracao = new int[9];
		int acumulador = 0;
		int inc = 2;
		for (int i = 0; i < 9; i++) {
			fracao[i] = (Math.abs(Integer.parseInt(CNH.substring(i, 1)))) * inc;
			acumulador += fracao[i];
			inc++;
		}

		int resto = acumulador % 11;
		int digito1 = 0;
		if (resto > 1) {
			digito1 = 11 - resto;
		}
		acumulador = digito1 * 2;
		inc = 3;
		for (int i = 0; i < 9; i++) {
			fracao[i] = (Math.abs(Integer.parseInt(CNH.substring(i, 1)))) * inc;
			acumulador += Math.abs(fracao[i]);
			inc++;
		}

		resto = acumulador % 11;
		int digito2 = 0;
		if (resto > 1) {
			digito2 = 11 - resto;
		}
		if (digito1 == Math.abs(Integer.parseInt(CNH.substring(9, 1)))
				&& digito2 == Math.abs(Integer.parseInt(CNH.substring(10, 1)))) {
			return true;
		}

		return false;
	}

	private static String desformatar(String valor) {
		String str = "";
		String caracter = "";
		for (int i = 0; i < valor.length(); i++) {
			caracter = valor.substring(i, i + 1);
			if (ehNumero(caracter)) {
				str += caracter;
			}
		}
		return str;
	}

	private static boolean ehNumero(String caracter) {
		for (int i = 0; i <= 9; i++) {
			if (caracter.equals("" + i)) {
				return true;
			}
		}

		return false;
	}

}
