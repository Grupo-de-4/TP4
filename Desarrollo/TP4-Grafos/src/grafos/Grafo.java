package grafos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Grafo {

	private MatrizAdyacencia matrizAdyacencia;
	
	/**
	 * Constructor del Grafo
	 * @param n
	 */
	public Grafo(int n)
	{
		matrizAdyacencia = new MatrizAdyacencia(n);
	}
	

	/**
	 * @return the matrizAdyacencia
	 */
	public MatrizAdyacencia getMatrizAdyacencia() {
		return matrizAdyacencia;
	}
	
	/**
	 * @param matrizAdyacencia the matrizAdyacencia to set
	 */
	public void setMatrizAdyacencia(MatrizAdyacencia matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}
	
	public int getCantidadDeNodos(){
		return matrizAdyacencia.getOrden();
	}
	
	public void enlazar(int f, int c)
	{
		matrizAdyacencia.enlazar(true, f, c);
	}
	
	public boolean enlazado(int f, int c)
	{
		return matrizAdyacencia.enlazado(f, c);
	}
	
	public int getCantidadDeAristas(){
		int cantAristas=0;
		int cantidadDeNodos = getCantidadDeNodos();
		for(int i=0; i<cantidadDeNodos; i++)
			for(int j= i+1; j < cantidadDeNodos; j++)
				if(matrizAdyacencia.enlazado(i, j))
				cantAristas++;	
		return cantAristas;
	}
	
	public int getGradoMin() {
		int gradoMin=Integer.MAX_VALUE;
		int cantidadDeNodos = getCantidadDeNodos();
		
		for (int i = 0; i < cantidadDeNodos; i++) {
			int g=0;
			for(int j = 0; j < cantidadDeNodos; j++)
				if(i!=j && matrizAdyacencia.enlazado(i,j))
					g++;
			if(g<gradoMin)
				gradoMin = g;
		}
		
		return gradoMin;
	}

	public int getGradoMax() {
		int gradoMax=0;
		int cantidadDeNodos = getCantidadDeNodos();
		
		for (int i = 0; i < cantidadDeNodos; i++) {
			int g=0;
			for(int j = 0; j < cantidadDeNodos; j++)
				if(i!= j && matrizAdyacencia.enlazado(i,j))
					g++;
			if(g>gradoMax)
				gradoMax = g;
		}
		
		return gradoMax;
	}

	public void escribirComoEntrada(String path) throws IOException {
		FileWriter archivo = new FileWriter(path);
		PrintWriter fichero = new PrintWriter(archivo);
		int cantidadDeAristas = getCantidadDeAristas() ;
		fichero.println(getCantidadDeNodos() + " " + cantidadDeAristas + " " + (double)cantidadDeAristas/getMaximaCantidadDeAristasPosibles() + " " + getGradoMax() + " " + getGradoMin());
		for (int i = 0; i < getCantidadDeNodos(); i++)
			for (int j = i; j < getCantidadDeNodos(); j++)
				if (i != j && matrizAdyacencia.enlazado(i, j) == true)
					fichero.println(i + " " + j);					
		archivo.close();
	}

	public int getMaximaCantidadDeAristasPosibles() {
		return matrizAdyacencia.getSize();
	}

	

}
