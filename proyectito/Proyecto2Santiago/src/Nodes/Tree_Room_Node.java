/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodes;

import Data_Structures.BinarySearchTree_Record;


public class Tree_Room_Node {
   private int number;
   private int floor;
   private String typeRoom;
   private BinarySearchTree_Record record_tree;
   private boolean occupied;

    public Tree_Room_Node(int number, int floor, String typeRoom) {
        this.number = number;
        this.floor = floor;
        this.typeRoom = typeRoom;
        record_tree = new BinarySearchTree_Record();
        occupied = false;
    }

    /**
     * @return the numero_hab
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param numero_hab the numero_hab to set
     */
    public void setNumber(int numero_hab) {
        this.number = numero_hab;
    }

    /**
     * @return the piso
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @param piso the piso to set
     */
    public void setFloor(int piso) {
        this.floor = piso;
    }

    /**
     * @return the tipo
     */
    public String getTypeRoom() {
        return typeRoom;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTypeRoom(String tipo) {
        this.typeRoom = tipo;
    }

    /**
     * @return the historial
     */
    public BinarySearchTree_Record getRecord_tree() {
        return record_tree;
    }

    /**
     * @param historial the historial to set
     */
    public void setRecord_tree(BinarySearchTree_Record historial) {
        this.record_tree = historial;
    }

    /**
     * @return the ocupada
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * @param ocupada the ocupada to set
     */
    public void setOccupied(boolean ocupada) {
        this.occupied = ocupada;
    }
   
   
}
