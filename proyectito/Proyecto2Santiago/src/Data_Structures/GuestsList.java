/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import Nodes.HashTable_Guest_Node;

public class GuestsList {

    HashTable_Guest_Node pFirst;
    HashTable_Guest_Node pLast;

    public GuestsList() {
        this.pFirst = null;
    }

    public void insertList(String name, String last_name, String email, String gender, String phone, String arrival, int hab) {
        HashTable_Guest_Node newGuest = new HashTable_Guest_Node(name, last_name, email, gender, phone, arrival, hab);
        if (this.pFirst == null) {
            this.pFirst = this.pLast = newGuest;
        } else {
            this.pLast.setpNext(newGuest);
            this.pLast = newGuest;
        }
    }

    public void deleteList(String name, String last_name) {
        if (this.pFirst != null) {
            if (this.pFirst.getName().toLowerCase().equals(name) || this.pFirst.getLast_name().toLowerCase().equals(last_name)) {
                HashTable_Guest_Node aux = this.pFirst;
                while (aux.getpNext() != null && (!aux.getpNext().getName().toLowerCase().equals(name)) || !aux.getpNext().getLast_name().toLowerCase().equals(last_name)) {
                    aux = aux.getpNext();
                }
                if (aux.getpNext() != null) {
                    aux.setpNext(aux.getpNext().getpNext());
                }
            } else {
                this.pFirst = this.pFirst.getpNext();
            }
        }
    }

    public HashTable_Guest_Node searchList(String name, String last_name) {
        if (this.pFirst != null) {
            HashTable_Guest_Node aux = this.pFirst;
            while (aux != null && (!aux.getName().toLowerCase().equals(name)) || !aux.getLast_name().toLowerCase().equals(last_name)) {
                aux = aux.getpNext();
            }
            return aux;
        }
        return null;
    }
    
    
}
