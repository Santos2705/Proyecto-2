/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import Nodes.Record_Node;

public class BinarySearchTree_Record {

    public Record_Node root;

    public BinarySearchTree_Record() {
        root = null;
    }

    public void addRecord(String name, String last_name, String email, String gen, String arrival, int id) {
        Record_Node newH = new Record_Node(name, last_name, email, gen, arrival, id);
        if (this.root == null) {
            this.root = newH;
        } else {
            this.insert(newH, this.root);
        }
    }

    private void insert(Record_Node data, Record_Node aux) {
        if (aux != null) {
            if (aux.getId() >= data.getId()) {
                if (aux.getLeft_son() != null) {
                    this.insert(data, aux.getLeft_son());
                } else {
                    aux.setLeft_son(data);
                }
            } else if (aux.getId() < data.getId()) {
                if (aux.getRight_son() != null) {
                    this.insert(data, aux.getRight_son());
                } else {
                    aux.setRight_son(data);
                }
            }
        }
    }
    
    public String showRecord(Record_Node aux, String record) {
        if (aux != null) {
            record = this.showRecord(aux.getLeft_son(), record);
            record += "Cliente " +aux.getName()+ " " + aux.getLast_name()+ "\n    -Correo: " + aux.getEmail() + "\n   -Genero: " + aux.getGender()+ 
                    "\n    -Fecha Llegada: " + aux.getArrival()+ "\n";
            record = this.showRecord(aux.getRight_son(), record);

        }
        return record;
    }
}
