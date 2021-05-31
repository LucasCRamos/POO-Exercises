package br.usp.ime.mac321.ep1.ex3;
import br.usp.ime.mac321.ep1.ex1.Controlador;
import br.usp.ime.mac321.ep1.ex1.Evento;
import br.usp.ime.mac321.ep1.ex2.Medico;
import br.usp.ime.mac321.ep1.ex2.Paciente;

public class Simulador1 extends Controlador {
	
	Medico medico = new Medico(10,"CKK");
	Paciente paciente = new Paciente(36.5,110000,5,5,0);
	
	private class criaMedicoPaciente extends Evento{
		
		long temp;
		
		public criaMedicoPaciente(long eventTime) {
			
			super(eventTime);
			temp = (eventTime - System.currentTimeMillis())/10 ;
		}
		
		public void ação() {
			
		}
		
		public String descrição() {
			
			return temp+" min\nMédico Criado\nPaciente Criado";
			
		}
		
	}
	
	private class pacienteIniciaSurto extends Evento{
		
		long temp;
		
		public pacienteIniciaSurto(long eventTime) {
			
			super(eventTime);
			temp = (eventTime - System.currentTimeMillis())/10 ;
		}
		
		public void ação() {
			
		}
		
		public String descrição() {
			
			return temp+" min\nPaciente inicia surto infeccioso";
			
		}
		
	}
	
	private class MonitoraPaciente extends Evento{
		
		long temp;
		
		public MonitoraPaciente(long eventTime) {
			
			super(eventTime);
			temp = (eventTime - System.currentTimeMillis())/10 ;
		}
		

		
		public void ação() {
			
			paciente.valorTemperatura(temp);
			paciente.valorConcentracao(temp);
				

		}
		
		public String descrição() {
			
			if (paciente.estaVivo(temp)==false) {
				
				return temp+" min\nMédico verifica óbito do paciente\nSimulação terminada";
				
			}
			
			else {
				
				if(temp == 0) {
					
					return "Médico consulta temperatura: " + paciente.valorTemperatura(temp) + 
							"\nMédico consulta concentração: " + paciente.valorConcentracao(temp);
				}
			
				else return temp+" min\nMédico consulta temperatura: " + paciente.valorTemperatura(temp) + 
						"\nMédico consulta concentração: " + paciente.valorConcentracao(temp);
			
			}
			
		}
		
	}

	private class Inicia extends Evento {
		
		
		public Inicia(long eventTime) {
			
			super(eventTime);
	
		}
		
		public void ação() {
			
			//Cada 10 ms no mundo real equivale a 1 min simulado//
			
			long tm = System.currentTimeMillis();
			insere(new criaMedicoPaciente(tm));
			insere(new MonitoraPaciente(tm));
			insere(new pacienteIniciaSurto(tm+10*paciente.getFrequenciaSurtos()));
			
			int i = 1;
			
			while(i<=7) {
				
				insere(new MonitoraPaciente(tm + 10*i*medico.getFreq()));
				i++;

			
			}
		
		}

		public String descrição() {
			
			return "Simulação Iniciada";
		
		}

	}

	public static void main(String[] args) {
		
		Simulador1 s1 = new Simulador1();
		long tm = System.currentTimeMillis();
		s1.insere(s1.new Inicia(tm));
		s1.run();
		
	}
}

