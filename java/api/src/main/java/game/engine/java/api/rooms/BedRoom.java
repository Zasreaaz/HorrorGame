package game.engine.java.api.rooms;

import game.engine.java.api.base.Room;
import game.engine.java.api.items.Bed;


public class BedRoom extends Room {

    public BedRoom() {
        super("bed_room");
        // TODO add more objects -----
        super.getObjects().add(new Bed("bed"));

    }

    public String getShortDescription() {
        return "Bedroom";
    }

    public String getFullDescription() {
        return "A very small room with nothing inside but a bed with a big pile coins on it ";
    }
}
