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

//aqui se solicitan las coordenadas del barco y se pasan al constructor

		System.out.println("introduce las coordenadas");
		Scanner sc = new Scanner(System.in);
		coordenadax = sc.nextInt();
		coordenaday = sc.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = sc.next().charAt(0);
		Portaviones porta = new Portaviones(coordenadax, coordenaday, posicion);

		System.out.println("introduce las coordenadas");
		Scanner sca = new Scanner(System.in);
		coordenadax = sca.nextInt();
		coordenaday = sca.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = sca.next().charAt(0);
		Buque buq = new Buque(coordenadax, coordenaday, posicion);

		System.out.println("introduce las coordenadas");
		Scanner scb = new Scanner(System.in);
		coordenadax = scb.nextInt();
		coordenaday = scb.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = scb.next().charAt(0);
		Submarino sub = new Submarino(coordenadax, coordenaday, posicion);

		System.out.println("introduce las coordenadas");
		Scanner scd = new Scanner(System.in);
		coordenadax = scd.nextInt();
		coordenaday = scd.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = scd.next().charAt(0);
		Crucero cru = new Crucero(coordenadax, coordenaday, posicion);

		System.out.println("introduce las coordenadas");
		Scanner sce = new Scanner(System.in);
		coordenadax = sce.nextInt();
		coordenaday = sce.nextInt();
		System.out.println("introduce la posicion, 'v', 'h'");
		posicion = sce.next().charAt(0);
		Lancha lan = new Lancha(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		int posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Portaviones portaMaquina = new Portaviones(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Buque buqMaquina = new Buque(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Submarino subMaquina = new Submarino(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Crucero cruMaquina = new Crucero(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 8);
		coordenaday = (int) (Math.random() * 8);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Lancha lanMaquina = new Lancha(coordenadax, coordenaday, posicion);

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
		System.out.println("*******************jugador****************");
		// aqui se mandan pintar los barcos del jugador y si es posible colocarlos
		// adecuadamente

		comprobarPosicion(porta);
		comprobarPosicion(buq);
		comprobarPosicion(sub);
		comprobarPosicion(cru);
		comprobarPosicion(lan);
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				System.out.print(tablero[i][j]);
			}
			System.out.print("\n");
		}

		System.out.println("\n\n\n\n*******************maquina****************");
//aqui se mandan pintar los barcos de la maquina y si es posible colocarlos adecuadamente
		comprobarPosicionMaquina(portaMaquina);
		comprobarPosicionMaquina(buqMaquina);
		comprobarPosicionMaquina(subMaquina);
		comprobarPosicionMaquina(cruMaquina);
		comprobarPosicionMaquina(lanMaquina);

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				System.out.print(tableroMaquina[i][j]);
			}
			System.out.print("\n");
		}

		while ((porta.getTamano() != 0 && buq.getTamano() != 0 && sub.getTamano() != 0 && cru.getTamano() != 0
				&& lan.getTamano() != 0)
				|| (portaMaquina.getTamano() != 0 && buqMaquina.getTamano() != 0 && subMaquina.getTamano() != 0
						&& cruMaquina.getTamano() != 0 && lanMaquina.getTamano() != 0)) {
//aqui empieza el turno del jugador y el resultado de los disparos	el resultado se hace sobre el tablero
//	de la maquina			

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
					int size = porta.getTamano();

					if (size == 0) {
						System.out.println("hundido");
					} else {

						porta.setTamano(size - 1);

					}

				}
					break;
				case 'b': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = buq.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						buq.setTamano(size - 1);

					}
				}
					break;
				case 's': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = sub.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						sub.setTamano(size - 1);

					}
				}
					break;
				case 'c': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = cru.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						cru.setTamano(size - 1);

					}
				}
					break;
				case 'l': {
					System.out.println("tocado!!");
					tableroMaquina[disparox][disparoy] = 't';
					int size = lan.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						lan.setTamano(size - 1);

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
						if (porta.getTamano() < 5) {
							System.out.println("no se puede cambiar el barco");
							break;

						} else {

							Scanner cambioPosicionBarcoPorta = new Scanner(System.in);
							System.out.println("introduce nueva posicion del barco ");
							int nuevax = situar.nextInt();
							int nuevay = situar.nextInt();
							System.out.println("introduce la posicion, 'v', 'h'");
							char nuevaPosicion = cambioPosicionBarcoPorta.next().charAt(0);
							porta.setPosicionInicial(nuevax);
							porta.setPosicionFinal(nuevay);
							porta.setHorientacion(nuevaPosicion);

							if (!cambioPosicionNueva(porta) || !cambioPosicion(porta)) {

								System.out.println("no se puede cambiar el barco");
							}
						}
					}

						break;

					case 'b': {

						Scanner cambioPosicionBarcoBuq = new Scanner(System.in);
						System.out.println("introduce nueva posicion del barco ");
						int nuevaxBuq = situar.nextInt();
						int nuevayBuq = situar.nextInt();
						System.out.println("introduce la posicion, 'v', 'h'");
						char nuevaPosicionBuq = cambioPosicionBarcoBuq.next().charAt(0);
						buq.setPosicionInicial(nuevaxBuq);
						buq.setPosicionFinal(nuevayBuq);
						buq.setHorientacion(nuevaPosicionBuq);

						if (!cambioPosicionNueva(buq) || !cambioPosicion(buq))

							System.out.println("no se puede cambiar el barco");
					}
						break;

					case 'c': {

						Scanner cambioPosicionBarcoCru = new Scanner(System.in);
						System.out.println("introduce nueva posicion del barco ");
						int nuevaxCru = situar.nextInt();
						int nuevayCru = situar.nextInt();
						System.out.println("introduce la posicion, 'v', 'h'");
						char nuevaPosicionCru = cambioPosicionBarcoCru.next().charAt(0);
						cru.setPosicionInicial(nuevaxCru);
						cru.setPosicionFinal(nuevayCru);
						cru.setHorientacion(nuevaPosicionCru);
						if (!cambioPosicionNueva(cru) || !cambioPosicion(cru))

							System.out.println("no se puede cambiar el barco");
					}

						break;

					case 's': {

						Scanner cambioPosicionBarcoSub = new Scanner(System.in);
						System.out.println("introduce nueva posicion del barco ");
						int nuevaxSub = situar.nextInt();
						int nuevaySub = situar.nextInt();
						System.out.println("introduce la posicion, 'v', 'h'");
						char nuevaPosicionSub = cambioPosicionBarcoSub.next().charAt(0);
						sub.setPosicionInicial(nuevaxSub);
						sub.setPosicionFinal(nuevaySub);
						sub.setHorientacion(nuevaPosicionSub);

						if (!cambioPosicionNueva(sub) || !cambioPosicion(sub))

							System.out.println("no se puede cambiar el barco");

					}
						break;

					case 'l': {

						Scanner cambioPosicionBarcoLan = new Scanner(System.in);
						System.out.println("introduce nueva posicion del barco ");
						int nuevaxLan = situar.nextInt();
						int nuevayLan = situar.nextInt();
						System.out.println("introduce la posicion, 'v', 'h'");
						char nuevaPosicionLan = cambioPosicionBarcoLan.next().charAt(0);
						lan.setPosicionInicial(nuevaxLan);
						lan.setPosicionFinal(nuevayLan);
						lan.setHorientacion(nuevaPosicionLan);

						if (!cambioPosicionNueva(sub) || !cambioPosicion(sub))

							System.out.println("no se puede cambiar el barco");

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

					if (size == 0) {
						System.out.println("hundido");
					} else {

						porta.setTamano(size - 1);

					}

				}
					break;
				case 'b': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = buq.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						buq.setTamano(size - 1);

					}
				}
					break;
				case 's': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = sub.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						sub.setTamano(size - 1);

					}
				}
					break;
				case 'c': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = cru.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						cru.setTamano(size - 1);

					}
				}
					break;
				case 'l': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = lan.getTamano();
					if (size == 0) {
						System.out.println("hundido");
					} else {

						lan.setTamano(size - 1);

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
//aqui termina el juego y se imprimen de nuevo los tableroa para ver el resultado		
		System.out.println("juego terminado");
		System.out.println("*************************jugador******************");
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				System.out.print(tablero[i][j]);
			}
			System.out.print("\n");
		}

		System.out.println("*************************maquina******************");

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				System.out.print(tableroMaquina[i][j]);
			}
			System.out.print("\n");
		}

	}
//este metodo le pasa al tablero los barcos del jugador que han sido aprobados por el metodo cambioPosicion()

	public static char[][] comprobarPosicion(Barco port) {

		char name = port.getNombre();
		Scanner nova = new Scanner(System.in);

		if (!cambioPosicion(port)) {
			System.out.println("introduce nuevas coordenadas ");
			int nuevax = nova.nextInt();
			int nuevay = nova.nextInt();
			System.out.println("introduce la posicion, 'v', 'h'");
			char nuevaPosicion = nova.next().charAt(0);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
			port.setHorientacion(nuevaPosicion);
			cambioPosicion(port);
		}

		switch (port.getHorientacion()) {

		case 'v': {

			for (int i = 0; i < port.getTamano(); i++) {
				tablero[port.getPosicionInicial() + i][port.getPosicionFinal()] = name;
			}

		}
			break;

		case 'h': {

			for (int i = 0; i < port.getTamano(); i++) {
				tablero[port.getPosicionInicial()][port.getPosicionFinal() + i] = name;
			}

		}
			break;

		}

		return tablero;
	}

//este metodo le pasa al tablero los barcos de la maquina que han sido aprobados por el metodo cambioPosicion()
	public static char[][] comprobarPosicionMaquina(Barco port) {

		char name = port.getNombre();

		do {
			char[] nuevaposicionBarco = { 'v', 'h' };
			char nuevaposicion;
			int nuevax = (int) (Math.random() * 8);
			int nuevay = (int) (Math.random() * 8);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
			int nuevaposicionAleatoria = (int) (Math.random() * 2);
			nuevaposicion = nuevaposicionBarco[nuevaposicionAleatoria];
			port.setHorientacion(nuevaposicion);
			cambioPosicionMaquina(port);
		} while (cambioPosicionMaquina(port) == false);

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

		return tableroMaquina;
	}

//este metodo comprueba que la casilla del barco no este ocupada y que haya un espacio entre ellos
	public static boolean cambioPosicion(Barco port) {
		boolean verdadero;
		String anadirCaracter = "";
		String anadirCaracterMaUno = "";
		String anadirCaracterMenosUno = "";
		String anadirCaracterR = "";
		String anadirCaracterMaUnoR = "";
		String anadirCaracterMenosUnoR = "";
		char caracterAnterior = ' ';
		char caracterPosterior = ' ';
		// este while comprueba que para colocar los barcos estos no pueden sobrepasar
		// el limite del
//	tablero en ese caso solicita unas nuevas coordenadas y vuelve a comprobar 		
		if ((port.getPosicionFinal() + port.getTamano()  > 8) && (port.getHorientacion() == 'h')
				|| (port.getPosicionInicial() + port.getTamano()  >8) && (port.getHorientacion() == 'v')) {
			Scanner nova = new Scanner(System.in);

			System.out.println("introduce nuevas coordenadas ");
			int nuevax = nova.nextInt();
			int nuevay = nova.nextInt();
			System.out.println("introduce la posicion, 'v', 'h'");
			char nuevaPosicion = nova.next().charAt(0);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
			port.setHorientacion(nuevaPosicion);
			cambioPosicion(port);
		} else {
//aqui se hacen los Strings con las casillas anteriores y posteriores del barco para saber que no estan ocupadas
			for (int i = 0; i < port.getTamano(); i++) {
				if (port.getHorientacion() == 'v') {
					anadirCaracter += (tablero[port.getPosicionInicial() + i][port.getPosicionFinal()]);
					if (port.getPosicionFinal() < 7)
						anadirCaracterMaUno += (tablero[port.getPosicionInicial() + i][port.getPosicionFinal() + 1]);
					if (port.getPosicionInicial() + port.getTamano() <8)
						caracterPosterior = (tablero[port.getPosicionInicial()-1 + port.getTamano()][port.getPosicionFinal()]);
					if (port.getPosicionFinal() > 0)
						anadirCaracterMenosUno += (tablero[port.getPosicionInicial() + i][port.getPosicionFinal() - 1]);
					if (port.getPosicionInicial() > 0)
						caracterAnterior = (tablero[port.getPosicionInicial() - 1][port.getPosicionFinal()]);
				}
				if (port.getHorientacion() == 'h') {
					anadirCaracterR += (tablero[port.getPosicionInicial()][port.getPosicionFinal() + i]);
					if (port.getPosicionInicial() < 7) {

						anadirCaracterMaUnoR += (tablero[port.getPosicionInicial() + 1][port.getPosicionFinal() + i]);
					}
					if (port.getPosicionInicial() > 0) {
						anadirCaracterMenosUnoR += (tablero[(port.getPosicionInicial() )- 1][port.getPosicionFinal()+ i]);
					
					caracterAnterior = (tablero[(port.getPosicionInicial()) - 1][port.getPosicionFinal()]);
					}
					if (port.getPosicionFinal() + port.getTamano() < 8)
						caracterPosterior = (tablero[port.getPosicionInicial() ][port.getPosicionFinal()+ port.getTamano()]);
				}
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
				&& !anadirCaracterMenosUnoR.contains("l")&&caracterPosterior!='p'&&caracterPosterior!='b'
				&&caracterPosterior!='c'&&caracterPosterior!='s'&&caracterPosterior!='l'&&caracterAnterior!='p'
				&&caracterAnterior!='b'&&caracterAnterior!='c'&&caracterAnterior!='s'&&caracterAnterior!='l') {

			verdadero = true;

		} else {
			verdadero = false;
		}

		return verdadero;

	}
//este metodo comprueba que la posicion de los barcos de la maquina no este ocupada y que haya un espacio entre ellos

	public static boolean cambioPosicionMaquina(Barco port) {
		String anadirCaracter = "";
		String anadirCaracterMaUno = "";
		String anadirCaracterMenosUno = "";
		String anadirCaracterR = "";
		String anadirCaracterMaUnoR = "";
		String anadirCaracterMenosUnoR = "";
		char caracterAnterior = ' ';
		char caracterPosterior = ' ';

		boolean verdadero;

		if ((port.getPosicionFinal() + port.getTamano()  > 8) && (port.getHorientacion() == 'h')
				|| (port.getPosicionInicial() + port.getTamano()  >8) && (port.getHorientacion() == 'v')) {
			Scanner nova = new Scanner(System.in);
			char[] nuevaposicionBarco = { 'v', 'h' };
			char nuevaposicion;
			int nuevax = (int) (Math.random() * 8);
			int nuevay = (int) (Math.random() * 8);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
			int nuevaposicionAleatoria = (int) (Math.random() * 2);
			nuevaposicion = nuevaposicionBarco[nuevaposicionAleatoria];
			port.setHorientacion(nuevaposicion);
			cambioPosicionMaquina(port);
		} else {
			for (int i = 0; i < port.getTamano(); i++) {
				if (port.getHorientacion() == 'v') {
					anadirCaracter += (tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal()]);
					if (port.getPosicionFinal() < 7)
						anadirCaracterMaUno += (tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal() + 1]);
					if (port.getPosicionInicial() + port.getTamano() < 8)
						caracterPosterior = (tableroMaquina[port.getPosicionInicial()-1 + port.getTamano()][port.getPosicionFinal()]);
					if (port.getPosicionFinal() > 0)
						anadirCaracterMenosUno += (tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal() - 1]);
					if (port.getPosicionInicial() > 0)
						caracterAnterior = (tableroMaquina[port.getPosicionInicial() - 1][port.getPosicionFinal()]);
				}
				if (port.getHorientacion() == 'h') {
					anadirCaracterR += (tableroMaquina[port.getPosicionInicial()][port.getPosicionFinal() + i]);
					if (port.getPosicionInicial() < 7) {

						anadirCaracterMaUnoR += (tableroMaquina[port.getPosicionInicial() + 1][port.getPosicionFinal() + i]);
					}
					if (port.getPosicionInicial() > 0) {
						anadirCaracterMenosUnoR += (tableroMaquina[(port.getPosicionInicial()) - 1][port.getPosicionFinal()+ i]);
					
					caracterAnterior = (tableroMaquina[(port.getPosicionInicial()) - 1][port.getPosicionFinal()]);
					}
					if (port.getPosicionFinal() + port.getTamano() < 8)
						caracterPosterior = (tableroMaquina[port.getPosicionInicial() ][port.getPosicionFinal()+ port.getTamano()]);
				}
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
						&& !anadirCaracterMenosUnoR.contains("l")&&caracterPosterior!='p'&&caracterPosterior!='b'
						&&caracterPosterior!='c'&&caracterPosterior!='s'&&caracterPosterior!='l'&&caracterAnterior!='p'
						&&caracterAnterior!='b'&&caracterAnterior!='c'&&caracterAnterior!='s'&&caracterAnterior!='l') {
			verdadero = true;

		} else {

			verdadero = false;
		}
		return verdadero;

	}

//este metodo comprueba que la posicion del barco movido no sea a una casilla bombardeada anteriormente
	public static boolean cambioPosicionNueva(Barco port) {

		String anadirCaracter = "";

		boolean verdadero;

		if (port.getHorientacion() == 'h') {
			for (int i = 0; i < port.getTamano(); i++) {

				anadirCaracter += (tablero[port.getPosicionInicial() + i][port.getPosicionFinal()]);
			}
		}
		if (port.getHorientacion() == 'v') {
			for (int i = 0; i < port.getTamano(); i++) {

				anadirCaracter += (tablero[port.getPosicionInicial()][port.getPosicionFinal() + i]);
			}
		}
		if (!anadirCaracter.contains("a") && !anadirCaracter.contains("t")) {

			verdadero = true;

		} else {

			verdadero = false;

		}
		return verdadero;
	}

}
