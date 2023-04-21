package collections.boletin1.ejercicio7.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import collections.boletin1.ejercicio7.comparator.CompartorCajas;
import collections.boletin1.ejercicio7.exception.CajaException;

public class Almacen {
	private static final int NUM_MAX_CAJAS = 20;
	private List<Caja> cajas;
	
	public Almacen() {
		super();
		this.cajas=new ArrayList<>();
		
		 for(int i=0; i<NUM_MAX_CAJAS; i++) {
	            this.cajas.add(new Caja(i, false));
	        }
	}
	
	public void abrirCaja(int numero) throws CajaException {
		for(Caja c: this.cajas) {
			if (c.getNumeroCaja()==numero) {
				c.abrirCaja();
			}
		}
	}
	
	public void cerrarCaja(int numero) throws CajaException {
		for(Caja c: this.cajas) {
			if (c.getNumeroCaja()==numero) {
				c.cerrarCaja();
			}
		}
	}
	
	public String nuevoCliente() {
		Cliente c = new Cliente();
		Collections.sort(this.cajas, new CompartorCajas());
		this.cajas.get(0).setClientes(c);
		return this.cajas.get(0).toString();
	}
	
	public String atenderCliente(int num) throws CajaException {
		String resultado="";
		for(Caja c: this.cajas) {
			if (c.getNumeroCaja()==num) {
				resultado = c.atenderCaja();
			}
		}
		return resultado;
	}
	
}
