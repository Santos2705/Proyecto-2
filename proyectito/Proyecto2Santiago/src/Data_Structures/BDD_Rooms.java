/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import Nodes.Tree_Room_Node;

public class BDD_Rooms {

    Tree_Room_Node[] rooms;

    public BDD_Rooms() {
        this.rooms = new Tree_Room_Node[300];
        for (int i = 0; i < 300; i++) {
            this.rooms[i] = null;
        }
    }

    public void createRoom(int number, int floor, String typeRoom) {
        rooms[number-1] = new Tree_Room_Node(number, floor, typeRoom);
    }

    public Tree_Room_Node searchRoom(int number) {
        return this.rooms[number-1];
    }

    public String searchRoomRecord(int number) {
        return this.rooms[number-1].getRecord_tree().showRecord(rooms[number-1].getRecord_tree().root, "");
    }

    public void addNewRecord(int number, String name, String last_name, String email, String gender, String arrival, int id) {
        this.rooms[number-1].getRecord_tree().addRecord(name, last_name, email, gender, arrival, id);
    }
    
    public Tree_Room_Node emptyRoom(String typeRoom){
        for (int i = 0; i < 300; i++) {
            if(this.rooms[i].getTypeRoom().equals(typeRoom) && !this.rooms[i].isOccupied()){
                return this.rooms[i];
            }
        }
        return null;
    }
}
