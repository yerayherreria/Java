package empresaIT.model;

import java.time.LocalDate;

public class WebDesigner extends Candidate implements Frontend {

	public WebDesigner() {
		super();
	}

	public WebDesigner(String dni, String name, String surname, LocalDate dateOfBirth, ContractType ct) {
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
	public Double computeGrossSalary() {
		Double totalSalario=0.0;
		if (isInProject()) {
			if (this.getCt().equals(ContractType.FULLTIME)) {
				totalSalario=this.createWebAPIDesingCost();
			} else {
				totalSalario=this.createWebAPIDesingCost()-(this.createWebAPIDesingCost()*REDUCCION_PARCIAL);
			}
		} else {
			if (this.getCt().equals(ContractType.FULLTIME)) {
				totalSalario=this.computeFeMaintenanceCost();
			} else {
				totalSalario=this.computeFeMaintenanceCost()-(this.computeFeMaintenanceCost()*REDUCCION_PARCIAL);
			}
		}
		return totalSalario;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
