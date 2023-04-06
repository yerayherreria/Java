package empresaIT.model;

import java.time.LocalDate;

public class BackendProgrammer extends Candidate implements Backend{

	public BackendProgrammer() {
		super();
	}

	public BackendProgrammer(String dni, String name, String surname, LocalDate dateOfBirth, ContractType ct) {
		super(dni, name, surname, dateOfBirth, ct);
	}

	@Override
	public Double computeGrossSalary() {
		Double totalSalario=0.0;
		if(isInProject()) {
			if(this.getCt().equals(ContractType.FULLTIME)) {
				totalSalario=this.createWebAPIAndDBConnectionCost();				
			} else {
				totalSalario=this.createWebAPIAndDBConnectionCost()-(this.createWebAPIAndDBConnectionCost()*REDUCCION_PARCIAL);				
			}
		}else {
			if(this.getCt().equals(ContractType.FULLTIME)) {
				totalSalario=this.maintenanceCost();				
			} else {
				totalSalario=this.maintenanceCost()-(this.maintenanceCost()*REDUCCION_PARCIAL);				
			}
		}
		return totalSalario;
	}

	@Override
	public double createWebAPIAndDBConnectionCost() {
		return WEB_API_DB_COST;
	}

	@Override
	public double maintenanceCost() {
		return BE_MAINTENANCE_COST;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
