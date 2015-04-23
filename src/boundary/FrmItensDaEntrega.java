package boundary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import control.ControlarItens;


public class FrmItensDaEntrega extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtCodProduto;
	private JTextField txtDataSolicit;
	private JTextField txtQuant;
	private JTextField txtNumeroNota;
	public JFrame frame;
	public ControlarItens control = new ControlarItens();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmItensDaEntrega frame = new FrmItensDaEntrega();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmItensDaEntrega() {
		setTitle("Itens da Entrega");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNovaEntrega = new JLabel("Nova Entrega");
		lblNovaEntrega.setBounds(30, 37, 80, 14);
		contentPane.add(lblNovaEntrega);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(30, 78, 140, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Data solicita\u00E7\u00E3o do pedido");
		lblNewLabel_2.setBounds(30, 149, 160, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero nota fiscal");
		lblNewLabel_4.setBounds(30, 118, 140, 20);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(364, 77, 89, 22);
		contentPane.add(btnNewButton);
	
		txtCliente = new JTextField();			
		txtCliente.setBounds(166, 78, 160, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtCodProduto = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("##########");
		}
		catch (Exception e){
		
		}
		
/*		txtDataSolicit = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataSolicit = new javax.swing.JFormattedTextField(nota);
		}
		catch (Exception e){
		
		}
		txtDataSolicit.setBounds(178, 138, 120, 20);
		contentPane.add(txtDataSolicit);
		txtDataSolicit.setColumns(10);
	*/	
		txtQuant = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("####");
		}
		catch (Exception e){
		
		}
		
		txtNumeroNota = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("##########");
			txtNumeroNota = new javax.swing.JFormattedTextField(nota);
		}
		catch (Exception e){
		
		}
		txtNumeroNota.setBounds(166, 118, 160, 20);
		contentPane.add(txtNumeroNota);
		txtNumeroNota.setColumns(10);
		
		final JDateChooser dataCadastro = new JDateChooser();
		dataCadastro.setBounds(166, 148, 160, 21);
		contentPane.add(dataCadastro);
		
		
		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o dos itens:");
		lblNewLabel_5.setBounds(30, 281, 120, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(156, 520, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(272, 520, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(387, 520, 89, 23);
		contentPane.add(btnCancelar);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(73, 305, 403, 190);
		contentPane.add(textArea);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			control.LimparCampos(txtCliente);
			control.LimparCampos(txtCodProduto);
			control.LimparCampos(txtDataSolicit);
			control.LimparCampos(txtQuant);
			control.LimparCampos(txtNumeroNota);
			control.LimparData(dataCadastro);
	}

		});
	}
}
