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
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import control.ControlarMotorista;

import com.toedter.calendar.JDateChooser;

import entity.Motorista;

public class FrmControleDeMotoristas extends JFrame {

	JFrame frame;
	private JTextField txtNomeMotorista;
	private JTextField txtCNH;
	private JTextField txtDataVencimento;
	private JTextArea txtDescricao;
	public ControlarMotorista control = new ControlarMotorista();
	public Motorista motorista = new Motorista();
	public String TipoDocumento[] = { null, "A", "B", "C", "D", "E" };

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FrmControleDeMotoristas window = new FrmControleDeMotoristas();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

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
		frame.setBounds(100, 100, 520, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 484, 493);
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
		txtCNH.setBounds(78, 83, 121, 20);
		panel.add(txtCNH);
		txtCNH.setColumns(10);

		JLabel lblVencimento = new JLabel("Vencimento:");
		lblVencimento.setBounds(261, 87, 90, 14);
		panel.add(lblVencimento);

		final JDateChooser dataCadastro = new JDateChooser();
		dataCadastro.setBounds(140, 143, 90, 20);
		panel.add(dataCadastro);

		txtDataVencimento = new JTextField();
		try {
			javax.swing.text.MaskFormatter vencimento = new javax.swing.text.MaskFormatter(
					"##/##/####");

			txtDataVencimento = new javax.swing.JFormattedTextField(vencimento);
		} catch (Exception e) {
		}
		txtDataVencimento.setBounds(341, 84, 105, 20);
		panel.add(txtDataVencimento);
		txtDataVencimento.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(28, 115, 46, 14);
		panel.add(lblTipo);

		final JComboBox cbTipo = new JComboBox();
		control.AdicionarValoresCB(cbTipo, TipoDocumento);
		cbTipo.setBounds(78, 112, 152, 20);
		panel.add(cbTipo);

		JLabel lblDataDeCadastro = new JLabel("Data de cadastro: ");
		lblDataDeCadastro.setBounds(28, 143, 130, 14);
		panel.add(lblDataDeCadastro);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(28, 211, 105, 14);
		panel.add(lblObservaes);

		txtDescricao = new JTextArea();
		txtDescricao.setBounds(56, 236, 390, 195);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null,
						"Deseja confirmar o cadastro do motorista?", "WARNING",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					String data  = ((JTextField)dataCadastro.getDateEditor().getUiComponent()).getText();
					
					motorista.setNome(txtNomeMotorista.getText());
					motorista.setCnh(txtCNH.getText());
					motorista.setTipo(cbTipo.getSelectedItem().toString());
					motorista.setVencimento(txtDataVencimento.getText());
					motorista.setDatacadastro(data);
					try {
						control.SalvarMotorista(motorista);
					} catch (IOException e1) {
						System.out.println("Arquivo n�o encontrado");
						e1.printStackTrace();
					}
					control.LimparCampos(txtNomeMotorista);
					control.LimparTextArea(txtDescricao);
					control.LimparCampos(txtDataVencimento);
					control.LimparCampos(txtCNH);
					control.LimparComboBox(cbTipo);
				}

			}
		});
		btnSalvar.setBounds(128, 459, 89, 23);
		panel.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(244, 459, 89, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.LimparCampos(txtNomeMotorista);
				control.LimparTextArea(txtDescricao);
				control.LimparCampos(txtDataVencimento);
				control.LimparCampos(txtCNH);
				control.LimparComboBox(cbTipo);
			}
		});
		panel.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(357, 459, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnCancelar);

		JButton pesquisarMotorista = new JButton("");
		setAlwaysOnTop(true);
		pesquisarMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String search = txtCNH.getText();
				motorista = control.PesquisarCNH(search);

				txtNomeMotorista.setText(motorista.getNome());
				txtCNH.setText(motorista.getCnh());
				cbTipo.setSelectedItem(motorista.getTipo());
				txtDataVencimento.setText(motorista.getVencimento());
				
				String data = motorista.getDatacadastro();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = null;
				try {
					date = (Date) formatter.parse(data);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				dataCadastro.setDate(date);
			}

		});
		pesquisarMotorista.setIcon(new ImageIcon(FrmControleDeMotoristas.class
				.getResource("/images/pesquisar.png")));
		pesquisarMotorista.setBounds(200, 82, 31, 22);
		panel.add(pesquisarMotorista);
	}
}
