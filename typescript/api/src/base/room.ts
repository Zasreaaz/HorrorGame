import {GameObject} from "./gameObject";
import {AbstractGameEnity} from "./abstractGameEnity";

/**
 * Abstract class that represents a room the user can be in
 * All other room should extend this class
 */
export class Room extends AbstractGameEnity {

    //Objects in room
    private _objects: GameObject[] = [];


    /**
     * Method that finds a GameObject in the room based on the id of the GameObject
     *
     * @param id:id of the object to find
     *
     * @returns GameObject, the GameObject with a matching id
     */
    public findObjectById(id: string):GameObject | undefined{
        for (const gameObject:GameObject of this.objects) {
            if (gameObject.id === id){
                return gameObject;
            }
        }
     return undefined;
    }


    public get objects(): GameObject[] {
        return this._objects;
    }


}