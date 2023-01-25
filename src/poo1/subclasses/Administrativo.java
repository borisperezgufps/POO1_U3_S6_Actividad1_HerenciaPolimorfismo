package poo1.subclasses;

import poo1.base.Empleado;

public class Administrativo extends Empleado {

	private double salarioMinimo;
	private OficinaAdministrativoEnum oficina;

	public Administrativo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}
	
	public OficinaAdministrativoEnum getOficina() {
		return oficina;
	}

	public void setOficina(OficinaAdministrativoEnum oficina) {
		this.oficina = oficina;
	}
	
	
	public double calcularSalarioAdministrativo() {
	
		if(oficina==null) {
			System.err.println("El administrativo "+getNombres()+" no tiene oficina asociada.");
			return -1;
		}
		
		if(salarioMinimo<500000) {
			System.err.println("No se puede calcular el salario al administrativo "+getNombres()+" porque no est� asignado el valor del SMMLV.");
			return -1;
		}
			
		
		double salario = -1;
		
		switch(oficina.name()) {
		case "PLANEACION":
			salario = salarioMinimo * 1.5;
			break;
		case "COORDINACION":
			salario = salarioMinimo;
			break;
		case "RECTORIA":
			salario = salarioMinimo * 2;
			break;
		}
		
		return salario;
	}
	
}
