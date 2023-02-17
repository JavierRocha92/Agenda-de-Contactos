package agenda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Agenda {
	/**
	 * PARAMETRO UN ARRAYLIST DE CONTACTOS
	 */
	private ArrayList<Contacto>contactos;
	/**
	 * CONSTRUCTOR CON EL PARAMETRO DEL ARRAYLIST
	 * @param contactos
	 */

	public Agenda(ArrayList<Contacto> contactos) {
		super();
		this.contactos = contactos;
	}
	/**
	 * CONSTRUCTOR VACIO POR DEFECTO
	 */

	public Agenda() {
		super();
		this.contactos = new ArrayList<Contacto>();
	}
	/**
	 * GETTER PARA EL ARRAYLIST DE CONATCTOS
	 * @return contactos, ES EL ARRAYLIST DE Contacto
	 */

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}
	/**
	 * SETTER PARA EL ARRAYLIST DE Contacto
	 * @param contactos
	 */

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	/**
	 * METODO TO STRING
	 */

	@Override
	public String toString() {
		return "Agenda [contactos=" + contactos + "]";
	}
	/**
	 * RECORRE EL ARRAYLIST CON UN BUCLE FOREACH E IMPRIME POR PANTALLA EL NOMBRE Y EL NUMERO DE TEELFONO DE CADA CONTACTO
	 * (NOS PERMITE VISUALIZAR LOS CONATCATOS QUE ESTEN CARGADOS EN EL ARRAYLIST)
	 */
	
	public void imprimirAgenda() {
		for (Contacto c : this.contactos) {
			System.out.println(c.getNombre()+"  "+c.getTelefono());
			
		}
		
	}
	/**
	 * METODO PARA CARGAR EN EL ATTAYLIST EL Contacto  QUE LE PASAMOS COMO PARAMETRO
	 * @param c = CONTACTO QUE PASAMOS COMO PARAMETRO
	 */
	
	public void añadirContacto(Contacto c) {
		this.contactos.add(c);
		
	}
	/**
	 * METODO PARA ELIMINAR UN CONTACTO USANDO COMO PARAMETRO EL NOMBRE DE DICHO Contacto,EL CUAL RECORRERA EL ARRAYLIST
	 * CON UN BUCLE FOREACH Y ELIMINARA EL CONTACTO QUE CORRESPONDA CON ESE NOMBRE
	 * @param nombre
	 */
	
	public void eliminarContacto(String nombre) {
		for (int i = 0; i < this.contactos.size(); i++) {
			if(this.contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				this.contactos.remove(i);
			}
		}
			
		
	}
	
	/*
	 * METODO PARA GENERA UN FICHERO DE OBEJTOS Y GUARADR LOS CONTACTOS QUE CARGA EN ESE MOMENTO EL ARRAYLIST, SE LE PASA COMO PARAMETRO EL
	 * NOMBRE DEL FICHERO A CREAR
	 */
	
	public void guardarAgenda(String filename) {
		try {
			FileOutputStream fo=new FileOutputStream(new File(filename));
			
			ObjectOutputStream salida=new ObjectOutputStream(fo);
			for (Contacto c : this.contactos) {
				salida.writeObject(c);
				
			}
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * METODO PARA LEER LOS Contacto  DE UN FICHERO DE OBJETOS Y CARGARLOS EN EL ARRAYLIST, PARA PODER TRABAJAR CON ELLOS, SE LE 
	 * PASA COMO PARAMETRO EL NOMBRE DEL FICHERO
	 * @param filename
	 */
	
	public void cargarAgenda(String filename) {
		try {
			FileInputStream fi=new FileInputStream(filename);
			ObjectInputStream entrada=new ObjectInputStream(fi);
			Contacto c=null;
			
			while(entrada!=null) {
				try {
					c=(Contacto)entrada.readObject();
					this.añadirContacto(c);
				} catch (Exception e) {
					entrada=null;//CAMBIO LA CONDICION DEL BUCLE CUANDO SALTA LA EXCEPCION PARA SALIR DEL BUCLE
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * MAIN DE LA CLASE AGENDA PARA PRUEBA UNITARIA(REMOVER COMENTADO PARA HACERLO FUNCIONAR)
	 */
//	public static void main(String[] args) {
//		
//		Agenda a=new Agenda();
////		a.añadirContacto(new Contacto("javier", "0987899", "calle falsa", "javier@gmail.com"));
////		a.añadirContacto(new Contacto("tania", "552154", "calle fuencarral", "tania@gmail.com"));
////		a.añadirContacto(new Contacto("ester", "220120", "calle bonita", "ester@gmail.com"));
////		
////		a.guardarAgenda("contactos.bin");
////		
////		a.añadirContacto(new Contacto("julio", "012254", "calle real", "julio@gmail.com"));
////		a.contactos.clear();
//		a.cargarAgenda("contactos.bin");
//		a.imprimirAgenda();
//	}
	
	

}
