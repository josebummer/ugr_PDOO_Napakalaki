/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author jose
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayer = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p , Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayer++;
    }
    @Override
    protected int getCombatLevel(){
        return super.getCombatLevel() + super.getCombatLevel()*20/100 + myCultistCard.getGainedLevels()*totalCultistPlayer;
    }
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    @Override
    protected boolean shouldConvert(){
        return false;
    }

    private Treasure giveMeATreasure(){
        Random  rnd = new Random();
        int number = (int) (rnd.nextDouble() * super.getVisibleTreasures().size());
        return super.getVisibleTreasures().get(number);
    }
   
    private boolean canYouGiveMeATreasure(){
        return !super.getVisibleTreasures().isEmpty();
    }
    
    public static int getTotalCultistPlayer(){
        return totalCultistPlayer;
    }
    
}
