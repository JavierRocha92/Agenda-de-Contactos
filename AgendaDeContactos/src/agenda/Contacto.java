package agenda;
/**
 * SERIALIZAMOS LA CLASE PARA PODER ALMACENARLA COMO BIT DE INFORMACION EN UN FICHERO DE OBJETOS
 */

import java.io.Serializable;

public class Contacto implements Serializable{
	/**
	 * NOMBRE DEL CONTACTO
	 */
	private String nombre;
	/**
	 * TELEFONO DEL CONTACTO
	 */
	private String telefono;
	/**
	 * DIRECCION DEL CONTACTO
	 */
	private String direccion;
	/**
	 * CORREO DEL CONTACTO
	 */
	private String correo;
	
	/**
	 * CONTRUCTOR CON 4 PRAMETROS
	 * @param nombre
	 * @param telefono
	 * @param direccion
	 * @param correo
	 */
	
	public Contacto(String nombre, String telefono, String direccion, String correo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
	}
	/**
	 * CONSTRUCTOR VACIO POR DEFECTO
	 */


	public Contacto() {
		super();
		this.nombre = "";
		this.telefono = "";
		this.direccion = "";
		this.correo = "";
	}
	/**
	 * GETTER PARA EL NOMBRE DEL Contacto
	 * @return, EL VALOR DEL NOMBRE
	 */


	public String getNombre() {
		return nombre;
	}
	/**
	 * SETTERS PARA EL NOMBRE DEL Contacto
	 * @param nombre
	 */


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * GETTER PARA EL TELEFONO DEL Contacto
	 * @return, EL VALOR DEL NOMBRE
	 */


	public String getTelefono() {
		return telefono;
	}
	/**
	 * SETTERS PARA EL TELEFONO DEL Contacto
	 * @param nombre
	 */


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * GETTER PARA LA DIRECCION DEL Contacto
	 * @return, EL VALOR DEL NOMBRE
	 */



	public String getDireccion() {
		return direccion;
	}
	/**
	 * SETTERS PARA LA DIRECCION DEL Contacto
	 * @param nombre
	 */



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * GETTER PARA EL CORREO DEL Contacto
	 * @return, EL VALOR DEL NOMBRE
	 */


	public String getCorreo() {
		return correo;
	}
	/**
	 * SETTERS PARA EL CORREO DEL Contacto
	 * @param nombre
	 */

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * METODO TO STRING
	 */

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", correo="
				+ correo + "]";
	}
	
	
	
	

}
