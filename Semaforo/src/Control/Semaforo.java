/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author aluno
 */
public class Semaforo {

    private int tempoverde;
    private int tempoamarelo;
    private int tempovermelho;
    
    public Semaforo() {};
    public Semaforo(int tempoverde, int tempoamarelo, int tempovermelho){
        setTempoverde(tempoverde);
        setTempoamarelo(tempoamarelo);
        setTempovermelho(tempovermelho);
    }
    /**
     * @return the tempoverde
     */
    public int getTempoverde() {
        return tempoverde;
    }

    /**
     * @param tempoverde the tempoverde to set
     */
    public void setTempoverde(int tempoverde) {
        this.tempoverde = tempoverde;
    }

    /**
     * @return the tempoamarelo
     */
    public int getTempoamarelo() {
        return tempoamarelo;
    }

    /**
     * @param tempoamarelo the tempoamarelo to set
     */
    public void setTempoamarelo(int tempoamarelo) {
        this.tempoamarelo = tempoamarelo;
    }

    /**
     * @return the tempovermelho
     */
    public int getTempovermelho() {
        return tempovermelho;
    }

    /**
     * @param tempovermelho the tempovermelho to set
     */
    public void setTempovermelho(int tempovermelho) {
        this.tempovermelho = tempovermelho;
    }

}
