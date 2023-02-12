package Mock_Exam;

public class Ejer3_YHO {
	public static double calcularFrecuencia(String nota) {
		double frecuencia=0;
		if (nota.equalsIgnoreCase("DO")) {
			frecuencia=523.25;
		} else if(nota.equalsIgnoreCase("RE")) {
			frecuencia=587.33;
		} else if(nota.equalsIgnoreCase("MI")) {
			frecuencia=659.26;
		} else if(nota.equalsIgnoreCase("FA")) {
			frecuencia=698.46;
		} else if(nota.equalsIgnoreCase("SOL")) {
			frecuencia=783.99;
		} else if(nota.equalsIgnoreCase("LA")) {
			frecuencia=880;
		} else if(nota.equalsIgnoreCase("SI")) {
			frecuencia=987.77;
		}
	
		/*switch (nota.toUpperCase()) {
			case "DO":
				frecuencia=523.25;
				break;
			case "RE":
				frecuencia=587.33;
				break;
			case "MI":
				frecuencia=659.26;
				break;
			case "FA":
				frecuencia=698.46;
				break;
			case "SOL":
				frecuencia=783.99;
				break;
			case "LA":
				frecuencia=880;
				break;
			case "SI":
				frecuencia=987.77;
				break;		
		}*/
		return frecuencia;
	}
	public static double calcularFrecuenciaSostenida(String nota,Boolean sostenido) {
		double frecuencia=0;
		if (nota.equalsIgnoreCase("DO")) {
			frecuencia=523.25;
		} else if(nota.equalsIgnoreCase("RE")) {
			frecuencia=587.33;
		} else if(nota.equalsIgnoreCase("MI")) {
			frecuencia=659.26;
		} else if(nota.equalsIgnoreCase("FA")) {
			frecuencia=698.46;
		} else if(nota.equalsIgnoreCase("SOL")) {
			frecuencia=783.99;
		} else if(nota.equalsIgnoreCase("LA")) {
			frecuencia=880;
		} else if(nota.equalsIgnoreCase("SI")) {
			frecuencia=987.77;
		}
		
		if (sostenido) {
			frecuencia*=1.03;
		}
		return frecuencia;
	}
	public static void main(String[] args) {
		System.out.println(calcularFrecuenciaSostenida("Do",true));
	}

}
