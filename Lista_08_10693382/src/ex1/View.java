package ex1;

import javax.swing.*;

public class View {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		
		f.setTitle("Calculadora de Fatorial");
		
		f.setSize(300,100);
		
		f.setLocation(500,300);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		
		JLabel l = new JLabel("Digite o número: ");
		
		p.add(l);
		
		JTextField t = new JTextField(10);
		
		p.add(t);
		
		JButton b = new JButton("OK");
		
		Botao action = new Botao(t);
		
		b.addActionListener(action);
		
		p.add(b);
		
		f.add(p);
		
		f.setVisible(true);
	}
}
