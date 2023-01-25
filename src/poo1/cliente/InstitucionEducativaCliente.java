package poo1.cliente;

import poo1.negocio.InstitucionEducativa;

public class InstitucionEducativaCliente {

	public static void main(String[] args) {
		InstitucionEducativa ie = 
				new InstitucionEducativa(5);
		
		ie.agregarDocente(88, "Carlos", "Perez", 45, 
				null, "Planta", 40);
		ie.agregarDocente(99, "Maribel", "Romero", 
				40, null, "Auxiliar", 20);
		
		ie.agregarAdministrativo(77, "Mia", "K.", 
				37, null, "Rectoria");
		
		System.out.println(ie.imprimirInformacionEmpleados());
	}
	
}
