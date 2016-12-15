# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class CultistPlayer < Player
  attr_reader :totalCultistPlayer
  
  @@totalCultistPlayer = 0
  
  def initialize( p , c )
    super(p)
    @myCultistCard = c
    @@totalCultistPlayer += 1
  end
  def getCombatLevel
    return super.getCombatLevel + super.getCombatLevel*20/100 + @myCultistCard.gainedLevels*@@totalCultistPlayer
  end
  def getOponentLevel(m)
    return m.levelChangeAgainstCultistPlayer
  end
  def shouldConvert
    return false
  end
  protected :getCombatLevel , :getOponentLevel , :shouldConvert
  
  def giveMeATreasure
    number = rand(super.visibleTreasures.length)
    return super.visibleTreasures[number]
  end
  def canYouGiveMeATreasure
    return !super.visibleTreasures.empty?
  end
  private :giveMeATreasure , :canYouGiveMeATreasure 
end
