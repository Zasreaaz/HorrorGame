package game.engine.java.api.base;

/**
 * Abstract class that represents any form of object in the game
 * Abstract classes Room and GameObject extend this class
 */
abstract class AbstractGameEntity {
    private String id;

    public AbstractGameEntity(String id) {
        this.id = id;
    }

    public String getShortDescription() {
        return "A object";
    }

    public String getFullDescription() {
        return "A very nice object";
    }

    public String getId() {
        return id;
    }


}