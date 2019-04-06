package logico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import visual.Principal;


public class Baloncesto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6369141671291306568L;
	private ArrayList<Equipo> misEquipos;
	private ArrayList<Juego> juegoRecord;
	private int cantJuegosTorneo;
	private boolean enJuego;
	private static Baloncesto mibaloncesto=null;//jo
	/**
	 * @param miFactura
	 * @param miCliente
	 * @param miQuesos
	 */
	
	 public static Baloncesto getInstance(){
		 if(mibaloncesto == null){
			 mibaloncesto = new Baloncesto();
		 }
		 return mibaloncesto;
	 } 
	
	private Baloncesto() {
		super();
		this.misEquipos = new ArrayList<Equipo>();
		this.juegoRecord = new ArrayList<Juego>();
		this.cantJuegosTorneo = 0;
		this.enJuego  = false;
	}
	
	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}
	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	public ArrayList<Juego> getJuegoRecord() {
		return juegoRecord;
	}

	public void setJuegoRecord(ArrayList<Juego> juegoRecord) {
		this.juegoRecord = juegoRecord;
	}

	public int getCantJuegos() {
		return cantJuegosTorneo;
	}
	public void setCantJuegos(int cantJuegos) {
		this.cantJuegosTorneo = cantJuegos;
	}
	
	public boolean isEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}

	//calcular factorial para calcular posibles combinaciones del calendario
	
	private int factorial(int x) {
		int y = x;
		
		if(x == 0) {
			return 1;
		}
		
		for(int i = (x - 1); i > 1; i--) {
			y *= i;
		}
		
		return y;
	}
	
	//agregar aquipo en el listado
	
	public void agregarEquipo(Equipo aux1) {
		misEquipos.add(aux1);
		escribirDatos();
	}
	
	//calcular cant de juegos a jugar
	
	public int calcCantJuego(ArrayList<Equipo> equipoTor) {
		int cantJuegos = 0;
		int cantEquipos = equipoTor.size();
		
		if(cantEquipos < 2) {
			return 0;
		}
		
		cantJuegos = (factorial(cantEquipos))/((2)*(factorial(cantEquipos - 2)));
		
		return cantJuegos;
	}
	
	//crear nuevo partido a partir de la fecha colocada y ya.
	
	public void crearPartido(ArrayList<Equipo> equipoTor, Date fechaInicio) {
		int i=0;
		int j=0;
		int k=j;
		int posi=0;
		int fech= 0;
		while(i<(equipoTor.size()-1)) {
			k+=1;
			j=k;
			while(j<equipoTor.size()) {
				Equipo [] auxEquipo = new Equipo[2];
				auxEquipo[0]=devolverEquipo(equipoTor.get(i));
				auxEquipo[1]=devolverEquipo(equipoTor.get(j));
				Juego aux;
				if (juegoRecord.size()==0) {
					aux = new Juego(fechaInicio);
					aux.setEquipoJuego(auxEquipo.clone());
					posi=juegoRecord.size();
					juegoRecord.add(aux);
					fech+=1;
				}else {
					int des=0;
					if (fech%3==0) {
						des=1;
					}
					aux = new Juego(fechaTorneo(juegoRecord.get(posi).getFechaJuego(), des));
					aux.setEquipoJuego(auxEquipo.clone());
					posi=juegoRecord.size();
					juegoRecord.add(aux);
					fech+=1;
				}
				j++;
			}
			i++;
		}
		escribirDatos();
	}
	
	
	//devolver equipo consiste en que se devolvera la puntuacion del equipo a su direccion de memoria
	
	private Equipo devolverEquipo(Equipo aux) {
		Equipo clone=null;
		String nombre = aux.getNombre();
		String coach = aux.getCoach();
		String cancha = aux.getCancha();
		File logoEquipo = aux.getLogoEquipo();
		ImageIcon logo = aux.getLogo();
		clone = new Equipo(nombre, coach, cancha, logoEquipo);
		clone.setLogo(logo);
		int i=0;
		while (i<aux.getNominaJugadores().size()) {
			String nombre1 = aux.getNominaJugadores().get(i).getNombre();
			float peso = aux.getNominaJugadores().get(i).getPeso();
			float estatura = aux.getNominaJugadores().get(i).getEstatura();
			String posicion = aux.getNominaJugadores().get(i).getPosicion();
			int numero = aux.getNominaJugadores().get(i).getNumero();
			Jugador clonJuga= new Jugador(nombre1, peso, estatura, posicion, numero);
			clone.agregarJugador(clonJuga);
			i++;
		}
		return clone;
	}
	
	// retorna la nueva fecha para el siguiente partido 
	// un equipo no juega dos veces el mismo dia 
	//tercer dia descanso de juego
	
	private Date fechaTorneo(Date fechaAnterior, int fechaDescanso) {
		int year = fechaAnterior.getYear();
		int month = fechaAnterior.getMonth();
		int date = fechaAnterior.getDate();
		int numDias=0;
		switch (month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            numDias = 31;
            if(month==12 && date==numDias) {
            	month=1;
            	date=(1+fechaDescanso);
            	year+=1;
            }else if (date==numDias) {
				date=(1+fechaDescanso);
				month+=1;
			}else {
				date+=(1+fechaDescanso);
			}
            break;
        case 4: case 6: case 9: case 11:
            numDias = 30;
            if(month==12 && date==numDias) {
            	month=1;
            	date=(1+fechaDescanso);
            	year+=1;
            }else if (date==numDias) {
				date=(1+fechaDescanso);
				month+=1;
			}else {
				date+=(1+fechaDescanso);
			}
            break;
        case 2:
            if(((year+1900)%4==0 && (year+1900)%100!=0) || (year+1900)%400==0){
                numDias = 29;
            }
            else{
                numDias = 28;
            }
            if(month==12 && date==numDias) {
            	month=1;
            	date=(1+fechaDescanso);
            	year+=1;
            }else if (date==numDias) {
				date=(1+fechaDescanso);
				month+=1;
			}else {
				date+=(1+fechaDescanso);
			}
            break;
        default:
            System.out.println("\nEl mes " + month + " es incorrecto.");
            break;
    }
		Date fechaNueva = new Date(year, month, date);
		return fechaNueva;
	}
	
	//guardar informaciones del programa
	
	public void escribirDatos()
	{
		
		try
		{
			FileOutputStream f = new FileOutputStream("src/Baloncesto.dat");
			ObjectOutputStream os = new ObjectOutputStream(f);
			os.writeInt(cantJuegosTorneo);
			os.writeBoolean(enJuego);
			os.writeObject(misEquipos);
			os.writeObject(juegoRecord);
			
			
			
		}
		catch(FileNotFoundException ex)
		{
			System.err.println(" Error "+ex);
		}catch (IOException ex){
			System.err.println(" Error "+ex);
			ex.printStackTrace();
		}
		
	
		
	}
	
	// agregar punto de lesión 
	
	public void agregarLesion(String codeAux, String equipo, Lesion lesion) {
		boolean found = false;
		int i = 0;
		
		while (!found && i < misEquipos.size()) {
			if(misEquipos.get(i).getNombre().equalsIgnoreCase(equipo)) {
				misEquipos.get(i).agregarLesionJugador(codeAux, lesion);
				found = true;
			}
			i++;
		}
		
	}
}
