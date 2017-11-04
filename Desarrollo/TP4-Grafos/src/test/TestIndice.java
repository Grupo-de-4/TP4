package test;

import org.junit.Assert;
import org.junit.Test;

import matrizSimetrica.MatrizSimetrica;

/**
 * Tests para verificar que la creacion de la matriz simetrica funciona correctamente.
 * Verificamos que las posiciones en el vector correspondan a la de la matriz.
 * @author avorraim
 *
 */
class TestIndice {

	private MatrizSimetrica matriz;

	/**
	 * Testeo de la Matriz Simetrica. Evaluamos que el indice interno del vector sea
	 * el correcto para (0,1)
	 */
	@Test
	public void testIndiceCero() {
		matriz = new MatrizSimetrica(3);
		Assert.assertEquals(matriz.getIndice(0, 1), 0);
	}

	/**
	 * Testeo de la Matriz Simetrica. Evaluamos que el indice interno del vector sea
	 * el correcto para (0,2)
	 */
	@Test
	public void testIndiceUno() {
		matriz = new MatrizSimetrica(3);
		Assert.assertEquals(matriz.getIndice(0, 2), 1);
	}

	/**
	 * Testeo de la Matriz Simetrica. Evaluamos que el indice interno del vector sea
	 * el correcto para (1,2)
	 */
	@Test
	public void testIndiceDos() {
		matriz = new MatrizSimetrica(3);
		Assert.assertEquals(matriz.getIndice(1, 2), 2);
	}
}
