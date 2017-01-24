/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jose
 */
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    
    private Napakalaki(){
        players = new ArrayList();
        dealer = CardDealer.getInstance();
        currentPlayer = null;
    }
    private void initPlayers( ArrayList<String> names ){
        for ( String n : names ){
            players.add(new Player(n));
        }
    }
    private Player nextPlayer(){
        Player p = null;
        if( currentPlayer == null){
            Random  rnd = new Random();
            int x = (int) (rnd.nextDouble() * players.size());
            p = players.get(x);
        }
        else if( currentPlayer == players.get(players.size()-1)){
            p = players.get(0);
        }
        else{
            int x = 0;
            for( Player i :players ){  
                x++;
                if( i == currentPlayer )
                    p = players.get(x);
            }
        }
        return p;
    }
    private boolean nextTurnAllowed(){
        if( currentPlayer == null )
            return true;
        else
            return currentPlayer.validState();
    }
    private void setEnemies(){
        int en;
        Random  rnd = new Random();
        for ( int i = 0; i < players.size(); i++){
            do{
                en = (int) (rnd.nextDouble() * players.size());
            }while( i == en );
            players.get(i).setEnemy(players.get(en));
        }
    }
    public static Napakalaki getInstance(){
        return instance;
    }
    public CombatResult developCombat(){
        CombatResult res = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if( res == CombatResult.LOSEANDCONVERT ){
            Cultist c = dealer.nextCultist();
            CultistPlayer cp = new CultistPlayer(currentPlayer,c);
            int pos = players.indexOf(currentPlayer);
            players.set(pos, cp);
            for ( Player p : players ){
                if( p.getEnemy().equals(currentPlayer) ){
                    p.setEnemy(cp);
                }
            }
            currentPlayer = cp;
        }
        return res;
    }
    public void discardVisibleTreasures( ArrayList<Treasure> treasures ){
        for ( Treasure t : treasures ){
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    public void discardHiddenTreasures( ArrayList<Treasure> treasures ){
        for ( Treasure t : treasures ){
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    public void makeTreasuresVisible( ArrayList<Treasure> treasures ){
        for ( Treasure t : treasures ){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    public void initGame( ArrayList<String> players ){
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurn(){
        boolean stateOK = this.nextTurnAllowed();
        
        if( stateOK ){
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            boolean dead = currentPlayer.isDead();
            if( dead ){
                currentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    public boolean endOfGame(CombatResult result){
        return (result == CombatResult.WINGAME);
    }
}
