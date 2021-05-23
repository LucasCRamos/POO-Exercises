package br.usp.ime.mac321.ep1.ex1;

public class GreenhouseControls extends Controlador {
	
	private boolean light = false;
	private boolean water = false;
	private String thermostat = "Day";

	private class LightOn extends Evento {
		
		public LightOn(long eventTime) {
			super(eventTime);
		}
		
		public void ação() {
		// Put hardware control code here to
		// physically turn on the light.
			light = true;
		}
		
		public String descrição() {
			
			return "Light is on";
		}

	}
	
	private class LightOff extends Evento {
		
		public LightOff(long eventTime) {
		super(eventTime);
	
	}

	public void ação() {
	// Put hardware control code here to
	// physically turn off the light.
		light = false;
		
	}

	public String descrição() {
		
		return "Light is off";
		
	}

}
	
	private class WaterOn extends Evento {
		
		public WaterOn(long eventTime) {
		super(eventTime);
		
	}

	public void ação() {
	// Put hardware control code here
		water = true;
	
	}

	public String descrição() {
		
		return "Greenhouse water is on";
		
	}
	
	}
	private class WaterOff extends Evento {
		
		public WaterOff(long eventTime) {
			super(eventTime);
			
	}
	public void ação() {
	// Put hardware control code here
		water = false;
		
	}
	public String descrição() {
		
		return "Greenhouse water is off";
	}

}
	private class ThermostatNight extends Evento {
		
		public ThermostatNight(long eventTime) {
		super(eventTime);
	
	}
	public void ação() {
	// Put hardware control code here
		thermostat = "Night";
	
	}
	public String descrição() {
			
		return "Thermostat on night setting";
		
	}
	
	}
	private class ThermostatDay extends Evento {
		
		public ThermostatDay(long eventTime) {
		super(eventTime);
		
	}
	public void ação() {
	// Put hardware control code here
		thermostat = "Day";
	
	}
	public String descrição() {
		
		return "Thermostat on day setting";
	
	}
}
// An example of an action() that inserts a
// new one of itself into the event list:
	private int rings;
	
	private class Bell extends Evento {
		
		public Bell(long eventTime) {
		super(eventTime);
	
	}
		
		public void ação() {
		// Ring bell every 2 seconds, rings times:
			System.out.println("Bing!");
			
			if(--rings > 0)
			insere(new Bell(
			System.currentTimeMillis() + 2000));
			}
		
		public String descrição() {
			
			return "Ring bell";
		
		}

	}
	
	private class Restart extends Evento {
		
		public Restart(long eventTime) {
			
			super(eventTime);
	
		}
		
		public void ação() {
			
			long tm = System.currentTimeMillis();
			// Instead of hard-wiring, you could parse
			// configuration information from a text
			// file here:
			rings = 5;
			insere(new ThermostatNight(tm));
			insere(new LightOn(tm + 1000));
			insere(new LightOff(tm + 2000));
			insere(new WaterOn(tm + 3000));
			insere(new WaterOff(tm + 8000));
			insere(new Bell(tm + 9000));
			insere(new ThermostatDay(tm + 10000));
			// Can even add a Restart object!
			insere(new Restart(tm + 20000));
		
		}

		public String descrição() {
			
			return "Restarting system";
		
		}

	}
	
	public static void main(String[] args) {
		
		GreenhouseControls gc =
		new GreenhouseControls();
		long tm = System.currentTimeMillis();
		gc.insere(gc.new Restart(tm));
		gc.run();
		
	}
}