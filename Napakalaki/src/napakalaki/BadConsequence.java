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
public class BadConsequence {
    
    private static final int MAXTREASURES = 5;
    
    private String text;
    private int levels , nVisibleTreasures , nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence( String text , int levels , int nVisible , int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    public BadConsequence( String text, boolean death){
        this.text = text;
        this.death = death;
        this.levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
    }
    public BadConsequence( String text , int levels , ArrayList<TreasureKind> tVisible , ArrayList<TreasureKind> tHidden ){
        this.text = text;
        this.levels = levels;
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        
    }
    public boolean isEmpty(){
        if ( (nVisibleTreasures == 0 && nHiddenTreasures == 0) && (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty()) ){
            return true;
        }
        return false;
    }
    public void substractVisibleTreasure(Treasure t){
        if( specificVisibleTreasures.contains(t.getType()) ){
            specificVisibleTreasures.remove(t.getType());
        }
        else if ( nVisibleTreasures > 0 ){
            nVisibleTreasures--;
        }
    }
    public void substractHiddenTreasure( Treasure t ){
        if( specificHiddenTreasures.contains(t.getType()) ){
            specificHiddenTreasures.remove(t.getType());
        }
        else if( nHiddenTreasures > 0 ){
            nHiddenTreasures--; 
        }
        
    }
    public BadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v , ArrayList<Treasure> h ){
        int nv , nh;
        ArrayList<TreasureKind>  av = new ArrayList();
        ArrayList<TreasureKind> ah = new ArrayList();
        
        if( this.getnVisibleTreasures() == 0 && this.getnHiddenTreasures() == 0 ){
            for( Treasure t : v ){
                if( this.getspecificVisibleTreasures().contains(t.getType()) && !av.contains(t.getType())){
                    av.add(t.getType());
                }
            }
            for( Treasure t : h ){
                if( this.getspecificHiddenTreasures().contains(t.getType()) && !ah.contains(t.getType())){
                    ah.add(t.getType());
                }
            }
            BadConsequence res = new BadConsequence(this.getText(),0,av,ah);
            return res;
        }
        if( this.getnVisibleTreasures() == 0 ){
            nv = 0;
        }
        else{
            nv = v.size();
        }
        if ( this.getnHiddenTreasures() == 0 ){
            nh = 0;
        }
        else{
            nh = h.size();
        }
        BadConsequence res = new BadConsequence(this.getText(),0,nv,nh);
        return res;
        
    }
    public static int getMaxTreasures(){
        return MAXTREASURES;
    }
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
    public boolean getDeath(){
        return death;
    }
    public ArrayList<TreasureKind> getspecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    public ArrayList<TreasureKind> getspecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    public String toString(){
        return "Texo: " + text + " Niveles: " + Integer.toString(levels) + " NºTesoros visibles: " +
                Integer.toString(nVisibleTreasures) + " NºTesoros ocultos: " + Integer.toString(nHiddenTreasures) +
                " Muerto: " + death + " Tesoros especificos ocultos = " + specificHiddenTreasures + 
                " Tesoros especificos visibles = " + specificVisibleTreasures;
    }
}
