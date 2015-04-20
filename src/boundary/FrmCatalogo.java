package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import control.ControlarCatalogo;
import control.ValidarCPFCNPJ;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import entity.Catalogo;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JProgressBar;

public class FrmCatalogo extends JFrame {

	private static final long serialVersionUID = -1332513679160310365L;
	public JPanel contentPane;
	public JPanel pnlCadastro;
	public JPanel pnlDescricao;
	public JLabel lblCodProduto;
	public JLabel lblNomeDoProduto;
	public JLabel lblFornecedor;
	public JLabel lblCnpj;
	public JLabel lblTelefone;
	public JLabel lblDataDeCadastro;
	public JLabel lblPeso;
	public JLabel lblVolume;
	public JTextField txtCodProduto;
	public JTextField txtNomeDoProduto;
	public JTextField txtFornecedor;
	public JTextField txtPeso;
	public JTextField txtVolume;
	public JFormattedTextField txtTelefone;
	public JFormattedTextField txtCNPJ;
	public JScrollPane scrollDescricao;
	public JTextArea txtAreaDescricao;
	public JButton btnSalvar;
	public JButton btnLimpar;
	public JButton btnCancelar;
	public JLabel lblCampoObrigatrioNomeProduto;
	public JLabel lblCampoObrigatrioFornecedor;
	public JLabel lblCampoObrigatrioCNPJ;
	public JLabel lblCampoObrigatrioTelefone;
	public JLabel lblCampoObrigatrioDataCadastro;
	public JLabel lblCampoObrigatrioPeso;
	public JLabel lblCampoObrigatrioVolume;
	public JLabel lblCampoObrigatrioDescricao;
	public JLabel lblCampoObrigatrioCodProduto;
	public JLabel lblCNPJInvalido;
	public JDateChooser txtDataCadastro;
	public ControlarCatalogo controle = new ControlarCatalogo();
	public Catalogo catalogo = new Catalogo();
	@SuppressWarnings("rawtypes")
	public JComboBox cmbCodProduto;

	public FrmCatalogo() {
		// Propriedades de inicializacao da tela
		propInicializacao();
	}

	// Metodo que inicializa as propriedades da tela
	// Metodo que define as propriedades do form na inicializacao
	private void propInicializacao() {
		// Informando que a janela n'ao pode ser redimencionada
		setResizable(false);

		// Definindo propriedades da tela principal
		setTitle("Cat\u00E1logo");
		setBounds(100, 100, 525, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Definindo propriedades do painel do cadastro de produtos
		pnlCadastro = new JPanel();
		pnlCadastro.setBorder(new TitledBorder(new LineBorder(new Color(192,
				192, 192), 1, true), "Cadastro de Produto",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		pnlCadastro.setBounds(10, 11, 497, 441);
		contentPane.add(pnlCadastro);
		pnlCadastro.setLayout(null);

		// Definindo Panel para a descricao
		pnlDescricao = new JPanel();
		pnlDescricao.setBorder(new TitledBorder(null, "Descrição:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDescricao.setBounds(10, 294, 477, 136);
		pnlCadastro.add(pnlDescricao);
		pnlDescricao.setLayout(null);

		// Declarando labels de mensagem de erro
		labelsMensagensErro();

		// Metodo que desbilita objetos de consulta
		consultaProduto(false);

		// Definindo propriedades do codigo do produto
		lblCodProduto = new JLabel("C\u00F3d. Produto:");
		lblCodProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodProduto.setBounds(38, 39, 68, 14);
		pnlCadastro.add(lblCodProduto);

		txtCodProduto = new JTextField();
		txtCodProduto.setBounds(116, 36, 46, 20);
		pnlCadastro.add(txtCodProduto);
		txtCodProduto.setColumns(10);

		// Definindo propriedades do nome do Produto
		lblNomeDoProduto = new JLabel("Nome do Produto:");
		lblNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoProduto.setBounds(19, 70, 87, 14);
		pnlCadastro.add(lblNomeDoProduto);

		txtNomeDoProduto = new JTextField();
		txtNomeDoProduto.setBounds(116, 67, 250, 20);
		pnlCadastro.add(txtNomeDoProduto);
		txtNomeDoProduto.setColumns(10);

		// Definindo propriedades do fornecedor
		lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFornecedor.setBounds(48, 101, 59, 14);
		pnlCadastro.add(lblFornecedor);

		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(116, 98, 250, 20);
		pnlCadastro.add(txtFornecedor);
		txtFornecedor.setColumns(10);

		// Definindo propriedades do CNPJ
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCnpj.setBounds(79, 132, 29, 14);
		pnlCadastro.add(lblCnpj);

		txtCNPJ = new JFormattedTextField();
		// Inserindo mascara de CNPJ no campo
		try {
			MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCNPJ.setBounds(116, 129, 142, 20);
		pnlCadastro.add(txtCNPJ);

		// Definindo propriedades do telefone
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(60, 163, 46, 14);
		pnlCadastro.add(lblTelefone);

		txtTelefone = new JFormattedTextField();
		// Inserindo mascara de telefone no campo
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");
			txtTelefone = new JFormattedTextField(mascaraTelefone);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefone.setBounds(116, 160, 101, 20);
		pnlCadastro.add(txtTelefone);

		// Definindo propriedades da data de cadastro
		lblDataDeCadastro = new JLabel("Data de Cadastro:");
		lblDataDeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDeCadastro.setBounds(17, 204, 89, 14);
		pnlCadastro.add(lblDataDeCadastro);

		txtDataCadastro = new JDateChooser();
		txtDataCadastro.setBounds(116, 198, 101, 20);
		pnlCadastro.add(txtDataCadastro);

		// Definindo propriedades do peso
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPeso.setBounds(77, 235, 29, 14);
		pnlCadastro.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(116, 232, 46, 20);
		pnlCadastro.add(txtPeso);
		txtPeso.setColumns(10);

		// Definindo propriedades do volume
		lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVolume.setBounds(68, 269, 38, 14);
		pnlCadastro.add(lblVolume);

		txtVolume = new JTextField();
		txtVolume.setColumns(10);
		txtVolume.setBounds(116, 263, 46, 20);
		pnlCadastro.add(txtVolume);
		excluirCaracteresEspeciais();

		// Declarando ScrollPane para o txtArea da descricao
		scrollDescricao = new JScrollPane();
		scrollDescricao.setBounds(6, 16, 331, 113);
		pnlDescricao.add(scrollDescricao);

		// Declarando txt Area da descricao
		txtAreaDescricao = new JTextArea();
		scrollDescricao.setViewportView(txtAreaDescricao);

		// Declarando botao salvar e adicionando funcao
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Metodo que valida e grava os dados em arquivo
				salvarDados();
			}
		});
		btnSalvar.setBounds(33, 463, 89, 23);
		contentPane.add(btnSalvar);

		// Declarando botao limpar e adicionando funcao
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Metodo que limpa os campos
				limparCampos();
			}
		});
		btnLimpar.setBounds(210, 463, 89, 23);
		contentPane.add(btnLimpar);

		// Declarando botao cancelar e adicionando funcao
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Metodo que fecha a janela atual
				dispose();
				// A janela do menu passa a ser acessivel
				FrmMenu.frame.setEnabled(true);
				// A Janela do menu vem para a frente da tela
				FrmMenu.frame.setAlwaysOnTop(true);
			}
		});
		btnCancelar.setBounds(383, 463, 89, 23);
		contentPane.add(btnCancelar);
	}

	// Declaracao de labels de mensagem de erro
	// Metodo que inicializa as mensagens de erro
	public void labelsMensagensErro() {

		lblCampoObrigatrioDescricao = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioDescricao.setVisible(false);
		lblCampoObrigatrioDescricao.setForeground(Color.RED);
		lblCampoObrigatrioDescricao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioDescricao.setBounds(358, 65, 94, 14);
		pnlDescricao.add(lblCampoObrigatrioDescricao);

		lblCampoObrigatrioNomeProduto = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioNomeProduto.setVisible(false);

		lblCampoObrigatrioCodProduto = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioCodProduto.setForeground(Color.RED);
		lblCampoObrigatrioCodProduto
				.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioCodProduto.setVisible(false);
		lblCampoObrigatrioCodProduto.setBounds(172, 39, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioCodProduto);

		lblCampoObrigatrioNomeProduto.setForeground(Color.RED);
		lblCampoObrigatrioNomeProduto
				.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioNomeProduto.setBounds(378, 70, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioNomeProduto);

		lblCampoObrigatrioFornecedor = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioFornecedor.setVisible(false);
		lblCampoObrigatrioFornecedor.setForeground(Color.RED);
		lblCampoObrigatrioFornecedor
				.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioFornecedor.setBounds(378, 101, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioFornecedor);

		lblCampoObrigatrioCNPJ = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioCNPJ.setVisible(false);
		lblCampoObrigatrioCNPJ.setForeground(Color.RED);
		lblCampoObrigatrioCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioCNPJ.setBounds(272, 132, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioCNPJ);

		lblCampoObrigatrioTelefone = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioTelefone.setVisible(false);
		lblCampoObrigatrioTelefone.setForeground(Color.RED);
		lblCampoObrigatrioTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioTelefone.setBounds(227, 163, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioTelefone);

		lblCampoObrigatrioDataCadastro = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioDataCadastro.setVisible(false);
		lblCampoObrigatrioDataCadastro.setForeground(Color.RED);
		lblCampoObrigatrioDataCadastro.setFont(new Font("Tahoma", Font.PLAIN,
				11));
		lblCampoObrigatrioDataCadastro.setBounds(227, 204, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioDataCadastro);

		lblCampoObrigatrioPeso = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioPeso.setVisible(false);
		lblCampoObrigatrioPeso.setForeground(Color.RED);
		lblCampoObrigatrioPeso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioPeso.setBounds(172, 235, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioPeso);

		lblCampoObrigatrioVolume = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioVolume.setVisible(false);
		lblCampoObrigatrioVolume.setForeground(Color.RED);
		lblCampoObrigatrioVolume.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioVolume.setBounds(172, 269, 94, 14);
		pnlCadastro.add(lblCampoObrigatrioVolume);

		lblCNPJInvalido = new JLabel("CNPJ Inválido!");
		lblCNPJInvalido.setVisible(false);
		lblCNPJInvalido.setForeground(Color.RED);
		lblCNPJInvalido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCNPJInvalido.setBounds(272, 132, 94, 14);
		pnlCadastro.add(lblCNPJInvalido);
	}

	// Metodo que valida o tipo do cliente e seu CNPJ
	public boolean validarTipoFornecedor() {
		int aindaFalta = 0;
		if (validarCampos()) {
			String CNPJ = "";
			CNPJ = txtCNPJ.getText();
			// Removendo caracteres da mascara do CNPJ
			CNPJ = CNPJ.replace(".", "");
			CNPJ = CNPJ.replace("/", "");
			CNPJ = CNPJ.replace("-", "");
			// Validacao do CNPJ
			if (ValidarCPFCNPJ.CNPJValido(CNPJ)) {
				System.out.println("CNPJ VÁLIDO");
				lblCNPJInvalido.setVisible(false);
				aindaFalta = 1;
			} else {
				lblCampoObrigatrioCNPJ.setVisible(false);
				lblCNPJInvalido.setVisible(true);
				System.out.println("CNPJ INVÁLIDO");
			}
		}
		if (aindaFalta == 0) {
			return false;
		} else {
			return true;
		}
	}

	// Metodo para gravar os dados em arquivo
	public void salvarDados() {
		// Verifica se o metodo salvar retorna que todos as informacoes
		// estao validas
		if (validarTipoFornecedor()) {
			// Caso estejam validas, estar[a habilidado para salvar as
			// informacoes
			System.out.println("Habilitado para salvar");
			catalogo.setCodProduto(Integer.parseInt(txtCodProduto.getText()));
			catalogo.setNome(txtNomeDoProduto.getText());
			catalogo.setFornecedor(txtFornecedor.getText());

			// Removendo os caracteres da mascara do CNPJ e gravando
			String CNPJ = "";
			CNPJ = txtCNPJ.getText();
			CNPJ = CNPJ.replace(".", "");
			CNPJ = CNPJ.replace("/", "");
			CNPJ = CNPJ.replace("-", "");
			catalogo.setCNPJ(CNPJ);

			// Removendo os caracteres da mascara do telefone e gravando
			String Telefone = "";
			Telefone = txtTelefone.getText();
			Telefone = Telefone.replace("(", "");
			Telefone = Telefone.replace(")", "");
			Telefone = Telefone.replace("-", "");
			catalogo.setTelefone(Telefone);

			// Coletando data no formato correto
			Date data = txtDataCadastro.getDate();
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			catalogo.setDataCadastro("" + f.format(data));

			// Gravando peso, volume e descricao
			catalogo.setPeso(Integer.parseInt(txtPeso.getText()));
			catalogo.setVolume(Integer.parseInt(txtVolume.getText()));
			catalogo.setDescricao(txtAreaDescricao.getText());

			// Try Catch para gravar em arquivo a partir do controle do catalogo
			try {
				controle.SalvarCatalogo(catalogo);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			// Caso estejam invalidas, nao estar[a habilidado para
			// salvar as informacoes
			System.out.println("Não Habilitado para salvar");
		}
	}

	// Metodo que desabilita caracteres especiais na tela
	public void excluirCaracteresEspeciais() {
		// Definindo que o campo do Nome so aceita Texto
		txtNomeDoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "ƒŠŒŽšœžŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ/|.!?@#$%¨&*(){}][´´;";
				if (caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});

		// Definindo que o campo do Fornecedor so aceita Texto
		txtFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "ƒŠŒŽšœžŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ/|.!?@#$%¨&*(){}][´´;";
				if (caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});

		// Definindo que o campo do Peso so aceita Numero
		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				if (!caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});

		// Definindo que o campo do Volume so aceita Numero
		txtVolume.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				if (!caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});
	}

	// Metodo que limpa os campos da tela
	public void limparCampos() {
		txtCodProduto.setText(null);
		txtNomeDoProduto.setText(null);
		txtFornecedor.setText(null);
		txtPeso.setText(null);
		txtVolume.setText(null);
		txtTelefone.setValue(null);
		txtCNPJ.setValue(null);
		txtAreaDescricao.setText(null);
		txtDataCadastro.setDate(null);
		lblCampoObrigatrioNomeProduto.setVisible(false);
		lblCampoObrigatrioFornecedor.setVisible(false);
		lblCampoObrigatrioCNPJ.setVisible(false);
		lblCampoObrigatrioTelefone.setVisible(false);
		lblCampoObrigatrioDataCadastro.setVisible(false);
		lblCampoObrigatrioPeso.setVisible(false);
		lblCampoObrigatrioVolume.setVisible(false);
		lblCampoObrigatrioDescricao.setVisible(false);
		lblCNPJInvalido.setVisible(false);
	}

	// Metodo que valida os campos
	public boolean validarCampos() {
		int aindaFalta = 1;
		// Validando campo do Cod Do produto
		if (txtCodProduto.getText().isEmpty()) {
			lblCampoObrigatrioCodProduto.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioCodProduto.setVisible(false);
		}

		// Validando campo do Nome do Produto
		if (txtNomeDoProduto.getText().isEmpty()) {
			lblCampoObrigatrioNomeProduto.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioNomeProduto.setVisible(false);
		}

		// Validando campo do Fornecedor
		if (txtFornecedor.getText().isEmpty()) {
			lblCampoObrigatrioFornecedor.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioFornecedor.setVisible(false);
		}

		// Validando campo da data
		if (txtDataCadastro.getDate() == null) {
			lblCampoObrigatrioDataCadastro.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioDataCadastro.setVisible(false);
		}

		// Verificando se o campo esta vazio ou nao foi preenchido por
		// completo
		if (txtCNPJ.getText().equals("  .   .   /    -  ")
				|| txtCNPJ.getText().trim().length() < 18) {
			lblCampoObrigatrioCNPJ.setVisible(true);
			lblCampoObrigatrioCNPJ.setBounds(272, 132, 94, 14);
			txtCNPJ.setValue(null);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioCNPJ.setVisible(false);
		}

		// Validando campo do telefone e verificando se o campo esta vazio ou
		// nao foi preenchido por completo
		if (txtTelefone.getText().equals("(  )        ")
				|| txtTelefone.getText().trim().length() < 12) {
			lblCampoObrigatrioTelefone.setVisible(true);
			txtTelefone.setValue(null);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioTelefone.setVisible(false);
		}

		// Validando campo Peso
		if (txtPeso.getText().isEmpty()) {
			lblCampoObrigatrioPeso.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioPeso.setVisible(false);
		}

		// Validando campo Volume
		if (txtVolume.getText().isEmpty()) {
			lblCampoObrigatrioVolume.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioVolume.setVisible(false);
		}

		// Validando campo Descricao
		if (txtAreaDescricao.getText().isEmpty()) {
			lblCampoObrigatrioDescricao.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioDescricao.setVisible(false);
		}
		if (aindaFalta == 0) {
			return false;
		} else {
			return true;
		}
	}

	// Metodo para validar campos de consulta
	public void consultaProduto(boolean hue) {
		cmbCodProduto = new JComboBox<Object>();
		cmbCodProduto.setBounds(116, 36, 87, 20);
		cmbCodProduto.setVisible(false);
		pnlCadastro.add(cmbCodProduto);
		
		if(hue == true){
			btnSalvar.setVisible(false);
			cmbCodProduto.setVisible(true);
			txtCodProduto.setVisible(false);
		}
	}
}
