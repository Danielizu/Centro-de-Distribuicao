package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FrmConsultaNF extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaNF frame = new FrmConsultaNF();
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
	public FrmConsultaNF() {
		setTitle("Consulta Nota Fiscal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNmeroDaNota = new JLabel("N\u00FAmero da nota fiscal");
		lblNmeroDaNota.setBounds(20, 60, 130, 14);
		contentPane.add(lblNmeroDaNota);
		
		textField = new JTextField();
		try{
			javax.swing.text.MaskFormatter nota = new javax.swing.text.MaskFormatter("##########");
			textField = new javax.swing.JFormattedTextField(nota);
		}
		catch (Exception e){
		
		}
		textField.setBounds(160, 57, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblPedidos = new JLabel("Pedido");
		lblPedidos.setBounds(20, 104, 53, 20);
		contentPane.add(lblPedidos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(314, 56, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblConsultaNf = new JLabel("Consulta NF");
		lblConsultaNf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsultaNf.setBounds(20, 26, 130, 23);
		contentPane.add(lblConsultaNf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 150, 429, 344);
		contentPane.add(scrollPane);
	}
}
