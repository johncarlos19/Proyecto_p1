package logico;

import java.util.Date;

public class Juego {
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
