package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLabel;

import control.ControlarSettings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSettings {

	private JFrame frame;
	ControlarSettings settings = new ControlarSettings();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSettings window = new FrmSettings();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmSettings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 349, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Veiculos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 53, 314, 179);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMarcaDeCarro = new JLabel("Marca de Carro");
		lblMarcaDeCarro.setBounds(10, 65, 129, 24);
		panel.add(lblMarcaDeCarro);
		
		JLabel lblCarroceria = new JLabel("Carroceria");
		lblCarroceria.setBounds(10, 100, 129, 24);
		panel.add(lblCarroceria);
		
		JLabel lblTipoDeVeiculo = new JLabel("Tipo de Veiculo");
		lblTipoDeVeiculo.setBounds(10, 134, 129, 24);
		panel.add(lblTipoDeVeiculo);
		
		JLabel lblCorDeCarro = new JLabel("Cor de Carro");
		lblCorDeCarro.setBounds(10, 31, 129, 23);
		panel.add(lblCorDeCarro);
		
		JButton btnAdicionarCor = new JButton("Adicionar");
		btnAdicionarCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cor = JOptionPane.showInputDialog("Digite o nome da cor: ");
				settings.AdicionarCor(cor);
			}
		});
		btnAdicionarCor.setBounds(118, 31, 89, 23);
		panel.add(btnAdicionarCor);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(213, 31, 89, 23);
		panel.add(btnRemover);
		
		JButton btnAdicionaMarca = new JButton("Adicionar");
		btnAdicionaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String marca = JOptionPane.showInputDialog("Digite o nome da Marca: ");
			}
		});
		btnAdicionaMarca.setBounds(118, 67, 89, 23);
		panel.add(btnAdicionaMarca);
		
		JButton button_1 = new JButton("Remover");
		button_1.setBounds(213, 67, 89, 23);
		panel.add(button_1);
		
		JButton btnAdicionaTipo= new JButton("Adicionar");
		btnAdicionaTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String marca = JOptionPane.showInputDialog("Digite o tipo de veiculo: ");
			}
		});
		btnAdicionaTipo.setBounds(118, 135, 89, 23);
		panel.add(btnAdicionaTipo);
		
		JButton button_3 = new JButton("Remover");
		button_3.setBounds(213, 135, 89, 23);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Remover");
		button_4.setBounds(213, 99, 89, 23);
		panel.add(button_4);
		
		JButton btnAdicionaCarroceria = new JButton("Adicionar");
		btnAdicionaCarroceria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String marca = JOptionPane.showInputDialog("Digite o tipo de carroceria: ");
			}
		});
		btnAdicionaCarroceria.setBounds(118, 99, 89, 23);
		panel.add(btnAdicionaCarroceria);
	}
}
