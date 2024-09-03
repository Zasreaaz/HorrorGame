/**
 * Class that holds data related to the games player session (current room, inventory etc)
 *
 */
export class PlayerSession {
    //The room the user is currently in
    private _currentRoom: string = "start_room";

    //the inventory of the user (keys, weapons)
    private _inventory: string[] = [];

    public constructor() {
    }

    public get inventory(): string[] {
        return this._inventory;
    }

    public set inventory(value: string[]) {
        this._inventory = value;
    }

    public get currentRoom(): string {
        return this._currentRoom;
    }

    public set currentRoom(value: string) {
        this._currentRoom = value;
    }


}