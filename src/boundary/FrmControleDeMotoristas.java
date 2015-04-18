package boundary;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.border.BevelBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import control.ControlarMotorista;
import com.toedter.calendar.JDateChooser;

public class FrmControleDeMotoristas {

	private JFrame frame;
	private JTextField txtNomeMotorista;
	private JTextField txtCNH;
	private JTextField txtDataVencimento;
	private JTextField txtDescricao;
	public ControlarMotorista control = new ControlarMotorista();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmControleDeMotoristas window = new FrmControleDeMotoristas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmControleDeMotoristas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 484, 530);
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Cadastro de Motoristas", TitledBorder.LEFT, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(28, 49, 46, 14);
		panel.add(lblNome);

		txtNomeMotorista = new JTextField();
		txtNomeMotorista.setBounds(78, 46, 368, 20);
		panel.add(txtNomeMotorista);
		txtNomeMotorista.setColumns(10);

		JLabel lblNCnh = new JLabel("N. CNH:");
		lblNCnh.setBounds(28, 87, 46, 14);
		panel.add(lblNCnh);

		txtCNH = new JTextField();
		try {
			javax.swing.text.MaskFormatter cnh = new javax.swing.text.MaskFormatter(
					"###########");

			txtCNH = new javax.swing.JFormattedTextField(cnh);
		} catch (Exception e) {
		}
		txtCNH.setBounds(78, 84, 100, 20);
		panel.add(txtCNH);
		txtCNH.setColumns(10);

		JLabel lblVencimento = new JLabel("Vencimento:");
		lblVencimento.setBounds(261, 87, 90, 14);
		panel.add(lblVencimento);

		txtDataVencimento = new JTextField();
		txtDataVencimento.setBounds(341, 84, 105, 20);
		panel.add(txtDataVencimento);
		txtDataVencimento.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(28, 129, 46, 14);
		panel.add(lblTipo);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 126, 113, 20);
		panel.add(comboBox);

		JLabel lblDataDeCadastro = new JLabel("Data de cadastro: ");
		lblDataDeCadastro.setBounds(28, 180, 130, 14);
		panel.add(lblDataDeCadastro);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(10, 254, 105, 14);
		panel.add(lblObservaes);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(51, 279, 390, 195);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CNH = txtCNH.toString();
				boolean vCNH = control.ValidadorCNH("01137369409");

				if (vCNH == true) {
					JOptionPane.showMessageDialog(null, "O CNH é Valido.");
				} else {
					JOptionPane.showMessageDialog(null, "O CNH é Invalido.");
				}
			}
		});
		btnSalvar.setBounds(156, 496, 89, 23);
		panel.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(273, 496, 89, 23);
		panel.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(385, 496, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		panel.add(btnCancelar);

		JDateChooser dataCadastro = new JDateChooser();
		dataCadastro.setBounds(138, 180, 105, 20);
		panel.add(dataCadastro);
	}
}
