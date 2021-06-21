package ex2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.Test;

import ex1.Controller;
import ex1.ForaDaFaixaException;
import ex1.NumeroNegativoException;
import ex1.View;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Testes {
	
	
	@Test
	public void testeView() {
		
		//O usuário vai executar o programa, dentro da caixa (Digite o número),
		//ele entrará com o valor desejado, apertará no botão "OK" e o resultado
		//será mostrado.
		
		//Uma pequena demonstração de como isso é feito é mostrada abaixo pelo robot.
		
		try {
				
			View.main(null);
			 Robot robot = new Robot();
			 robot.setAutoDelay(400);
			 robot.mouseMove(690, 350);
			 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			 robot.keyPress(KeyEvent.VK_5);
			 robot.keyRelease(KeyEvent.VK_5);
			 robot.mouseMove(640, 385);
			 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			 robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			 robot.delay(2000);
	
			 
		}
		
		catch(AWTException e) {
			
			  e.printStackTrace();
		}
		
	}
		
	@Test
	public void testeController(){
		
		try {
			
			assertEquals("1",String.valueOf(Controller.calcula(0)));
			
			assertEquals("24",String.valueOf(Controller.calcula(4)));
		}
		
		catch (NumeroNegativoException e) {
			
			System.out.println(e);
			fail();
		}
		
		catch (ForaDaFaixaException e) {
			
			System.out.println(e);
			fail();
		}
		
	}
	
	@Test
	public void testeControllerException() {
		
		assertThrows(NumeroNegativoException.class, () -> {Controller.calcula(-20);});
		assertThrows(ForaDaFaixaException.class, () -> {Controller.calcula(15);});
		
	}
}
	
