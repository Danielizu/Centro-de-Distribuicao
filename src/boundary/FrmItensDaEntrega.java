package boundary;

import java.awt.*;


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
		lblNovaEntrega.setBounds(10, 26, 80, 14);
		contentPane.add(lblNovaEntrega);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 70, 140, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Data solicita\u00E7\u00E3o do pedido");
		lblNewLabel_2.setBounds(10, 141, 160, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero nota fiscal");
		lblNewLabel_4.setBounds(10, 106, 140, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(355, 66, 89, 23);
		contentPane.add(btnNewButton);
	
		txtCliente = new JTextField();			
		txtCliente.setBounds(179, 67, 160, 20);
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
		txtNumeroNota.setBounds(179, 103, 160, 20);
		contentPane.add(txtNumeroNota);
		txtNumeroNota.setColumns(10);
		
		final JDateChooser dataCadastro = new JDateChooser();
		dataCadastro.setBounds(179, 137, 160, 21);
		contentPane.add(dataCadastro);
		
		
		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o dos itens:");
		lblNewLabel_5.setBounds(10, 280, 120, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnSalvar = new JButton("Salvar");
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 305, 484, 190);
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
