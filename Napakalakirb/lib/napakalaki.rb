#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "combat_result.rb"
require_relative "player.rb"
require_relative "monster.rb"
require_relative "card_dealer.rb"
require_relative "treasure_kind.rb"

class Napakalaki
  include Singleton
  
  attr_reader:currentMonster
  attr_reader:currentPlayer
  
  def initialize
    @players = Array.new
    @dealer = CardDealer.instance
  end
  
  def initPlayers( names )
    names.each do |p|
      @players << Player.new(p)
    end
  end
  def nextPlayer
    if ( @currentPlayer.nil? )
      nu = rand(@players.size)
      @currentPlayer = @players[nu]
      return @currentPlayer
    end
    if ( @currentPlayer == @players[@players.size-1] )
      @currentPlayer = @players[0]
      return @currentPlayer
    end
    i = 0
    while( i < @players.size)
      if( @currentPlayer == @players[i] )
        @currentPlayer = @players[i+1]
        return @currentPlayer
      end
      i += 1
    end
  end
  def nextTurnAllowed
    if( @currentPlayer.nil? )
      return true
    else
      return @currentPlayer.validState
    end
  end
  def setEnemies
    i = 0
    while ( i < @players.size )
      nu = rand(@players.size)
      @players[i].enemy = @players[nu]
      if( i != nu )
        i += 1
      end
    end
  end
  private :initPlayers, :nextPlayer, :nextTurnAllowed, :setEnemies
  def developCombat
    cre = @currentPlayer.combat(@currentMonster)
    @dealer.giveMonsterBack(@currentMonster)
    return cre
  end
  def discardVisibleTreasures( treasures )
    treasures.each do |t|
      @currentPlayer.discardVisibleTreasure(t)
      @dealer.giveTreasureBack(t)
    end
  end
  def discardHiddenTreasures( treasures )
    treasures.each do |t|
      @currentPlayer.discardHiddenTreasure(t)
      @dealer.giveTreasureBack(t)
    end
  end
  def makeTreasuresVisible( treasures )
    treasures.each do |t|
      @currentPlayer.makeTreasureVisible(t)
    end
  end
  def initGame( players )
    initPlayers(players)
    setEnemies
    @dealer.initCards
    nextTurn
  end
  def nextTurn
    stateOK = nextTurnAllowed
    
    if( stateOK )
      @currentMonster = @dealer.nextMonster
      @currentPlayer = nextPlayer
      dead = @currentPlayer.dead
      if ( dead )
        @currentPlayer.initTreasures
      end
    end
    return stateOK
  end
  def endOfGame( result )
    return ( result ==  [CombatResult::WINGAME])
  end
end
