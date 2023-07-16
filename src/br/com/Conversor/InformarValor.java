package br.com.Conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;

public class InformarValor extends JFrame {

	private JPanel contentPane;
	private JTextField textValorInformado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformarValor frame = new InformarValor(0);
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
	public InformarValor(int opcao) {
		int opcaoEscolhida = opcao;
		System.out.println(opcaoEscolhida);
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
		
		JLabel lblNewLabel = new JLabel("Informe o valor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 5, 400, 15);
		contentPane.add(lblNewLabel);
		
		textValorInformado = new JTextField();
		textValorInformado.setBounds(96, 32, 222, 28);
		contentPane.add(textValorInformado);
		textValorInformado.setColumns(10);
		
		JLabel lblErro = new JLabel("");
		lblErro.setForeground(new Color(224, 27, 36));
		lblErro.setFont(new Font("Dialog", Font.BOLD, 11));
		lblErro.setHorizontalTextPosition(SwingConstants.CENTER);
		lblErro.setIconTextGap(2);
		lblErro.setHorizontalAlignment(SwingConstants.CENTER);
		lblErro.setBounds(5, 63, 400, 25);
		contentPane.add(lblErro);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(45, 90, 117, 25);
		contentPane.add(btnConverter);
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblErro.setText("");
				try {
					
					double valorText = Double.parseDouble(textValorInformado.getText().replace(",", "."));
					String valor = new Requisicao().getValor(opcaoEscolhida, valorText);
					new Resultado(valor,opcaoEscolhida).setVisible(true);
					System.out.println(valor);
				}catch(Exception e1) {
					System.out.println("erro");
					lblErro.setText("Não deve conter letras e deve ter ponto no lugar de vígula.");
					
				}
				
			}
		});
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(228, 90, 117, 25);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ConversorDeMoedas().setVisible(true);
			}
		});

		

	}

}
