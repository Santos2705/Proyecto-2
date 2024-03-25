/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import Data_Structures.GuestsList;
import Nodes.HashTable_Guest_Node;


public class HashTable_Clients {
    GuestsList[] bdd_clients;
    int size;
    
    public HashTable_Clients(){
        this.bdd_clients = new GuestsList[350];
        this.size = 350;
        for (int i = 0; i < 350; i++) {
            this.bdd_clients[i] = new GuestsList();
            
        }
    }
    
    public int hash(String name, String last_name){
        int hash = 37;
        
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i)*i;
        }
        
        for (int i = 0; i < last_name.length(); i++) {
            hash += last_name.charAt(i)*i;
        }
        int pos = hash % this.size;
        return pos;
    }
    
    public void newGuest(String name, String last_name, String email, String gender, String arrival, String phone, int hab){
        this.bdd_clients[this.hash(name.toLowerCase(),last_name.toLowerCase())].insertList( name,  last_name,  email,  gender,  arrival,  phone,  hab);
    }
    
    public void deleteGuest(String name, String last_name){
        this.bdd_clients[this.hash(name.toLowerCase(),last_name.toLowerCase())].deleteList( name.toLowerCase(),  last_name.toLowerCase());
    }
    
    public HashTable_Guest_Node searchGuest(String name, String last_name){
        return this.bdd_clients[this.hash(name.toLowerCase(),last_name.toLowerCase())].searchList( name.toLowerCase(),  last_name.toLowerCase());
    }
    
    public String showGuest(String name, String last_name){
        return this.bdd_clients[this.hash(name.toLowerCase(),last_name.toLowerCase())].searchList( name.toLowerCase(),  last_name.toLowerCase()).toString();
    }
}
