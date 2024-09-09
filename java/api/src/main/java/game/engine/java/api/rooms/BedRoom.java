package game.engine.java.api.rooms;

import game.engine.java.api.base.Room;
import game.engine.java.api.items.Bed;
import game.engine.java.api.items.Closet;
import game.engine.java.api.items.Trapfloor;


public class BedRoom extends Room {

    public BedRoom() {
        super("bed_room");
        // TODO add more objects -----
        super.getObjects().add(new Bed("bed"));
        super.getObjects().add(new Closet("closet"));
        super.getObjects().add(new Trapfloor("trapfloor"));

    }

    public String getShortDescription() {
        return "Bedroom";
    }

    public String getFullDescription() {
        return "A very small room with nothing inside but a bed with a big pile coins on it ";
    }
}
