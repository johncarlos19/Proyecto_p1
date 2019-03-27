package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Equipo {
	
	private String nombre;
	private ArrayList<Jugador> nominaJugadores;
	private String coach;
	private String cancha;
	private boolean estado;
	private int puntos;
	private ImageIcon logo;
	private File logoEquipo;
	
	public Equipo(String nombre, String coach, String cancha, File logoEquipo) {
		super();
		this.nombre = nombre;
		this.nominaJugadores = new ArrayList<>();
		this.coach = coach;
		this.cancha = cancha;
		this.estado = true;
		this.puntos = 0;
		this.logoEquipo = logoEquipo;
		//this.logo = new ImageIcon(logoEquipo.toString());
		//logo.se
	}
/*	FileInputStream lector = new FileInputStream(logoEquipo);
    FileOutputStream escritor = new FileOutputStream(archivoSalida);
	 int unByte;     
     // Informa que se está copiando el archivo
     //System.out.println("\n\tEl archivo está siendo copiado....");
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
	
	public void guardarLogo() throws IOException, ClassNotFoundException  {
		
		File archivoSalida = new File("src/logo_equipo/"+nombre+".jpeg");
		FileInputStream lector = new FileInputStream(logoEquipo);
	    FileOutputStream escritor = new FileOutputStream(archivoSalida);
		 int unByte;     
	     // Informa que se está copiando el archivo
	     System.out.println("\n\tEl archivo está siendo copiado....");
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
	     System.out.println("\tEl archivo ha sido copiado con éxito....\n");
	     logo = new ImageIcon(archivoSalida.toString());
	}
}
	
