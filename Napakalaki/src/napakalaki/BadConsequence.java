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
public abstract class BadConsequence {
    
    private static final int MAXTREASURES = 5;
    
    private String text;
    private int levels;
    
    public BadConsequence(String text , int levels){
        this.text = text;
        this.levels = levels;
    }
    
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure( Treasure t );
    
    public abstract BadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v , ArrayList<Treasure> h );
    
    public static int getMaxTreasures(){
        return MAXTREASURES;
    }
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    
    public String toString(){
        return "Texo: " + text + " Niveles: " + Integer.toString(levels);
    }
}
