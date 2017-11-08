package grafos;

import matrizSimetrica.MatrizSimetrica;

public class MatrizAdyacencia extends MatrizSimetrica {

	private int cantidadAristas;
	private int[] gradoNodos;
	
	public MatrizAdyacencia(int n) {
		super(n);
		gradoNodos = new int[n];
	}

	public double calcularPorcentajeAdyacencia() {
		double aristasTotales = (((double)orden - 1) * orden) / 2;
		double aristasEnGrafo = cantidadAristas;
		return aristasEnGrafo / aristasTotales;
	}

	public boolean enlazar(boolean valor, int f, int c) {
		if (super.setPos(valor, f, c) == true) {
			cantidadAristas++;
			gradoNodos[f]++;
			gradoNodos[c]++;
			return true;
		}
		return false;
	}
	
	public boolean enlazado(int f, int c)
	{
		return getPos(f, c)!=false;
	}

	public int[] getGradoNodos() {
		return gradoNodos;
	}

	public void setGradoNodos(int[] gradoNodos) {
		this.gradoNodos = gradoNodos;
	}

}
