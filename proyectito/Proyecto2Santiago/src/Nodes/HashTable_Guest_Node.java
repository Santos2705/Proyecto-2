/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodes;


public class HashTable_Guest_Node {
    private String name;
    private String last_name;
    private String email;
    private String gender;
    private String arrival;
    private String phone;
    private int room;
    private HashTable_Guest_Node pNext;

    public HashTable_Guest_Node(String name, String last_name, String email, String genre, String phone, String arrival, int room) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.gender = genre;
        this.arrival = arrival;
        this.phone = phone;
        this.room = room;
        pNext = null;
    }
    
    @Override
    public String toString(){
        return "-Nombre: " + this.name + " " + this.last_name + "\n-Correo: "+ this.email + "\n-Genero: "+this.gender + "\n-Celular: "+this.phone + "\n-Fecha de Llegada: " + this.arrival + "\n-Habitacion #" + this.room;
    }

    /**
     * @return the primer_nombre
     */
    public String getName() {
        return name;
    }

    /**
     * @param primer_nombre the primer_nombre to set
     */
    public void setName(String primer_nombre) {
        this.name = primer_nombre;
    }

    /**
     * @return the segundo_nombre
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param segundo_nombre the segundo_nombre to set
     */
    public void setLast_name(String segundo_nombre) {
        this.last_name = segundo_nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the genero
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param genero the genero to set
     */
    public void setGender(String genero) {
        this.gender = genero;
    }

    /**
     * @return the llegada
     */
    public String getArrival() {
        return arrival;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setArrival(String llegada) {
        this.arrival = llegada;
    }

    /**
     * @return the celular
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param celular the celular to set
     */
    public void setPhone(String celular) {
        this.phone = celular;
    }

    /**
     * @return the num_hab
     */
    public int getRoom() {
        return room;
    }

    /**
     * @param num_hab the num_hab to set
     */
    public void setRoom(int num_hab) {
        this.room = num_hab;
    }

    /**
     * @return the pNext
     */
    public HashTable_Guest_Node getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(HashTable_Guest_Node pNext) {
        this.pNext = pNext;
    }
}
