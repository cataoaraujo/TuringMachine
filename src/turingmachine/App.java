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
public class App {
    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine();
        tm.addSimboloNaFita("a");
        tm.addSimboloNaFita("a");
        tm.addSimboloNaFita("a");
        tm.addSimboloNaFita("b");
        tm.addSimboloNaFita("b");
        tm.addSimboloNaFita("b");
        
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");
        Estado q4 = new Estado("q4");
        
        
        q0.addFuncaoPrograma("a", "A", q1, Transicao.Direcao.Direita);
        q0.addFuncaoPrograma(Simbolo.InicioDaFita.toString(), Simbolo.InicioDaFita.toString(), q0, Transicao.Direcao.Direita);
        q0.addFuncaoPrograma(Simbolo.Branco.toString(), Simbolo.Branco.toString(), q4, Transicao.Direcao.Direita);
        q0.addFuncaoPrograma("B", "B", q3, Transicao.Direcao.Direita);
        
        q1.addFuncaoPrograma("a", "a", q1, Transicao.Direcao.Direita);
        q1.addFuncaoPrograma("B", "B", q1, Transicao.Direcao.Direita);
        q1.addFuncaoPrograma("b", "B", q2, Transicao.Direcao.Esquerda);
        
        q2.addFuncaoPrograma("a", "a", q2, Transicao.Direcao.Esquerda);
        q2.addFuncaoPrograma("B", "B", q2, Transicao.Direcao.Esquerda);
        q2.addFuncaoPrograma("A", "A", q0, Transicao.Direcao.Direita);
        
        q3.addFuncaoPrograma("B", "B", q3, Transicao.Direcao.Direita);
        q3.addFuncaoPrograma(Simbolo.Branco.toString(), Simbolo.Branco.toString(), q4, Transicao.Direcao.Esquerda);
        
        
        tm.addEstado(q0);
        tm.addEstado(q1);
        tm.addEstado(q2);
        tm.addEstado(q3);
        tm.addEstado(q4);
        
        tm.setInicial(q0);
        tm.addEstadoFinal(q4);
        
        System.out.println(tm.processa());
        
    }
    
}
