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
public class Transicao {

    public enum Direcao {
        Direita,
        Esquerda
    }
    private String simbolo;
    private Estado estado;
    private Direcao direcao;

    public Transicao(String simbolo, Estado estado, Direcao direcao) {
        this.estado = estado;
        this.simbolo = simbolo;
        this.direcao = direcao;
    }

    public String getNovoSimbolo() {
        return simbolo;
    }

    public Estado getNovoEstado() {
        return estado;
    }

    public Direcao getDirecao() {
        return direcao;
    }
    
}
