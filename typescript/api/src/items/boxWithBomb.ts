import {PlayerSession} from "../playerSession";
import {GameObject} from "../base/gameObject";
import {GameOverRoom} from "../rooms/gameOverRoom";

export class BoxWithBomb extends GameObject {

    public open(playerSession: PlayerSession): string {
        playerSession.currentRoom = GameOverRoom.id;
        return "BOEM! A bomb explodes and your dead!";
    }

    public getShortDescription(): string {
        return "A small golden box";
    }

    public getFullDescription(): string {
        return "A small, golden and beautiful box";
    }

}