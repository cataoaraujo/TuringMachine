/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turingmachine;

/**
 *
 * @author Rodrigo
 */
public enum Simbolo {
    Branco ("-"),
    InicioDaFita ("#");
    
    private final String name;       

    private Simbolo(String s) {
        name = s;
    }

    public String toString(){
       return name;
    }
}
