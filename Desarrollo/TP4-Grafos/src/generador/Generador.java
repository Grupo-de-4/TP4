package generador;

import java.util.Random;

import exceptions.InvalidArgumentsException;
import matrizSimetrica.MatrizSimetrica;

/**
 * Clase que me permite generar diversos tipos de grafos
 * 
 * @author avorraim
 */
public class Generador {

	/**
	 * Metodo que me permite generar un grafo a partir de un orden y una
	 * probabilidad de arista.
	 * 
	 * @param n
	 *            Orden del grafo a generar
	 * @param probabilidad
	 *            Probabilidad de generar un arista
	 * @return Un grafo
	 */
	public MatrizSimetrica genAleatorioProb(int n, double probabilidad) {
		MatrizSimetrica grafo = new MatrizSimetrica(n);
		Random r = new Random();

		for (int f = 0; f < n; f++)
			for (int c = f + 1; c < n; c++)
				if (r.nextDouble() < probabilidad)
					grafo.setPos(1, f, c);

		return grafo;
	}

	/**
	 * Metodo que me permite generar un grafo aleatorio con un porcentaje de
	 * adyacencia
	 * 
	 * @param n
	 *            Orden del grafo a generar
	 * @param adyacencia
	 *            Porcentaje de adyacencia
	 * @return Un grafo
	 */
	public MatrizSimetrica genAleatorioAdyacencia(int n, int adyacencia) {
		MatrizSimetrica grafo = new MatrizSimetrica(n);

		for (int f = 0; f < n; f++)
			for (int c = f + 1; c < n; c++) {
				// TODO
			}

		return grafo;
	}

	/**
	 * Metodo que me permite generar un grafo regular. 
	 * El grado tiene que ser menor al orden. 
	 * El grado solo puede ser 1 si el orden es 2. 
	 * Para los nodos impares no puedo elegir grados impares.
	 * 
	 * @param n
	 *            Orden del grafo a generar
	 * @param g
	 *            Grado de los nodos
	 * @return Un grafo
	 * @throws InvalidArgumentsException 
	 */
	public MatrizSimetrica genRegular(int n, int g) throws InvalidArgumentsException {
		
		if(n==0 || (g>=n) || (n>2 && g==1) || ( n!=1 && n%2!=0 && g%2!=0))
		{
			throw new InvalidArgumentsException("Argumentos invalidos");
		}
		
		MatrizSimetrica grafo = new MatrizSimetrica(n);
		
		for (int f = 0; f < n; f++) {
			int cLazos = 0;
			for (int c = 0; c < n; c++) {
				if (f != c && cLazos < g && grafo.getPos(f, c) == 0) {
					grafo.setPos(1, f, c);
					cLazos++;
				}
			}
		}
		return grafo;
	}

}
