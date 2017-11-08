package grafos;

import java.util.Arrays;
import java.util.Random;

import exceptions.InvalidArgumentsException;

/**
 * Clase que me permite generar diversos tipos de grafos
 * 
 * @author avorraim
 * @param <T>
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
	public static Grafo genAleatorioProb(int orden, double probabilidad) {
		Grafo grafo = new Grafo(orden);
		Random r = new Random();

		for (int f = 0; f < orden; f++)
			for (int c = f + 1; c < orden; c++)
				if (r.nextDouble() < probabilidad)
					grafo.enlazar(f, c);

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
	public static Grafo genAleatorioAdyacencia(int orden, int adyacencia) {
		Random rand = new Random();
		Grafo grafo = null;
		int i,j;
		int aristasNec = (int)Math.round((Math.pow(orden, 2)-orden)*adyacencia/2);
		while( grafo==null|| grafo.getCantidadDeAristas() != aristasNec){
			i=0;
			grafo=new Grafo(orden);
			while(i < orden && grafo.getCantidadDeAristas() != aristasNec){
				j=i+1;
				while(j<orden && grafo.getCantidadDeAristas() != aristasNec){
					if((rand.nextDouble()) <= adyacencia){
						grafo.enlazar(i, j);
					}
					j++;
				}
				i++;
			}
		}
		return grafo;
	}

	/**
	 * Metodo que me permite generar un grafo regular. El grado tiene que ser menor
	 * al orden. El grado solo puede ser 1 si el orden es 2. Para los nodos impares
	 * no puedo elegir grados impares.
	 * 
	 * @param orden
	 *            Orden del grafo a generar
	 * @param grado
	 *            Grado de los nodos
	 * @return Un grafo
	 * @throws InvalidArgumentsException
	 */
	public static Grafo genRegular(int orden, int grado) throws InvalidArgumentsException {

		if (orden == 0 || (grado >= orden) || (orden > 2 && grado == 1)
				|| (orden != 1 && orden % 2 != 0 && grado % 2 != 0))
			throw new InvalidArgumentsException("Argumentos invalidos");

		Grafo grafo = new Grafo(orden);
		for (int i = 0; i < orden; i++) {
			for (int j = 1; j <= grado / 2; j++) {
				grafo.enlazar(i, (i + j) % orden);
			}
			if (i < (orden / 2) && grado % 2 == 1) {
				grafo.enlazar(i, i + (orden / 2));
			}
		}

		return grafo;
	}

	/**
	 * Metodo que me permite generar un grafo regular segun un porcentaje de
	 * adyacencia El grado tiene que ser menor al orden. El grado solo puede ser 1
	 * si el orden es 2. Para los nodos impares no puedo elegir grados impares.
	 * 
	 * @param n
	 *            Orden del grafo a generar
	 * @param p
	 *            Porcentaje de adyacencia
	 * @return Un grafo
	 * @throws InvalidArgumentsException 
	 */
	public static Grafo genRegularAdyacencia(int n, double p) throws InvalidArgumentsException {
		int grado = (int) Math.round(p * (n - 1));

		return genRegular(n, grado);
	}

	/**
	 * Metodo que me permite generar un grafo G-partito de N nodos.
	 * 
	 * @param n
	 *            Orden del grafo a generar
	 * @param g
	 *            Numero de conjuntos/particiones
	 * @return Un grafo
	 */
	public static Grafo genNPartito(int n, int g) {
		if(g >= n){
			System.out.println("ERROR: No se puede tener un grafo de " + n + "nodos con " + g + "particiones.");
		}
		 
		int elementosPorPart = Math.round(n / g);
		int f_imparidad = (n%2==0&&g%2!=0)||(n%2!=0&&g%2==0)?1:0; 
		
		Grafo grafo = new Grafo(n);
		
		for(int i=0; i + elementosPorPart + f_imparidad <= grafo.getCantidadDeNodos(); i++){
			for(int j = (i/elementosPorPart)*elementosPorPart + elementosPorPart; j < grafo.getCantidadDeNodos(); j++){
				grafo.enlazar(i, j);
			}
		}
		
		return grafo;
	}

}
