package fr.univ_lille1.iut_info.fablety.coachsportif;

/**
 * Created by fablety on 27/03/17.
 */

public class User {
    public  String alias;
    public int id;
    public String name;


    public User(String alias, String name, int id) {
        this.alias = alias;
        this.name = name;
        this.id = id;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "Alias='" + alias + '\'' +
                ", Id=" + id +
                ", Name='" + name + '\'' +
                '}';
    }
}
