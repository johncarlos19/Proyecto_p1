package logico;

import java.io.Serializable;
import java.util.Date;

public class Lesion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1550564490440332723L;
	private int tipoLesion;
	private Date fechaLesion;
	private String detalleLesion;
	/**
	 * @param tipoLesion
	 * @param fechaLesion
	 * @param detalleLesion
	 */
	public Lesion(int tipoLesion, Date fechaLesion, String detalleLesion) {
		super();
		this.tipoLesion = tipoLesion;
		this.fechaLesion = fechaLesion;
		this.detalleLesion = detalleLesion;
	}
	public int getTipoLesion() {
		return tipoLesion;
	}
	public void setTipoLesion(int tipoLesion) {
		this.tipoLesion = tipoLesion;
	}
	public Date getFechaLesion() {
		return fechaLesion;
	}
	
	public void setFechaLesion(Date fechaLesion) {
		this.fechaLesion = fechaLesion;
	}
	public String getDetalleLesion() {//ghhg
		return detalleLesion;
	}
	public void setDetalleLesion(String detalleLesion) {
		this.detalleLesion = detalleLesion;
	}
	
}
	
