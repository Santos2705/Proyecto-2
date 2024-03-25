/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Structures;

import Nodes.Tree_Reservation_Node;

public class BinarySearchTree_Reservations {

    Tree_Reservation_Node root;

    public BinarySearchTree_Reservations() {
        root = null;
    }

    public void newReservation(int id, String first_name, String last_name, String email, String gen, String room, String number, String arrival, String departure) {
        Tree_Reservation_Node newR = new Tree_Reservation_Node(id, first_name, last_name, email, gen, room, number, arrival, departure);
        if (this.root != null) {
            this.insert(newR, this.root);
        } else {
            this.root = newR;
        }
    }

    private void insert(Tree_Reservation_Node newReservation, Tree_Reservation_Node aux) {
        if (aux != null) {
            if (aux.getId() >= newReservation.getId()) {
                if (aux.getLeft_son() != null) {
                    this.insert(newReservation, aux.getLeft_son());
                } else {
                    aux.setLeft_son(newReservation);
                }
            } else if (aux.getId() < newReservation.getId()) {
                if (aux.getRight_son() != null) {
                    this.insert(newReservation, aux.getRight_son());
                } else {
                    aux.setRight_son(newReservation);
                }
            }
        }
    }
    
    public Tree_Reservation_Node sortTree(Tree_Reservation_Node aux) {
        if (aux == null) {
            return aux;
        }

        if (this.Balance(aux) == 2) {
            if (this.Balance(aux.getLeft_son()) < 0) {
                aux.setLeft_son(this.LeftRotation(aux.getLeft_son()));
            }
            aux = this.RightRotation(aux);
        } else if (this.Balance(aux) == -2) {
            if (this.Balance(aux.getRight_son()) > 0) {
                aux.setRight_son(this.RightRotation(aux.getRight_son()));
            }
            aux = this.LeftRotation(aux);
        }

        aux.setHeight(this.MaxNum(this.height(aux.getLeft_son()), this.height(aux.getRight_son())) + 1);

        return aux;
    }
    
    public int height(Tree_Reservation_Node aux) {
        if (aux == null) {
            return 0;
        }
        return aux.getHeight();
    }

    public void deleteReservation(int ci) {
        this.root = delete(this.root, ci);        
    }

    
    private Tree_Reservation_Node delete(Tree_Reservation_Node aux, int id) {
        if (aux == null) {
            return null;
        }

        if (id < aux.getId()) {
            
            aux.setLeft_son(delete(aux.getLeft_son(), id));
            
        } else if (id > aux.getId()) {

            aux.setRight_son(delete(aux.getRight_son(), id));

        } else {

            if (aux.getLeft_son() == null && aux.getRight_son() == null) {

                aux = null;

            } else if (aux.getLeft_son() == null) {

                aux = aux.getRight_son();

            } else if (aux.getRight_son() == null) {

                aux = aux.getLeft_son();

            } else {

                Tree_Reservation_Node minR = minReservation(aux.getRight_son());
                aux.setId(minR.getId());
                aux.setName(minR.getName());
                aux.setLast_name(minR.getLast_name());
                aux.setEmail(minR.getEmail());
                aux.setGender(minR.getGender());
                aux.setPhone(minR.getPhone());
                aux.setArrival(minR.getArrival());
                aux.setDeparture(minR.getDeparture());
                aux.setRight_son(delete(aux.getRight_son(), minR.getId()));
            }
        }

        if (aux != null) {
            
            aux.setHeight(1 + Math.max(Branch(aux.getLeft_son()), Branch(aux.getRight_son())));
            
            int balance = Branch(aux.getLeft_son()) - Branch(aux.getRight_son());

            if (balance > 1 && Branch(aux.getLeft_son().getLeft_son()) >= Branch(aux.getLeft_son().getRight_son())) {

                aux = RightRotation(aux);

            } else if (balance > 1 && Branch(aux.getLeft_son().getRight_son()) > Branch(aux.getLeft_son().getLeft_son())) {

                aux.setLeft_son(LeftRotation(aux.getLeft_son()));
                aux = RightRotation(aux);

            } else if (balance < -1 && Branch(aux.getRight_son().getRight_son()) >= Branch(aux.getRight_son().getLeft_son())) {

                aux = LeftRotation(aux);

            } else if (balance < -1 && Branch(aux.getRight_son().getLeft_son()) > Branch(aux.getRight_son().getRight_son())) {

                aux.setRight_son(RightRotation(aux.getRight_son()));
                aux = LeftRotation(aux);

            }
        }

        return aux;
    }

    private Tree_Reservation_Node minReservation(Tree_Reservation_Node aux) {
        if (aux.getLeft_son() == null) {
            return aux;
        }
        return minReservation(aux.getLeft_son());
    }

    public Tree_Reservation_Node RightRotation(Tree_Reservation_Node reservation) {
        Tree_Reservation_Node left_son = reservation.getLeft_son();
        Tree_Reservation_Node aux = left_son.getRight_son();

        left_son.setRight_son(reservation);
        reservation.setLeft_son(aux);

        reservation.setHeight(this.MaxNum(this.Branch(reservation.getLeft_son()), this.Branch(reservation.getRight_son())) + 1);
        left_son.setHeight(this.MaxNum(this.Branch(left_son.getLeft_son()), this.Branch(left_son.getRight_son())) + 1);

        return left_son;
    }

    public Tree_Reservation_Node LeftRotation(Tree_Reservation_Node reservation) {
        Tree_Reservation_Node right_son = reservation.getRight_son();
        Tree_Reservation_Node aux = right_son.getLeft_son();

        right_son.setLeft_son(reservation);
        reservation.setRight_son(aux);

        reservation.setHeight(this.MaxNum(this.Branch(reservation.getLeft_son()), this.Branch(reservation.getRight_son())) + 1);
        right_son.setHeight(this.MaxNum(this.Branch(right_son.getLeft_son()), this.Branch(right_son.getRight_son())) + 1);

        return right_son;
    }

    public int Balance(Tree_Reservation_Node aux) {
        if (aux == null) {
            return 0;
        }
        return this.Branch(aux.getLeft_son()) - this.Branch(aux.getRight_son());
    }

    public int Branch(Tree_Reservation_Node aux) {
        if (aux == null) {
            return 0;
        }
        return aux.getHeight();
    }

    public int MaxNum(int a, int b) {
        return (a > b) ? a : b;
    }
    public Tree_Reservation_Node searchReservation(int id) {
        return this.search(id, root);
    }

    private Tree_Reservation_Node search(int id, Tree_Reservation_Node aux) {
        if (aux != null) {
            Tree_Reservation_Node found = null;
            if (aux.getId() > id) {
                found = this.search(id, aux.getLeft_son());
            } else if (aux.getId() < id) {
                found = this.search(id, aux.getRight_son());
            } else {
                return aux;
            }
            return found;
        }
        return null;
    }

    public String showReservations(){
        return this.show(root, "");
    }
    
    private String show(Tree_Reservation_Node aux, String reservations) {
        if (aux != null) {
            reservations = this.show(aux.getLeft_son(), reservations);
            reservations += aux.getId() + "; ";
            reservations = this.show(aux.getRight_son(), reservations);

        }
        return reservations;
    }


}
