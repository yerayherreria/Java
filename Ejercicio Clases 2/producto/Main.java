package com.producto;

import com.producto.model.Producto;

public class Main {

	public static void main(String[] args) {
		Producto p = new Producto("currucu especial para tu hogar",234.00);
		System.out.println(p);
		System.out.println(p.precioVenta());
	}

}
