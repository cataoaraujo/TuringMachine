/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachine;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class TuringMachine {

    private ArrayList<String> fita = new ArrayList<String>();
    private ArrayList<Estado> estados = new ArrayList<>();
    private Estado inicial;
    private ArrayList<Estado> estadosFinais = new ArrayList<>();

    private Estado atual;
    private int posicaoFita;

    public TuringMachine() {
        fita.add(Simbolo.InicioDaFita.toString());
    }

    public boolean processa() {
        fita.add(Simbolo.Branco.toString());

        posicaoFita = 0;
        while (atual != null) {
            String s = fita.get(posicaoFita);
            Transicao transicao = atual.processa(s);
            try {
                fita.set(posicaoFita, transicao.getNovoSimbolo());
                atual = transicao.getNovoEstado();
                if (transicao.getDirecao().equals(Transicao.Direcao.Direita)) {
                    posicaoFita++;
                } else {
                    if (posicaoFita > 0) {
                        posicaoFita--;
                    } else {
                        return false;
                    }
                }
                System.out.println(atual + " - Posição na Fita: " + posicaoFita);
                System.out.println(fita + "\n");
                if (estadosFinais.contains(atual)) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public ArrayList<String> getFita() {
        return fita;
    }

    public void addSimboloNaFita(String simbolo) {
        this.fita.add(simbolo);
    }

    public Estado getInicial() {
        return inicial;
    }

    public void setInicial(Estado inicial) {
        this.atual = inicial;
        this.inicial = inicial;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void addEstado(Estado estado) {
        estados.add(estado);
    }

    public ArrayList<Estado> getEstadosFinais() {
        return estadosFinais;
    }

    public void addEstadoFinal(Estado estado) {
        estadosFinais.add(estado);
    }

}
