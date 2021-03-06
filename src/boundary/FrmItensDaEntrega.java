package boundary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import control.ControlarCatalogo;
import control.ControlarClientes;
import control.ControlarItens;
import entity.Catalogo;
import entity.Cliente;
import entity.Item;


public class FrmItensDaEntrega extends JFrame {

	protected static final JTextComponent dataCadastro = null;
	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtCodProdut;
	private JTextField txtDataSolicit;
	private JTextField txtQuant;
	private JTextField txtNumeroNota;
	public JFrame frame;
	public ControlarItens control = new ControlarItens();
	public Item item = new Item();
	private JTextField textField;
	public ControlarCatalogo controlCatalogo = new ControlarCatalogo();
	public Catalogo catalogo = new Catalogo();
	private JTextField textProd;
	public FrmCatalogo cat = new FrmCatalogo ();
	public ControlarClientes controlC = new ControlarClientes ();
	public Cliente cliente = new Cliente();
	
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
		lblNovaEntrega.setBounds(10, 26, 80, 14);
		contentPane.add(lblNovaEntrega);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 70, 140, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Data solicita\u00E7\u00E3o do pedido");
		lblNewLabel_2.setBounds(10, 142, 160, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero nota fiscal");
		lblNewLabel_4.setBounds(10, 178, 140, 14);
		contentPane.add(lblNewLabel_4);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 305, 449, 57);
		contentPane.add(textArea);
		
		
		txtCliente = new JTextField();			
		txtCliente.setBounds(179, 67, 160, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		

		JButton pesquisarCliente = new JButton("Buscar");
//		setAlwaysOnTop(true);
		pesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String search = txtCliente.getText();
				cliente = controlC.PesquisarCliente(search);


			txtCliente.setText(cliente.getNome());		
			}

		});
		pesquisarCliente.setBounds(355, 66, 89, 23);
		contentPane.add(pesquisarCliente);
		
		
		
		txtCodProdut = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("##########");
		}
		catch (Exception e){
		
		}
		
		txtQuant = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("####");
		}
		catch (Exception e){
		
		}
		
		txtNumeroNota = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("##########");
		}
		catch (Exception e){
		
		}
		txtNumeroNota.setBounds(179, 175, 160, 20);
		contentPane.add(txtNumeroNota);
		txtNumeroNota.setColumns(8);
		
		final JDateChooser dataCadastro = new JDateChooser();
		dataCadastro.setBounds(179, 137, 160, 21);
		contentPane.add(dataCadastro);
		
		
		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_5.setBounds(10, 280, 120, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null,
						"Os itens estÃ£o corretos?", "AVISO",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					String data  = ((JTextField)dataCadastro.getDateEditor().getUiComponent()).getText();
					
					item.setCliente(txtCliente.getText());
					item.setNota(txtNumeroNota.getText());
					item.setData(data);
					try {
						control.SalvarItem(item);
					} catch (IOException e1) {
						System.out.println("Arquivo nÃ£o encontrado");
						e1.printStackTrace();
					}
					control.LimparCampos(txtCliente);
					control.LimparCampos(txtNumeroNota);
					control.LimparCampos(dataCadastro);
				}

			}
		});
		btnSalvar.setBounds(22, 520, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(195, 520, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(365, 520, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo do Item");
		lblNewLabel_1.setBounds(10, 106, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(179, 103, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		textProd = new JTextField();
		textProd.setBounds(25, 397, 429, 57);
		contentPane.add(textProd);
		textProd.setColumns(10);
		
		
		JButton btnCod = new JButton("Buscar");
		btnCod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			String search = cat.txtCodProduto.getText();
			catalogo = controlCatalogo.PesquisarCatalogo(search);
			
				textProd.setText(String.valueOf(catalogo.getCodProduto()) + catalogo.getNome() + String.valueOf(catalogo.getPeso()) + String.valueOf(catalogo.getVolume()) + catalogo.getDescricao());
			}
		});
		
		btnCod.setBounds(355, 102, 89, 23);
		contentPane.add(btnCod);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			control.LimparCampos(txtCliente);
			control.LimparCampos(txtCodProdut);
			control.LimparCampos(txtDataSolicit);
			control.LimparCampos(txtQuant);
			control.LimparCampos(txtNumeroNota);
			control.LimparCampos(dataCadastro);
	}

		});
	}
}
