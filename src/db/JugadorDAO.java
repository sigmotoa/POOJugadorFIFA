package db;

import models.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    public void saveDB(Jugador j)
    {
     String sql = "INSERT INTO jugadores (name, dorsal, is_alive) VALUES (?,?,?)";

     try (Connection conn = Database.connect();
          PreparedStatement ps = conn.prepareStatement(sql)
     )
     {
         ps.setString(1, j.name);
         ps.setInt(2,j.dorsal);
         ps.setBoolean(3, j.is_alive);
         ps.executeUpdate();

         System.out.println("Jugador guardado");
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }

    }

    public List<Jugador> showAllDB(){

        List<Jugador> listaJugadores = new ArrayList<>();
        String sql = "SELECT * FROM jugadores";

        try (Connection conn = Database.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)
        )
        {
            while (rs.next())
            {
                listaJugadores.add(fromRow(rs));
            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return listaJugadores;
    }

    private Jugador fromRow(ResultSet rs) throws SQLException {
        Jugador j = new Jugador();
        j.name=rs.getString("name");
        j.dorsal=rs.getInt("dorsal");
        j.is_alive=rs.getBoolean("is_alive");

        return j;
    }
}








