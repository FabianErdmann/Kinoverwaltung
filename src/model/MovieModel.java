package model;

public class MovieModel {

    private int id;
    private String name;
    private int lauflaengeMin;
    private byte fskFreigabe;

    public MovieModel(int id, String name, int lauflaengeMin, byte fskFreigabe) {
        this.id = id;
        this.name = name;
        this.lauflaengeMin = lauflaengeMin;
        this.fskFreigabe = fskFreigabe;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLauflaengeMin() {
        return lauflaengeMin;
    }

    public void setLauflaengeMin(int lauflaengeMin) {
        this.lauflaengeMin = lauflaengeMin;
    }

    public byte getFskFreigabe() {
        return fskFreigabe;
    }

    public void setFskFreigabe(byte fskFreigabe) {
        this.fskFreigabe = fskFreigabe;
    }
}
