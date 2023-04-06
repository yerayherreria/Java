package empresaIT.model;

import java.util.Arrays;

import blocNota.model.Nota;
import empresaIT.comparables.ComparatorExperiencia;
import empresaIT.exception.EmpresaException;

public class Empresa {
	
	private static final int NUM_MAXIMO_EMPLEADOS= 11;
	private static final int NUM_MAXIMO_BACKEND  = 6;
	private static final int NUM_MAXIMO_FRONTEND = 3;
	private static final int NUM_MAXIMO_FULL     = 2;
	private int numEmpleado;
	private int contBack;
	private int contFront;
	private int contFull;
	private Candidate[] empresaCurro;
	
	public Empresa() {
		empresaCurro=new Candidate[NUM_MAXIMO_EMPLEADOS];
	}
	private int buscarEmpleado(String dni) {
		int posicion = -1;
		for(int i=0; i<empresaCurro.length && posicion==-1; i++) {
			if(this.empresaCurro[i]!=null && this.empresaCurro[i].getDni().equals(dni)) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	private Candidate[] quitarNulos() {
		int cont=0;
		for(int i=0; i<empresaCurro.length; i++) {
			if(this.empresaCurro!=null) {
				cont++;
			}
		}

		Candidate[] empresaSinNulo= new Candidate[cont];
		int acum=0;
		for(int i=0; i<empresaCurro.length; i++) {
			if(this.empresaCurro!=null) {
				empresaSinNulo[acum++]=this.empresaCurro[i];
			}
		}
		return empresaSinNulo;
	}
	
	public void darAlta(Candidate candidate) throws EmpresaException {
		
		if (numEmpleado<NUM_MAXIMO_EMPLEADOS){
			if (candidate instanceof BackendProgrammer && contBack<NUM_MAXIMO_BACKEND) {
				empresaCurro[numEmpleado++]=candidate;
				contBack++;
			} else if(candidate instanceof WebDesigner && contFront<NUM_MAXIMO_FRONTEND) {
				empresaCurro[numEmpleado++]=candidate;
				contFront++;
			} else if(candidate instanceof FullStackDeveloper && contFull<NUM_MAXIMO_FULL) {
				empresaCurro[numEmpleado++]=candidate;
				contFull++;
			} else {
				throw new EmpresaException("Error. No hay disponible más plazas del tipo de empleado que deseas.");
			}
		} else {
			throw new EmpresaException("Error. No hay más espacio.");
		} 
	}
	
	public String consultarInformacion(String dni) {
		String resultado="No encontrado";
		if (dni!=null && buscarEmpleado(dni)!=-1) {
			resultado=this.empresaCurro[buscarEmpleado(dni)].toString();
		}
		
		return resultado;
	}

	public String ordenarExperiencia() {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(empresaCurro, new ComparatorExperiencia());
		
		for(Candidate candidate: empresaCurro) {
			if(candidate!=null) {
				sb.append(candidate.toString()).append("\n");
			}
		}
		return sb.toString();
	}


	@Override
	public String toString() {
		return ordenarExperiencia();
	}
	
}
