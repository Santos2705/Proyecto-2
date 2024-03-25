/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import Nodes.HashTable_Guest_Node;
import Data_Structures.HashTable_Clients;
import Data_Structures.BinarySearchTree_Reservations;
import Data_Structures.BDD_Rooms;
import Nodes.Tree_Room_Node;
import Nodes.Tree_Reservation_Node;


public class Hotel_Administration {
    public BinarySearchTree_Reservations bdd_reservaciones;
    public HashTable_Clients bdd_clientes;
    public BDD_Rooms bdd_habitaciones;

    public Hotel_Administration(BinarySearchTree_Reservations bdd_reservations, HashTable_Clients bdd_clients, BDD_Rooms bdd_rooms) {
        this.bdd_reservaciones = bdd_reservations;
        this.bdd_clientes = bdd_clients;
        this.bdd_habitaciones = bdd_rooms;
    }
    
    public String Check_in(int id) {
        Tree_Reservation_Node client_reservation = bdd_reservaciones.searchReservation(id);
        if (client_reservation != null) {
            Tree_Room_Node emptyRoom = bdd_habitaciones.emptyRoom(client_reservation.getTypeRoom());
            if (emptyRoom != null) {                
                this.bdd_clientes.newGuest( client_reservation.getName(), client_reservation.getLast_name(), client_reservation.getEmail(), client_reservation.getGender(),client_reservation.getArrival(), client_reservation.getPhone(), emptyRoom.getNumber());
                this.bdd_reservaciones.deleteReservation(id);
                emptyRoom.setOccupied(true);
                
                
                return "El cliente será asignado a la habitación #" + emptyRoom.getNumber()+ ". Disfrute su estadía.";
            } else {
                return "El hotel se encuentra lleno";
            }
        } else {
            return "El cliente no ha reealizado ninguna reserva";
        }
    }

    public String Check_out(String name, String last_name, int id) {
        HashTable_Guest_Node guest = bdd_clientes.searchGuest(name, last_name);
        if (guest != null) {
            Tree_Room_Node room = this.bdd_habitaciones.rooms[guest.getRoom()-1];
            if (room != null) {      
                bdd_habitaciones.addNewRecord(room.getNumber(), name, last_name, guest.getEmail(), guest.getGender(), guest.getArrival(), id);
                bdd_clientes.deleteGuest(name, last_name);
                room.setOccupied(false);
                return "Gracias por visitarnos! La habitación " + room.getNumber() + " ahora se encuentra desocpuada.";
            }
        }
        return "Revise los datos e intente nuevamente.";
    }
    
    

}
