import {GameStateResponse} from "./response/gameStateResponse";
import {Room} from "./base/room";
import {GameEntityResponse} from "./response/gameEntityResponse";

/**
 * Builder class to  build responseObjects (that are send to client)
 *
 */
export class ResponseBuilder {

    /**
     * Handle a custom action
     *
     * @param room where the gamers is located
     * @param gameStateResponse GameStateResponse that need to be filled
     *
     */
    public static fillResponse(room: Room, gameState: GameStateResponse): void {
        const roomObject: GameEntityResponse = new GameEntityResponse();
        roomObject.fullDescription = room.getFullDescription();
        roomObject.shortDescription = room.getShortDescription();
        roomObject.id = room.id;
        gameState.currentRoom = roomObject;
        room.objects.forEach(function (object) {
            const objectInRoom: GameEntityResponse = new GameEntityResponse();
            objectInRoom.id = object.id;
            objectInRoom.fullDescription = object.getFullDescription();
            objectInRoom.shortDescription = object.getShortDescription();
            gameState.objectsInRoom.push(objectInRoom);
        });
        return;
    }


}