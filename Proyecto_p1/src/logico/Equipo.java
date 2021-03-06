package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Equipo implements Serializable {
	
	private static final long serialVersionUID = -9050316527821816246L;
	private String nombre;
	private ArrayList<Jugador> nominaJugadores;
	private String coach;
	private String cancha;
	private boolean estado;
	private int puntos;
	private ImageIcon logo;
	private File logoEquipo;
	private int juegosPerdidos;
	
	public Equipo(String nombre, String coach, String cancha, File logoEquipo) {
		super();
		this.nombre = nombre;
		this.nominaJugadores = new ArrayList<>();
		this.coach = coach;
		this.cancha = cancha;
		this.estado = true;
		this.puntos = 0;
		this.logoEquipo = logoEquipo;
		this.juegosPerdidos=0;
		//this.logo = new ImageIcon(logoEquipo.toString());
		//logo.se
	}
/*	FileInputStream lector = new FileInputStream(logoEquipo);
    FileOutputStream escritor = new FileOutputStream(archivoSalida);
	 int unByte;     
     // Informa que se est� copiando el archivo
     //System.out.println("\n\tEl archivo est� siendo copiado....");
     // Lee el archivoEntrada y guarda la informacion en el archivoSalida
     try {
			while ((unByte = lector.read()) != -1)
			   escritor.write(unByte);
			
		    lector.close();
	        escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        */
    
	
	public File getLogoEquipo() {
		return logoEquipo;
	}


	public ImageIcon getLogo() {
		return logo;
	}


	public void setLogo(ImageIcon logo) {
		this.logo = logo;
	}


	public void setLogoEquipo(File logoEquipo) {
		this.logoEquipo = logoEquipo;
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
	
	public int getJuegosPerdidos() {
		return juegosPerdidos;
	}


	public void setJuegosPerdidos(int juegosPerdidos) {
		this.juegosPerdidos = juegosPerdidos;
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
			if (nominaJugadores.get(i).getNombre().equalsIgnoreCase(codeAux)) {
				nominaJugadores.get(i).agregarLesiones(aux);
				hecho=true;
			}
			
			i++;
		}
		return hecho;
	}
	
	public void guardarLogo() throws IOException, ClassNotFoundException  {
		
		File archivoSalida = new File("src/logo_equipo/"+nombre+".jpeg");
		FileInputStream lector = new FileInputStream(logoEquipo);
	    FileOutputStream escritor = new FileOutputStream(archivoSalida);
		 int unByte;     
	     // Informa que se est� copiando el archivo
	     System.out.println("\n\tEl archivo est� siendo copiado....");
	     // Lee el archivoEntrada y guarda la informacion en el archivoSalida
	     try {
				while ((unByte = lector.read()) != -1)
				   escritor.write(unByte);
				
			    lector.close();
		        escritor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     System.out.println("\tEl archivo ha sido copiado con �xito....\n");
	     logo = new ImageIcon(archivoSalida.toString());
	}
	
	public int cantPuntoDelEquipo() {
		int tiro = 0;
		
		for (Jugador jugador : nominaJugadores) {
			tiro += jugador.getPuntoJugador().cantPunto();
		}
		
		return tiro;
	}
	public int cantTiro(int aux) {
		int tiro = 0;
		
		if (aux==1) {
			for (Jugador jugador : nominaJugadores) {
				tiro += jugador.getPuntoJugador().getTiroLibre();
			}
		}
		if (aux==2) {
			for (Jugador jugador : nominaJugadores) {
				tiro += jugador.getPuntoJugador().getTiroDoble();
			}
		}
		if (aux==3) {
			for (Jugador jugador : nominaJugadores) {
				tiro += jugador.getPuntoJugador().getTiroTriple();
			}
		}
		if (aux==4) {
			for (Jugador jugador : nominaJugadores) {
				tiro += jugador.getPuntoJugador().getRebotes();
			}
		}
		if (aux==5) {
			for (Jugador jugador : nominaJugadores) {
				tiro += jugador.getPuntoJugador().getAsistencias();
			}

		}
		
		if (aux==6) {
			for (Jugador jugador : nominaJugadores) {
				tiro += jugador.getPuntoJugador().getRobos();
			}
		}
		if (aux==7) {
			for (Jugador jugador : nominaJugadores) {
				tiro += jugador.getPuntoJugador().getBloqueos();
			}

		}
		
		return tiro;
	}
}
	
