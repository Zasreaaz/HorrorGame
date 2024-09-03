import {Room} from "../base/room";

export class GameOverRoom extends Room {

    public static id: string = "game_over_room";

    public constructor() {
        super(GameOverRoom.id);
    }

    public getShortDescription(): string {
        return "Game over!";
    }

    public getFullDescription(): string {
        return "Game over! Click on (Re)Start game for a new try";
    }

}