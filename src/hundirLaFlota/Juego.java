package hundirLaFlota;

import java.util.Scanner;

import barcos.Barco;
import barcos.Buque;
import barcos.Crucero;
import barcos.Lancha;
import barcos.Portaviones;
import barcos.Submarino;

public class Juego {
	static int coordenadax;
	static int coordenaday;
	static char posicion;
	static int disparox;
	static int disparoy;
	static char tiro;
	static int jugador = 1;
	static boolean tamanoCorrecto;
	
	
	
	
	
	

	static char[][] tablero = new char[8][8];
	static char[][] tableroMaquina = new char[8][8];
	static char[] posicionBarco = { 'v', 'h' };

	public static void main(String[] args) {
		//aqui se inicializan los tableros

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						tablero[i][j] = '.';
					}
				}

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						tableroMaquina[i][j] = '.';
					}
				}

//aqui se solicitan las coordenadas del barco y se pasan al constructor

		System.out.println("introduce las coordenadas");
		Scanner sc = new Scanner(System.in);
		coordenadax = sc.nextInt();
		coordenaday = sc.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = sc.next().charAt(0);
		Portaviones porta = new Portaviones(coordenadax, coordenaday, posicion);
		comprobarPosicion(porta);
		
		System.out.println("introduce las coordenadas");
		Scanner sca = new Scanner(System.in);
		coordenadax = sca.nextInt();
		coordenaday = sca.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = sca.next().charAt(0);
		Buque buq = new Buque(coordenadax, coordenaday, posicion);
		comprobarPosicion(buq);

		System.out.println("introduce las coordenadas");
		Scanner scb = new Scanner(System.in);
		coordenadax = scb.nextInt();
		coordenaday = scb.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = scb.next().charAt(0);
		Submarino sub = new Submarino(coordenadax, coordenaday, posicion);
		comprobarPosicion(sub);

		System.out.println("introduce las coordenadas");
		Scanner scd = new Scanner(System.in);
		coordenadax = scd.nextInt();
		coordenaday = scd.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = scd.next().charAt(0);
		Crucero cru = new Crucero(coordenadax, coordenaday, posicion);
		comprobarPosicion(cru);

		System.out.println("introduce las coordenadas");
		Scanner sce = new Scanner(System.in);
		coordenadax = sce.nextInt();
		coordenaday = sce.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = sce.next().charAt(0);
		Lancha lan = new Lancha(coordenadax, coordenaday, posicion);
		comprobarPosicion(lan);

		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		int posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Portaviones portaMaquina = new Portaviones(coordenadax, coordenaday, posicion);
		comprobarPosicionMaquina(portaMaquina);
		
		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Buque buqMaquina = new Buque(coordenadax, coordenaday, posicion);
		comprobarPosicionMaquina(buqMaquina);
		
		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Submarino subMaquina = new Submarino(coordenadax, coordenaday, posicion);
		comprobarPosicionMaquina(subMaquina);
		
		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Crucero cruMaquina = new Crucero(coordenadax, coordenaday, posicion);
		comprobarPosicionMaquina(cruMaquina);
		
		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Lancha lanMaquina = new Lancha(coordenadax, coordenaday, posicion);
		comprobarPosicionMaquina(lanMaquina);

		System.out.println("*******************jugador****************");
		imprimirTablero();

		System.out.println("\n\n\n\n*******************maquina****************");
//aqui se mandan pintar los barcos de la maquina y si es posible colocarlos adecuadamente
		
		imprimirTableroMaquina();

		do {  
//aqui empieza el turno del jugador y el resultado de los disparos	el resultado se hace sobre el tablero
//	de la maquina			
			imprimirTablero();
			jugador = 1;
			if (jugador == 1) {
				System.out.println("jugador dispara!!");

				Scanner disparo = new Scanner(System.in);
				disparox = disparo.nextInt();
				disparoy = disparo.nextInt();
				tiro = tableroMaquina[disparox][disparoy];

				switch (tiro) {
				case 'p': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = portaMaquina.getTamano();
					portaMaquina.setTamano(size - 1);
					if (portaMaquina.getTamano() == 0) {
						System.out.println("hundido");
					}

				}
					break;
				case 'b': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = buqMaquina.getTamano();
					buqMaquina.setTamano(size - 1);
					if (buqMaquina.getTamano() == 0) {
						System.out.println("hundido");
					}

				}
					break;
				case 's': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = subMaquina.getTamano();
					subMaquina.setTamano(size - 1);
					if (subMaquina.getTamano() == 0) {
						System.out.println("hundido");
					}

				}
					break;
				case 'c': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = cruMaquina.getTamano();
					cruMaquina.setTamano(size - 1);
					if (cruMaquina.getTamano() == 0) {
						System.out.println("hundido");
					}

				}
					break;
				case 'l': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = lanMaquina.getTamano();
					lanMaquina.setTamano(size - 1);
					if (lanMaquina.getTamano() == 0) {
						System.out.println("hundido");
					}

					break;
				}
				case '.': {
					System.out.println("agua!!");
					tableroMaquina[disparox][disparoy] = 'a';

				}
					break;
				case 'a': {
					System.out.println("agua!!");

				}
					break;
				case 't': {
					System.out.println("agua!!");
				}
					break;

				}
				System.out.println("quiere deshacer su jugada s/n");
				Scanner cambio = new Scanner(System.in);
				char posicionAnterior = cambio.next().charAt(0);
				switch (posicionAnterior) {
				case ('s'): {
					tableroMaquina[disparox][disparoy] = tiro;

				}

				}
//aqui el juagador elige si quiere mover un barco y se comprueba si es movible o no
				System.out.println("quiere cambiar el barco s/n");
				Scanner situar = new Scanner(System.in);
				char situarBarco = situar.next().charAt(0);
				switch (situarBarco) {
				case ('s'): {
					
					System.out.println("introduce la inicial del barco----p,b,c,s,l");

					Scanner cambioPosicionBarco = new Scanner(System.in);
					char barcoElegido = cambioPosicionBarco.next().charAt(0);
				switch (barcoElegido) {
					case 'p': {
						int numeroVeces=0;
					}
						if (porta.getTamano() < 5) {
							System.out.println("no se puede cambiar el barco");
							break;

						} else {
							int eliminarPosicionx=porta.getPosicionInicial();
							int eliminarPosiciony=porta.getPosicionFinal();
							
							comprobarPosicion( porta);
							tablero[eliminarPosicionx][eliminarPosiciony]='.';
							System.out.println("\n\n***********barco Movido********");
							imprimirTablero();
						}
					

						break;

					case 'b': {
						if (porta.getTamano() < 4) {
							System.out.println("no se puede cambiar el barco");
							break;

						} else {
							int eliminarPosicionx=buq.getPosicionInicial();
							int eliminarPosiciony=buq.getPosicionFinal();
							comprobarPosicion( buq);
							tablero[eliminarPosicionx][eliminarPosiciony]='.';
							System.out.println("\n\n***********barco Movido********/n/n");
							imprimirTablero();
					}
					}
						break;

					case 'c': {
						if (porta.getTamano() < 3) {
							System.out.println("no se puede cambiar el barco");
							break;

						} else {
							int eliminarPosicionx=cru.getPosicionInicial();
							int eliminarPosiciony=cru.getPosicionFinal();
							comprobarPosicion( cru);
							tablero[eliminarPosicionx][eliminarPosiciony]='.';
							System.out.println("\n\n***********barco Movido********");
							imprimirTablero();
					
					}
					}
						break;

					case 's': {
						if (porta.getTamano() < 2) {
							System.out.println("no se puede cambiar el barco");
							break;

						} else {
							int eliminarPosicionx=sub.getPosicionInicial();
							int eliminarPosiciony=sub.getPosicionFinal();
							comprobarPosicion( sub);
							tablero[eliminarPosicionx][eliminarPosiciony]='.';
							System.out.println("\n\n***********barco Movido********");
							imprimirTablero();
						}
					}
						break;

					case 'l': {
						if (porta.getTamano() < 1) {
							System.out.println("no se puede cambiar el barco");
							break;

						} else {
							int eliminarPosicionx=lan.getPosicionInicial();
							int eliminarPosiciony=lan.getPosicionFinal();
							comprobarPosicion( lan);
							tablero[eliminarPosicionx][eliminarPosiciony]='.';
							System.out.println("\n\n***********barco Movido********");
							imprimirTablero();
						}
					}
						break;

					}
				}

			}

				jugador = 0;
			}
//aqui empieza el turno de la maquina y el resultado de los disparos
			if (jugador == 0) {

				System.out.println("maquina dispara!!");
				disparox = (int) (Math.random() * 8);
				disparoy = (int) (Math.random() * 8);
				tiro = tablero[disparox][disparoy];
				switch (tiro) {
				case 'p': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = porta.getTamano();
					porta.setTamano(size - 1);
					if (porta.getTamano() == 0) {
						System.out.println("hundido");
					}

				}
					break;
				case 'b': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = buq.getTamano();
					buq.setTamano(size - 1);
					if (buq.getTamano() == 0) {
						System.out.println("hundido");
					}
				}
					break;
				case 's': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = sub.getTamano();
					sub.setTamano(size - 1);
					if (sub.getTamano() == 0) {
						System.out.println("hundido");
					}
				}
					break;
				case 'c': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = cru.getTamano();
					cru.setTamano(size - 1);
					if (cru.getTamano() == 0) {
						System.out.println("hundido");
					}
				}
					break;
				case 'l': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = lan.getTamano();
					lan.setTamano(size - 1);
					if (lan.getTamano() == 0) {
						System.out.println("hundido");
					}
					break;
				}
				case '.': {
					System.out.println(disparox + " " + disparoy + " agua!!");
					tablero[disparox][disparoy] = 'a';

				}
					break;
				case 'a': {
					System.out.println(disparox + " " + disparoy + "agua!!");

				}
					break;
				case 't': {
					System.out.println(disparox + " " + disparoy + "agua!!");
				}
					break;

				}
				System.out.println("quiere deshacer la jugada de la maquina s/n");
				Scanner cambioMaquina = new Scanner(System.in);
				char posicionAnteriorMaquina = cambioMaquina.next().charAt(0);
				switch (posicionAnteriorMaquina) {
				case ('s'): {
					tablero[disparox][disparoy] = tiro;

				}

				}
			}
			
//aqui se hace el cambio del jugador 
			if (jugador == 1) {
				jugador = 0;
			} else {
				jugador = 1;
			}
		}
		while(((porta.getTamano() > 0 )|| (buq.getTamano() >0) || (sub.getTamano() > 0) || (cru.getTamano() > 0)
				|| (lan.getTamano() > 0))
				&&((portaMaquina.getTamano() > 0) || (buqMaquina.getTamano() > 0) || (subMaquina.getTamano() > 0)
						|| (cruMaquina.getTamano() > 0 )||( lanMaquina.getTamano() > 0)));
//aqui termina el juego y se imprimen de nuevo los tableroa para ver el resultado		
		System.out.println("juego terminado");
		System.out.println("*************************jugador******************");
		imprimirTablero();

		System.out.println("*************************maquina******************");

		imprimirTableroMaquina();

	}

	private static void imprimirTablero() {
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				System.out.print(tablero[i][j]);
			}
			System.out.print("\n");
		}
	}

	private static void imprimirTableroMaquina() {
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				System.out.print(tableroMaquina[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static char[][] comprobarPosicion(Barco port) {
		
		 String anadirCaracter = "";
		 String anadirCaracterMaUno = "";
		 String anadirCaracterMenosUno = "";
		 String anadirCaracterR = "";
		 String anadirCaracterMaUnoR = "";
		 String anadirCaracterMenosUnoR = "";
		 String caracterAnterior="";
		 String caracterPosterior="";
		 String caracterAnteriorR="";
		 String caracterPosteriorR="";
		 char name = port.getNombre();
		
			
		
		// este while comprueba que para colocar los barcos estos no pueden sobrepasar
		// el limite del
//	tablero en ese caso solicita unas nuevas coordenadas y vuelve a comprobar 		
		if ((port.getPosicionFinal() + port.getTamano() > 7) && (port.getHorientacion() == 'h')
				|| (port.getPosicionInicial() + port.getTamano() >7) && (port.getHorientacion() == 'v')) {
			
		
			Scanner nova = new Scanner(System.in);

			System.out.println("introduce nuevas coordenadas");
			int nuevax = nova.nextInt();
			int nuevay = nova.nextInt();
			System.out.println("introduce la posicion, 'v', 'h'");
			char nuevaPosicion = nova.next().charAt(0);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
			port.setHorientacion(nuevaPosicion);	
		} 

		
		for (int i = 0; i < port.getTamano(); i++) { 
		
			if (port.getHorientacion() == 'v') {
				anadirCaracter += tablero[port.getPosicionInicial() + i][port.getPosicionFinal()];
				if (port.getPosicionFinal() < 7)
					anadirCaracterMaUno += (tablero[port.getPosicionInicial() + i][port.getPosicionFinal()+ 1]);
				
				if (port.getPosicionInicial() + port.getTamano() < 7) 
					caracterPosterior = Character.toString((tablero[port.getPosicionInicial()+ port.getTamano()][port.getPosicionFinal()]));
				
				if (port.getPosicionFinal() > 0) 
					anadirCaracterMenosUno += (tablero[port.getPosicionInicial() + i][port.getPosicionFinal()
							- 1]);
				
				if (port.getPosicionInicial() > 0) 
					caracterAnterior =Character.toString((tablero[port.getPosicionInicial()-1][port.getPosicionFinal()]));
		
			}
					if (port.getHorientacion() == 'h') {
				anadirCaracterR += tablero[port.getPosicionInicial()][port.getPosicionFinal() + i];
				if (port.getPosicionInicial() < 7)

					anadirCaracterMaUnoR += (tablero[port.getPosicionInicial() + 1][port.getPosicionFinal()+ i]);
				
				if (port.getPosicionInicial() > 0) 
					anadirCaracterMenosUnoR += (tablero[(port.getPosicionInicial()) - 1][port.getPosicionFinal() + i]);
				
				if(port.getPosicionFinal()>0)
					caracterAnterior = Character.toString((tablero[(port.getPosicionInicial())][port.getPosicionFinal()-1]));
				
				 if(port.getPosicionFinal() + port.getTamano() < 7) 
					caracterPosterior = Character.toString((tablero[port.getPosicionInicial()][port.getPosicionFinal()
							+ port.getTamano()]));
			
					}
		}
			if (!anadirCaracter.contains("p") && !anadirCaracterMaUno.contains("p") && !anadirCaracterMenosUno.contains("p")
					&& !anadirCaracter.contains("b") && !anadirCaracterMaUno.contains("b")
					&& !anadirCaracterMenosUno.contains("b") && !anadirCaracter.contains("s")
					&& !anadirCaracterMaUno.contains("s") && !anadirCaracterMenosUno.contains("s")
					&& !anadirCaracter.contains("c") && !anadirCaracterMaUno.contains("c")
					&& !anadirCaracterMenosUno.contains("c") && !anadirCaracter.contains("l")
					&& !anadirCaracterMaUno.contains("l") && !anadirCaracterMenosUno.contains("l")
					&& !anadirCaracterR.contains("p") && !anadirCaracterMaUnoR.contains("p")
					&& !anadirCaracterMenosUnoR.contains("p") && !anadirCaracterR.contains("b")
					&& !anadirCaracterMaUnoR.contains("b") && !anadirCaracterMenosUnoR.contains("b")
					&& !anadirCaracterR.contains("s") && !anadirCaracterMaUnoR.contains("s")
					&& !anadirCaracterMenosUnoR.contains("s") && !anadirCaracterR.contains("c")
					&& !anadirCaracterMaUnoR.contains("c") && !anadirCaracterMenosUnoR.contains("c")
					&& !anadirCaracterR.contains("l") && !anadirCaracterMaUnoR.contains("l")
					&& !anadirCaracterMenosUnoR.contains("l") && !caracterPosterior.contains("p") && !caracterPosterior.contains("b")
					&& !caracterPosterior.contains("c") && !caracterPosterior.contains ("s") && !caracterPosterior.contains("l")
					&& !caracterAnterior.contains("p") && !caracterAnterior.contains("b") && !caracterAnterior.contains("c")
					&& !caracterAnterior.contains("s") && !caracterAnterior.contains("l")&& !caracterPosteriorR.contains("p") && !caracterPosteriorR.contains("b")
					&& !caracterPosteriorR.contains("c") && !caracterPosteriorR.contains("s") && !caracterPosteriorR.contains("l")
					&& !caracterAnteriorR.contains("p") && !caracterAnteriorR.contains("b") && !caracterAnteriorR.contains("c")
					&& !caracterAnteriorR.contains("s") && !caracterAnteriorR.contains("l")&&!anadirCaracter.contains("a")&&!anadirCaracterR.contains("a"))
	 {
				switch (port.getHorientacion()) {

				case 'v': {

					for (int i = 0; i < port.getTamano(); i++) {
						tablero[port.getPosicionInicial() + i][port.getPosicionFinal()] = name;
					}

				}break;
					

				case 'h': {

					for (int i = 0; i < port.getTamano(); i++) {
						tablero[port.getPosicionInicial()][port.getPosicionFinal() + i] = name;
					}

				}
				break;	

				}
				 imprimirTablero();
				
				}else {
					Scanner nova = new Scanner(System.in);
					System.out.println("introduce nuevas coordenadas");
					int nuevax = nova.nextInt();
					int nuevay = nova.nextInt();
					System.out.println("introduce la posicion, 'v', 'h'");
					char nuevaPosicion = nova.next().charAt(0);
					port.setPosicionInicial(nuevax);
					port.setPosicionFinal(nuevay);
					port.setHorientacion(nuevaPosicion);
					comprobarPosicion(port);
					
				}
				
			return tablero;
		
	}
//este metodo comprueba que la posicion de los barcos de la maquina no este ocupada y que haya un espacio entre ellos

	public static char[][] comprobarPosicionMaquina(Barco port) {
		 String anadirCaracter = "";
		 String anadirCaracterMaUno = "";
		 String anadirCaracterMenosUno = "";
		 String anadirCaracterR = "";
		 String anadirCaracterMaUnoR = "";
		 String anadirCaracterMenosUnoR = "";
		 String caracterAnterior="";
		 String caracterPosterior="";
		 String caracterAnteriorR="";
		 String caracterPosteriorR="";
		 char name = port.getNombre();

		do { 
			char[] nuevaposicionBarco = { 'v', 'h' };
			char nuevaposicion;
			int nuevaposicionAleatoria= (int) (Math.random() * 2);
			int nuevax= (int) (Math.random() * 8);
			int nuevay= (int) (Math.random() * 8);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
		
			nuevaposicion = nuevaposicionBarco[nuevaposicionAleatoria];
			port.setHorientacion(nuevaposicion);
			
		} while((port.getPosicionFinal() + port.getTamano() >7) && (port.getHorientacion() == 'h')
				|| (port.getPosicionInicial() + port.getTamano() >7) && (port.getHorientacion() == 'v'));
		for (int i = 0; i < port.getTamano(); i++) { 
			
			if (port.getHorientacion() == 'v') {
				anadirCaracter += tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal()];
				if (port.getPosicionFinal() < 7)
					anadirCaracterMaUno += (tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal()+ 1]);
				
				if (port.getPosicionInicial() + port.getTamano() <=7) 
					caracterPosterior = Character.toString((tableroMaquina[port.getPosicionInicial()+ port.getTamano()][port.getPosicionFinal()]));
				
				if (port.getPosicionFinal() > 0) 
					anadirCaracterMenosUno += (tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal()
							- 1]);
				
				if (port.getPosicionInicial() > 0) 
					caracterAnterior =Character.toString((tableroMaquina[port.getPosicionInicial()-1][port.getPosicionFinal()]));
		
			}
			
					if (port.getHorientacion() == 'h') {
				anadirCaracterR += tableroMaquina[port.getPosicionInicial()][port.getPosicionFinal() + i];
				if (port.getPosicionInicial() < 7)

					anadirCaracterMaUnoR += (tableroMaquina[port.getPosicionInicial() + 1][port.getPosicionFinal()+ i]);
				
				if (port.getPosicionInicial() > 0) 
					anadirCaracterMenosUnoR += (tableroMaquina[(port.getPosicionInicial()) - 1][port.getPosicionFinal() + i]);
				
				if(port.getPosicionFinal()>0)
					caracterAnterior = Character.toString((tableroMaquina[(port.getPosicionInicial())][port.getPosicionFinal()-1]));
				
				 if(port.getPosicionFinal() + port.getTamano() <= 7) 
					caracterPosterior = Character.toString((tableroMaquina[port.getPosicionInicial()][port.getPosicionFinal()+ port.getTamano()]));
			
					}
		}

			if (!anadirCaracter.contains("p") && !anadirCaracterMaUno.contains("p") && !anadirCaracterMenosUno.contains("p")
					&& !anadirCaracter.contains("b") && !anadirCaracterMaUno.contains("b")
					&& !anadirCaracterMenosUno.contains("b") && !anadirCaracter.contains("s")
					&& !anadirCaracterMaUno.contains("s") && !anadirCaracterMenosUno.contains("s")
					&& !anadirCaracter.contains("c") && !anadirCaracterMaUno.contains("c")
					&& !anadirCaracterMenosUno.contains("c") && !anadirCaracter.contains("l")
					&& !anadirCaracterMaUno.contains("l") && !anadirCaracterMenosUno.contains("l")
					&& !anadirCaracterR.contains("p") && !anadirCaracterMaUnoR.contains("p")
					&& !anadirCaracterMenosUnoR.contains("p") && !anadirCaracterR.contains("b")
					&& !anadirCaracterMaUnoR.contains("b") && !anadirCaracterMenosUnoR.contains("b")
					&& !anadirCaracterR.contains("s") && !anadirCaracterMaUnoR.contains("s")
					&& !anadirCaracterMenosUnoR.contains("s") && !anadirCaracterR.contains("c")
					&& !anadirCaracterMaUnoR.contains("c") && !anadirCaracterMenosUnoR.contains("c")
					&& !anadirCaracterR.contains("l") && !anadirCaracterMaUnoR.contains("l")
					&& !anadirCaracterMenosUnoR.contains("l") && !caracterPosterior.contains("p") && !caracterPosterior.contains("b")
					&& !caracterPosterior.contains("c") && !caracterPosterior.contains ("s") && !caracterPosterior.contains("l")
					&& !caracterAnterior.contains("p") && !caracterAnterior.contains("b") && !caracterAnterior.contains("c")
					&& !caracterAnterior.contains("s") && !caracterAnterior.contains("l")&& !caracterPosteriorR.contains("p") && !caracterPosteriorR.contains("b")
					&& !caracterPosteriorR.contains("c") && !caracterPosteriorR.contains("s") && !caracterPosteriorR.contains("l")
					&& !caracterAnteriorR.contains("p") && !caracterAnteriorR.contains("b") && !caracterAnteriorR.contains("c")
					&& !caracterAnteriorR.contains("s") && !caracterAnteriorR.contains("l"))
	 {

			switch (port.getHorientacion()) {
				
				case 'v': {

					for (int i = 0; i < port.getTamano(); i++) {
						tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal()] = name;
					}

				}
					break;

				case 'h': {

					for (int i = 0; i < port.getTamano(); i++) {
						tableroMaquina[port.getPosicionInicial()][port.getPosicionFinal() + i] = name;
					}
				}

					break;	
			}
				
		} else{
				 char[] nuevaposicionBarco = { 'v', 'h' };
					char nuevaposicion;
					
					int nuevax= (int) (Math.random() * 8);
					 int nuevay= (int) (Math.random() * 8);
					int nuevaposicionAleatoria;  
					 nuevaposicionAleatoria= (int) (Math.random() * 2);
					port.setPosicionInicial(nuevax);
					port.setPosicionFinal(nuevay);
					nuevaposicion = nuevaposicionBarco[nuevaposicionAleatoria];
					port.setHorientacion(nuevaposicion);
				
					comprobarPosicionMaquina(port);
		}

			 return tableroMaquina;

	}


}
