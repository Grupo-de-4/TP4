package test;

import org.junit.Assert;
import org.junit.Test;

import exceptions.InvalidArgumentsException;
import generador.Generador;
import matrizSimetrica.MatrizSimetrica;

public class TestCreacionGrafo {

	MatrizSimetrica matriz;
	
	/**
	 * Testeo base del funcionamiento de generador regular, con N=3 y G=2
	 */
	@Test
	public void creacionRegular3g2()
	{
		Generador gen = new Generador();
		try {
			matriz = gen.genRegular(3, 2);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
			e.printStackTrace();
		}
		
		Assert.assertEquals(1, matriz.getPos(0, 1));
		Assert.assertEquals(1, matriz.getPos(0, 2));
		Assert.assertEquals(1, matriz.getPos(1, 0));
		Assert.assertEquals(1, matriz.getPos(1, 2));
		
		Assert.assertEquals(0, matriz.getPos(0, 0));
		Assert.assertEquals(0, matriz.getPos(1, 1));
		Assert.assertEquals(0, matriz.getPos(2, 2));
	}
	
	/**
	 * Testeo de argumentos invalidos pasados al generador: N=3, G=3, no deberia poder generarse
	 */
	@Test
	public void creacionRegular3g3Exception()
	{
		boolean thrown = false;
		Generador gen = new Generador();
		try {
			matriz = gen.genRegular(3, 3);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
			//e.printStackTrace();
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	/**
	 * Testeo de argumentos invalidos pasados al generador: N=1, G=1, no deberia poder generarse
	 */
	@Test
	public void creacionRegular1g1Exception()
	{
		boolean thrown = false;
		Generador gen = new Generador();
		try {
			matriz = gen.genRegular(1, 1);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
			e.printStackTrace();
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	/**
	 * Testeo de argumentos invalidos pasados al generador: N=5, G=3, no deberia poder generarse
	 * ya que ambos N y G son impares
	 */
	@Test
	public void creacionRegular5g3Exception()
	{
		boolean thrown = false;
		Generador gen = new Generador();
		try {
			matriz = gen.genRegular(5, 3);
		} catch (InvalidArgumentsException e) {
			System.out.println("Argumentos invalidos!");
			e.printStackTrace();
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
}
