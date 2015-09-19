
package proyecto1.test;

import java.util.Random;
import proyecto1.Numero;
import org.junit.Assert;
import org.junit.Test;

public class TestNumero {

	private Random random = new Random();

	/**
	 * Prueba unitaria para el método numero
	 */
	@Test
	public void testPrueba() {
	int i = 0;
	while(i < 100000) {
		Double doble = 	random.nextDouble()*Double.MAX_VALUE;
		String cadena = doble.toString();
		Assert.assertTrue(Numero.numero(cadena));
		i++;
	}
		String n = "numero";
		Assert.assertFalse(Numero.numero(n));	
	
	}


}
