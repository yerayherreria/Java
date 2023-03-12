package arrays.fecha.model;

public class Fecha {
	private int dia;
	private int mes;
	private int anyo;
	public Fecha(int dia, int mes, int anyo) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}
	
	public String cambiarFormatoMes(int mes) {
		String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		String resultado="";
		if (mes>0 && mes<13) {
			resultado=meses[mes-1];
		}
		return resultado;
	}
	
	public int diasDeUnMes(int mes,int anyo) {
		int[] diaMes = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] diaMesBisiesto = {31,29,31,30,31,30,31,31,30,31,30,31};
		int resultado=0;
		
		if  ((mes>0 && mes<13) && ((anyo % 4 == 0) && ((anyo % 100 != 0) || (anyo % 400 == 0)))) {
			resultado=diaMesBisiesto[mes-1];
		} else if (mes>0 && mes<13) {
			resultado=diaMes[mes-1];
		}
		return resultado;
	}

	@Override
	public String toString() {
		String resultado="Fecha incorrecta";
		if (!(cambiarFormatoMes(mes).equals("")) && diasDeUnMes(mes,anyo)>=dia && dia>0) {
			resultado="La fecha en formato largo es "+dia+" de "+cambiarFormatoMes(mes)+" de "+anyo;
		}
		return resultado;
	}
	
}
