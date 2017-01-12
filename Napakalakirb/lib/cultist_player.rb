# encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class CultistPlayer < Player
  attr_reader :totalCultistPlayer
  
  @@totalCultistPlayer = 0
  
  def initialize( p , c )
    super(p.name)
    newCopia(p)
    @myCultistCard = c
    @@totalCultistPlayer += 1
  end
  def getCombatLevel
    return super() + super()*70/100 + @myCultistCard.gainedLevels*@@totalCultistPlayer
  end
  def getOponentLevel(m)
    return m.getLevelChangeAgainstCultistPlayer
  end
  def shouldConvert
    return false
  end
  protected :getOponentLevel , :shouldConvert
  
  def giveMeATreasure
    number = rand(visibleTreasures.length)
    return visibleTreasures[number]
  end
  def canYouGiveMeATreasure
    return !visibleTreasures.empty?
  end
  private :giveMeATreasure , :canYouGiveMeATreasure
  protected :getCombatLevel , :getOponentLevel , :shouldConvert
end
