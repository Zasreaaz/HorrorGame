package game.engine.java.api.base;

import java.util.ArrayList;

/**
 * Abstract class that represents a room the user can be in
 * All other room should extend this class
 */
public abstract class Room extends AbstractGameEntity {
    private ArrayList<GameObject> objects = new ArrayList<>();

    public Room(String id) {
        super(id);
    }

    /**
     * Method that finds a GameObject in the room based on the id of the GameObject
     *
     * @param id:id of the object to find
     * @returns GameObject, the GameObject with a matching id
     */
    public GameObject findObjectById(String id) {
//         TODO implement method -----
        for(GameObject object : objects) {
            if(object.getId().equals(id)) {
                return object;
            }
        }
        return null;
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }

}
