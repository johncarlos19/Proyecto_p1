package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3834684781329387617L;
	private String nombre;
	private float peso;
	private String code;
	private float estatura;
	private String posicion;
	private int numero;
	private ArrayList<Lesion> lesionJugador;
	private Estadistica puntoJugador;
	
	public Jugador(String nombre, float peso, float estatura, String posicion, int numero, String code) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.estatura = estatura;
		this.posicion = posicion;
		this.numero = numero;
		this.lesionJugador = new ArrayList<Lesion>();
		this.puntoJugador = new Estadistica();
		this.code = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {//ffg
		this.nombre = nombre;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Lesion> getLesionJugador() {
		return lesionJugador;
	}

	public void setLesionJugador(ArrayList<Lesion> lesionJugador) {
		this.lesionJugador = lesionJugador;
	}

	public Estadistica getPuntoJugador() {
		return puntoJugador;
	}

	public void setPuntoJugador(Estadistica puntoJugador) {
		this.puntoJugador = puntoJugador;
	}
	
	public String getCode() {
		return code;
	}

	public void code(String code) {
		this.code = code;
	}
	
	public boolean agregarLesiones (Lesion aux){
		boolean cant= false;
		lesionJugador.add(aux);
		return cant; 
	}
	
	//public boolean 
	
}
