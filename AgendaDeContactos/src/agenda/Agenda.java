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
	private ArrayList<Contacto>contactos;

	public Agenda(ArrayList<Contacto> contactos) {
		super();
		this.contactos = contactos;
	}

	public Agenda() {
		super();
		this.contactos = new ArrayList<Contacto>();
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	@Override
	public String toString() {
		return "Agenda [contactos=" + contactos + "]";
	}
	
	public void imprimirAgenda() {
		for (Contacto c : this.contactos) {
			System.out.println(c.getNombre()+"  "+c.getTelefono());
			
		}
		
	}
	
	public void añadirContacto(Contacto c) {
		this.contactos.add(c);
		
	}
	
	public void eliminarContacto(String nombre) {
		for (int i = 0; i < this.contactos.size(); i++) {
			if(this.contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				this.contactos.remove(i);
			}
		}
			
		
	}
	
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
