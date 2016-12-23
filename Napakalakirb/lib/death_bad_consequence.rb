#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class DeathBadConsequence < NumericBadConsequence
  
  attr_reader :death
  
  def initialize(aText)
    super(aText,Player::MAXLEVEL,MAXTREASURES,MAXTREASURES)
    @death = true;
  end
  
  def isEmpty
    return super()
  end
  
  def adjustToFitTreasureLists( v , h )
    return super(v,h)
  end
  
  def to_s
    return super() + ", Muerte: #{@death}"
  end
  
end
