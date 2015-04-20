package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import control.ControlarCatalogo;
import control.ControlarClientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.IOException;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

public class FrmMenu extends JFrame {

	ControlarClientes cliente = new ControlarClientes();
	ControlarCatalogo catalogo = new ControlarCatalogo();

	// Declarando objetos
	public static FrmMenu frame = new FrmMenu();
	FrmCliente frmCliente;
	FrmCatalogo frmCatalogo;
	FrmHistoricoEntrega frmHistoricoEntrega;
	private static final long serialVersionUID = -6535340075713045183L;
	private JPanel contentPane;
	public JButton btnNovoCliente;
	public JButton btnNovoProduto;
	public JButton btnHistorico;
	public JButton btnConsultarCliente;
	private JPanel painelCliente;
	private JPanel painelProduto;
	private JButton btnConsultarProduto;

	// Main da aplicacao
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Construtor
	public FrmMenu() {
		propInicializacao();
	}

	// Metodo para inicializar a tela
	public void propInicializacao() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Declarando botao exibir historico
		btnHistorico = new JButton("Historico de Entregas");
		btnHistorico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historicoEntrega();
			}
		});
		btnHistorico.setBounds(148, 200, 146, 23);
		contentPane.add(btnHistorico);

		// Painel do cliente
		painelCliente = new JPanel();
		painelCliente.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Clientes",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		painelCliente.setBounds(33, 9, 368, 72);
		contentPane.add(painelCliente);
		painelCliente.setLayout(null);

		// Declarando botao novo cliente e adicionando acao
		btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.setBounds(21, 27, 146, 23);
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novoCliente();
			}
		});
		painelCliente.add(btnNovoCliente);
		btnNovoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));

		// Declarando botao consultar cliente
		btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.setBounds(199, 27, 146, 23);
		painelCliente.add(btnConsultarCliente);
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaCliente();
			}
		});
		btnConsultarCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));

		// Painel do produto
		painelProduto = new JPanel();
		painelProduto.setBounds(33, 92, 363, 78);
		contentPane.add(painelProduto);
		painelProduto.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Produtos",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		painelProduto.setLayout(null);

		// Declarando botao novo produto
		btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.setBounds(22, 31, 146, 23);
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novoProduto();
			}
		});
		painelProduto.add(btnNovoProduto);
		btnNovoProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));

		// Declarando botao para consultar o produto
		btnConsultarProduto = new JButton("Consultar Produto");
		btnConsultarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaProduto();
			}
		});
		btnConsultarProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultarProduto.setBounds(199, 31, 146, 23);
		painelProduto.add(btnConsultarProduto);

	}

	// Metodo para o botao novo cliente
	public void novoCliente() {
		frmCliente = new FrmCliente();
		frmCliente.setVisible(true);
		frmCliente.setLocationRelativeTo(null);
		frmCliente.setAlwaysOnTop(true);
		frmCliente.limparCampos();
		frame.setEnabled(false);
		frame.setAlwaysOnTop(false);
	}

	// Metodo para o botao novo produto
	public void novoProduto() {
		frmCatalogo = new FrmCatalogo();
		frmCatalogo.setVisible(true);
		frmCatalogo.setLocationRelativeTo(null);
		frmCatalogo.setAlwaysOnTop(true);
		frmCatalogo.limparCampos();
		frame.setEnabled(false);
		frame.setAlwaysOnTop(false);
	}

	// Metodo para o botao exibir historio
	public void historicoEntrega() {
		frmHistoricoEntrega = new FrmHistoricoEntrega();
		frmHistoricoEntrega.setVisible(true);
		frmHistoricoEntrega.setLocationRelativeTo(null);
		frmHistoricoEntrega.setAlwaysOnTop(true);
		frmHistoricoEntrega.limparCampos();
		frame.setEnabled(false);
		frame.setAlwaysOnTop(false);
	}

	// Metodo para o botao consulta cliente
	public void consultaCliente() {
		frmCliente = new FrmCliente();
		frmCliente.setVisible(true);
		frmCliente.setLocationRelativeTo(null);
		frmCliente.setAlwaysOnTop(true);
		frmCliente.limparCampos();
		frmCliente.consultaCliente(true);
		frame.setEnabled(false);
		frame.setAlwaysOnTop(false);
		try {
			// Metodo que faz a leitura de todos os dados dos clientes
			cliente.lerCliente();
			// Metodo que alimenta um vetor com os nomes dos cliente
			cliente.alimentarNomeCliente();
			// Alimentando combo box com os nomes dos clientes
			for (int i = 0; i != cliente.nomeClientes.length; i++) {
				frmCliente.cmbNomeClientes.addItem(cliente.nomeClientes[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo para o botao de consulta do produto
	@SuppressWarnings("unchecked")
	public void consultaProduto(){
		frmCatalogo = new FrmCatalogo();
		frmCatalogo = new FrmCatalogo();
		frmCatalogo.setVisible(true);
		frmCatalogo.setLocationRelativeTo(null);
		frmCatalogo.setAlwaysOnTop(true);
		frmCatalogo.limparCampos();
		frmCatalogo.consultaProduto(true);
		frame.setEnabled(false);
		frame.setAlwaysOnTop(false);
		try {
			// Metodo que faz a leitura de todos os dados dos clientes
			catalogo.lerCatalogo();
			// Metodo que alimenta um vetor com os nomes dos cliente
			catalogo.alimentarCodProduto();
			// Alimentando combo box com os nomes dos clientes
			for (int i = 0; i != catalogo.linhas.length; i++) {
				frmCatalogo.cmbCodProduto.addItem(catalogo.codProduto[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
