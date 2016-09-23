package Model;

/**
 * Created by eladh_000 on 22/9/2016.
 */
public class Entity {
    private int Id;

    public Entity(){};
    public Entity(int id){
        Id = id;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
