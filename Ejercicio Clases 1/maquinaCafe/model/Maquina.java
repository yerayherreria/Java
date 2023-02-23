package com.maquinaCafe.model;

public class Maquina {
	private final double PRECIOLECHE=0.8;
	private final double PRECIOCAFE=1;
	private final double PRECIOCAFELECHE=1.8;
	
	public Maquina(){}
	public Maquina(int depositoCafe, int depositoLeche, int depositoVaso, double monederoMaquina) {
		super();
		this.depositoCafe = depositoCafe;
		this.depositoLeche = depositoLeche;
		this.depositoVaso = depositoVaso;
		this.monederoMaquina = monederoMaquina;
	}
	public int getDepositoCafe() {
		return depositoCafe;
	}
	public void setDepositoCafe(int depositoCafe) {
		this.depositoCafe = depositoCafe;
	}
	public int getDepositoLeche() {
		return depositoLeche;
	}
	public void setDepositoLeche(int depositoLeche) {
		this.depositoLeche = depositoLeche;
	}
	public int getDepositoVaso() {
		return depositoVaso;
	}
	public void setDepositoVaso(int depositoVaso) {
		this.depositoVaso = depositoVaso;
	}
	public double getMonederoMaquina() {
		return monederoMaquina;
	}
	public void setMonederoMaquina(double monederoMaquina) {
		this.monederoMaquina = monederoMaquina;
	}
	public void llenarDepositos() {
		this.depositoCafe=50;
		this.depositoLeche=50;
		this.depositoVaso=80;
	}
	public void vaciarMonedero() {
		this.monederoMaquina=0;
	}
	public String consultarEstado() {
		return ("La máquina tiene "+ this.depositoCafe+" despositos de cafe "+this.depositoLeche+" depositos de leche "+this.depositoVaso+" depositos de vaso y "+this.monederoMaquina+" €.");
	}
	public String servirCafe(double dinero) {
		String resultado="";
		if (dinero<PRECIOCAFE) {
			resultado="No hay suficiente dinero.";
		} else if (this.depositoCafe<1) {
			resultado="No hay café.Lo sentimos.";
		} else if (this.depositoVaso<1) {
			resultado="No hay vasos.";
		} else if (this.monederoMaquina<dinero) {
			resultado="No tenemos cambio.";
		} else {
			this.depositoCafe--;
			this.depositoVaso--;
			this.monederoMaquina+=PRECIOCAFE;
			resultado="Producto servido, el cambios es de "+(dinero-PRECIOCAFE);
		}
		return resultado;
	}
	public String servirLeche(double dinero) {
		String resultado="";
		if (dinero<PRECIOLECHE) {
			resultado="No hay suficiente dinero.";
		} else if (this.depositoLeche<1) {
			resultado="No hay leche.Lo sentimos.";
		} else if (this.depositoVaso<1) {
			resultado="No hay vasos.";
		} else if (this.monederoMaquina<dinero) {
			resultado="No tenemos cambio.";
		} else {
			this.depositoVaso--;
			this.depositoLeche--;
			this.monederoMaquina+=PRECIOLECHE;
			resultado="Producto servido, el cambios es de "+(dinero-PRECIOLECHE);
		}
		return resultado;
	}
	public String servirCafeLeche(double dinero) {
		String resultado="";
		if (dinero<PRECIOCAFELECHE) {
			resultado="No hay suficiente dinero.";
		} else if (this.depositoCafe<1) {
			resultado="No hay café.Lo sentimos.";
		} else if (this.depositoLeche<1) {
			resultado="No hay leche";
		} else if (this.depositoVaso<1) {
			resultado="No hay vasos.";
		} else if (this.monederoMaquina<dinero) {
			resultado="No tenemos cambio.";
		} else {
			this.depositoCafe--;
			this.depositoLeche--;
			this.depositoVaso--;
			this.monederoMaquina+=PRECIOCAFELECHE;
			resultado="Producto servido, el cambios es de "+(dinero-PRECIOCAFELECHE);
		}
		return resultado;
	}
	private int depositoCafe;
	private int depositoLeche;
	private int depositoVaso;
	private double monederoMaquina;
}
