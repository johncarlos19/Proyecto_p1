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
	
	private int rebotes;
	private int asistencias;
	private int bloqueos;
	private int robos;
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
		
		this.rebotes = 0;
		this.asistencias = 0;
		this.bloqueos = 0;
		this.robos = 0;
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
	public int getRebotes() {
		return rebotes;
	}
	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public int getBloqueos() {
		return bloqueos;
	}
	public void setBloqueos(int bloqueos) {
		this.bloqueos = bloqueos;
	}
	public int getRobos() {
		return robos;
	}
	public void setRobos(int robos) {
		this.robos = robos;
	}
	public int cantPunto() {
		int tiro=0;
		tiro = tiroDoble*2 + tiroTriple*3 + tiroLibre;
		return tiro;
	}
	
	
}
