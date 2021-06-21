package ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Botao implements ActionListener {
	
	private JTextField t;
	
	public Botao(JTextField t) {
		
		this.t = t;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		int valor = 0;
		
		try {
			
			valor = Integer.parseInt(t.getText());
			
			if (valor < 0) throw new NumeroNegativoException();
			
			else if (valor > 12) throw new ForaDaFaixaException();
			
			JOptionPane.showMessageDialog(null, "Fatorial é: " + Controller.calcula(valor) + ".");
		
		}
	
		catch(NumberFormatException ex) {
			
			JOptionPane.showMessageDialog(null, "Número fora do formato esperado!");
			
		}
		
		catch(ForaDaFaixaException ex) {
			
			JOptionPane.showMessageDialog(null, "Fatorial excede o limite do int!");
		}
		
		catch(NumeroNegativoException ex) {
			
			JOptionPane.showMessageDialog(null, "Fatorial de número negativo não existe!");
		}
		
	}

}

