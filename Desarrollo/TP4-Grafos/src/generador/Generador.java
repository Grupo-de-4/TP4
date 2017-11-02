package generador;

import java.util.Random;

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
	 * 		Orden del grafo a generar
	 * @param adyacencia
	 * 		Porcentaje de adyacencia
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

}
