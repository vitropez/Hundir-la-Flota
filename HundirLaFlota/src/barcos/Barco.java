package barcos;

public class Barco {
	int posicionInicial;
	int posicionFinal;
	char horientacion;
	int tamano;
	char nombre;
	public Barco(int posicionInicial, int posicionFinal, char horientacion) {
		
		this.posicionInicial = posicionInicial;
		this.posicionFinal = posicionFinal;
		this.horientacion = horientacion;
		
	}
	public Barco(int posicionInicial, int posicionFinal) {
		// TODO Auto-generated constructor stub
	}
	public int getPosicionInicial() {
		return posicionInicial;
	}
	public void setPosicionInicial(int posicionInicial) {
		this.posicionInicial = posicionInicial;
	}
	public int getPosicionFinal() {
		return posicionFinal;
	}
	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}
	public char getHorientacion() {
		return horientacion;
	}
	public void setHorientacion(char horientacion) {
		this.horientacion = horientacion;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
	public char getNombre() {
		return nombre;
	}
	public void setNombre(char nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Portaviones [posicionInicial=" + posicionInicial + ", posicionFinal=" + posicionFinal + ", horientacion="
				+ horientacion + ", tamano=" + tamano + "]";
	}

	}	
		
//estoy modificando
