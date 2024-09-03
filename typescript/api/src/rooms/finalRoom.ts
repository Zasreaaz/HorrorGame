import {Room} from "../base/room";

export class FinalRoom extends Room {

    public constructor() {
        super("final_room");
    }

    public getShortDescription(): string {
        return "Last room";
    }

    public getFullDescription(): string {
        return "A very nice room, with your missing cat! You have won!";
    }

}