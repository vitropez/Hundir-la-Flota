package barcos;

public class Portaviones extends Barco {
char nombre='p';
int posicionInicial;
int posicionFinal;
char horientacion;
int tamano;

public Portaviones(int posicionInicial, int posicionFinal, char horientacion) {
	super( posicionInicial,  posicionFinal,  horientacion);
	
	this.posicionInicial = posicionInicial;
	this.posicionFinal = posicionFinal;
	this.horientacion = horientacion;
	this.tamano = 5;
	
}

public char getNombre() {
	return nombre;
}

public void setNombre(char nombre) {
	this.nombre = nombre;
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



	
	
	
}


