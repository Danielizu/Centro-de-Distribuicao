package boundary;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

public class FrmMenuPrincipal {

	private JFrame frmCentralDeDistribuio;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal window = new FrmMenuPrincipal();
					window.frmCentralDeDistribuio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmMenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCentralDeDistribuio = new JFrame();
		frmCentralDeDistribuio.setTitle("Central de Distribui\u00E7\u00E3o");
		frmCentralDeDistribuio.setBounds(100, 100, 838, 546);
		frmCentralDeDistribuio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCentralDeDistribuio.setLocationRelativeTo(null);  
		frmCentralDeDistribuio.setResizable(false);
		frmCentralDeDistribuio.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Menu Principal", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 267, 485);
		frmCentralDeDistribuio.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnControleDeVeiculos = new JButton("     Controle de Veiculos");
		btnControleDeVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmControleDeVeiculos formVeiculos = new FrmControleDeVeiculos();
				formVeiculos.frame.setVisible(true);
				formVeiculos.frame.setLocationRelativeTo(null);  
				formVeiculos.frame.setResizable(false);
				formVeiculos.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
				}
		});
		btnControleDeVeiculos.setHorizontalAlignment(SwingConstants.LEFT);
		btnControleDeVeiculos.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/veiculo_icon2.png")));
		btnControleDeVeiculos.setBounds(20, 45, 220, 43);
		panel.add(btnControleDeVeiculos);
		
		JButton btnControleDeMotoristas = new JButton("    Controle de Motoristas");
		btnControleDeMotoristas.setHorizontalAlignment(SwingConstants.LEFT);
		btnControleDeMotoristas.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/motorista_icon2.png")));
		btnControleDeMotoristas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmControleDeMotoristas formMotoristas = new FrmControleDeMotoristas();
				formMotoristas.frame.setVisible(true);
				formMotoristas.frame.setLocationRelativeTo(null);  
				formMotoristas.frame.setResizable(false);
				formMotoristas.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
			}
			});
		btnControleDeMotoristas.setBounds(20, 99, 220, 43);
		panel.add(btnControleDeMotoristas);
		
		JButton btnCatalogo = new JButton("     Controle do Catalogo");
		btnCatalogo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCatalogo.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/catalogo_icon2.png")));
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			FrmCatalogo formCatalogo = new FrmCatalogo();
			formCatalogo.setLocationRelativeTo(null);
			formCatalogo.setVisible(true);
			formCatalogo.setResizable(false);
			formCatalogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
			}
		});
		btnCatalogo.setBounds(20, 153, 220, 43);
		panel.add(btnCatalogo);
		
		JButton btnItensDeEntrega = new JButton("       Itens de Entrega");
		btnItensDeEntrega.setHorizontalAlignment(SwingConstants.LEFT);
		btnItensDeEntrega.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/box_icon2.png")));
		btnItensDeEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmItensDaEntrega formItens = new FrmItensDaEntrega();
				formItens.setVisible(true);
				formItens.setLocationRelativeTo(null);  
				formItens.setResizable(false);
				formItens.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			}
			});
		btnItensDeEntrega.setBounds(20, 207, 220, 43);
		panel.add(btnItensDeEntrega);
		
		JButton btnClientes = new JButton("       Controle de  Clientes");
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/clientes_icon2.png")));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente formCliente = new FrmCliente();
				formCliente.setVisible(true);
				formCliente.setLocationRelativeTo(null);
				formCliente.setResizable(false);
				formCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
			}
			});
		btnClientes.setBounds(20, 261, 220, 43);
		panel.add(btnClientes);
		
		JButton btnNFe = new JButton("      Consulta de NFe");
		btnNFe.setHorizontalAlignment(SwingConstants.LEFT);
		btnNFe.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/nfe_icon2.png")));
		btnNFe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmConsultaNF formConsultaNF = new FrmConsultaNF();
				formConsultaNF.setVisible(true);
				formConsultaNF.setLocationRelativeTo(null);
				formConsultaNF.setResizable(false);
				formConsultaNF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
			}
		});
		btnNFe.setBounds(20, 315, 220, 43);
		panel.add(btnNFe);
		
		JButton btnSobre = new JButton("               Sobre");
		btnSobre.setHorizontalAlignment(SwingConstants.LEADING);
		btnSobre.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/sobre_icon2.png")));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmSobre formSobre = new FrmSobre();
				formSobre.frame.setLocationRelativeTo(null);
				formSobre.frame.setVisible(true);
				formSobre.frame.setResizable(false);
				formSobre.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
				
			}
		});
		btnSobre.setBounds(20, 423, 220, 43);
		panel.add(btnSobre);
		
		JButton btnHistorico = new JButton("   Hist\u00F3rico de Entregas");
		btnHistorico.setEnabled(false);
		btnHistorico.setBounds(20, 369, 220, 43);
		panel.add(btnHistorico);
		btnHistorico.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/entrega_icon2.png")));
		btnHistorico.setHorizontalAlignment(SwingConstants.LEADING);
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmHistoricoEntrega formHistorico = new FrmHistoricoEntrega();
				formHistorico.setVisible(true);
				formHistorico.setLocationRelativeTo(null);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(287, 493, 491, -472);
		frmCentralDeDistribuio.getContentPane().add(panel_1);
		
		textField = new JTextField();
		textField.setBounds(303, 95, 509, 288);
		frmCentralDeDistribuio.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblListaDePendncias = new JLabel("Lista de Pend\u00EAncias");
		lblListaDePendncias.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListaDePendncias.setBounds(473, 70, 172, 14);
		frmCentralDeDistribuio.getContentPane().add(lblListaDePendncias);
		
		JButton btnSair = new JButton("        Sair");
		btnSair.setBounds(592, 453, 220, 43);
		frmCentralDeDistribuio.getContentPane().add(btnSair);
		btnSair.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/images/sair_icon2.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
