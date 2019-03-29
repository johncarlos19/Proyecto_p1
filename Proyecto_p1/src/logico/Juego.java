package logico;

import java.io.Serializable;
import java.util.Date;

public class Juego implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2700358167077251146L;
	private Equipo [] equipoJuego;
	private Date fechaJuego;
	
	
	/**
	 * @param equipoJuego
	 * @param fechaJuego
	 * @param tiempo
	 */
	public Juego(Date fechaJuego) {
		super();
		this.equipoJuego = new Equipo[2];
		this.fechaJuego = fechaJuego;
	}
	public Equipo[] getEquipoJuego() {
		return equipoJuego;
	}
	public void setEquipoJuego(Equipo[] equipoJuego) {
		this.equipoJuego = equipoJuego;
	}
	public Date getFechaJuego() {
		return fechaJuego;
	}
	public void setFechaJuego(Date fechaJuego) {
		this.fechaJuego = fechaJuego;//jj
	}
	
	
}
