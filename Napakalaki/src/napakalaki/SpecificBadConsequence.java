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
public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public SpecificBadConsequence( String text , int levels , ArrayList<TreasureKind> tVisible , ArrayList<TreasureKind> tHidden ){
        super(text,levels);
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }
    
    @Override
    public boolean isEmpty(){
        if ( specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty() ){
            return true;
        }
        return false;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if( specificVisibleTreasures.contains(t.getType()) ){
            specificVisibleTreasures.remove(t.getType());
        }
    }
    
    @Override
    public void substractHiddenTreasure( Treasure t ){
        if( specificHiddenTreasures.contains(t.getType()) ){
            specificHiddenTreasures.remove(t.getType());
        }        
    }
    
    @Override
    public SpecificBadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v , ArrayList<Treasure> h ){
        ArrayList<TreasureKind>  av = new ArrayList();
        ArrayList<TreasureKind> ah = new ArrayList();
       
        for( Treasure t : v ){
            if( this.getspecificVisibleTreasures().contains(t.getType())){
                av.add(t.getType());
            }
        }
        for( Treasure t : h ){
            if( this.getspecificHiddenTreasures().contains(t.getType())){
                ah.add(t.getType());
            }
        }
        SpecificBadConsequence res = new SpecificBadConsequence(this.getText(),0,av,ah);
        return res;
    }
    
    public ArrayList<TreasureKind> getspecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    public ArrayList<TreasureKind> getspecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Tesoros especificos ocultos = " + specificHiddenTreasures + 
                " Tesoros especificos visibles = " + specificVisibleTreasures;
    }
    
}
