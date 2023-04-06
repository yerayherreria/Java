package empresaIT.model;

import java.time.LocalDate;

public class FullStackDeveloper extends Candidate implements Backend, Frontend {

	public FullStackDeveloper() {
		super();
	}

	public FullStackDeveloper(String dni, String name, String surname, LocalDate dateOfBirth, ContractType ct) {
		super(dni, name, surname, dateOfBirth, ct);
	}

	@Override
	public double createWebAPIDesingCost() {
		return WEB_INTERFACE_DESGN_COST;
	}

	@Override
	public double computeFeMaintenanceCost() {
		return FE_MAINTENANCE_COST;
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
	public Double computeGrossSalary() {
		Double totalSalario=0.0;
		if(isInProject()) {
			if(this.getCt().equals(ContractType.FULLTIME)) {
				totalSalario=this.createWebAPIAndDBConnectionCost();	
				totalSalario+=this.createWebAPIDesingCost();
			} else {
				totalSalario=this.createWebAPIAndDBConnectionCost()-(this.createWebAPIAndDBConnectionCost()*REDUCCION_PARCIAL);		
				totalSalario+=this.createWebAPIDesingCost()-(this.createWebAPIDesingCost()*REDUCCION_PARCIAL);
			}
		}else {
			if(this.getCt().equals(ContractType.FULLTIME)) {
				totalSalario=this.maintenanceCost();
				totalSalario+=this.computeFeMaintenanceCost();
			} else {
				totalSalario=this.maintenanceCost()-(this.maintenanceCost()*REDUCCION_PARCIAL);			
				totalSalario+=this.computeFeMaintenanceCost()-(this.computeFeMaintenanceCost()*REDUCCION_PARCIAL);
			}
		}
		return totalSalario;
	}

	@Override
	public String toString() {
		return super.toString();
	}


}
