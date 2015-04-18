package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmMenu extends JFrame {
	public static FrmMenu frame = new FrmMenu();
	/**
	 * 
	 */
	private static final long serialVersionUID = -6535340075713045183L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public FrmMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNovoCliente = new JButton("Novo Cliente");
		btnNovoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCliente frmCliente = new FrmCliente();
				frmCliente.setVisible(true);
				frmCliente.setLocationRelativeTo(null);
				frmCliente.setAlwaysOnTop(true);
				frmCliente.limparCampos();
				frame.setEnabled(false);
				frame.setAlwaysOnTop(false);
			}
		});
		btnNovoCliente.setBounds(158, 96, 146, 23);
		contentPane.add(btnNovoCliente);
		
		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCatalogo frmCatalogo = new FrmCatalogo();
				frmCatalogo.setVisible(true);
				frmCatalogo.setLocationRelativeTo(null);
				frmCatalogo.setAlwaysOnTop(true);
				frmCatalogo.limparCampos();
				frame.setEnabled(false);
				frame.setAlwaysOnTop(false);
			}
		});
		btnNovoProduto.setBounds(158, 145, 146, 23);
		contentPane.add(btnNovoProduto);
		
		JButton btnHistorico = new JButton("Historico de Entregas");
		btnHistorico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmHistoricoEntrega frmHistoricoEntrega = new FrmHistoricoEntrega();
				frmHistoricoEntrega.setVisible(true);
				frmHistoricoEntrega.setLocationRelativeTo(null);
				frmHistoricoEntrega.setAlwaysOnTop(true);
				frmHistoricoEntrega.limparCampos();
				frame.setEnabled(false);
				frame.setAlwaysOnTop(false);
			}
		});
		btnHistorico.setBounds(158, 190, 146, 23);
		contentPane.add(btnHistorico);
		
		
	}
}
