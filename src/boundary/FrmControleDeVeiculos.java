package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class FrmControleDeVeiculos{

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
	public JComboBox cbCombustivel;
	public Veiculo veiculo = new Veiculo();
	public ControlarVeiculos control = new ControlarVeiculos();
	public CrudVeiculo crud = new CrudVeiculo();
	String cores[] = {null, "Azul", "Amarelo", "Vermelho", "Preto", "Prata", "Cinza", "Grafite"};
	String marcas[] = {null, "Agrale", "Ford", "International", "Iveco", "Mercede Benz", "Scania", "Shacman", "Sinotruk", "Volkswagen", "Volvo"};
	String combustivel[] = {null, "Gasolina", "Diesel", "Gás Natural", "Etanol", "Biodisel", "Biogás"};
	
	

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
		
		
		// Criação da Janela
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Declarando a label "Placa"
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(30, 58, 46, 14);
		frame.getContentPane().add(lblPlaca);
		
		//Declarando o campo de entrada da "Placa" e criação da máscara
		txtPlaca = new JTextField();
		try {
			javax.swing.text.MaskFormatter placa = new javax.swing.text.MaskFormatter(
					"UUU-####");

			txtPlaca = new javax.swing.JFormattedTextField(placa);
		} catch (Exception e) {
		}
		txtPlaca.setBounds(138, 55, 121, 20);
		frame.getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);
		
		//Declarando a label "Capacidade Máxima"
		JLabel lblCapacidadeMax = new JLabel("Capacidade Max.");
		lblCapacidadeMax.setBounds(30, 89, 126, 14);
		frame.getContentPane().add(lblCapacidadeMax);
		
		//Declarando o campo de entrada da "Capacidade Máxima" e criação da máscara
		txtCapacidadeMax = new JTextField();
		try {
			javax.swing.text.MaskFormatter capacidade = new javax.swing.text.MaskFormatter(
					"###");

			txtCapacidadeMax = new javax.swing.JFormattedTextField(capacidade);
		} catch (Exception e) {
		}
		txtCapacidadeMax.setBounds(176, 86, 83, 20);
		frame.getContentPane().add(txtCapacidadeMax);
		txtCapacidadeMax.setColumns(10);
		
		//Declarando a label "Tipo"
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(30, 122, 46, 14);
		frame.getContentPane().add(lblTipo);
		
		//Declarando o combo box do "Tipo"
		final JComboBox cbTipo = new JComboBox();
		cbTipo.setBounds(138, 119, 121, 20);
		frame.getContentPane().add(cbTipo);
		
		//Declarando a label "Quantidade de Paletes"
		JLabel lblQtdPaletes = new JLabel("Qtd. Máxima de Paletes");
		lblQtdPaletes.setBounds(30, 161, 136, 14);
		frame.getContentPane().add(lblQtdPaletes);
		
		//Declarando o campo de entrada da "Quantidade máxima de Paletes" e criação da máscara
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
		
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro");
		lblDataDeCadastro.setBounds(30, 196, 126, 14);
		frame.getContentPane().add(lblDataDeCadastro);
		
		txtDataCadastro = new JTextField();
		txtDataCadastro.setBounds(173, 193, 86, 20);
		frame.getContentPane().add(txtDataCadastro);
		control.InserirData(txtDataCadastro);
		txtDataCadastro.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(288, 58, 46, 14);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(288, 89, 46, 14);
		frame.getContentPane().add(lblCor);
		
		JLabel lblCarroceria = new JLabel("Carroceria");
		lblCarroceria.setBounds(288, 122, 74, 14);
		frame.getContentPane().add(lblCarroceria);
		
		final JComboBox cbMarca = new JComboBox();
		cbMarca.setBounds(344, 55, 134, 20);
		control.AdicionarValoresCB(cbMarca, marcas);
		frame.getContentPane().add(cbMarca);
		
		final JComboBox cbCor = new JComboBox();
		cbCor.setBounds(344, 86, 134, 20);
		control.AdicionarValoresCB(cbCor, cores);
		frame.getContentPane().add(cbCor);
		
		final JComboBox cbCombustivel = new JComboBox();
		cbCombustivel.setBounds(354, 119, 124, 20);
		control.AdicionarValoresCB(cbCombustivel, combustivel);
		frame.getContentPane().add(cbCombustivel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 311, 46, 14);
		frame.getContentPane().add(lblNome);
		
		txtNomeMotorista = new JTextField();
		txtNomeMotorista.setBounds(88, 308, 294, 20);
		frame.getContentPane().add(txtNomeMotorista);
		txtNomeMotorista.setColumns(10);
		
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
				control.LimparCampos(txtDataCadastro);
				control.LimparCampos(txtNomeMotorista);
				control.LimparCampos(txtDadosMotorista);
				control.LimparComboBox(cbTipo);
				control.LimparComboBox(cbMarca);
				control.LimparComboBox(cbCor);
				control.LimparComboBox(cbCombustivel);
			}
		}
		);
		btnLimpar.setBounds(148, 507, 89, 23);
		frame.getContentPane().add(btnLimpar);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crud.SalvarVeiculo(veiculo);
				} catch (IOException e1) {
					System.out.println("Arquivo não encontrado");
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(30, 507, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		

		JPanel borderMotorista = new JPanel();
		FlowLayout flowLayout = (FlowLayout) borderMotorista.getLayout();
		borderMotorista.setBounds(10, 11, 484, 539);
		borderMotorista.setBorder(BorderFactory.createTitledBorder("Cadastro de Veiculos"));
		frame.getContentPane().add(borderMotorista);
		
		JPanel border = new JPanel();
		border.setBounds(10, 246, 484, -193);
		border.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Cadastro de Motoristas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(border);
		
		
	}
}
