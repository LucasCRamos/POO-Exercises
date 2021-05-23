package br.usp.ime.mac321.ep1.ex3;
import br.usp.ime.mac321.ep1.ex1.Controlador;
import br.usp.ime.mac321.ep1.ex2.Medico;
import br.usp.ime.mac321.ep1.ex2.Paciente;

public class Simulador1 extends Controlador {
	
	Medico medico = new Medico(10); //monitora sinais a cada 10min
	Paciente paciente = new Paciente(36.5,110000,5,5,0);
	
}
