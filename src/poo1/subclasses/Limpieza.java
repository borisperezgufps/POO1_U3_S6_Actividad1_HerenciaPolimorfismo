package poo1.subclasses;

import poo1.base.Empleado;

public class Limpieza extends Empleado {

	private int cantidadTurnos;
	private double valorTurno;
	
	public Limpieza(double valorTurno) {
		this.valorTurno = valorTurno;
	}

	public int getCantidadTurnos() {
		return cantidadTurnos;
	}

	public void setCantidadTurnos(int cantidadTurnos) {
		this.cantidadTurnos = cantidadTurnos;
	}
	
	@Override
	public double calcularSalario() {
		double salario = -1;
		
		if(cantidadTurnos>0 && valorTurno>0)		
			salario = cantidadTurnos * valorTurno;
		else
			System.err.println("No se puede calcular el salario al persona "
					+ "de limpieza "+getNombres()+", porque no tiene turnos "
							+ "asignados o el valor del turno no está definido");
		
		return salario;
	}
	
}
