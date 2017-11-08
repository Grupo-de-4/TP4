package matrizSimetrica;

/**
 * Matriz simetrica reflejada con ceros en la diagonal principal
 * 
 * @author avorraim
 */
public class MatrizSimetrica {
	protected int orden;
	protected int size;
	protected boolean vector[];

	public MatrizSimetrica(int n) {
		this.orden = n;
		this.size = (int) ((Math.pow(orden, 2) - orden) / 2);
		vector = new boolean[this.size];
	}

	public boolean getPos(int f, int c) {
		if (c == f)
			return false;

		//Invierto los indices si me llegan al reves
		if (c < f) {
			f = f + c;
			c = f - c;
			f = f - c;
		}

		int indice = (int) (f * orden + c - (Math.pow(f, 2) + 3 * f + 2) / 2);
		return vector[indice];
	}

	public int getIndice(int f, int c) {
		int indice = (int) (f * orden + c - (Math.pow(f, 2) + 3 * f + 2) / 2);
		return indice;
	}

	public boolean setPos(boolean valor, int f, int c) {

		if (f == c)
			return false;

		if (c < f) {
			f = f + c;
			c = f - c;
			f = f - c;
		}

		int indice = (int) (f * orden + c - (Math.pow(f, 2) + 3 * f + 2) / 2);
		vector[indice] = valor;

		return true;
	}

	public int getOrden() {
		return this.orden;
	}

	public int getSize() {
		return size;
	}

	public void printUpperTriangle() {
		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++)
				System.out.print(j <= i ? "0 " : getPos(i, j) + " ");
			System.out.println("");
		}
	}

	public void printMatrix() {
		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++)
				System.out.print(getPos(i, j) + " ");
			System.out.println("");
		}
	}
}
