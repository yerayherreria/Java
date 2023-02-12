package Mock_Exam;

public class Ejer2_YHO {
	public static double calcularFrecuenciaCardiaca(int anyoActual,String fechaNacimiento) {
		fechaNacimiento=fechaNacimiento.substring(6);
		int anyoNacimiento=Integer.valueOf(fechaNacimiento);
		int frecuencia=(85*(220-(anyoActual-anyoNacimiento)))/100;
		return frecuencia;
	}
	public static void main(String[] args) {
		System.out.println(calcularFrecuenciaCardiaca(2022,"02/02/2004"));
	}

}
