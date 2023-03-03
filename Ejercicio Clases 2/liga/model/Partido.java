package com.liga.model;

public class Partido {	
	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int numGolVisitante;
	private int numGolLocal;
	private int numPartidoGanadoLocal;
	private int numPartidoGanadoVisitante;
	private int jornada;
	private String resultadoQuiniela;
	private String resultado;
	
	public Partido(Equipo equipoLocal, Equipo equipoVisitante, int jornada) {
		super();
		if(jornada>0 && jornada<39) {
			this.equipoLocal = equipoLocal;
			this.equipoVisitante = equipoVisitante;
			this.jornada = jornada;
		}
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public int getNumGolVisitante() {
		return numGolVisitante;
	}
	public int getNumGolLocal() {
		return numGolLocal;
	}
	public int getNumPartidoGanadoLocal() {
		return numPartidoGanadoLocal;
	}
	public int getNumPartidoGanadoVisitante() {
		return numPartidoGanadoVisitante;
	}
	public int getJornada() {
		return jornada;
	}
	public String getResultadoQuiniela() {
		return resultadoQuiniela;
	}
	public String getResultado() {
		return resultado;
	}
	
	public void ponerResultado(String resultado) {
		this.numGolLocal = Integer.valueOf(resultado.substring(0,0+1));
		this.numGolVisitante = Integer.valueOf(resultado.substring(2,2+1));
		this.resultado = resultado;
	}
	public void asignarEquipoGanador() {
		if((Integer.valueOf(resultado.charAt(0)) < Integer.valueOf(resultado.charAt(2))) && resultado!=null) {
			this.numPartidoGanadoVisitante ++;
		}else if ((Integer.valueOf(resultado.charAt(0)) < Integer.valueOf(resultado.charAt(2))) && resultado!=null){
			this.numPartidoGanadoLocal ++;
		}
	}
	public void asignarQuiniela() {
		if((Integer.valueOf(resultado.charAt(0)) < Integer.valueOf(resultado.charAt(2))) && resultado!=null) {
			this.resultadoQuiniela="2";
		}else if ((Integer.valueOf(resultado.charAt(0)) > Integer.valueOf(resultado.charAt(2))) && resultado!=null){
			this.resultadoQuiniela="1";
		}else {
			this.resultadoQuiniela="X";
		}
	}
	@Override
	public String toString() {
		String resultado="";
		if (jornada >= 1 && jornada <= 38) {
			resultado="Partido entre equipo local "+ equipoLocal +" y el equipo visitante "+ equipoVisitante +" ha finalizado con " + numGolLocal+ " goles de equipo local y "+ numGolVisitante +" goles de equipo visitante. Resultado quiniela= " + resultadoQuiniela;
		} else if  (equipoLocal != null && equipoVisitante != null) {
			resultado="Partido entre equipo local "+ equipoLocal +" y equipo visitante "+ equipoVisitante +" todavía no se ha jugado";
		}
		return resultado;
	}
	
}
