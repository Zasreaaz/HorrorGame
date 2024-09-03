package game.engine.java.api;

import game.engine.java.api.base.Room;
import game.engine.java.api.rooms.BedRoom;
import game.engine.java.api.rooms.StartRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds data related to the game design (all rooms, that first room ect)
 */
public class GameTemplate {
    private static GameTemplate instance;
    private List<Room> rooms = new ArrayList();
    private Room startRoom = new StartRoom();
    private Room BedRoom = new BedRoom();

    private GameTemplate() {
        // TODO add other rooms -----
        this.rooms.add(this.BedRoom);
        this.rooms.add(this.startRoom);
    }

    /**
     * Static method that returns the one and only instance (Singleton)
     */
    public static GameTemplate getInstance() {
        if (GameTemplate.instance == null) {
            GameTemplate.instance = new GameTemplate();
        }
        return GameTemplate.instance;
    }

    // TODO return the room in this.rooms with matching id instead of the startRoom -----
    public Room getRoomById(String id) {
        for (Room room : this.rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public Room getBedRoom() {
        return BedRoom;
    }

    public void setBedRoom(Room BedRoom) {
        this.BedRoom = BedRoom;
    }


}
