import java.time.LocalDate;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Jugador newPlayer = new Jugador("Pele", LocalDate.of(1940, 10,23));
        newPlayer.is_alive = false;
        newPlayer.dorsal=10;
        //System.out.println(newPlayer);
        //System.out.println("Edad: "+newPlayer.getEdad());
        //System.out.println(newPlayer.playerToCSV());
        //savePlayer(newPlayer);
        System.out.println("*************************");
        readPlayer();
        /*




        Jugador j1 = new Jugador();

        Equipo e1 = new Equipo();


        Jugador j3 = new Jugador("Quintero",
                LocalDate.of(1993,1,18));


        e1.plantilla = new Jugador[5];
        e1.plantilla[0] = j1;
        j1.posicion = Posicion.EXTREMO;

        Persona p1 = new Persona();
        p1.name = "Daniel";
        p1.setCountry("Colombia");

        Jugador j2 = new Jugador();
        //j2.p1 = p1;
        j2.posicion = Posicion.DELANTERO;
        j1.name = "Messi";
        j1.dorsal = 10;
        j1.setNacimiento(LocalDate.of(1987,9,28));
        //j1.country = "Argentina";
        //j1.id = "1";
        j1.setCountry("España");
        System.out.println(j1.getCountry());

        System.out.println(j1);


        Tecnico t1 = new Tecnico();

        t1.name="Pekerman";
        t1.club="Desempleado";

        System.out.println(t1);

        System.out.println(j3.getEdad());
*/
    }

    public static void savePlayer(Jugador jugadorToSave)
    {
        try{
            FileWriter escribir = new FileWriter("players.csv");
            escribir.write(jugadorToSave.playerToCSV());
            escribir.close();
            System.out.println("Player Saved");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void readPlayer()
    {
        try {
            FileReader lector = new FileReader("players.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String playerReader;

            while ((playerReader= buffer.readLine())!=null)
            {
                System.out.println(playerReader);
            }


            buffer.close();
            System.out.println("All players have been read");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
