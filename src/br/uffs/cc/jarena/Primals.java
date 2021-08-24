/**
 * Integrantes da equipe:
 *
 * @author Matheus Giordani
**/

package br.uffs.cc.jarena;

public class Primals extends Agente {
    private boolean worthCombat;
    private int longWait;
    /**
     * Construtor da classe.
     *
     * @param x       posição X no mapa onde o agente vai nascer.
     * @param y       posição Y no mapa onde o agente vai nascer.
     * @param energia quantidade e energia inicial agente.
     */
    public Primals(Integer x, Integer y, Integer energia) {
        super(x, y, energia);
        worthCombat = false;
        longWait = 5;
    }

    @Override
    public void pensa() {
        if (isParado()) longWait--;

        if (getEnergia() > 1000) {
            divide();
        }

        if (longWait <= 0) {
            worthCombat = false;
            longWait = 5;
            setDirecao(geraDirecaoAleatoria());
        }

        if(!podeMoverPara(getDirecao())) {
            setDirecao(geraDirecaoAleatoria());
        }
    }

    @Override
    public void recebeuEnergia() {
        para();
        longWait++;
    }

    @Override
    public void tomouDano(int energiaRestanteInimigo) {
        worthCombat = false;

        worthCombat = energiaRestanteInimigo + 20 < getEnergia();
        if (worthCombat) {
            para();
        }
    }

    @Override
    public void ganhouCombate() {

    }

    @Override
    public void recebeuMensagem(String msg) {

    }

    @Override
    public String getEquipe() {
        return "Primals";
    }
}
