package collections.boletin1.ejercicio7.model;

import java.util.ArrayList;
import java.util.List;

import collections.boletin1.ejercicio7.exception.CajaException;

public class Caja {
		private int numeroCaja;
		private boolean estado;
		private List<Cliente> clientes;
		
		public Caja(int numCaja, boolean estado) {
			super();
			this.numeroCaja=numCaja;
			this.estado=estado;
			this.clientes= new ArrayList<>();
		}
		
		public int getNumeroCaja() {
			return numeroCaja;
		}

		public boolean isEstado() {
			return estado;
		}

		public int getClientes() {
			return this.clientes.size();
		}

		public void setClientes(Cliente clientes) {
			this.clientes.add(clientes);
		}

		public void abrirCaja() throws CajaException {
			if(!this.estado) {
				this.estado=true;
			} else {
				throw new CajaException("Error. Caja abierta anteriormente.");
			}
		}
		
		public void cerrarCaja() throws CajaException {
			if(this.estado && this.clientes.isEmpty()) {
				this.estado=false;
			} else {
				throw new CajaException("Error. Caja cerrada anteriormente o hay algun cliente.");
			}
		}
		public String atenderCaja() throws CajaException {
			String resultado="";
			if(this.estado) {
				resultado = "Se ha atendido al cliente con número "+ this.clientes.get(0).getNumeroCliente();
			} else {
				throw new CajaException("Error. La caja se encuentra cerrada.");
			}
			return resultado;
		}

		@Override
		public String toString() {
			return ""+numeroCaja;
		}
}
