package com.geometria;

import com.geometria.model.Rectangulo;

public class Main {
	public static void main(String[] args) {
		Rectangulo r = new Rectangulo();
		System.out.println(r.calcularArea(15, 14));
		System.out.println(r.calcularPerimetro(15, 14));
	}
}
