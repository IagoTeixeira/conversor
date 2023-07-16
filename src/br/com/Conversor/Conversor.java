package br.com.Conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;

public class Conversor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor window = new Conversor();
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
	public Conversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 420, 132);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 418, 85);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/*
		 * Lista de conversores
		 */
		String[] conversores = {"Conversor De Moedas"};
		
		JComboBox ListaConversores = new JComboBox(conversores);
		ListaConversores.setBounds(70, 24, 168, 24);
		panel.add(ListaConversores);
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(ListaConversores.getSelectedIndex()) {
					case 0:
						frame.setVisible(false);
						new ConversorDeMoedas().setVisible(true);
						break;		
				}
			}
		});
		btnNewButton.setBounds(250, 24, 117, 25);
		panel.add(btnNewButton);
	}
}
