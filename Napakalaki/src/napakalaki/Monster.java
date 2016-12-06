/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author jose
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize buenrollo;
    private BadConsequence malrollo;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster( String name , int level , BadConsequence bc , Prize prize , int IC ){
        this.name = name;
        combatLevel = level;
        buenrollo = prize;
        malrollo = bc;
        levelChangeAgainstCultistPlayer = IC;
    }
    public Monster( String name , int level , BadConsequence bc , Prize prize){
        this.name = name;
        combatLevel = level;
        buenrollo = prize;
        malrollo = bc;
        levelChangeAgainstCultistPlayer = 0;
    }
    public int getCombatLevelAgainstCultistPlayer(){
        return levelChangeAgainstCultistPlayer;
    }
    public String getName(){
        return name;
    }
    public int getcombatLevel(){
        return combatLevel;
    }
    public BadConsequence getBadConsequence(){
        return malrollo;
    }
    public int getLevelsGained(){
        return buenrollo.getLevel();
    }
    public int getTreasuresGained(){
        return buenrollo.getTreasures();
    }
    public String toString(){
        return "Nombre: " + name + " Nivel de combate: " + Integer.toString(combatLevel) + 
                "\nBuen rollo: " + buenrollo.toString() + "\nMal rollo: " + malrollo.toString() + "\n";
    }
}
