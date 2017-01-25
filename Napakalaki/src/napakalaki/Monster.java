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
    private int level;
    private Prize buenrollo;
    private BadConsequence malrollo;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster( String name , int p_level , BadConsequence bc , Prize prize , int IC ){
        this.name = name;
        level = p_level;
        buenrollo = prize;
        malrollo = bc;
        levelChangeAgainstCultistPlayer = IC;
    }
    public Monster( String name , int p_level , BadConsequence bc , Prize prize){
        this.name = name;
        level = p_level;
        buenrollo = prize;
        malrollo = bc;
        levelChangeAgainstCultistPlayer = 0;
    }
    public int getCombatLevelAgainstCultistPlayer(){
        return level + levelChangeAgainstCultistPlayer;
    }
    public String getName(){
        return name;
    }
    public int getCombatLevel(){
        return level;
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
    public Prize getPrize(){
        return buenrollo;
    }
    public String toString(){
        return "Nombre: " + name + "\nNivel de combate: " + Integer.toString(level) + "\nNivel de combate SECTARIOS: " + getCombatLevelAgainstCultistPlayer() + "\n";
    }
}
