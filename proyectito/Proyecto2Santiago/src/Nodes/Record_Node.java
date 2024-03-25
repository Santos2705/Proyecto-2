/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodes;


public class Record_Node {
    private String name;
    private String last_name;
    private String email;
    private String gender;
    private String arrival;
    private int id;
    private Record_Node left_son;
    private Record_Node right_son;

    public Record_Node(String name, String last_name, String email, String gender, String arrival, int id) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.arrival = arrival;
        this.id = id;
        this.right_son = null;
        this.left_son = null;
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
     * @return the HijoIzquierdo
     */
    public Record_Node getLeft_son() {
        return left_son;
    }

    /**
     * @param HijoIzquierdo the HijoIzquierdo to set
     */
    public void setLeft_son(Record_Node HijoIzquierdo) {
        this.left_son = HijoIzquierdo;
    }

    /**
     * @return the HijoDerecho
     */
    public Record_Node getRight_son() {
        return right_son;
    }

    /**
     * @param HijoDerecho the HijoDerecho to set
     */
    public void setRight_son(Record_Node HijoDerecho) {
        this.right_son = HijoDerecho;
    }

    
    
    
    
    
    
}
