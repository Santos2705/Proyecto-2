/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodes;


public class Tree_Reservation_Node {
    private int id;
    private String name;
    private String last_name;
    private String email;
    private String gender;
    private String typeRoom;
    private String phone;
    private String arrival;
    private String departure;
    private Tree_Reservation_Node left_son;
    private Tree_Reservation_Node right_son;
    private int height;

    public Tree_Reservation_Node(int id, String name, String last_name, String email, String gender, String typeRoom, String phone, String arrival, String departure) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.typeRoom = typeRoom;
        this.phone = phone;
        this.arrival = arrival;
        this.departure = departure;
        this.left_son = null;
        this.right_son = null;
        this.height = 0;
    }
    
    @Override
    public String toString(){
        return "------------------------------------------------------\nNombre: " + this.name + " " + this.last_name + "\nCorreo: " + this.email + "\nGenero: " + this.gender 
                + "\nCelular: " + this.phone + "\nFecha de Llegada: " +this.arrival + "\nFecha de Salida: " + this.departure;
    }

    /**
     * @return the ci
     */
    public int getId() {
        return id;
    }

    /**
     * @param ci the ci to set
     */
    public void setId(int ci) {
        this.id = ci;
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
     * @return the fecha_salida
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param fecha_salida the fecha_salida to set
     */
    public void setDeparture(String fecha_salida) {
        this.departure = fecha_salida;
    }

    /**
     * @return the HijoIzquierdo
     */
    public Tree_Reservation_Node getLeft_son() {
        return left_son;
    }

    /**
     * @param HijoIzquierdo the HijoIzquierdo to set
     */
    public void setLeft_son(Tree_Reservation_Node HijoIzquierdo) {
        this.left_son = HijoIzquierdo;
    }

    /**
     * @return the HijoDerecho
     */
    public Tree_Reservation_Node getRight_son() {
        return right_son;
    }

    /**
     * @param HijoDerecho the HijoDerecho to set
     */
    public void setRight_son(Tree_Reservation_Node HijoDerecho) {
        this.right_son = HijoDerecho;
    }

    /**
     * @return the altura
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param altura the altura to set
     */
    public void setHeight(int altura) {
        this.height = altura;
    }
    
    
}
