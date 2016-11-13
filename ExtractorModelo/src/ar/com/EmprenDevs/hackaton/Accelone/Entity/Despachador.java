package ar.com.EmprenDevs.hackaton.Accelone.Entity;

import java.io.Serializable;

/**
 * Despachor de datos
 * @author beetoven.desir
 *
 */

public class Despachador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private  String datos;
	private  long   date;
	
	
	
	
	public Despachador(String datos, long date) {
		super();
		this.datos = datos;
		this.date = date;
	}
	
	
	
	public Despachador() {
		super();
	}



	public String getDatos() {
		return datos;
	}
	public void setDatos(String datos) {
		this.datos = datos;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
	
	
	
}
