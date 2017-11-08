package test;

import org.junit.Assert;
import org.junit.Test;

import exceptions.InvalidArgumentsException;
import grafos.Generador;
import grafos.Grafo;

/**
 * Testeo la creacion de grafos
 * 
 * @author avorraim
 *
 */
public class TestCreacionGrafo {

	Grafo grafo;

	/**
	 * Testeo base del funcionamiento de generador regular, con N=3 y G=2
	 */
	@Test
	public void creacionRegular3g2() {
		try {
			grafo = Generador.genRegular(3, 2);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
		}

		Assert.assertEquals(true, grafo.enlazado(0, 1));
		Assert.assertEquals(true, grafo.enlazado(0, 2));
		Assert.assertEquals(true, grafo.enlazado(1, 0));
		Assert.assertEquals(true, grafo.enlazado(1, 2));

		Assert.assertEquals(false, grafo.enlazado(0, 0));
		Assert.assertEquals(false, grafo.enlazado(1, 1));
		Assert.assertEquals(false, grafo.enlazado(2, 2));

		System.out.println((double) grafo.getCantidadDeAristas() / grafo.getMaximaCantidadDeAristasPosibles());
	}

	/**
	 * Testeo base del funcionamiento de generador regular, con N=10 y G=4
	 */
	@Test
	public void creacionRegular4g2() {
		try {
			grafo = Generador.genRegular(4, 2);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
		}

		System.out.println((double) grafo.getCantidadDeAristas() / grafo.getMaximaCantidadDeAristasPosibles());
		Assert.assertTrue(true);
	}

	/**
	 * Testeo de argumentos invalidos pasados al generador: N=3, G=3, no deberia
	 * poder generarse
	 */
	@Test
	public void creacionRegular3g3Exception() {
		boolean thrown = false;
		try {
			grafo = Generador.genRegular(3, 3);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}

	/**
	 * Testeo de argumentos invalidos pasados al generador: N=1, G=1, no deberia
	 * poder generarse
	 */
	@Test
	public void creacionRegular1g1Exception() {
		boolean thrown = false;
		try {
			grafo = Generador.genRegular(1, 1);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}

	/**
	 * Testeo de argumentos invalidos pasados al generador: N=5, G=3, no deberia
	 * poder generarse ya que ambos N y G son impares
	 */
	@Test
	public void creacionRegular5g3Exception() {
		boolean thrown = false;
		try {
			grafo = Generador.genRegular(5, 3);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}

	
	/**
	 * Testeo de creacion de grafo aleatorio N=3 por probabilidad 1 (todas las conexiones)
	 */
	@Test
	public void creacionAleatorioProbabilidad3prob1() {
		grafo = Generador.genAleatorioProb(3, 1);
		Assert.assertEquals(true, grafo.enlazado(0, 1));
		Assert.assertEquals(true, grafo.enlazado(0, 2));
		Assert.assertEquals(true, grafo.enlazado(1, 0));
		Assert.assertEquals(true, grafo.enlazado(1, 2));

		Assert.assertEquals(false, grafo.enlazado(0, 0));
		Assert.assertEquals(false, grafo.enlazado(1, 1));
		Assert.assertEquals(false, grafo.enlazado(2, 2));
	}

	/**
	 * Testeo de creacion de grafo aleatorio N=6 por probabilidad 1 (todas las conexiones)
	 */
	@Test
	public void creacionAleatorioProbabilidad6prob1() {
		grafo = Generador.genAleatorioProb(6, 1);
		Assert.assertEquals(true, grafo.enlazado(0, 1));
		Assert.assertEquals(true, grafo.enlazado(0, 2));
		Assert.assertEquals(true, grafo.enlazado(0, 3));
		Assert.assertEquals(true, grafo.enlazado(0, 4));
		Assert.assertEquals(true, grafo.enlazado(0, 5));
		
		Assert.assertEquals(true, grafo.enlazado(1, 2));
		Assert.assertEquals(true, grafo.enlazado(1, 3));
		Assert.assertEquals(true, grafo.enlazado(1, 4));
		Assert.assertEquals(true, grafo.enlazado(1, 5));

		Assert.assertEquals(true, grafo.enlazado(2, 3));
		Assert.assertEquals(true, grafo.enlazado(2, 4));
		Assert.assertEquals(true, grafo.enlazado(2, 5));

		Assert.assertEquals(true, grafo.enlazado(3, 4));
		Assert.assertEquals(true, grafo.enlazado(3, 5));

		Assert.assertEquals(true, grafo.enlazado(4, 5));
	}
	
	/**
	 * Testeo de creacion de grafo aleatorio N=6 por probabilidad 0 (ninguna conexion)
	 */
	@Test
	public void creacionAleatorioProbabilidad6prob0() {
		grafo = Generador.genAleatorioProb(6, 0);
		Assert.assertEquals(false, grafo.enlazado(0, 1));
		Assert.assertEquals(false, grafo.enlazado(0, 2));
		Assert.assertEquals(false, grafo.enlazado(0, 3));
		Assert.assertEquals(false, grafo.enlazado(0, 4));
		Assert.assertEquals(false, grafo.enlazado(0, 5));
		
		Assert.assertEquals(false, grafo.enlazado(1, 2));
		Assert.assertEquals(false, grafo.enlazado(1, 3));
		Assert.assertEquals(false, grafo.enlazado(1, 4));
		Assert.assertEquals(false, grafo.enlazado(1, 5));

		Assert.assertEquals(false, grafo.enlazado(2, 3));
		Assert.assertEquals(false, grafo.enlazado(2, 4));
		Assert.assertEquals(false, grafo.enlazado(2, 5));

		Assert.assertEquals(false, grafo.enlazado(3, 4));
		Assert.assertEquals(false, grafo.enlazado(3, 5));

		Assert.assertEquals(false, grafo.enlazado(4, 5));
	}
	
	
	/**
	 * Testeo de creacion de grafo aleatorio N=6 por porcentaje 1 (todas las conexiones)
	 */
	@Test
	public void creacionAleatorioPorcentaje6porc1() {
		grafo = Generador.genAleatorioAdyacencia(6, 1);
		Assert.assertEquals(true, grafo.enlazado(0, 1));
		Assert.assertEquals(true, grafo.enlazado(0, 2));
		Assert.assertEquals(true, grafo.enlazado(0, 3));
		Assert.assertEquals(true, grafo.enlazado(0, 4));
		Assert.assertEquals(true, grafo.enlazado(0, 5));
		
		Assert.assertEquals(true, grafo.enlazado(1, 2));
		Assert.assertEquals(true, grafo.enlazado(1, 3));
		Assert.assertEquals(true, grafo.enlazado(1, 4));
		Assert.assertEquals(true, grafo.enlazado(1, 5));

		Assert.assertEquals(true, grafo.enlazado(2, 3));
		Assert.assertEquals(true, grafo.enlazado(2, 4));
		Assert.assertEquals(true, grafo.enlazado(2, 5));

		Assert.assertEquals(true, grafo.enlazado(3, 4));
		Assert.assertEquals(true, grafo.enlazado(3, 5));

		Assert.assertEquals(true, grafo.enlazado(4, 5));
	}
	
	/**
	 * Testeo de creacion de grafo aleatorio N=6 por porcentaje 0 (ninguna conexion)
	 */
	@Test
	public void creacionAleatorioPorcentaje6porc0() {
		grafo = Generador.genAleatorioAdyacencia(6, 0);
		Assert.assertEquals(false, grafo.enlazado(0, 1));
		Assert.assertEquals(false, grafo.enlazado(0, 2));
		Assert.assertEquals(false, grafo.enlazado(0, 3));
		Assert.assertEquals(false, grafo.enlazado(0, 4));
		Assert.assertEquals(false, grafo.enlazado(0, 5));
		
		Assert.assertEquals(false, grafo.enlazado(1, 2));
		Assert.assertEquals(false, grafo.enlazado(1, 3));
		Assert.assertEquals(false, grafo.enlazado(1, 4));
		Assert.assertEquals(false, grafo.enlazado(1, 5));

		Assert.assertEquals(false, grafo.enlazado(2, 3));
		Assert.assertEquals(false, grafo.enlazado(2, 4));
		Assert.assertEquals(false, grafo.enlazado(2, 5));

		Assert.assertEquals(false, grafo.enlazado(3, 4));
		Assert.assertEquals(false, grafo.enlazado(3, 5));

		Assert.assertEquals(false, grafo.enlazado(4, 5));
	}
	
	/**
	 * Testeo de creacion de grafo regular con porcentaje de adyacencia. N=6 Porcentaje=100
	 * @throws InvalidArgumentsException 
	 */
	@Test
	public void creacionRegularPorcentaje6porc1() throws InvalidArgumentsException
	{
		grafo = Generador.genRegularAdyacencia(6, 1);
		Assert.assertEquals(true, grafo.enlazado(0, 1));
		Assert.assertEquals(true, grafo.enlazado(0, 2));
		Assert.assertEquals(true, grafo.enlazado(0, 3));
		Assert.assertEquals(true, grafo.enlazado(0, 4));
		Assert.assertEquals(true, grafo.enlazado(0, 5));
		
		Assert.assertEquals(true, grafo.enlazado(1, 2));
		Assert.assertEquals(true, grafo.enlazado(1, 3));
		Assert.assertEquals(true, grafo.enlazado(1, 4));
		Assert.assertEquals(true, grafo.enlazado(1, 5));

		Assert.assertEquals(true, grafo.enlazado(2, 3));
		Assert.assertEquals(true, grafo.enlazado(2, 4));
		Assert.assertEquals(true, grafo.enlazado(2, 5));

		Assert.assertEquals(true, grafo.enlazado(3, 4));
		Assert.assertEquals(true, grafo.enlazado(3, 5));

		Assert.assertEquals(true, grafo.enlazado(4, 5));
	}
	
	/**
	 * Testeo de creacion de grafo regular con porcentaje de adyacencia. N=6 Porcentaje=50
	 * @throws InvalidArgumentsException 
	 */
	@Test
	public void creacionRegularPorcentaje6porc05() throws InvalidArgumentsException
	{
		grafo = Generador.genRegularAdyacencia(6, 0.5);
		Assert.assertEquals(true, grafo.enlazado(0, 1));
		Assert.assertEquals(true, grafo.enlazado(1, 2));
		Assert.assertEquals(true, grafo.enlazado(2, 3));
		Assert.assertEquals(true, grafo.enlazado(3, 4));
		Assert.assertEquals(true, grafo.enlazado(5, 0));
		Assert.assertEquals(true, grafo.enlazado(0, 3));
		Assert.assertEquals(true, grafo.enlazado(1, 4));
		Assert.assertEquals(true, grafo.enlazado(2, 5));
	}
	
	/**
	 * Testeo del generador N partito, con N=6 y 3 partiiones
	 */
	@Test
	public void creacionNPartito()
	{
		grafo = Generador.genNPartito(6, 3);
		Assert.assertEquals(false, grafo.enlazado(0, 1));
		Assert.assertEquals(true, grafo.enlazado(0, 2));
		Assert.assertEquals(true, grafo.enlazado(0, 3));
		Assert.assertEquals(true, grafo.enlazado(0, 4));
		Assert.assertEquals(true, grafo.enlazado(0, 5));
		
		Assert.assertEquals(true, grafo.enlazado(1, 2));
		Assert.assertEquals(true, grafo.enlazado(1, 3));
		Assert.assertEquals(true, grafo.enlazado(1, 4));
		Assert.assertEquals(true, grafo.enlazado(1, 5));

		Assert.assertEquals(false, grafo.enlazado(2, 3));
		Assert.assertEquals(true, grafo.enlazado(2, 4));
		Assert.assertEquals(true, grafo.enlazado(2, 5));

		Assert.assertEquals(true, grafo.enlazado(3, 4));
		Assert.assertEquals(true, grafo.enlazado(3, 5));

		Assert.assertEquals(false, grafo.enlazado(4, 5));
	}
	
}
