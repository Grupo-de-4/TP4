package matrizSimetrica;

public class MatrizSimetrica {
	private int orden;
	private int tamaño;
	private int vector[];

	public MatrizSimetrica(int n) {
		this.orden = n;
		this.tamaño = (int) ((Math.pow(orden, 2) - orden) / 2);
		vector = new int[this.tamaño];
	}

	public int getPos(int f, int c) {
		int indice = (int) (f * orden + c - (Math.pow(f, 2) + 3 * f + 2) / 2);
		return vector[indice];
	}
	
	public void setPos(int valor ,int f, int c)
	{
		int indice = (int) (f * orden + c - (Math.pow(f, 2) + 3 * f + 2) / 2);
		vector[indice] = valor;
	}
	
	public int getOrden()
	{
		return this.orden;
	}
}
