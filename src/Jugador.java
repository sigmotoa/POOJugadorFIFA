import java.time.LocalDate;
import java.time.Period;

public class Jugador extends Persona {
    public int dorsal;
    public Posicion posicion;
    private LocalDate nacimiento;

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getEdad()
    {
         return Period.between(
                nacimiento,
                LocalDate.now()
        ).getYears();

    }


    @Override
    public String toString() {
        return "Jugador{" +
                "dorsal=" + dorsal +
                "} "
                + super.toString();
    }


    public Jugador(String nombre, LocalDate nacimiento)
    {
        super.name=nombre;
        this.nacimiento=nacimiento;
    }

    public Jugador()
    {}

    public String playerToCSV()
    {
        return this.name + ","+this.dorsal+","+this.getEdad()+","+is_alive;
    }
}
