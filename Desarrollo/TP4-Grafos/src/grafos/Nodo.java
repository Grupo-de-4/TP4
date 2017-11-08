package grafos;

public class Nodo<T> implements Comparable<Nodo<T>>{

	private T data;
	private int grado;
	
	public Nodo(T data, int grado) {
		super();
		this.data = data;
		this.grado = grado;
	}

	@Override
	public int compareTo(Nodo<T> o) {
		return this.grado - o.grado;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the grado
	 */
	public int getGrado() {
		return grado;
	}

	/**
	 * @param grado the grado to set
	 */
	public void setGrado(int grado) {
		this.grado = grado;
	}

	public void incGrado()
	{
		this.grado++;
	}
	
	public void decGrado()
	{
		this.grado--;
	}
	
	
}
