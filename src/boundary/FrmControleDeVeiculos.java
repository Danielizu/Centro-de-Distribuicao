package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;

import control.ControlarMotorista;
import control.ControlarVeiculos;
import entity.Motorista;
import entity.Veiculo;

import java.awt.Color;
import java.io.IOException;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrmControleDeVeiculos extends JFrame {

	public JFrame frame;
	public JTextField txtPlaca;
	public JFormattedTextField txtCapacidadeMax;
	private JFormattedTextField txtCapacidadeMax_1;
	public JFormattedTextField txtQtdPaletesMax;
	private JFormattedTextField txtQtdPaletesMax_1;
	public JTextField txtDataCadastro;
	public JTextField txtCNH;
	public JTextArea txtDadosMotorista;
	public JComboBox cbTipo;
	public JComboBox cbCor;
	public JComboBox cbMarca;
	public JComboBox cbCarroceria;
	public Veiculo veiculo = new Veiculo();
	public Motorista motorista = new Motorista();
	public ControlarVeiculos control = new ControlarVeiculos();
	public ControlarMotorista controlmotorista = new ControlarMotorista();
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
		frame.setBounds(100, 100, 520, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/** DECLARANDO A LABEL PLACA */
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(30, 58, 46, 14);
		frame.getContentPane().add(lblPlaca);

		/** DECLARANDO O CAMPO DE ENTRADA DA PLACA E CRIAÇÃO DA MÁSCARA */
		txtPlaca = new JTextField();
		try {
			MaskFormatter placa = new MaskFormatter(
					"UUU-####");
			txtPlaca.addFocusListener(null);

			txtPlaca = new JFormattedTextField(placa);
		} catch (Exception e) {
		}
		txtPlaca.setBounds(138, 55, 99, 20);
		frame.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);

		/** DECLARANDO A LABEL DA CAPACIDADE MÁXIMA */
		JLabel lblCapacidadeMax = new JLabel("Capacidade Max.");
		lblCapacidadeMax.setBounds(30, 89, 126, 14);
		frame.getContentPane().add(lblCapacidadeMax);
		
		JLabel lblKg = new JLabel("KG");
		setAlwaysOnTop(true);
		lblKg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKg.setBounds(234, 89, 25, 14);
		frame.getContentPane().add(lblKg);
		
		JLabel lblUnidades = new JLabel("Unid.");
		setAlwaysOnTop(true);
		lblUnidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnidades.setBounds(234, 161, 35, 14);
		frame.getContentPane().add(lblUnidades);

		/**
		 * DECLARANDO O CAMPO DE ENTRADA DA CAPACIDADE MÁXIMA E CRIAÇÃO DA
		 * MÁSCARA
		 */
		txtCapacidadeMax = new JFormattedTextField();
		try {
			javax.swing.text.MaskFormatter capacidademax = new javax.swing.text.MaskFormatter(
					"###");

			txtCapacidadeMax_1 = new JFormattedTextField(
					capacidademax);
			txtCapacidadeMax_1.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (Exception e) {
		}
		txtCapacidadeMax_1.setBounds(176, 86, 61, 20);
		frame.getContentPane().add(txtCapacidadeMax_1);
		txtCapacidadeMax_1.setColumns(10);

		/** DECLARANDO A LABEL TIPO */
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(30, 122, 46, 14);
		frame.getContentPane().add(lblTipo);

		/** DECLARANDO O COMBO BOX DO TIPO */
		final JComboBox cbTipo = new JComboBox();
		control.AdicionarValoresCB(cbTipo, tipo);
		cbTipo.setBounds(138, 119, 121, 20);
		frame.getContentPane().add(cbTipo);

		/** DECLARANDO A LABEL DA QUANTIDADE DE PALETES */
		JLabel lblQtdPaletes = new JLabel("Qtd. Máxima de Paletes");
		lblQtdPaletes.setBounds(30, 161, 136, 14);
		frame.getContentPane().add(lblQtdPaletes);

		/**
		 * DECLARANDO O CAMPO DE ENTRADA DA QUANTIDADE MÁXIMA DE PALETES E
		 * CRIAÇÃO DA MÁSCARA
		 */
		txtQtdPaletesMax = new JFormattedTextField();
		try {
			javax.swing.text.MaskFormatter quantidade = new javax.swing.text.MaskFormatter(
					"###");

			txtQtdPaletesMax_1 = new javax.swing.JFormattedTextField(quantidade);
			txtQtdPaletesMax_1.setFocusLostBehavior(JFormattedTextField.PERSIST);
		} catch (Exception e) {
		}
		txtQtdPaletesMax_1.setBounds(176, 158, 61, 20);
		frame.getContentPane().add(txtQtdPaletesMax_1);
		txtQtdPaletesMax_1.setColumns(10);

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
		cbMarca.setBounds(352, 55, 126, 20);
		control.AdicionarValoresCB(cbMarca, marcas);
		frame.getContentPane().add(cbMarca);

		/** CRIAÇÃO DA COMBO BOX DA COR */
		final JComboBox cbCor = new JComboBox();
		cbCor.setBounds(352, 86, 126, 20);
		control.AdicionarValoresCB(cbCor, cores);
		frame.getContentPane().add(cbCor);

		/** CRIAÇÃO DA COMBO BOX DA CARROCERIA */
		final JComboBox cbCarroceria = new JComboBox();
		cbCarroceria.setBounds(354, 119, 124, 20);
		control.AdicionarValoresCB(cbCarroceria, carroceria);
		frame.getContentPane().add(cbCarroceria);

		/** DECLARANDO A LABEL CNH */
		JLabel lblNome = new JLabel("CNH: ");
		lblNome.setBounds(41, 275, 46, 14);
		frame.getContentPane().add(lblNome);
		
		/*BOTÃO PARA PESQUISAR A PLACA*/
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
			//	 }
			}
			
		});
		pesquisarPlaca.setIcon(new ImageIcon(FrmControleDeVeiculos.class
				.getResource("/images/pesquisar.png")));
		pesquisarPlaca.setBounds(234, 54, 31, 22);
		frame.getContentPane().add(pesquisarPlaca);
		

		/** CRIAÇÃO DO CAMPO CNH DO MOTORISTA */
		txtCNH = new JTextField();
		try {
			javax.swing.text.MaskFormatter cnh = new javax.swing.text.MaskFormatter(
					"###########");
			txtCNH.addFocusListener(null);

			txtCNH = new javax.swing.JFormattedTextField(cnh);
		} catch (Exception e) {
		}
		txtCNH.setBounds(99, 272, 294, 20);
		frame.getContentPane().add(txtCNH);
		txtCNH.setColumns(10);

		/**  */
		JLabel lblDadosDoMotorista = new JLabel("Dados do Motorista: ");
		lblDadosDoMotorista.setBounds(41, 312, 126, 14);
		frame.getContentPane().add(lblDadosDoMotorista);

		txtDadosMotorista = new JTextArea();
		txtDadosMotorista.setEditable(false);
		txtDadosMotorista.setBounds(165, 305, 313, 131);
		frame.getContentPane().add(txtDadosMotorista);
		txtDadosMotorista.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				motorista = controlmotorista.PesquisarCNH(txtCNH.getText());

				txtDadosMotorista.setText("Nome do Motorista: "
						+ motorista.getNome() + "\nCNH do Motorista: "
						+ motorista.getCnh() + "\nCategoria da carteira: "
						+ motorista.getTipo() + "\nData de Vencimento: "
						+ motorista.getVencimento() + "\nData de Cadastro: "
						+ motorista.getDatacadastro());
			}
		});
		btnBuscar.setBounds(395, 271, 83, 23);
		frame.getContentPane().add(btnBuscar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(389, 461, 89, 23);
		frame.getContentPane().add(btnCancelar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.LimparCampos(txtPlaca);
				control.LimparCampos(txtCapacidadeMax);
				control.LimparCampos(txtQtdPaletesMax);
				control.LimparCampos(txtCNH);
				control.LimparTextArea(txtDadosMotorista);
				control.LimparComboBox(cbTipo);
				control.LimparComboBox(cbMarca);
				control.LimparComboBox(cbCor);
				control.LimparComboBox(cbCarroceria);
			}
		});
		btnLimpar.setBounds(273, 461, 89, 23);
		frame.getContentPane().add(btnLimpar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*VALIDAÇÃO PARA SABER SE TODOS OS CAMPOS FORAM PREENCHIDOS*/
				if (txtPlaca.getText().isEmpty() ||  txtCapacidadeMax.getText().isEmpty()
						||  txtQtdPaletesMax.getText().isEmpty()
						||  txtDadosMotorista.getText().isEmpty() ||cbTipo.getSelectedItem() == null
						||  cbMarca.getSelectedItem() == null ||  cbCor.getSelectedItem() == null
						||  cbCarroceria.getSelectedItem() == null) {
					
					JOptionPane.showMessageDialog(null,
							"Todos os campos devem ser preenchidos.");
				} else {
					
                   /*PERGUNTA AO USUÁRIO SE ELE TEM CERTEZA SE DESEJA GRAVAR OS DADOS*/
					if (JOptionPane.showConfirmDialog(null,
							"Deseja confirmar o cadastro do Veiculo?",
							"WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

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
						veiculo.setCNH(txtCNH.getText());

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

						JOptionPane.showMessageDialog(null,
								"Cadastro realizado com sucesso!");
					}
				}
			}
		});

		btnSalvar.setBounds(153, 461, 89, 23);
		frame.getContentPane().add(btnSalvar);

		JPanel borderMotorista = new JPanel();
		FlowLayout flowLayout = (FlowLayout) borderMotorista.getLayout();
		borderMotorista.setBounds(10, 11, 484, 489);
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

		


	}
}
