#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "combat_result.rb"
require_relative "bad_consequence.rb"
require_relative "dice.rb"
require_relative "treasure.rb"
require_relative "treasure_kind.rb"


class Player
  MAXLEVEL = 10
  attr_reader :name
  attr_reader :level
  attr_reader :dead
  attr_reader :canISteal
  attr_accessor :enemy
  attr_reader :hiddenTreasures
  attr_reader :pendingBadConsequence
  attr_reader :visibleTreasures
  def initialize( name )
    @name = name
    @level = 0
    @dead = true
    @canISteal = false
    @hiddenTreasures = Array.new
    @visibleTreasures = Array.new
    @pendingBadConsequence = nil
  end
  def newCopia( player )
    @name = player.name
    @level = player.level
    @dead = player.dead
    @canISteal = player.canISteal
    @hiddenTreasures = Array.new(player.hiddenTreasures)
    @visibleTreasures = Array.new(player.visibleTreasures)
    @pendingBadConsequence = player.pendingBadConsequence
    @enemy = player.enemy
  end
  
  def bringToLife
    @dead = false
  end
  
  def getCombatLevel
    resultado = @level
    @visibleTreasures.each do |v|
      resultado += v.bonus
    end
    return resultado
  end
  
  def getOponentLevel(m)
        return m.combatLevel
  end
  
  def incrementLevels( i )
    if( (@level+i) >= MAXLEVEL )
      @level = MAXLEVEL
    else
      @level += i
    end
  end
  
  def decrementLevels( i )
    if( (@level-i) <= 0 )
      @level = 0
    else
      @level -= i
    end
  end
  
  def setPendingBadConsequence( b )
    @pendingBadConsequence = b
  end
  
  def applyPrize( m )
    nLevels = m.getLevelsGained
    nTreasures = m.getTreasuresGained
    incrementLevels(nLevels)
    if( nTreasures > 0 )
      dealer = CardDealer.instance
      i = 0
      while( i < nTreasures )
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
        i+=1
      end
    end
  end
  def applyBadConsequence ( m )
    badConsequence = m.malrollo
    nLevels = badConsequence.levels
    decrementLevels(nLevels)
    pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
    setPendingBadConsequence(pendingBad)
  end
  def canMakeTreasureVisible( t )
    if ( @visibleTreasures.empty? )
      return true
    end
    if ( t.type == TreasureKind::BOTHHANDS )
      @visibleTreasures.each do |v|
        if ( v.type == TreasureKind::ONEHAND || v.type == t.type )
          return false
        end
      end
      return true
    end
    if ( t.type != TreasureKind::ONEHAND)
      @visibleTreasures.each do |v|
        if ( v.type == t.type )
          return false
        end
      end
      return true
    end
    cont = 0
    @visibleTreasures.each do |v|
      if( v.type == TreasureKind::BOTHHANDS )
        return false
      elsif( v.type == t.type )
        cont += 1
      end
    end
    if ( cont < 2 )
      return true
    end
    return false
  end
 
  def howManyVisibleTreasures( tKind )
    resultado = 0
    @visibleTreasures.each do |v|
      if( v.type == tKind )
        resultado += 1
      end
    end
    return resultado
  end
  
  def dieIfNoTreasures
    @dead = true
  end
  
  def combat( m )
    myLevel = getCombatLevel
    monsterLevel = getOponentLevel(m)
    if( !@canISteal )
      dice = Dice.instance
      number = dice.nextNumber
      if( number < 3 )
        enemyLevel = @enemy.getCombatLevel
        monsterLevel += enemyLevel
      end
    end
    if( myLevel > monsterLevel )
      applyPrize(m)
      if( @level >= MAXLEVEL )
        res = CombatResult::WINGAME
      else
        res = CombatResult::WIN
      end
    else
      applyBadConsequence(m)
      b = shouldConvert
      if(b)
        res = CombatResult::LOSEANDCONVERT
      else
        res = CombatResult::LOSE
      end
    end
    return res
  end
  def makeTreasureVisible( t )
    canI = canMakeTreasureVisible(t)
    if( canI )
      @visibleTreasures << t
      @hiddenTreasures.delete(t)
    end
  end
  def discardVisibleTreasure( t )
    @visibleTreasures.delete(t)
    if( !@pendingBadConsequence.nil? && !@pendingBadConsequence.isEmpty )
      @pendingBadConsequence.substractVisibleTreasure(t)
    end
    dieIfNoTreasures
  end
  def discardHiddenTreasure( t )
    @hiddenTreasures.delete(t)
    if( !@pendingBadConsequence.nil? && !@pendingBadConsequence.isEmpty )
      @pendingBadConsequence.substractHiddenTreasure(t)
    end
    dieIfNoTreasures
  end
  
  def validState
    if( @pendingBadConsequence == nil )
      if ( @hiddenTreasures.size < 5 )
        return true
      end
    elsif ( @pendingBadConsequence.isEmpty && @hiddenTreasures.size < 5 )
      return true
    end
    return false
  end
  
  def initTreasures
    dealer = CardDealer.instance
    dice = Dice.instance
    bringToLife
    treasure = dealer.nextTreasure
    @hiddenTreasures << treasure
    number = dice.nextNumber
    if( number > 1 )
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
    end
    if( number == 6 )
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
    end
  end
  def stealTreasure
    treasure = nil
    canI = @canISteal
    if( canI )
      canYou = @enemy.canYouGiveMeATreasure
      if( canYou )
        treasure = @enemy.giveMeATreasure
        @hiddenTreasure << treasure
        haveStolen
      end
    end
    return treasure
  end
  
  def shouldConvert
        dice = Dice.instance
        number = dice.nextNumber
        if( number == 6 ) 
            return true
        end
        return false
  end
    
  def giveMeATreasure
    nu = rand(@hiddenTreasures.size)
    return @hiddenTreasures[nu]
  end
  
  def canYouGiveMeATreasure
    if( !@hiddenTreasures.empty? )
      return true
    end
    return false
  end
  
  def haveStolen
    @canISteal = false
  end
  
  private :giveMeATreasure , :canYouGiveMeATreasure , :haveStolen
  def discardAllTreasures
    copv = Array.new(@visibleTreasures)
    coph = Array.new(@hiddenTreasures)
    copv.each do |treasure|
      discardVisibleTreasure(treasure) 
    end
    coph.each do |treasure|
      discardHiddenTreasure(treasure)
    end
  end
  def to_s
    strh = Array.new
    strv = Array.new
    @hiddenTreasures.each do |t|
      strh << t.to_s
    end
    @visibleTreasures.each do |t|
      strv << t.to_s
    end
    "Nombre: #{@name}, Nivel: #{@level}, Nivel de combate: #{getCombatLevel} ,
    Muerte: #{@dead} , 
    Ha robado: #{@canISteal} 
    Tesoros ocultos: #{strh} ,
    Tesoros visibles: #{strv} ,
    PendingBadConsequence: #{@pendingBadConsequence}, 
    Enemigo: #{@enemy.name}\n"
  end
  
  private :bringToLife , :incrementLevels , :decrementLevels , :setPendingBadConsequence , :applyPrize , :applyBadConsequence , :canMakeTreasureVisible , :howManyVisibleTreasures , :dieIfNoTreasures
  protected :getOponentLevel, :shouldConvert , :getCombatLevel
end
