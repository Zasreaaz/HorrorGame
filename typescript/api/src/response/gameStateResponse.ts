import {GameEntityResponse} from "./gameEntityResponse";

/**
 * Class that holds data, related to the game state, that is returned to the client
 *
 */
export class GameStateResponse {
    public currentRoom: GameEntityResponse | undefined;
    public objectsInRoom: GameEntityResponse[] = [];
    public lastActionResult: string = "";
}