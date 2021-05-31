package br.usp.ime.mac321.ep1.ex4;
import br.usp.ime.mac321.ep1.ex1.Controlador;
import br.usp.ime.mac321.ep1.ex1.Evento;

public class Simulador2 extends Controlador{
	
	Medico medico = new Medico(10,"CKK");
	Paciente paciente = new Paciente(36.0,100000,5,120,38*Math.pow(10, -3));
	Droga droga = new Droga(27*Math.pow(10, -3),54*Math.pow(10, -3));

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
			
			paciente.valorTemperatura(temp,droga.getVelRedTemp(),120);
			paciente.valorConcentracao(temp,droga.getVelRedConc(),120);
				

		}
		
		public String descrição() {
			
			if (paciente.estaVivo(temp,droga.getVelRedTemp(),droga.getVelRedConc(),120)==false) {
				
				return temp+" min\nMédico verifica óbito do paciente\nSimulação terminada";
				
			}
			
			else {
				
				if(temp == 0) {
					
					return "Médico consulta temperatura: " + paciente.valorTemperatura(temp,droga.getVelRedTemp(),120) + 
							"\nMédico consulta concentração: " + paciente.valorConcentracao(temp,droga.getVelRedConc(),120);
				}
			
				else return temp+" min\nMédico consulta temperatura: " + paciente.valorTemperatura(temp,droga.getVelRedTemp(),120) + 
						"\nMédico consulta concentração: " + paciente.valorConcentracao(temp,droga.getVelRedConc(),120);
			
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
			
			while(i<=36) {
				
				insere(new MonitoraPaciente(tm + 10*i*medico.getFreq()));
				i++;

			
			}
		
		}

		public String descrição() {
			
			return "Simulação Iniciada";
		
		}

	}

	public static void main(String[] args) {
		
		Simulador2 s2 = new Simulador2();
		long tm = System.currentTimeMillis();
		s2.insere(s2.new Inicia(tm));
		s2.run();
		
	}
}