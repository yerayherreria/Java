package empresaIT.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Candidate implements Comparable<Candidate> {
	protected static final Double REDUCCION_PARCIAL=0.33;

	private LocalDate dateOfBirth;
	private LocalDateTime startDate;
	private String dni;
	private String name;
	private String surname;
	private ContractType ct;
	private boolean inProject;
	
	public Candidate() {
		super();
		this.startDate=LocalDateTime.now();
	}
	
	public Candidate(String dni, String name, String surname, LocalDate dateOfBirth, ContractType ct) {
		super();
		setDni(dni);
		setName(name);
		setSurname(surname);
		setDateOfBirth(dateOfBirth);
		this.ct = ct;
		this.startDate=LocalDateTime.now();
		
	}

	public abstract Double computeGrossSalary();

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ContractType getCt() {
		return ct;
	}

	public void setCt(ContractType ct) {
		this.ct = ct;
	}

	public boolean isInProject() {
		return inProject;
	}

	public void setInProject(boolean inProject) {
		this.inProject = inProject;
	}
	
	@Override
	public int compareTo(Candidate o) {
		return this.dni.compareTo(o.dni);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this==obj && obj==null;
		
		if (!sonIguales && obj instanceof Candidate) {
			Candidate other = (Candidate) obj;
			sonIguales= ct == other.ct && Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(dni, other.dni)
					&& inProject == other.inProject && Objects.equals(name, other.name)
					&& Objects.equals(startDate, other.startDate) && Objects.equals(surname, other.surname);			
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return "El empleado "+getClass().getSimpleName()+" con nombre y apellido "+name+" "+surname+" nacido el "
		+dateOfBirth+" trabajando con nosotros desde el "+startDate+" con DNI "+dni+" con contrato "+ct.name()+
		" y su estado de proyecto es " +inProject;
	}
	
}
