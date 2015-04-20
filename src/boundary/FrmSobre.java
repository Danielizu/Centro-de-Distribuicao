package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSobre {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSobre window = new FrmSobre();
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
	public FrmSobre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 254, 257);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmSobre.class.getResource("/images/FrmSobre_12.png")));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(274, 11, 187, 193);
		frame.getContentPane().add(panel_1);
		
		JLabel lblCentroDeDistribuio = new JLabel("Centro de Distribui\u00E7\u00E3o");
		lblCentroDeDistribuio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblCentroDeDistribuio);
		
		JLabel lblSistemaDesenvolvidoPor = new JLabel("Sistema desenvolvido por:");
		panel_1.add(lblSistemaDesenvolvidoPor);
		
		JLabel lblAlexandreLima = new JLabel("<html><br>\r\nAlexandre Lima<br>\r\nDaniel Izu<br>\r\nDemetrius Dione<br>\r\nFelipe Lima<br>\r\nFilipe <br>\r\nGabriel Dias<br>\r\nJackson Silva<br>\r\nMarcelo<br>\r\nThiago Marques<br>\r\nVagner Carvalho<br></html>");
		lblAlexandreLima.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_1.add(lblAlexandreLima);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnVoltar.setBounds(321, 228, 94, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
