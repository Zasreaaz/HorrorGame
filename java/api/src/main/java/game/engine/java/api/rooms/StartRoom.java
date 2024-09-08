package game.engine.java.api.rooms;

import game.engine.java.api.base.Room;
import game.engine.java.api.items.Chest;
import game.engine.java.api.items.Door;
import game.engine.java.api.items.Table;

public class StartRoom extends Room {

    public StartRoom() {
        super("start_room");
        // TODO add more objects -----
        super.getObjects().add(new Door("door"));
        super.getObjects().add(new Chest("chest"));
        super.getObjects().add(new Table("table"));
    }

    public String getShortDescription() {
        return "Starting room";
    }

    public String getFullDescription() {
        return "A very strange room. There is a table, two boxes and a closed door";
    }
}
