/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachine;

import java.util.HashMap;
import turingmachine.Transicao.Direcao;

/**
 *
 * @author Rodrigo
 */
public class Estado {

    // Order: Simbolo Lido -- Simbolo a ser gravado -- Novo estado gerado
    private HashMap<String, Transicao> programa = new HashMap<>();
    private String nome;

    public Estado(String nome) {
        this.nome = nome;
    }

    
    public String getNome() {
        return nome;
    }
    
    public void addFuncaoPrograma(String simboloLido, String simboloGravado, Estado novoEstado, Direcao direcao) {
        Transicao t = new Transicao(simboloGravado, novoEstado, direcao);
        programa.put(simboloLido, t);
    }

    /**
     * Estado corrente = this 
     * Simbolo lido = @param simbolo
     * @return Transicao
     */
    public Transicao processa(String simbolo) {
        if (programa.containsKey(simbolo)) {
            Transicao t = programa.get(simbolo);
            return t;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Estado{" + "nome=" + nome + '}';
    }
    
    

}
