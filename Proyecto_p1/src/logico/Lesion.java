package logico;

import java.util.Date;

public class Lesion {
	private String tipoLesion;
	private Date fechaLesion;
	private String detalleLesion;
	/**
	 * @param tipoLesion
	 * @param fechaLesion
	 * @param detalleLesion
	 */
	public Lesion(String tipoLesion, Date fechaLesion, String detalleLesion) {
		super();
		this.tipoLesion = tipoLesion;
		this.fechaLesion = fechaLesion;
		this.detalleLesion = detalleLesion;
	}
	public String getTipoLesion() {
		return tipoLesion;
	}
	public void setTipoLesion(String tipoLesion) {
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
	
