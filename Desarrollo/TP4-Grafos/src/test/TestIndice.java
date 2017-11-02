package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import matrizSimetrica.MatrizSimetrica;

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
