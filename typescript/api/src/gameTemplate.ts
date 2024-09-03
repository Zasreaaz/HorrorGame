import {FinalRoom} from "./rooms/finalRoom";
import {StartRoom} from "./rooms/startRoom";
import {GameOverRoom} from "./rooms/gameOverRoom";
import {Room} from "./base/room";

/**
 * Class that holds data related to the game design (all rooms, that first room ect)
 *
 */
export class GameTemplate {
    private static instance: GameTemplate;

    //All room in the game
    private _rooms: Room[] = [];

    //The room the gamer is in when the game starts
    //Should also be in rooms
    private _startRoom: Room = new StartRoom();

    private constructor() {
        this._rooms.push(this._startRoom);
        this._rooms.push(new FinalRoom());
        this._rooms.push(new GameOverRoom());
    }

    public getRoom(roomId: string): Room {
        const room: Room | undefined = this._rooms.find(function (room) {
            return room.id === roomId;
        });
        if (room) {
            return room;
        }
        console.log("Error room not found");
        return this._startRoom;
    }

    /**
     * Static method that returns the one and only instance (Singleton)
     *
     */
    public static getInstance(): GameTemplate {
        if (this.instance === undefined) {
            this.instance = new GameTemplate();
        }
        return this.instance;
    }

}