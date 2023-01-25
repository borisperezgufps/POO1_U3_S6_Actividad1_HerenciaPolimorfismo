package poo1.subclasses;

import poo1.base.Empleado;

public class Docente extends Empleado {

	private CategoriaDocenteEnum categoria;
	private int numeroHoras;
	
	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public CategoriaDocenteEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDocenteEnum categoria) {
		this.categoria = categoria;
	}

	
	public double calcularSalarioDocente() {
		double salario = -1;
		double valorHora = obtenerValorHora(getCategoria());
		
		if(valorHora>0) {		
			salario = valorHora * getNumeroHoras();
		}else {
			System.err.println("El docente "+getNombres()+" no tiene categor�a asociada.");
		}
		
		return salario;
		
	}
	
	private double obtenerValorHora(CategoriaDocenteEnum categoria) {
		String categoriaString = categoria.name();
		
		double valorHora = 0;
		
		switch(categoriaString) {
		case "PLANTA":
			valorHora = 50000;
			break;
		case "CATEDRATICO":
			valorHora = 35000;
			break;
		case "AUXILIAR":
			valorHora = 25000;
			break;
		default:
			valorHora = -1;
		}
		
		return valorHora;
	}
	
}
