package poo1.negocio;

import java.util.Calendar;

import poo1.base.Empleado;
import poo1.subclasses.Administrativo;
import poo1.subclasses.CategoriaDocenteEnum;
import poo1.subclasses.Docente;
import poo1.subclasses.Limpieza;
import poo1.subclasses.OficinaAdministrativoEnum;

public class InstitucionEducativa {

	private double salarioMinimo;
	private double valorTurno;
	
	private Empleado[] empleados;
	private int contador;
	
	public InstitucionEducativa(int cantEmpleados) {
		empleados = new Empleado[cantEmpleados];
		
		salarioMinimo = 900000;
		valorTurno = 35000;
	}
	
	/**
	 * Permite agregar a un docente a la institucion educativa. 
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param fechaIngreso
	 * @param categoria String con las opciones "Planta", "Catedratico" y "Auxiliar"
	 */
	public void agregarDocente(int dni, String nombre, 
			String apellido, int edad, 
			Calendar fechaIngreso, String categoria, 
			int numeroHorasTrabajadas) {
		
		if(categoria.equals("Planta") || 
				categoria.equals("Catedratico") || 
				categoria.equals("Auxiliar")){
			
			Docente d = new Docente();
			d.setDni(dni);
			d.setNombres(nombre);
			d.setApellidos(apellido);
			d.setEdad(edad);
			d.setFechaIngreso(fechaIngreso);
			
			CategoriaDocenteEnum cate = null;
			
			if(categoria.equals("Planta"))
				cate = CategoriaDocenteEnum.PLANTA;
			else if(categoria.equals("Catedratico"))
				cate = CategoriaDocenteEnum.CATEDRATICO;
			else if(categoria.equals("Auxiliar"))
				cate = CategoriaDocenteEnum.AUXILIAR;
			
			d.setCategoria(cate);
			d.setNumeroHoras(numeroHorasTrabajadas);
			
			empleados[contador] = d;
			contador++;
			
		}else {
			System.err.println("La categor�a ingresada no es v�lida. ");
			return;
		}
	}
	
	public void agregarAdministrativo(int dni, String nombre, 
			String apellido, int edad, Calendar fechaIngreso, 
			String oficina) {
		
		if(oficina.equals("Planeacion") || oficina.equals("Coordinacion") || oficina.equals("Rectoria")){
			
			Administrativo d = new Administrativo(salarioMinimo);
			d.setDni(dni);
			d.setNombres(nombre);
			d.setApellidos(apellido);
			d.setEdad(edad);
			d.setFechaIngreso(fechaIngreso);
			
			OficinaAdministrativoEnum ofi = null;
			
			if(oficina.equals("Planeacion"))
				ofi = OficinaAdministrativoEnum.PLANEACION;
			else if(oficina.equals("Coordinacion"))
				ofi = OficinaAdministrativoEnum.COORDINACION;
			else if(oficina.equals("Rectoria"))
				ofi = OficinaAdministrativoEnum.RECTORIA;
			
			d.setOficina(ofi);
			
			empleados[contador] = d;
			contador++;
			
		}else {
			System.err.println("La oficina ingresada no es v�lida. ");
			return;
		}
	}
	
	public void agregarPersonalLimpieza(int dni, String nombre, 
			String apellido, int edad, 
			Calendar fechaIngreso) {
			
		Limpieza d = new Limpieza(valorTurno);
		d.setDni(dni);
		d.setNombres(nombre);
		d.setApellidos(apellido);
		d.setEdad(edad);
		d.setFechaIngreso(fechaIngreso);
		
		empleados[contador] = d;
		contador++;
				
	}
	
	/**
	 * Calcula el salario de todos los empleados de la institucion	
	 * @return
	 */
	public double calcularSalarioEmpleados() {
		double sumaSalarios = 0;
		for(Empleado e : empleados) {
			sumaSalarios += e.calcularSalario();
		}
		return sumaSalarios;
	}
	
	public String imprimirInformacionEmpleados() {
		String sb = "";
		
		for(int t=0;t<empleados.length;t++) {
			Empleado e = empleados[t];
			if(e!=null) {
				
				sb += e.getApellidos() + 
					", " + 
					e.getNombres() + 
					"\n";
			}
			
		}
		
		return sb;
	}
	
	public String calcularAntiguedadEmpleados() {
		String sb = "";
		
		for(Empleado e : empleados) {
			
			int anioActual = Calendar.getInstance().get(Calendar.YEAR);
			
			int antiguedadEmpleado = anioActual - e.getFechaIngreso().get(Calendar.YEAR);
			
			sb += e.getApellidos() + ", " + e.getNombres() + " - A�os antig�edad: "+ antiguedadEmpleado + "\n";
		}
		
		return sb;
	}
	
}
