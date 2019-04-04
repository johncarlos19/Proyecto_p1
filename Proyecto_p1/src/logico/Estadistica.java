package logico;

import java.io.Serializable;

public class Estadistica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8910922322328217594L;
	private int tiroDoble;
	private int tiroLibre;
	private int tiroTriple;
	private int cantFalta;
	/**
	 * @param asistencia
	 * @param cantebote
	 * @param tiroDoble
	 * @param tiroLibre
	 * @param tiroTriple
	 * @param cantFalta
	 */
	public Estadistica() {
		super();
		this.tiroDoble = 0;
		this.tiroLibre = 0;
		this.tiroTriple = 0;;
		this.cantFalta = 0;
	}
	public int getTiroDoble() {
		return tiroDoble;
	}
	public void setTiroDoble(int tiroDoble) {
		this.tiroDoble = tiroDoble;
	}
	public int getTiroLibre() {
		return tiroLibre;
	}
	public void setTiroLibre(int tiroLibre) {
		this.tiroLibre = tiroLibre;
	}
	public int getTiroTriple() {
		return tiroTriple;
	}
	public void setTiroTriple(int tiroTriple) {//fhf
		this.tiroTriple = tiroTriple;
	}
	public int getCantFalta() {
		return cantFalta;
	}
	public void setCantFalta(int cantFalta) {
		this.cantFalta = cantFalta;
	}
	public int cantPunto() {
		int tiro=0;
		tiro = tiroDoble*2 + tiroTriple*3 + tiroLibre;
		return tiro;
	}
	
	
}
