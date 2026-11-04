import db.Database;
import models.Jugador;
import operations.OperationsDB;

import java.time.LocalDate;
import java.util.Scanner;

import static operations.Operation.*;
import static operations.OperationsDB.readPlayersDB;

public class Main {
    public static void main(String[] args) {

        //models.Jugador newPlayer = new models.Jugador("Pele", LocalDate.of(1940, 10,23));
        //newPlayer.is_alive = false;
        //newPlayer.dorsal=10;
        //TODO crear menu para usar y operar las acciones de los jugadores
        Database.createTable();
        Scanner leer = new Scanner(System.in);


        //Menu
        //Ingresar jugador -> pulsa 1
        //Leer todos jugadores -> pulsa 2
        //Buscar jugador -> pulsa 3


        int opcion;
        do {
            System.out.println("\n *********** CRUD FIFAS *********** ");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Buscar Jugador");
            System.out.println("3. Mostrar jugadores");
            //TODO actualizar y borrar
            System.out.println("0. Salir destamonda");
            System.out.println("*********** CRUD FIFAS *********** ");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    newPlayer();
                    break;
                case 2:
                    findPlayer();
                    break;
                case 3:
                    showAllPlayers();
                    break;
                case 0:
                    System.out.println("Nos vemos");
                    break;
                default:
                    System.out.println("Abrite burro");


            }
        }
        while (opcion!=0);

    }

    public static void newPlayer() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador");
        String name_player = leer.nextLine();
        System.out.println("Ingrese año de nacimiento");
        int year = leer.nextInt();
        System.out.println("Ingrese mes de naciemiento");
        int month = leer.nextInt();
        System.out.println("Ingrese día de nacimiento");
        int day = leer.nextInt();
        //savePlayer(new Jugador(name_player, LocalDate.of(year, month, day)));
        Jugador j2db = new Jugador(name_player,LocalDate.of(year,month,day));
        System.out.println("Ingrese el dorsal");
        j2db.dorsal = leer.nextInt();
        j2db.is_alive = true;
        OperationsDB.saveJugadorDB(j2db);
    }

    public static void findPlayer() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el jugador a buscar");
        readOnePlayer(leer.next());

    }

    public static void showAllPlayers() {
        //readPlayers();
        readPlayersDB();
    }


}
