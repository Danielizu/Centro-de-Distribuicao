package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import control.ControlarVeiculos;
import control.CrudVeiculo;
import entity.Veiculo;

import java.awt.Color;
import java.io.IOException;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;

public class FrmControleDeVeiculos extends JFrame {

	public JFrame frame;
	public JTextField txtPlaca;
	public JTextField txtCapacidadeMax;
	public JTextField txtQtdPaletesMax;
	public JTextField txtDataCadastro;
	public JTextField txtNomeMotorista;
	public JTextField txtDadosMotorista;
	public JComboBox cbTipo;
	public JComboBox cbCor;
	public JComboBox cbMarca;
	public JComboBox cbCarroceria;
	public Veiculo veiculo = new Veiculo();
	public ControlarVeiculos control = new ControlarVeiculos();
	String tipo[] = { null, "Caminhão", "Carro" };
	String cores[] = { null, "Azul", "Amarelo", "Vermelho", "Preto", "Prata",
			"Cinza", "Grafite" };
	String marcas[] = { null, "Agrale", "Ford", "International", "Iveco",
			"Mercede Benz", "Scania", "Shacman", "Sinotruk", "Volkswagen",
			"Volvo" };
	String carroceria[] = { null, "Gasolina", "Diesel", "Gás Natural",
			"Etanol", "Biodisel", "Biogás" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmControleDeVeiculos window = new FrmControleDeVeiculos();

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
	public FrmControleDeVeiculos() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/** CRIAÇÃO DA TELA */
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/** DECLARANDO A LABEL PLACA */
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(30, 58, 46, 14);
		frame.getContentPane().add(lblPlaca);

		/** DECLARANDO O CAMPO DE ENTRADA DA PLACA E CRIAÇÃO DA MÁSCARA */
		txtPlaca = new JTextField();
		try {
			javax.swing.text.MaskFormatter placa = new javax.swing.text.MaskFormatter(
					"UUU-####");
			txtPlaca.addFocusListener(null);

			txtPlaca = new javax.swing.JFormattedTextField(placa);
		} catch (Exception e) {
		}
		txtPlaca.setBounds(138, 55, 99, 20);
		frame.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);

		/** DECLARANDO A LABEL DA CAPACIDADE MÁXIMA */
		JLabel lblCapacidadeMax = new JLabel("Capacidade Max.");
		lblCapacidadeMax.setBounds(30, 89, 126, 14);
		frame.getContentPane().add(lblCapacidadeMax);

		/** DECLARANDO O CAMPO DE ENTRADA DA CAPACIDADE MÁXIMA E CRIAÇÃO DA MÁSCARA*/
		txtCapacidadeMax = new JTextField();
		try {
			javax.swing.text.MaskFormatter capacidademax = new javax.swing.text.MaskFormatter(
					"###");

			txtCapacidadeMax = new javax.swing.JFormattedTextField(
					capacidademax);
		} catch (Exception e) {
		}
		txtCapacidadeMax.setBounds(176, 86, 83, 20);
		frame.getContentPane().add(txtCapacidadeMax);
		txtCapacidadeMax.setColumns(10);

		/** DECLARANDO A LABEL TIPO */
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(30, 122, 46, 14);
		frame.getContentPane().add(lblTipo);

		/** DECLARANDO O COMBO BOX DO TIPO */
		final JComboBox cbTipo = new JComboBox();
		control.AdicionarValoresCB(cbTipo, tipo);
		cbTipo.setBounds(138, 119, 121, 20);
		frame.getContentPane().add(cbTipo);

		/** DECLARANDO A LABEL DA QUANTIDADE DE PALETES  */
		JLabel lblQtdPaletes = new JLabel("Qtd. Máxima de Paletes");
		lblQtdPaletes.setBounds(30, 161, 136, 14);
		frame.getContentPane().add(lblQtdPaletes);

		/** DECLARANDO O CAMPO DE ENTRADA DA QUANTIDADE MÁXIMA DE PALETES E CRIAÇÃO DA MÁSCARA  */
		txtQtdPaletesMax = new JTextField();
		try {
			javax.swing.text.MaskFormatter quantidade = new javax.swing.text.MaskFormatter(
					"###");

			txtQtdPaletesMax = new javax.swing.JFormattedTextField(quantidade);
		} catch (Exception e) {
		}
		txtQtdPaletesMax.setBounds(176, 158, 83, 20);
		frame.getContentPane().add(txtQtdPaletesMax);
		txtQtdPaletesMax.setColumns(10);

		/** CRIAÇÃO DA LABEL DATA DE CADASTRO */
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro");
		lblDataDeCadastro.setBounds(30, 196, 126, 14);
		frame.getContentPane().add(lblDataDeCadastro);

		/** DECLARANDO O CAMPO DATA DE CADASTRO COM A DATA ATUAL */
		txtDataCadastro = new JTextField();
		txtDataCadastro.setBounds(173, 193, 86, 20);
		frame.getContentPane().add(txtDataCadastro);
		control.InserirData(txtDataCadastro);
		txtDataCadastro.setColumns(10);

		/** DECLARANDO A LABEL MARCA */
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(288, 58, 46, 14);
		frame.getContentPane().add(lblMarca);

		
		/** DECLARANDO A LABEL DA COR */
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(288, 89, 46, 14);
		frame.getContentPane().add(lblCor);

		/** DECLARANDO A LABEL DA CARROCERIA */
		JLabel lblCarroceria = new JLabel("Carroceria");
		lblCarroceria.setBounds(288, 122, 74, 14);
		frame.getContentPane().add(lblCarroceria);

		/** CRIAÇÃO DA COMBO BOX DA MARCA */
		final JComboBox cbMarca = new JComboBox();
		cbMarca.setBounds(344, 55, 134, 20);
		control.AdicionarValoresCB(cbMarca, marcas);
		frame.getContentPane().add(cbMarca);

		/** CRIAÇÃO DA COMBO BOX DA COR */
		final JComboBox cbCor = new JComboBox();
		cbCor.setBounds(344, 86, 134, 20);
		control.AdicionarValoresCB(cbCor, cores);
		frame.getContentPane().add(cbCor);

		/** CRIAÇÃO DA COMBO BOX DA CARROCERIA */
		final JComboBox cbCarroceria = new JComboBox();
		cbCarroceria.setBounds(354, 119, 124, 20);
		control.AdicionarValoresCB(cbCarroceria, carroceria);
		frame.getContentPane().add(cbCarroceria);

		/** DECLARANDO A LABEL NOME */
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 311, 46, 14);
		frame.getContentPane().add(lblNome);

		/** CRIAÇÃO DO CAMPO NOME DO MOTORISTA */
		txtNomeMotorista = new JTextField();
		txtNomeMotorista.setBounds(88, 308, 294, 20);
		frame.getContentPane().add(txtNomeMotorista);
		txtNomeMotorista.setColumns(10);

		/**  */
		JLabel lblDadosDoMotorista = new JLabel("Dados do Motorista");
		lblDadosDoMotorista.setBounds(30, 348, 126, 14);
		frame.getContentPane().add(lblDadosDoMotorista);

		txtDadosMotorista = new JTextField();
		txtDadosMotorista.setBounds(154, 341, 313, 131);
		frame.getContentPane().add(txtDadosMotorista);
		txtDadosMotorista.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(384, 307, 83, 23);
		frame.getContentPane().add(btnBuscar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(378, 507, 89, 23);
		frame.getContentPane().add(btnCancelar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.LimparCampos(txtPlaca);
				control.LimparCampos(txtCapacidadeMax);
				control.LimparCampos(txtQtdPaletesMax);
				control.LimparCampos(txtNomeMotorista);
				control.LimparCampos(txtDadosMotorista);
				control.LimparComboBox(cbTipo);
				control.LimparComboBox(cbMarca);
				control.LimparComboBox(cbCor);
				control.LimparComboBox(cbCarroceria);
			}
		});
		btnLimpar.setBounds(148, 507, 89, 23);
		frame.getContentPane().add(btnLimpar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null,
						"Deseja confirmar o cadastro do Veiculo?", "WARNING",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					veiculo.setPlaca(txtPlaca.getText());
					veiculo.setMarca(cbMarca.getSelectedItem().toString());
					veiculo.setCapMax(Integer.valueOf(txtCapacidadeMax
							.getText()));
					veiculo.setCor(cbCor.getSelectedItem().toString());
					veiculo.setTipo(cbTipo.getSelectedItem().toString());
					veiculo.setCarroceria((cbCarroceria.getSelectedItem()
							.toString()));
					veiculo.setQtdPaletes(Integer.valueOf(txtQtdPaletesMax
							.getText()));
					veiculo.setDatacadastro(txtDataCadastro.getText());

					try {
						control.SalvarVeiculo(veiculo);
					} catch (IOException e1) {
						System.out.println("Arquivo não encontrado");
						e1.printStackTrace();
					}
					control.LimparCampos(txtPlaca);
					control.LimparComboBox(cbMarca);
					control.LimparCampos(txtCapacidadeMax);
					control.LimparComboBox(cbCor);
					control.LimparComboBox(cbTipo);
					control.LimparComboBox(cbCarroceria);
					control.LimparCampos(txtQtdPaletesMax);
					
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				}
			}
			
		});

		btnSalvar.setBounds(30, 507, 89, 23);
		frame.getContentPane().add(btnSalvar);

		JPanel borderMotorista = new JPanel();
		FlowLayout flowLayout = (FlowLayout) borderMotorista.getLayout();
		borderMotorista.setBounds(10, 11, 484, 539);
		borderMotorista.setBorder(BorderFactory
				.createTitledBorder("Cadastro de Veiculos"));
		frame.getContentPane().add(borderMotorista);

		JPanel border = new JPanel();
		border.setBounds(10, 246, 484, -193);
		border.setBorder(new TitledBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Cadastro de Motoristas", TitledBorder.LEFT, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		frame.getContentPane().add(border);

		JButton pesquisarPlaca = new JButton("");
		setAlwaysOnTop(true);
		pesquisarPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String search = txtPlaca.getText();
				//boolean resultado = false;
				veiculo = control.PesquisarPlaca(search);

				
				//if (resultado == true) {
				txtPlaca.setText(veiculo.getPlaca());
				cbMarca.setSelectedItem(veiculo.getMarca());
				txtCapacidadeMax.setText(String.valueOf(veiculo.getCapMax()));
				cbCor.setSelectedItem(veiculo.getCor());
				cbTipo.setSelectedItem(veiculo.getTipo());
				cbCarroceria.setSelectedItem(veiculo.getCarroceria());
				txtQtdPaletesMax.setText(String.valueOf(veiculo.getQtdPaletes()));
				txtDataCadastro.setText(veiculo.getDatacadastro());
			//	}
			}
		});
		pesquisarPlaca.setIcon(new ImageIcon(FrmControleDeVeiculos.class
				.getResource("/images/pesquisar.png")));
		pesquisarPlaca.setBounds(234, 54, 31, 22);
		frame.getContentPane().add(pesquisarPlaca);

	}
}
