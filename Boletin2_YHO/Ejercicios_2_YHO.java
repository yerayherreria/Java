package Boletin2_YHO;

import java.util.Scanner;

public class Ejercicios_YHO {
	Scanner sc= new Scanner(System.in);
	//Ejercicio 1
	public static String numeroSolucionesEcuacionSegundoGrado(double a,double b,double c) {
		double x1=0,x2=0;
		if (a!=0) {
			x1=((-b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
			x2=((-b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		}else {
			x1 = -1;
			x2 = -1;
		}
		String resultado = "El primer resultado es "+x1+" y el segundo resultado es " + x2;
		return resultado;
	}
	//Ejercicio 2
	public static String invertirNumero(String num) {
		String resultado = "";
		for (int i = num.length();i>0;) {
			i--;
			resultado += num.charAt(i);
		}
		return resultado;
	}
	//Ejercicio 3
	public static boolean esContrasenyaFuerte(String contrasenya) {
		boolean contMay = false, contMin = false , contSig = false , contDig = false;
		
		if (contrasenya.length()>=8) {
			int cont=0;
			while (cont<contrasenya.length()) {
				if (Character.isUpperCase(contrasenya.charAt(cont))) {
					contMay=true;
				} else if (Character.isLowerCase(contrasenya.charAt(cont))) {
					contMin=true;
				} else if (Character.isDigit(contrasenya.charAt(cont))) {
					contDig=true;
				} else if ((contrasenya.charAt(cont)==',') || contrasenya.charAt(cont)==';' || contrasenya.charAt(cont)==':' || contrasenya.charAt(cont)=='?' || contrasenya.charAt(cont)=='¿' || contrasenya.charAt(cont)=='!' || contrasenya.charAt(cont)=='¡') {
					contSig=true;
				}
				cont++;
			}
		}
		return contMay==true && contMin==true && contDig==true && contSig==true;
	}
	//Ejercicio 4
	public static String intercambioCaracteres(String frase) {
		String resultado="";
		int cont=0;
		while (cont<frase.length()) {
			if (cont%2!=0) {
				resultado+=String.valueOf(frase.charAt(cont)) + String.valueOf(frase.charAt(cont-1));
			}
			cont++;
		}
		
		
		return resultado;
	}
	//Ejercicio 5
	public static Boolean esMultiplo(int num1,int num2) {
		boolean resultado=false;
		if (num2%num1==0) {
			resultado=true;
		}
		return resultado;
	}
	//Ejercicio 6
	public static int horaMayor(int hora,int min,int seg,int hora2,int min2,int seg2) {
		int resultado=-1000;
		if (((hora>=0 && hora<=23)&&(seg>=0 && seg<=59)&&(min>=0 && min<=59) && (hora2>=0 && hora2<=23)&&(seg2>=0 && seg2<=59)&&(min2>=0 && min2<=59)) || ((hora==24 && min==0 && seg==0) || (hora2==24 && min2==0 && seg2==0))){
			if (hora==hora2) {
				if (min>min2) {
					resultado=1;
				} else if (min2>min) {
					resultado=2;
				} else {
					if (seg>seg2) {
						resultado=1;
					} else if (seg2>seg) {
						resultado=2;
					} else {
						resultado=0;
					}
				}
			} else if (hora>hora2) {
				resultado=1;
			} else {
				resultado=2;
			}
		}
		return resultado;
	}
	//Ejercicio 7
	public static int segundosEntre (int hora,int min,int seg,int hora2,int min2,int seg2) {
		int segHora1=0,segHora2=0,segDiferencia=0;
		if (((hora>=0 && hora<=23)&&(seg>=0 && seg<=59)&&(min>=0 && min<=59) && (hora2>=0 && hora2<=23)&&(seg2>=0 && seg2<=59)&&(min2>=0 && min2<=59)) || ((hora==24 && min==0 && seg==0) || (hora2==24 && min2==0 && seg2==0))) {
			segHora1= hora*3600 + min*60 + seg;
			segHora2= hora2*3600 + min2*60 + seg2;
			if (segHora1>segHora2) {
				segDiferencia=segHora1-segHora2;
			} else {
				segDiferencia=segHora2-segHora1;
			}
		} else {
			segDiferencia=-1000;
		}
		return segDiferencia;
	}
	//Ejercicio 8
	public static String toBinary(int decimal) {
		String binario="";
		while(decimal>0) {
			if (decimal%2==0) {
				binario="0"+ binario;
			} else {
				binario="1"+ binario;
			}
			decimal/=2;
		}
		return binario;
	}
	//Ejercicio 9
	public static int toDecimal(String binario) {
		int decimal = 0,cont = 0;
		for(int i=binario.length()-1; i>=0; i--) {
			int digito = 1;
			if(binario.charAt(i) == '0') {
				digito = 0;
			}
			double multiplicador = Math.pow(2, cont);
			decimal += digito * multiplicador;
			cont ++;
		}
		return decimal;
	}
	//Ejercicio 10
	public static int greaterCommonDivisor(int num1,int num2) {
		while (num2>0) {
			if (num2<num1) {
				num1=num1-num2;
			} else {
				num2=num2-num1;
			}
		}
		return num1;
	}
	//Ejercicio 11
	public static int minimoComunMultiplo(int num1,int num2) {
		int mcm=(num1*num2)/(greaterCommonDivisor(num1,num2));
		return mcm;
	}
	
	public static void main(String[] args) {
			System.out.println(minimoComunMultiplo(4,6));
	}

}
