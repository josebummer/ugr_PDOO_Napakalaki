/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

/**
 *
 * @author jose
 */
public class Player {
    
    public static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    protected Player enemy;
   
   
    public Player(String name){
        this.name = name;
        level = 0;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        canISteal = true;
        dead = true;
        pendingBadConsequence = null;
    }
    
    public Player(Player p){
        this.name = p.getName();
        level = p.getLevels();
        hiddenTreasures = new ArrayList(p.getHiddenTreasures());
        visibleTreasures = new ArrayList(p.getVisibleTreasures());
        canISteal = p.canISteal();
        dead = p.dead;
        pendingBadConsequence = p.pendingBadConsequence;
        enemy = p.enemy;
    }
   
    public String getName()
    {
    return name;
    }
    
    public Player getEnemy(){
        return enemy;
    }
    
    private void bringToLife(){
        dead = false;
    }
   
    protected int getCombatLevel()
    {
        int cl = level;
        for( Treasure t: visibleTreasures ){
                cl += t.getBonus();
        }
       
        return cl;             
           
    }
   
   
   
    private void incrementLevels(int l)
    {
        if( (level + l) >= MAXLEVEL )
            level = MAXLEVEL;
        else
            level += l;
    }
   
    private void decrementLevels(int l)
    {
        if ( (level-l) <= 0 )
            level = 0;
        else
            level -= l;
    }
   
    private void setPendingBadConsequence(BadConsequence b)
    {
        pendingBadConsequence = b;
    }
   
   private void applyPrize(Monster m){
       int nLevels = m.getLevelsGained();
       int nTreasures = m.getTreasuresGained();
       
       this.incrementLevels(nLevels);
       if( nTreasures > 0 ){
           CardDealer dealer = CardDealer.getInstance();
           int i = 0;
           while ( i < nTreasures ){
               Treasure t = dealer.nextTreasure();
               hiddenTreasures.add(t);
               i++;
           }
       }
   }
   
   private void applyBadConsequence(Monster m){
       BadConsequence badConsequence = m.getBadConsequence();
       int nLevels = badConsequence.getLevels();
       
       this.decrementLevels(nLevels);
       BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
       this.setPendingBadConsequence(pendingBad);
   }
   
    private boolean canMakeTreasureVisible(Treasure t ){
       if( visibleTreasures.isEmpty() )
           return true;
       if ( t.getType() == TreasureKind.BOTHHANDS ){
           for ( Treasure x : visibleTreasures ){
               if ( x.getType() == TreasureKind.ONEHAND || x.getType() == t.getType() )
                   return false;
           }
           return true;
       }
       if ( t.getType() != TreasureKind.ONEHAND ){
           for ( Treasure x : visibleTreasures ){
               if ( t.getType() == x.getType() )
                   return false;
           }
           return true;
       }
       int c = 0;
       for ( Treasure x : visibleTreasures ){
           if( x.getType() == TreasureKind.BOTHHANDS ){
               return false;
           }
           else if ( x.getType() == t.getType() )
               c++;
       }
       if ( c < 2 )
           return true;
       return false;
    }
   
    private int howManyVisibleTreasures(TreasureKind tKind)
    {
        int n = 0;
        for(Treasure t: visibleTreasures){
            if ( t.getType() == tKind ) n++;
        }
        return n;
    }
   
    boolean isDead()
    {
        return dead;
    }
   
    public ArrayList<Treasure> getHiddenTreasures()
    {
        return hiddenTreasures;
    }
   
    public ArrayList<Treasure> getVisibleTreasures()
    {
        return visibleTreasures;
    }
   
    public CombatResult combat(Monster m){
        CombatResult res;
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        
        if( !canISteal ){
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber("Vamos a tirar el dado","Para combatir.");
            if( number < 3 ){
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel += enemyLevel;
            }
        }
        if( myLevel > monsterLevel ){
            this.applyPrize(m);
            if( this.level >= MAXLEVEL ){
                res = CombatResult.WINGAME;
            }
            else{
                res = CombatResult.WIN;
            }
        }
        else{
            this.applyBadConsequence(m);
            boolean b = this.shouldConvert();
            if(b){
                res = CombatResult.LOSEANDCONVERT;
            }
            else{
            res = CombatResult.LOSE;
            }
        }
        return res;
    }
   
    public void makeTreasureVisible(Treasure t){
        boolean canI = this.canMakeTreasureVisible(t);
        if( canI ){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
   
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if( pendingBadConsequence != null && !pendingBadConsequence.isEmpty() ){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        this.dieIfNoTreasures();
    }
   
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if( pendingBadConsequence != null && !pendingBadConsequence.isEmpty() ){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        this.dieIfNoTreasures();
    }
   
    public boolean validState()
    {
        if ( pendingBadConsequence == null ){
            if( hiddenTreasures.size() < 5 )
                return true;
        }
        else if( pendingBadConsequence.isEmpty() && hiddenTreasures.size() < 5 ){
            return true;
        }
        return false;
    }
   
   public void initTreasures(){
       CardDealer dealer = CardDealer.getInstance();
       Dice dice = Dice.getInstance();
       
       this.bringToLife();
       
       Treasure treasure = dealer.nextTreasure();
       hiddenTreasures.add(treasure);
       
       int number = dice.nextNumber("Tire el dado","Suerte con el 6");
       if( number > 1 ){
           treasure = dealer.nextTreasure();
           hiddenTreasures.add(treasure);
       }
       if( number == 6 ){
           treasure = dealer.nextTreasure();
           hiddenTreasures.add(treasure);
       }
   }
   
    public int getLevels()
    {
        return level;
    }
   
    public Treasure stealTreasure(){
        boolean canI = this.canISteal();
        Treasure treasure = null;
        
        if ( canI ){
            boolean canYou = enemy.canYouGiveMeATreasure();
            if( canYou ){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }
        return treasure;
    }
   
    public void setEnemy(Player enemy)
    {
        this.enemy = enemy;
    }
   
    private Treasure giveMeATreasure(){
        Random  rnd = new Random();
        int t = (int) (rnd.nextDouble() * hiddenTreasures.size());
        return hiddenTreasures.get(t);
    }
   
    public boolean canISteal()
    {
        return canISteal;
    }
   
    private boolean canYouGiveMeATreasure()
    {
        if( !hiddenTreasures.isEmpty() )
            return true;
        else return false;
    }
   
    private void haveStolen()
    {
        canISteal = false;
    }
   
    public void discardAllTreasures(){
        ArrayList<Treasure> copiav = new ArrayList(visibleTreasures);
        ArrayList<Treasure> copiah = new ArrayList(hiddenTreasures);
        for( Treasure t : copiav ){
            this.discardVisibleTreasure(t);
        }
        for( Treasure t : copiah ){
            this.discardHiddenTreasure(t);
        }
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
   
    private void dieIfNoTreasures(){
        dead = true;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber("Has perdido el combate","A ver si te conviertes en sectario");
        if( number == 6 ){
            return true;
        }
        return false;
    }
    
    
    public String toString(){
        return "Nombre: " + name + "\nNivel: " + Integer.toString(level) + "\nNivel de combate: " + this.getCombatLevel() +
                "\nMuerte: " + dead + "\nPuede robar: " + canISteal + "\nEnemigo: " + enemy.getName() + "\n";
    }
}
   
