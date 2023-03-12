package arrays.calculos;

import arrays.calculos.model.Calculo;

public class Main {

	public static void main(String[] args) {
		int [] numero = {1,8,9,19,18,23,29};
		Calculo c = new Calculo(numero);
		System.out.println(c.computeAverage());
		System.out.println(c.obtenerMasRepetido());	
	}
	
}
