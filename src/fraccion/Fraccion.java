package fraccion;


/**
 * Clase que define una fracción
 * @author jmmoreno
 *
 */
public class Fraccion {

	/**
	 * Numerador
	 */
	private int num;

	/**
	 * Denominador
	 */
	private int den;

	/**
	 * Constructor por defecto
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}


	/**
	 * Constructor con parámetros
	 * @param num
	 * @param den
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}


	/**
	 * Constructor copia
	 * @param f
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * Setter
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * Getter
	 * @return Devuelve el numerador
	 */
	public int getNum() {
		return num;

	}
	/**
	 * Setter
	 * @param den
	 */
	public void setDen(int den) {
		this.den = den;
	}
	/**
	 * Getter
	 * @return Devuelve el denominador
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Cálculo del máximo común divisor por el algoritmo de Euclides
	 * @return Devuelve u 
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * Método para simplificar francciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}


	/**
	 * Método toString
	 * Devuelve mensaje
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}


	/**
	 * Suma de fracciones
	 * @param f
	 * @return Devuelve aux
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * restar fracciones
	 * @param f
	 * @return Devuelve aux
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Multiplicar fracciones
	 * @param f
	 * @return Devuelve aux
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Dividir fracciones
	 * @param f
	 * @return Devuelve aux
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
