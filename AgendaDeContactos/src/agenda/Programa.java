package agenda;

import java.util.Scanner;

public class Programa {
	private Agenda a;
	
	
	
	public Programa(Agenda a) {
		super();
		this.a = a;
	}
	
	

	public Agenda getA() {
		return a;
	}



	public void setA(Agenda a) {
		this.a = a;
	}



	public static void main(String[] args) {
		
		
		
		Programa p=new Programa(new Agenda());
		int option=0;
		Scanner teclado=new Scanner(System.in);
		
		p.getA().cargarAgenda("contactos.bin");
		
		do {
			p.menu();
			option=teclado.nextInt();
			
			switch(option) {
			case 1:
				p.getA().imprimirAgenda();
				break;
			case 2:
				p.crearContacto();
				break;
			case 3:
				System.out.println("Introduce el nombre del contacto que qiers borrar");
				String name=teclado.next();
				p.getA().eliminarContacto(name);
				break;
			
			}
			
			
		}while(option!=4);
		
		p.getA().guardarAgenda("contactos.bin");
		
		
	}
	
	private void crearContacto() {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Escribe el nombre");
		String name=entrada.next();
		System.out.println("Escribe el numero de telefono");
		String tel=entrada.next();
		System.out.println("Escribe la direccion");
		entrada.nextLine();
		String adress=entrada.nextLine();
		System.out.println("Escribe el correo");
		String email=entrada.next();
		this.a.añadirContacto(new Contacto(name, tel, adress, email));
		
	}



	public void menu() {
		System.out.println("1. Imprimir agenda");
		System.out.println("2. Añadir contacto");
		System.out.println("3. Eliminar contacto");
		System.out.println("4. Salir");
		System.out.println("Introduce una opcion");
	}

}
