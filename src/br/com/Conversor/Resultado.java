package br.com.Conversor;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Resultado extends JFrame {

	private JPanel contentPane;
	private final JButton btnOk = new JButton("Ok");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultado frame = new Resultado("", 0);
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
	public Resultado(String valor, int simbolo) {
		String[] simbolosDoDinheiro = {"$","R$","Є","R$"};		
		
		setAlwaysOnTop(true);
		setLocation(new Point(0, 0));
		setType(Type.POPUP);
		setResizable(false);
		setBounds(100, 100, 410, 127);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(148, 90, 117, 25);
		contentPane.add(btnOk);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 32, 410, 15);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("O valor convertido é de " + simbolosDoDinheiro[simbolo] + valor);
	}
}
