package business.entities;

public class Hobby {

    private int hobby_id;
    private String name;

    public Hobby(int hobby_id, String name) {
        this.hobby_id = hobby_id;
        this.name = name;
    }

    public int getHobby_id() {
        return hobby_id;
    }

    public String getName() {
        return name;
    }
}
