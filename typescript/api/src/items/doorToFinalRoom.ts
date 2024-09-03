import {PlayerSession} from "../playerSession";
import {GameObject} from "../base/gameObject";

export class DoorToFinalRoom extends GameObject {

    public open(_playerSession: PlayerSession): string {
        if (_playerSession.inventory.includes("golden key")) {
            _playerSession.inventory.push("win");
            _playerSession.currentRoom = "final_room";
            return "You use the golden key and the door opens ";
        }
        return "The door is locked";
    }

    public getShortDescription(): string {
        return "A closed door";
    }

    public getFullDescription(): string {
        return "A door that is closed";
    }

}