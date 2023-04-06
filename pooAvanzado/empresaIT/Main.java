package empresaIT;

import java.time.LocalDate;

import empresaIT.exception.EmpresaException;
import empresaIT.model.BackendProgrammer;
import empresaIT.model.ContractType;
import empresaIT.model.Empresa;
import empresaIT.model.FullStackDeveloper;

public class Main {

	public static void main(String[] args) {
		FullStackDeveloper emple1 = new FullStackDeveloper("12345678B", "Paco", "Herr", LocalDate.of(1993, 3, 18), ContractType.FULLTIME);
		BackendProgrammer emple2 = new BackendProgrammer("12345678A", "Curro", "Lopez", LocalDate.of(2004, 9, 2),  ContractType.PARTIAL);
		FullStackDeveloper emple3 = new FullStackDeveloper("12345678C", "Manolo", "De la Puebla", LocalDate.of(1965, 12, 24), ContractType.PARTIAL);
		FullStackDeveloper emple4 = new FullStackDeveloper("12345678D", "Agustin", "Vitienes", LocalDate.of(1964, 9, 18), ContractType.FULLTIME);
		
		System.out.println(emple1);
		System.out.println(emple2);
		
		Empresa empresa = new Empresa();
		
		try {
			empresa.darAlta(emple4);
			empresa.darAlta(emple3);
			empresa.darAlta(emple2);
			//empresa.darAlta(emple1);
		} catch (EmpresaException e) {
			e.printStackTrace();
		}
		
		System.out.println(empresa.consultarInformacion("pepe"));
		System.out.println(empresa.consultarInformacion("12345678A"));
		
		System.out.println(empresa);
		System.out.println(emple2.computeGrossSalary());
		System.out.println(emple3.computeGrossSalary());
		System.out.println(emple4.computeGrossSalary());
	}

}
