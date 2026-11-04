package operations;

import models.Jugador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {
    public static String generarId() {
        Set<String> usados = new HashSet<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("players.csv"))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                usados.add(line.split(",")[0]);
            }
        }
        catch (IOException e) {
        }
        Random ramdom = new Random();
        String nuevo;
        do{
            nuevo = String.valueOf(100000 + ramdom.nextInt(900000));
        }
        while (usados.contains(nuevo));
            return nuevo;
    }
    public static void savePlayer(Jugador jugadorToSave)
    {
        jugadorToSave.setId(generarId());
    try{
        FileWriter escribir = new FileWriter("players.csv", true);

        //escribir.write(jugadorToSave.playerToCSV());
        escribir.write(jugadorToSave.playerToCSV());
        escribir.write("\n");
        escribir.close();
        System.out.println("Player Saved");

    }
    catch (IOException e)
    {
        System.out.println(e.getMessage());
    }
}
    public static void readPlayers()
    {
        try {
            FileReader lector = new FileReader("players.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String playerReader;

            while ((playerReader= buffer.readLine())!=null)
            {
                String[] d = playerReader.split(",");
                System.out.println("ID: " + d[0] + " | Nombre: " + d[1] + " | Dorsal: " + d[2] + " | Edad: " + d[3] + " | Vivo: " + d[4]);
            }


            buffer.close();
            System.out.println("All players have been read");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readOnePlayer(String name)
    {
        try {
            FileReader lector = new FileReader("players.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String playerReader;

            while ((playerReader = buffer.readLine())!=null)
            {

               String [] data_readed = playerReader.split(",");
               Jugador temp_player = new Jugador();
               temp_player.setId(data_readed[0]);
               temp_player.name= data_readed[1];
               temp_player.dorsal = Integer.parseInt(data_readed[2]);
               temp_player.is_alive = Boolean.parseBoolean(data_readed[4]);

               if (temp_player.name.equals(name))
               {

                   System.out.println(playerReader);
                   //playerReader = null;
               }

            }


            buffer.close();
            System.out.println("All players have been read");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //TODO adicionar ID para los registros de jugadores


    }

















}
