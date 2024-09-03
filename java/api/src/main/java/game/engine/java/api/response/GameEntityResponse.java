package game.engine.java.api.response;

/**
 * Class represent rooms or gameobjects, that is returned to the client
 */
public class GameEntityResponse {
    private String id;
    private String shortDescription;
    private String fullDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
