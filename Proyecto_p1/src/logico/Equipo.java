package logico;

import java.util.ArrayList;

public class Equipo {
	
	private String nombre;
	private ArrayList<Jugador> nominaJugadores;
	private String coach;
	private String cancha;
	private boolean estado;
	private int puntos;
	
	public Equipo(String nombre, String coach, String cancha) {
		super();
		this.nombre = nombre;
		this.nominaJugadores = new ArrayList<>();
		this.coach = coach;
		this.cancha = cancha;
		this.estado = true;
		this.puntos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getNominaJugadores() {
		return nominaJugadores;
	}

	public void setNominaJugadores(ArrayList<Jugador> nominaJugadores) {
		this.nominaJugadores = nominaJugadores;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getCancha() {
		return cancha;
	}

	public void setCancha(String cancha) {
		this.cancha = cancha;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public boolean agregarJugador(Jugador aux){
		boolean cant = false;
		if (nominaJugadores.size() <15){
			
			nominaJugadores.add(aux); 
			cant=true;//kk
		}
		
		return cant;
	 }
	
	public boolean agregarLesionJugador(String codeAux, Lesion aux){
		boolean hecho = false;
		int i=0;
		while(i<nominaJugadores.size()){
			if (nominaJugadores.get(i).getCode().equalsIgnoreCase(codeAux)) {
				nominaJugadores.get(i).agregarLesiones(aux);
				hecho=true;
			}
			
			i++;
		}
		return hecho;
	}
}
