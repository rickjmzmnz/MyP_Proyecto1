
package proyecto1.test;

import java.util.Random;
import proyecto1.ArbolAnalizador;
import org.junit.Assert;
import org.junit.Test;

public class TestArbolAnalizador {

	/**
	 * Prueba unitaria para el método agrega
	 */

	@Test
	public void testPrueba() {
		String cadena = "cadena";
		ArbolAnalizador arbol1 = new ArbolAnalizador();
		ArbolAnalizador arbol2 = new ArbolAnalizador();
		arbol1.agrega(cadena,arbol1.getRaiz());
		arbol2.agrega(cadena,arbol2.getRaiz());
		String a1 = arbol1.getRaiz().getToken();
		String a2 = arbol2.getRaiz().getToken();
		Assert.assertTrue(a1.equals(a2));
	}


}
