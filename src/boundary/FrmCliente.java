package boundary;

import control.ControlarClientes;
import control.ValidarCPFCNPJ;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

import entity.Cliente;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.io.IOException;

public class FrmCliente extends JFrame {

	// Declarando objetos
	private static final long serialVersionUID = 5647441286916995173L;
	private JPanel contentPane;
	private JTextField txtNomeCompleto;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtCNPJ;
	private JFormattedTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JFormattedTextField txtCEP;
	private JTextField txtComplemento;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JLabel lblNomeCompleto;
	private JLabel lblCpf;
	private JLabel lblCnpj;
	private JLabel lblTelefone;
	private JLabel lblEndereco;
	private JLabel lblCep;
	private JLabel lblComplemento;
	private JLabel lblNumero;
	private JLabel lblCPFInvalido;
	private JLabel lblCNPJInvalido;
	private JLabel lblCampoObrigatrioNome;
	private JLabel lblCampoObrigatrioCPFCNPJ;
	private JLabel lblCampoObrigatrioTelefone;
	private JLabel lblCampoObrigatrioNumero;
	private JLabel lblCampoObrigatrioCEP;
	private JLabel lblCampoObrigatrioEndereco;
	private JRadioButton rdbtnPessoaFsica;
	private JRadioButton rdbtnPessoaJuridica;
	private JLabel lblRazoSocial;
	public Cliente cliente = new Cliente();
	public ControlarClientes controleCliente = new ControlarClientes();
	
	// Criando o frame
	public FrmCliente() {
		propInicializacao();

		labelsMsgErro();

		// Declarando label da razao social
		lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRazoSocial.setBounds(42, 41, 64, 14);
		contentPane.add(lblRazoSocial);

		// Label da razao social comeca invisivel
		lblRazoSocial.setVisible(false);

		// Declarando propriedades do campo Nome Completo
		lblNomeCompleto = new JLabel("Nome completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeCompleto.setBounds(29, 41, 77, 14);
		contentPane.add(lblNomeCompleto);

		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(116, 38, 302, 20);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);

		// Declarando propriedades do campo CPF
		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setBounds(83, 72, 23, 14);
		contentPane.add(lblCpf);

		// Inserindo mascara de CPF no campo
		try {
			MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
			txtCPF = new JFormattedTextField(mascaraCPF);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCPF.setBounds(116, 69, 115, 20);
		contentPane.add(txtCPF);

		// Declarando propriedades do campo CNPJ
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCnpj.setBounds(77, 72, 29, 14);
		contentPane.add(lblCnpj);

		// Inserindo mascara de CNPJ no campo
		try {
			MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCNPJ.setBounds(116, 69, 143, 20);
		contentPane.add(txtCNPJ);

		// Declarando propriedades do campo telefone
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(60, 103, 46, 14);
		contentPane.add(lblTelefone);

		// Inserindo mascara de telefone no campo
		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-####");
			txtTelefone = new JFormattedTextField(mascaraTelefone);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefone.setBounds(116, 100, 101, 20);
		contentPane.add(txtTelefone);

		// Declarando propriedades do campo Endereco
		lblEndereco = new JLabel(" Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereco.setBounds(54, 134, 52, 14);
		contentPane.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(116, 131, 302, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		// Declarando propriedades do campo CEP
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCep.setBounds(296, 165, 23, 14);
		contentPane.add(lblCep);

		// Inserindo mascara de CEP no campo
		try {
			MaskFormatter mascaraCEP = new MaskFormatter(
					"#####-###");
			txtCEP = new JFormattedTextField(mascaraCEP);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCEP.setBounds(329, 162, 89, 20);
		contentPane.add(txtCEP);

		// Declarando propriedades do campo Complemento
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComplemento.setBounds(37, 196, 69, 14);
		contentPane.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(116, 193, 143, 20);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		// Declarando propriedades do campo Numero
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumero.setBounds(64, 165, 46, 14);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(116, 162, 40, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		// Declarando botaao Salvar
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(salvar()){
					System.out.println("Habilitado para salvar");
					cliente.setNome(txtNomeCompleto.getText());
					
					String CPF = "";
					CPF = txtCPF.getText();
					CPF = CPF.replace(".", "");
					CPF = CPF.replace("-", "");
					cliente.setCpf(CPF);
					
					String Telefone = "";
					Telefone = txtTelefone.getText();
					Telefone = Telefone.replace("(", "");
					Telefone = Telefone.replace(")", "");
					Telefone = Telefone.replace("-", "");
					System.out.println(Telefone);
					cliente.setTelefone(Telefone);
					
					cliente.setEndereco(txtEndereco.getText());
					cliente.setNumero(Integer.parseInt(txtNumero.getText()));
					
					String CEP = "";
					CEP = txtCEP.getText();
					CEP = CEP.replace("-", "");
					cliente.setCep(Integer.parseInt(CEP));
					
					cliente.setComplemento(txtComplemento.getText());
					try {
						controleCliente.SalvarCliente(cliente);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else{
					System.out.println("Não Habilitado para salvar");
				};
			}
		});
		btnSalvar.setBounds(83, 238, 89, 23);
		contentPane.add(btnSalvar);

		// Declarando botaao Limpar
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(230, 238, 89, 23);
		contentPane.add(btnLimpar);

		// Declarando botaao Cencelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			// Declarando acao no botao cancelar
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrmMenu.frame.setEnabled(true);
				FrmMenu.frame.setAlwaysOnTop(true);
			}
		});
		btnCancelar.setBounds(372, 238, 89, 23);
		contentPane.add(btnCancelar);

		// Tratando radio button da pessoa Fisica
		rdbtnPessoaFsica = new JRadioButton("Pessoa F\u00EDsica");
		rdbtnPessoaFsica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		// Dizendo que o radio Button da pessoa Fisica comecara marcado
		rdbtnPessoaFsica.setSelected(true);
		if (rdbtnPessoaFsica.isSelected()) {
			naoPode();
		}
		rdbtnPessoaFsica.setBounds(116, 8, 109, 23);
		contentPane.add(rdbtnPessoaFsica);

		// Tratando radio button da pessoa Juridica
		rdbtnPessoaJuridica = new JRadioButton("Pessoa Juridica");
		rdbtnPessoaJuridica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnPessoaJuridica.setBounds(230, 8, 109, 23);
		contentPane.add(rdbtnPessoaJuridica);

		// Definindo que o programa comeca com o CNPJ desabilitado
		txtCNPJ.setVisible(false);
		lblCnpj.setVisible(false);

		// Adicionando acao ao radio button da pessoa fisica
		rdbtnPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioPessoaFisica();
			}
		});

		// Adicionando acao ao radio button da pessoa juridica
		rdbtnPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioPessoaJuridica();
			}
		});
	}

	// Metodo que define as propriedades do form na inicializacao
	public void propInicializacao() {
		// Definindo que a tela nao pode ser redimencionada
		setResizable(false);
		// Alterando o icone da tela
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
				// Endereco da imagem
						"C:\\Users\\Jackson\\workspace\\prjCentroDistribuicao\\src\\view\\imgCliente.png"));
		setTitle("Novo Cliente");

		// Definindo prorpiedades da tela Cliente
		setBounds(100, 100, 534, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	// Declaracao de labels de mensagem de erro
	public void labelsMsgErro() {
		// Labels de mensagem de erro e suas propriedades
		lblCampoObrigatrioNome = new JLabel("Campo obrigat\u00F3rio!");
		lblCampoObrigatrioNome.setVisible(false);
		lblCampoObrigatrioNome.setForeground(Color.RED);
		lblCampoObrigatrioNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioNome.setBounds(428, 41, 92, 14);
		contentPane.add(lblCampoObrigatrioNome);

		lblCampoObrigatrioCPFCNPJ = new JLabel("Campo obrigat\u00F3rio!");
		lblCampoObrigatrioCPFCNPJ.setVisible(false);
		lblCampoObrigatrioCPFCNPJ.setForeground(Color.RED);
		lblCampoObrigatrioCPFCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioCPFCNPJ.setBounds(269, 72, 92, 14);
		contentPane.add(lblCampoObrigatrioCPFCNPJ);

		lblCampoObrigatrioTelefone = new JLabel("Campo obrigat\u00F3rio!");
		lblCampoObrigatrioTelefone.setVisible(false);
		lblCampoObrigatrioTelefone.setForeground(Color.RED);
		lblCampoObrigatrioTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioTelefone.setBounds(227, 103, 92, 14);
		contentPane.add(lblCampoObrigatrioTelefone);

		lblCampoObrigatrioNumero = new JLabel("Campo obrigat\u00F3rio!");
		lblCampoObrigatrioNumero.setVisible(false);
		lblCampoObrigatrioNumero.setForeground(Color.RED);
		lblCampoObrigatrioNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioNumero.setBounds(166, 165, 92, 14);
		contentPane.add(lblCampoObrigatrioNumero);

		lblCampoObrigatrioCEP = new JLabel("Campo obrigat\u00F3rio!");
		lblCampoObrigatrioCEP.setVisible(false);
		lblCampoObrigatrioCEP.setForeground(Color.RED);
		lblCampoObrigatrioCEP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioCEP.setBounds(428, 165, 92, 14);
		contentPane.add(lblCampoObrigatrioCEP);

		lblCampoObrigatrioEndereco = new JLabel("Campo obrigat\u00F3rio!");
		lblCampoObrigatrioEndereco.setVisible(false);
		lblCampoObrigatrioEndereco.setForeground(Color.RED);
		lblCampoObrigatrioEndereco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioEndereco.setBounds(428, 134, 92, 14);
		contentPane.add(lblCampoObrigatrioEndereco);

		lblCPFInvalido = new JLabel("CPF Inválido!");
		lblCPFInvalido.setVisible(false);
		lblCPFInvalido.setForeground(Color.RED);
		lblCPFInvalido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCPFInvalido.setBounds(240, 69, 115, 20);
		contentPane.add(lblCPFInvalido);

		lblCNPJInvalido = new JLabel("CNPJ Inválido!");
		lblCNPJInvalido.setVisible(false);
		lblCNPJInvalido.setForeground(Color.RED);
		lblCNPJInvalido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCNPJInvalido.setBounds(269, 72, 92, 14);
		contentPane.add(lblCNPJInvalido);
	}

	// Funcoes do botao salvar
	public boolean salvar() {
		int aindaFalta = 1;
		// validando os campos e verificando se o CPF e valido
		if (rdbtnPessoaFsica.isSelected()) {
			if (validarCampos()) {
				String CPF = "";
				CPF = txtCPF.getText();
				// Removendo caracteres da mascara do CPF
				CPF = CPF.replace(".", "");
				CPF = CPF.replace("-", "");
				// Validacao do CPF
				if (ValidarCPFCNPJ.CPFValido(CPF)) {
					System.out.println("CPF VÁLIDO");
					lblCPFInvalido.setVisible(false);
				} else {
					lblCampoObrigatrioCPFCNPJ.setVisible(false);
					lblCPFInvalido.setVisible(true);
					System.out.println("CPF INVÁLIDO");
					aindaFalta = 0;
				}
			}
		} else {
			// validando os campos e verificando se o CNPJ e valido
			if (rdbtnPessoaJuridica.isSelected()) {
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
					} else {
						lblCampoObrigatrioCPFCNPJ.setVisible(false);
						lblCNPJInvalido.setVisible(true);
						System.out.println("CNPJ INVÁLIDO");
						aindaFalta = 0;
					}
				}
			}
		}
		if (aindaFalta == 0) {
			return false;
		} else {
			return true;
		}
	}

	// Metodo que aplica acoes quando o radio da pessoa fisica e selecionado
	public void radioPessoaFisica() {
		if (rdbtnPessoaFsica.isSelected()) {
			// Limpando campos caso o ususario venha de pessoa Juridica
			limparCampos();
			// Definindo posicao do label de mensagem de erro
			lblCampoObrigatrioCPFCNPJ.setBounds(240, 69, 115, 20);
			// Desabilitando a selecao da Pessoa Juridica
			rdbtnPessoaJuridica.setSelected(false);

			// Habilitando e desbilitando os campos necessarios
			lblNomeCompleto.setVisible(true);
			lblRazoSocial.setVisible(false);
			txtCPF.setVisible(true);
			lblCpf.setVisible(true);
			txtCNPJ.setVisible(false);
			lblCnpj.setVisible(false);
		}
	}

	// Metodo que aplica acoes quando o radio da pessoa juridica e selecionado
	public void radioPessoaJuridica() {
		if (rdbtnPessoaJuridica.isSelected()) {
			// Limpando campos caso o ususario venha de pessoa Fisica
			limparCampos();
			// Definindo posicao do label de mensagem de erro
			lblCampoObrigatrioCPFCNPJ.setBounds(269, 72, 92, 14);
			// Desabilitando a selecao da Pessoa Fisica
			rdbtnPessoaFsica.setSelected(false);
			// Habilitando e desbilitando os campos necessarios
			lblNomeCompleto.setVisible(false);
			lblRazoSocial.setVisible(true);
			txtCNPJ.setVisible(true);
			lblCnpj.setVisible(true);
			txtCPF.setVisible(false);
			lblCpf.setVisible(false);
		}
	}

	// Metodo que desabilita caracteres especiais do campo nome
	public void naoPode() {
		// Definindo que o campo do Nome so aceita Texto
		txtNomeCompleto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321ƒŠŒŽšœžŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ/|.!?@#$%¨&*(){}][´´;";
				if (caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});

		// Definindo que o campo do Numero so aceita Numeros
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				if (!caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});

		// Definindo que o campo do Endereco nao aceita certos caracteres
		txtEndereco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "ƒŠŒŽšœžŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ/|!?@#$%¨&*{}][´´;";
				if (caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});
	}

	// Metodo para limpar todos os campos e os Labels de mensagem de erro
	public void limparCampos() {
		txtNomeCompleto.setText(null);
		txtCPF.setValue(null);
		txtCNPJ.setValue(null);
		txtTelefone.setValue(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtCEP.setValue(null);
		txtComplemento.setText(null);
		lblCampoObrigatrioNome.setVisible(false);
		lblCampoObrigatrioCPFCNPJ.setVisible(false);
		lblCampoObrigatrioTelefone.setVisible(false);
		lblCampoObrigatrioEndereco.setVisible(false);
		lblCampoObrigatrioNumero.setVisible(false);
		lblCampoObrigatrioCEP.setVisible(false);
		lblCPFInvalido.setVisible(false);
	}

	// Metodo para validar se todos os campos foram preenchidos corretamente
	public boolean validarCampos() {
		int aindaFalta = 1;
		// Validando campo do Nome
		if (txtNomeCompleto.getText().isEmpty()) {
			lblCampoObrigatrioNome.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioNome.setVisible(false);
		}

		// Validando campo da pessoa fisica
		if (rdbtnPessoaFsica.isSelected()) {
			// Verificando se o campo esta vazio ou nao foi preenchido por
			// completo
			if (txtCPF.getText().equals("   .   .   -  ")
					|| txtCPF.getText().trim().length() < 14) {
				lblCampoObrigatrioCPFCNPJ.setVisible(true);
				lblCampoObrigatrioCPFCNPJ.setBounds(240, 69, 115, 20);
				txtCPF.setValue(null);
				aindaFalta = 0;
			} else {
				lblCampoObrigatrioCPFCNPJ.setVisible(false);
			}
		}

		// Validando campo da pessoa fisica
		if (rdbtnPessoaJuridica.isSelected()) {
			// Verificando se o campo esta vazio ou nao foi preenchido por
			// completo
			if (txtCNPJ.getText().equals("  .   .   /    -  ")
					|| txtCNPJ.getText().trim().length() < 18) {
				lblCampoObrigatrioCPFCNPJ.setVisible(true);
				lblCampoObrigatrioCPFCNPJ.setBounds(269, 72, 92, 14);
				txtCNPJ.setValue(null);
				aindaFalta = 0;
			} else {
				lblCampoObrigatrioCPFCNPJ.setVisible(false);
			}
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

		// Validando campo do endereco
		if (txtEndereco.getText().isEmpty()) {
			lblCampoObrigatrioEndereco.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioEndereco.setVisible(false);
		}

		// Validando campo do numero
		if (txtNumero.getText().isEmpty()) {
			lblCampoObrigatrioNumero.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioNumero.setVisible(false);
		}

		// Validando campo do CEP
		if (txtCEP.getText().equals("     -   ")
				|| txtTelefone.getText().trim().length() < 9) {
			lblCampoObrigatrioCEP.setVisible(true);
			txtCEP.setValue(null);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioCEP.setVisible(false);
		}

		if (aindaFalta == 0) {
			return false;
		} else {
			return true;
		}
	}

}