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
public class NumericBadConsequence extends BadConsequence {
    
    private int nVisibleTreasures , nHiddenTreasures;
    
    public NumericBadConsequence( String text , int levels , int nVisible , int nHidden){
        super(text,levels);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    @Override
    public boolean isEmpty(){
        if ( nVisibleTreasures == 0 && nHiddenTreasures == 0 ){
            return true;
        }
        return false;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if ( nVisibleTreasures > 0 ){
            nVisibleTreasures--;
        }
    }
    
    @Override
    public void substractHiddenTreasure( Treasure t ){
        if( nHiddenTreasures > 0 ){
            nHiddenTreasures--; 
        }
    }
    
    @Override
    public NumericBadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v , ArrayList<Treasure> h ){
        int nv , nh;
        
        if( this.getnVisibleTreasures() == 0 ){
            nv = 0;
        }
        else if( this.getnVisibleTreasures() < v.size() ){
            nv = this.getnVisibleTreasures();
        }
        else{
            nv = v.size();
        }
        if ( this.getnHiddenTreasures() == 0 ){
            nh = 0;
        }
        else if( this.getnHiddenTreasures() < h.size() ){
            nh = this.getnHiddenTreasures();
        }
        else{
            nh = h.size();
        }
        NumericBadConsequence res = new NumericBadConsequence(this.getText(),0,nv,nh);
        return res;  
    }
    
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    @Override
    public String toString(){
        return super.toString() + " NºTesoros visibles: " + Integer.toString(nVisibleTreasures) + " NºTesoros ocultos: " + Integer.toString(nHiddenTreasures);
    }
    
}
