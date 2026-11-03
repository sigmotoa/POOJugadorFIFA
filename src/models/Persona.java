package models;

public class Persona {
    public String name;
    private String country ;
    private String id ;
    public boolean is_alive = true;

    public String getCountry(){
        return country;
    }

    public void setCountry(String newCountry){
        this.country=newCountry;
    }

    @Override
    public String toString() {
        return "models.Persona{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", is_alive=" + is_alive +
                '}';
    }

    public String getId(){
        return id;
    }
    public void setId(String Id){
        this.id=Id;
    }




}
