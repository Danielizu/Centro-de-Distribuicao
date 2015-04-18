package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FrmHistoricoEntrega extends JFrame {

	private static final long serialVersionUID = -1521264863605086732L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblDe;
	private JLabel lblAte;
	private JLabel lblDiaDe;
	private JLabel lblMesDe;
	private JLabel lblAnoDe;
	private JLabel lblAnoAte;
	private JLabel lblMesAte;
	private JLabel lblDiaAte;
	private JLabel lblCampoObrigatrioDe;
	private JLabel lblCampoObrigatrioAte;
	private JButton btnConsultar;
	private JButton btnCancelar;
	@SuppressWarnings("rawtypes")
	private JComboBox<Comparable> cmbDiaDe;
	@SuppressWarnings("rawtypes")
	private JComboBox<Comparable> cmbMesDe;
	@SuppressWarnings("rawtypes")
	private JComboBox<Comparable> cmbAnoDe;
	@SuppressWarnings("rawtypes")
	private JComboBox<Comparable> cmbAnoAte;
	@SuppressWarnings("rawtypes")
	private JComboBox<Comparable> cmbMesAte;
	@SuppressWarnings("rawtypes")
	private JComboBox<Comparable> cmbDiaAte;

	@SuppressWarnings("rawtypes")
	public FrmHistoricoEntrega() {
		setResizable(false);

		// Metodo que inicia propriedades de inicializacao da tela
		propInicializacao();

		// Metodo que inicializa labels de mensagem de erro
		labelsMensagensErro();

		// Definindo propriedades das labels De e Ate
		lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDe.setBounds(80, 86, 21, 14);
		contentPane.add(lblDe);

		lblAte = new JLabel("At\u00E9:");
		lblAte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAte.setBounds(499, 86, 21, 14);
		contentPane.add(lblAte);

		// Declarando combo box do Dia De
		cmbDiaDe = new JComboBox<Comparable>();
		cmbDiaDe.setBounds(105, 84, 46, 20);
		contentPane.add(cmbDiaDe);

		// Declarando label do Dia De
		lblDiaDe = new JLabel("Dia");
		lblDiaDe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDiaDe.setBounds(105, 70, 24, 14);
		contentPane.add(lblDiaDe);

		// Declarando combo box do Mes De
		cmbMesDe = new JComboBox<Comparable>();
		cmbMesDe.setBounds(162, 84, 46, 20);
		contentPane.add(cmbMesDe);

		// Declarando labels do Mes De
		lblMesDe = new JLabel("M\u00EAs");
		lblMesDe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMesDe.setBounds(161, 70, 24, 14);
		contentPane.add(lblMesDe);

		// Declarando combo box do Ano De
		cmbAnoDe = new JComboBox<Comparable>();
		cmbAnoDe.setBounds(220, 84, 73, 20);
		contentPane.add(cmbAnoDe);

		// Declarando label do Ano De
		lblAnoDe = new JLabel("Ano");
		lblAnoDe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAnoDe.setBounds(220, 70, 24, 14);
		contentPane.add(lblAnoDe);

		// Declarando combo box do Ano Ate
		cmbAnoAte = new JComboBox<Comparable>();
		cmbAnoAte.setBounds(645, 84, 73, 20);
		contentPane.add(cmbAnoAte);

		// Declarando Label do Ano Ate
		lblAnoAte = new JLabel("Ano");
		lblAnoAte.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAnoAte.setBounds(645, 70, 24, 14);
		contentPane.add(lblAnoAte);

		// Declarando label do Mes Ate
		lblMesAte = new JLabel("M\u00EAs");
		lblMesAte.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMesAte.setBounds(586, 70, 24, 14);
		contentPane.add(lblMesAte);

		// Declarando combo box do Mes Ate
		cmbMesAte = new JComboBox<Comparable>();
		cmbMesAte.setBounds(587, 84, 46, 20);
		contentPane.add(cmbMesAte);

		// Declarando combo box do Dia Ate
		cmbDiaAte = new JComboBox<Comparable>();
		cmbDiaAte.setBounds(530, 84, 46, 20);
		contentPane.add(cmbDiaAte);

		// Declarando label do Dia Ate
		lblDiaAte = new JLabel("Dia");
		lblDiaAte.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDiaAte.setBounds(530, 70, 24, 14);
		contentPane.add(lblDiaAte);

		// Inicializando os combos
		datas();

		// Declarando e adicionado funcao do boto consultar
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se o metodo salvar retorna que todos as informacoes
				// estao validas
				if (validarCampos()) {
					// Caso estejam validas, estar[a habilidado para salvar as
					// informacoes
					System.out.println("Habilitado para consultar");
				} else {
					// Caso estejam invalidas, nao estar[a habilidado para
					// salvar as informacoes
					System.out.println("Não Habilitado para consultar");
				}
				;
			}
		});
		btnConsultar.setBounds(316, 141, 89, 23);
		contentPane.add(btnConsultar);

		// Declarando e adicionando funcao do botao Cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrmMenu.frame.setEnabled(true);
				FrmMenu.frame.setAlwaysOnTop(true);
			}
		});
		btnCancelar.setBounds(415, 141, 89, 23);
		contentPane.add(btnCancelar);

		/*
		 * Declarando JTable
		 * NAO FUNCIONA AINDA,
		 */
		table = new JTable();
		table.setBounds(10, 196, 818, 215);
		contentPane.add(table);

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				// aqui adiciona-se as colunas e seus respectivos nomes
				" ", "Nome", "Telefone", "email", "Sexo" }));
	}

	// Propriedades de incializacao
	public void propInicializacao() {
		setTitle("Hist\u00F3rico de Entregas");
		setBounds(100, 100, 850, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	// Metodo para inicializar labels de mensagem de erro
	public void labelsMensagensErro() {
		lblCampoObrigatrioDe = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioDe.setForeground(Color.RED);
		lblCampoObrigatrioDe.setVisible(false);
		lblCampoObrigatrioDe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioDe.setBounds(303, 86, 102, 14);
		contentPane.add(lblCampoObrigatrioDe);

		lblCampoObrigatrioAte = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioAte.setForeground(Color.RED);
		lblCampoObrigatrioAte.setVisible(false);
		lblCampoObrigatrioAte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioAte.setBounds(726, 86, 102, 14);
		contentPane.add(lblCampoObrigatrioAte);
	}

	// Metodo que limpa os campos
	public void limparCampos() {
		cmbDiaDe.setSelectedItem("");
		cmbAnoDe.setSelectedItem("");
		cmbDiaAte.setSelectedItem("");
		cmbAnoAte.setSelectedItem("");
	}

	// Metodo para validar campos
	public boolean validarCampos() {
		int aindaFalta = 1;
		// Validando campo da data e verificando se o campo esta vazio ou
		// nao foi preenchido por completo
		if (cmbDiaDe.getSelectedItem().equals("")) {
			lblCampoObrigatrioDe.setVisible(true);
			aindaFalta = 0;
		} else {
			if (cmbMesDe.getSelectedItem().equals("")) {
				lblCampoObrigatrioDe.setVisible(true);
				aindaFalta = 0;
			} else {
				if (cmbAnoDe.getSelectedItem().equals("")) {
					lblCampoObrigatrioDe.setVisible(true);
					aindaFalta = 0;
				} else {
					lblCampoObrigatrioDe.setVisible(false);
				}
			}
		}

		// Validando campo da data e verificando se o campo esta vazio ou
		// nao foi preenchido por completo
		if (cmbDiaAte.getSelectedItem().equals("")) {
			lblCampoObrigatrioAte.setVisible(true);
			aindaFalta = 0;
		} else {
			if (cmbMesAte.getSelectedItem().equals("")) {
				lblCampoObrigatrioAte.setVisible(true);
				aindaFalta = 0;
			} else {
				if (cmbAnoAte.getSelectedItem().equals("")) {
					lblCampoObrigatrioAte.setVisible(true);
					aindaFalta = 0;
				} else {
					lblCampoObrigatrioAte.setVisible(false);
				}
			}
		}
		if (aindaFalta == 0) {
			return false;
		} else {
			return true;
		}
	}

	// Metodo para alimentar os combo boxes das datas
	public void datas() {
		// Iniciando combo do dia
		cmbDiaDe.insertItemAt("", 0);
		for (int i = 1; i <= 28; i++) {
			cmbDiaDe.addItem(i);
		}

		// Iniciando combo do Mes
		cmbMesDe.insertItemAt("", 0);
		for (int i = 1; i <= 12; i++) {
			cmbMesDe.addItem(i);
		}

		// Iniciando combo do ano
		Calendar cal = GregorianCalendar.getInstance();
		int AnoAtual = cal.get(Calendar.YEAR);
		cmbAnoDe.insertItemAt("", 0);
		for (int i = AnoAtual; i >= 1995; i--) {
			cmbAnoDe.addItem(i);
		}

		// Adicionando acao para definir os dias corretos para cada mes
		ActionListener MesDeSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = (int) cmbMesDe.getSelectedItem();
				if (comboSelected != 2) {
					cmbDiaDe.addItem("29");
					cmbDiaDe.addItem("30");
					cmbDiaDe.addItem("31");
				} else {
					cmbDiaDe.removeAllItems();
					cmbDiaDe.insertItemAt("", 0);
					for (int i = 1; i <= 28; i++) {
						cmbDiaDe.addItem(i);
					}
				}
			}
		};
		cmbMesDe.addActionListener(MesDeSelect);

		// Iniciando combo do dia
		cmbDiaAte.insertItemAt("", 0);
		for (int i = 1; i <= 28; i++) {
			cmbDiaAte.addItem(i);
		}

		// Iniciando combo do Mes
		cmbMesAte.insertItemAt("", 0);
		for (int i = 1; i <= 12; i++) {
			cmbMesAte.addItem(i);
		}

		// Iniciando combo do ano
		cmbAnoAte.insertItemAt("", 0);
		for (int i = AnoAtual; i >= 1995; i--) {
			cmbAnoAte.addItem(i);
		}

		// Adicionando acao para definir os dias corretos para cada mes
		ActionListener mesAteSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = (int) cmbMesAte.getSelectedItem();
				if (comboSelected != 2) {
					cmbDiaAte.addItem("29");
					cmbDiaAte.addItem("30");
					cmbDiaAte.addItem("31");
				} else {
					cmbDiaAte.removeAllItems();
					cmbDiaAte.insertItemAt("", 0);
					for (int i = 1; i <= 28; i++) {
						cmbDiaAte.addItem(i);
					}
				}
			}
		};
		cmbMesAte.addActionListener(mesAteSelect);
	}
}
