package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrmHistoricoEntrega extends JFrame {

	private static final long serialVersionUID = -1521264863605086732L;
	private JPanel contentPane;
	private JLabel lblDe;
	private JLabel lblAte;
	private JLabel lblCampoObrigatrioDe;
	private JLabel lblCampoObrigatrioAte;
	private JLabel lblDataInicialIncorreta;
	private JButton btnConsultar;
	private JButton btnCancelar;
	private JDateChooser dataInicial;
	private JDateChooser dataFinal;

	public FrmHistoricoEntrega() {
		setResizable(false);

		// Metodo que inicia propriedades de inicializacao da tela
		propInicializacao();

		// Metodo que inicializa labels de mensagem de erro
		labelsMensagensErro();

		// Definindo propriedades das label De
		lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDe.setBounds(80, 86, 21, 14);
		contentPane.add(lblDe);

		// JCalendar para data inicial
		dataInicial = new JDateChooser();
		dataInicial.setBounds(102, 80, 101, 20);
		contentPane.add(dataInicial);

		// Definindo propriedades das label Ate
		lblAte = new JLabel("At\u00E9:");
		lblAte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAte.setBounds(498, 86, 21, 14);
		contentPane.add(lblAte);

		// JCalendar para data Final
		dataFinal = new JDateChooser();
		dataFinal.setBounds(529, 80, 102, 20);
		contentPane.add(dataFinal);

		// Declarando e adicionado funcao do boto consultar
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {
					// Caso estejam validas, estar[a habilidado para salvar as
					// informacoes
					System.out.println("Habilitado para consultar");
				} else {
					// Caso estejam invalidas, nao estar[a habilidado para
					// salvar as informacoes
					System.out.println("Não Habilitado para consultar");
				}
			}
		});
		btnConsultar.setBounds(316, 141, 89, 23);
		contentPane.add(btnConsultar);

		// Declarando e adicionando funcao do botao Cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(415, 141, 89, 23);
		contentPane.add(btnCancelar);


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
		// Campo obrigatorio de
		lblCampoObrigatrioDe = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioDe.setForeground(Color.RED);
		lblCampoObrigatrioDe.setVisible(false);
		lblCampoObrigatrioDe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioDe.setBounds(213, 86, 102, 14);
		contentPane.add(lblCampoObrigatrioDe);

		// Campo obrigatorio de Ate
		lblCampoObrigatrioAte = new JLabel("Campo Obrigat\u00F3rio!");
		lblCampoObrigatrioAte.setForeground(Color.RED);
		lblCampoObrigatrioAte.setVisible(false);
		lblCampoObrigatrioAte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObrigatrioAte.setBounds(641, 86, 102, 14);
		contentPane.add(lblCampoObrigatrioAte);

		// Definindo propriedades das labels De mensagem de erro de data maior
		// quea outra
		lblDataInicialIncorreta = new JLabel("Data inicial incorreta!");
		lblDataInicialIncorreta.setForeground(Color.RED);
		lblDataInicialIncorreta.setVisible(false);
		lblDataInicialIncorreta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataInicialIncorreta.setBounds(356, 86, 102, 14);
		contentPane.add(lblDataInicialIncorreta);
	}

	// Metodo que limpa os campos
	public void limparCampos() {
		dataInicial.setCalendar(null);
		dataFinal.setCalendar(null);
	}

	// Metodo para validar campos
	public boolean validarCampos() {
		int aindaFalta = 1;

		// Validando campo da data Inicial está preenchido
		if (dataInicial.getDate() == null) {
			lblCampoObrigatrioDe.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioDe.setVisible(false);
		}

		// Validando campo da data Inicial está preenchido
		if (dataFinal.getDate() == null) {
			lblCampoObrigatrioAte.setVisible(true);
			aindaFalta = 0;
		} else {
			lblCampoObrigatrioAte.setVisible(false);
		}

		//Verificando se uma data e maior que a outra.
		Date dataIni = dataInicial.getDate();
		Date dataFin = dataFinal.getDate();
		if (dataIni.after(dataFin)) {
			aindaFalta = 0;
			lblDataInicialIncorreta.setVisible(true);
		}else{
			lblDataInicialIncorreta.setVisible(false);
			//Somente passando a Data para String e exibindo
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data Inicial: " + f.format(dataIni));
			System.out.println("Data Final: " + f.format(dataFin));
		}

		if (aindaFalta == 0) {
			return false;
		} else {
			return true;
		}
	}
}
