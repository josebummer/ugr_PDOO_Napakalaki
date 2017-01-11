/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class DeathBadConsequence extends NumericBadConsequence {
    
    private boolean death;
    
    public DeathBadConsequence( String text, boolean death){
        super(text,Player.MAXLEVEL,BadConsequence.getMaxTreasures(),BadConsequence.getMaxTreasures());
        this.death = death;
    }
    
    @Override
    public boolean isEmpty(){
        return super.isEmpty();
    }
    
    public boolean getDeath(){
        return death;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Muerto: " + death;
    }
    
}
