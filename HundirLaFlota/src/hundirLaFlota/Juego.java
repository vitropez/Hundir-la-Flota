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

	static char[][] tablero = new char[20][20];
	static char[][] tableroMaquina = new char[20][20];
	static char[] posicionBarco = { 'v', 'h' };

	public static void main(String[] args) {
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

		coordenadax = (int) (Math.random() * 10);
		coordenaday = (int) (Math.random() * 10);
		int posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Portaviones portaMaquina = new Portaviones(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 10);
		coordenaday = (int) (Math.random() * 10);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Buque buqMaquina = new Buque(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 10);
		coordenaday = (int) (Math.random() * 10);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Submarino subMaquina = new Submarino(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 10);
		coordenaday = (int) (Math.random() * 10);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Crucero cruMaquina = new Crucero(coordenadax, coordenaday, posicion);

		coordenadax = (int) (Math.random() * 10);
		coordenaday = (int) (Math.random() * 10);
		posicionAleatoria = (int) (Math.random() * 2);
		posicion = posicionBarco[posicionAleatoria];
		Lancha lanMaquina = new Lancha(coordenadax, coordenaday, posicion);

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				tablero[i][j] = '.';
			}
		}

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				tableroMaquina[i][j] = '.';
			}
		}
		System.out.println("*******************jugador****************");

		comprobarPosicion(porta);
		comprobarPosicion(buq);
		comprobarPosicion(sub);
		comprobarPosicion(cru);
		comprobarPosicion(lan);
		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 20; j++) {

				System.out.print(tablero[i][j]);
			}
			System.out.print("\n");
		}

		System.out.println("\n\n\n\n*******************maquina****************");

		comprobarPosicionMaquina(portaMaquina);
		comprobarPosicionMaquina(buqMaquina);
		comprobarPosicionMaquina(subMaquina);
		comprobarPosicionMaquina(cruMaquina);
		comprobarPosicionMaquina(lanMaquina);

		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 20; j++) {

				System.out.print(tableroMaquina[i][j]);
			}
			System.out.print("\n");
		}

		while (porta.getTamano() != 0 || buq.getTamano() != 0 || sub.getTamano() != 0 || cru.getTamano() != 0
				|| lan.getTamano() != 0) {
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

					if (size == 1) {
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
					if (size == 1) {
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
					if (size == 1) {
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
					if (size == 1) {
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
					if (size == 1) {
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
						
						Scanner cambioPosicionBarcoPorta = new Scanner(System.in);
						System.out.println("introduce nueva posicion del barco ");
						int nuevax = situar.nextInt();
						int nuevay = situar.nextInt();
						System.out.println("introduce la posicion, 'v', 'h'");
						char nuevaPosicion = cambioPosicionBarcoPorta.next().charAt(0);
						porta.setPosicionInicial(nuevax);
						porta.setPosicionFinal(nuevay);
						porta.setHorientacion(nuevaPosicion);

						if (!cambioPosicionNueva(porta) || !cambioPosicion(porta))

							System.out.println("no se puede cambiar el barco");
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

			if (jugador == 0) {

				System.out.println("maquina dispara!!");
				disparox = (int) (Math.random() * 19);
				disparoy = (int) (Math.random() * 19);
				tiro = tablero[disparox][disparoy];
				switch (tiro) {
				case 'p': {
					System.out.println(disparox + " " + disparoy + "tocado!!");
					tablero[disparox][disparoy] = 't';
					int size = porta.getTamano();

					if (size == 1) {
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
					if (size == 1) {
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
					if (size == 1) {
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
					if (size == 1) {
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
					if (size == 1) {
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
			if (jugador == 1) {
				jugador = 0;
			} else {
				jugador = 1;
			}
		}

	}

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

	public static char[][] comprobarPosicionMaquina(Barco port) {

		char name = port.getNombre();
		if (!cambioPosicionMaquina(port)) {
			char[] nuevaposicionBarco = { 'v', 'h' };
			char nuevaposicion;
			int nuevax = (int) (Math.random() * 16);
			int nuevay = (int) (Math.random() * 16);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
			int nuevaposicionAleatoria = (int) (Math.random() * 2);
			nuevaposicion = nuevaposicionBarco[nuevaposicionAleatoria];
			port.setHorientacion(nuevaposicion);
			cambioPosicionMaquina(port);
		}

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

	public static boolean cambioPosicion(Barco port) {
		String anadirCaracter = "";
		String anadirCaracterMaUno = "";
		String anadirCaracterMenosUno = "";
		String anadirCaracterR = "";
		String anadirCaracterMaUnoR = "";
		String anadirCaracterMenosUnoR = "";

		boolean verdadero;
		int checkx;
		int checky;
		int checkxMasUno;
		int checkyMasUno;
		char name = port.getNombre();

		if (port.getPosicionFinal() <= 0) {
			checkx = 1;
		} else {
			checkx = port.getPosicionFinal();
		}
		if (port.getPosicionInicial() <= 0) {
			checky = 1;
		} else {
			checky = port.getPosicionInicial();
		}
		if (port.getPosicionFinal() >= 19) {
			checkxMasUno = 18;
		} else {
			checkxMasUno = port.getPosicionFinal();
		}
		if (port.getPosicionInicial() >= 19) {
			checkyMasUno = 18;
		} else {
			checkyMasUno = port.getPosicionInicial();
		}

		if (port.getPosicionInicial() + port.getTamano() > 19 || port.getPosicionFinal() + port.getTamano() > 19) {
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
		}

		for (int i = 0; i < port.getTamano(); i++) {

			anadirCaracter += (tablero[port.getPosicionInicial() + i][port.getPosicionFinal()]);

			anadirCaracterMaUno += (tablero[port.getPosicionInicial() + i][checkxMasUno + 1]);
			anadirCaracterMenosUno += (tablero[port.getPosicionInicial() + i][checkx - 1]);
			anadirCaracterR += (tablero[port.getPosicionInicial()][port.getPosicionFinal() + i]);

			anadirCaracterMaUnoR += (tablero[checkyMasUno + 1][port.getPosicionFinal() + i]);
			anadirCaracterMenosUnoR += (tablero[checky - 1][port.getPosicionFinal() + i]);

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
				&& !anadirCaracterMenosUnoR.contains("l")) {

			verdadero = true;

		} else {
			verdadero = false;
		}

		return verdadero;

	}

	public static boolean cambioPosicionMaquina(Barco port) {
		String anadirCaracter = "";
		String anadirCaracterMaUno = "";
		String anadirCaracterMenosUno = "";
		String anadirCaracterR = "";
		String anadirCaracterMaUnoR = "";
		String anadirCaracterMenosUnoR = "";

		boolean verdadero;
		int checkx;
		int checky;
		int checkxMasUno;
		int checkyMasUno;
		if (port.getPosicionFinal() == 0) {
			checkx = 1;
		} else {
			checkx = port.getPosicionFinal();
		}
		if (port.getPosicionInicial() == 0) {
			checky = 1;
		} else {
			checky = port.getPosicionInicial();
		}
		if (port.getPosicionFinal() >= 19) {
			checkxMasUno = 18;
		} else {
			checkxMasUno = port.getPosicionFinal();
		}
		if (port.getPosicionInicial() >= 19) {
			checkyMasUno = 18;
		} else {
			checkyMasUno = port.getPosicionInicial();
		}

		if (port.getPosicionInicial() + port.getTamano() > 19 || port.getPosicionFinal() + port.getTamano() > 19) {
			char[] nuevaposicionBarco = { 'v', 'h' };
			char nuevaposicion;
			int nuevax = (int) (Math.random() * 19);
			int nuevay = (int) (Math.random() * 19);
			port.setPosicionInicial(nuevax);
			port.setPosicionFinal(nuevay);
			int nuevaposicionAleatoria = (int) (Math.random() * 2);
			nuevaposicion = nuevaposicionBarco[nuevaposicionAleatoria];
			port.setHorientacion(nuevaposicion);
			cambioPosicionMaquina(port);

		}

		for (int i = 0; i < port.getTamano(); i++) {

			anadirCaracter += (tableroMaquina[port.getPosicionInicial() + i][port.getPosicionFinal()]);

			anadirCaracterMaUno += (tableroMaquina[port.getPosicionInicial() + i][checkxMasUno + 1]);
			anadirCaracterMenosUno += (tableroMaquina[port.getPosicionInicial() + i][checkx - 1]);
			anadirCaracterR += (tableroMaquina[port.getPosicionInicial()][port.getPosicionFinal() + i]);

			anadirCaracterMaUnoR += (tableroMaquina[checkyMasUno + 1][port.getPosicionFinal() + i]);
			anadirCaracterMenosUnoR += (tableroMaquina[checky - 1][port.getPosicionFinal() + i]);

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
				&& !anadirCaracterMenosUnoR.contains("l")) {

			verdadero = true;

		} else {
			verdadero = false;
		}
		return verdadero;

	}

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
//añado
