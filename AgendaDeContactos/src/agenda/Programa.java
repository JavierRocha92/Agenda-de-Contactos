package agenda;

import java.util.Scanner;

public class Programa {
	/**
	 * ATRIBUTO UN OBJETO Agenda
	 */
	private Agenda a;
	
	/**
	 * CONSTRUCTOR DE 1 PARAMETRO
	 * @param a
	 */
	public Programa(Agenda a) {
		super();
		this.a = a;
	}
	/**
	 * GETTERS DE Agenda DE PROGRAMA
	 * @return a, VALOR DE LA Agenda
	 */
	

	public Agenda getA() {
		return a;
	}
	/**
	 * SETTER DE Agenda DE PROGRAMA
	 * @param a
	 */


	public void setA(Agenda a) {
		this.a = a;
	}

	/**
	 * METODO MAIN
	 * @param args
	 */
	

	public static void main(String[] args) {
		
		
		/**
		 * DECLARACION DE ONJETO DE Programa DE Scanner PARA IMPRIMIR POR PANTALLA Y UN Int PARA LA OPCION DEL MENU
		 */
		Programa p=new Programa(new Agenda());
		int option=0;
		Scanner teclado=new Scanner(System.in);
		/**
		 * CARGA INICIAL DEL ARRAYLIST DE Contacto PARA EMPEZAR CON INFORMACON DENTRO DE ARRAYLIST
		 */
		p.getA().cargarAgenda("contactos.bin");
		/**
		 * BUCLE DOWHILE PARA GENERAR UN MENU POR PANTALLA
		 */
		do {
			/**
			 * LLAMADA A METODO MENU PARA GENERAR UN MENU POR PANTALLA
			 */
			p.menu();
			/**
			 * EL USUARIO TECLEA LA OPCION DESEAA Y CON ELLA ACTUAREMOS SOBRE LA ESTRUCTURA DE CONTROL (SWITCH)
			 */
			option=teclado.nextInt();
			
			switch(option) {
			/**
			 * OPCION 1: SE LLAMA A METODO imprimirAgenda() DE LA CLASE Agenda
			 */
			case 1:
				p.getA().imprimirAgenda();
				break;
				/**
				 * OPCION 2: SE LLAMA A METODO craerContacto() DE LA CLASE Programa
				 */
			case 2:
				p.crearContacto();
				break;
				/**
				 * OPCION 3: SE LLAMA A METODO eliminarContacto() DE LA CLASE Programa, `REVIAMENTE SE LE PIDE AL USUARIO QUE ESCRIBA UN NOMBRE
				 * , QUE PASAREMOS COMO PARAMETRO PARA PODER REALIZAR EL METODO
				 */
			case 3:
				System.out.println("Introduce el nombre del contacto que qiers borrar");
				String name=teclado.next();
				p.getA().eliminarContacto(name);
				break;
			
			}
			
			/**
			 * OPCION PARA SALIR DEL BUCLE DOWHILE
			 */
		}while(option!=4);
		/**
		 * SE LLAMA AL METODO guardarAgenda() DE LA CLASE Programa PARA GUARADR TODS LAINFORMACION EN E FICHERO DE CONTACTOS AL TERMINAR EL PROGRAMA
		 */
		p.getA().guardarAgenda("contactos.bin");
		
		
	}
	/**
	 * METODO PARA CREAR UN CONTACTO
	 */
	
	private void crearContacto() {
		/**
		 * DECLARAMOS UN OBJETO SE LA CLASE Scanner PARA IMPRIMIR POR PANTALLA LOS MENSAJES HACIA EL USYARIO
		 */
		Scanner entrada=new Scanner(System.in);
		/**
		 * LE PEDIMOS TODOS LOS DATOS DE Contacto  A EL USUARIO POR PANTALLA
		 */
		System.out.println("Escribe el nombre");
		String name=entrada.next();
		System.out.println("Escribe el numero de telefono");
		String tel=entrada.next();
		System.out.println("Escribe la direccion");
		entrada.nextLine();
		String adress=entrada.nextLine();
		System.out.println("Escribe el correo");
		String email=entrada.next();
		/**
		 * CREAMOS UN NUEVO Contacto CON LOS DATOS DEL USARIOS Y LO AÑADIMOS AL ARRAYLIST DE Contacto
		 */
		this.a.añadirContacto(new Contacto(name, tel, adress, email));
		
	}

    /**
     * METODO MENUS PARA IMPRIMIR EL MENU DE INTERFAZ CON EL USUARIO
     */
	public void menu() {
		System.out.println("1. Imprimir agenda");
		System.out.println("2. Añadir contacto");
		System.out.println("3. Eliminar contacto");
		System.out.println("4. Salir");
		System.out.println("Introduce una opcion");
	}

}
