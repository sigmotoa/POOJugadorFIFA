package operations;

import db.JugadorDAO;
import models.Jugador;

public class OperationsDB {

    private static final JugadorDAO dao = new JugadorDAO();

    public static void saveJugadorDB(Jugador j2save)
    {
        dao.saveDB(j2save);
    }
    public static void readPlayersDB(){
        for (Jugador j: dao.showAllDB())
        {
            System.out.println(j);
        }
    }

}
