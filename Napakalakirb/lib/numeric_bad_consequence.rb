#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class NumericBadConsequence < BadConsequence
  
  attr_reader :nVisibleTreasures
  attr_reader :nHiddenTreasures
  
  def initialize(aText, someLevels,someVisibleTreasures, someHiddenTreasures)
    super(aText,someLevels)
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
  end
  
  def isEmpty
    if( @nVisibleTreasures == 0 && @nHiddenTreasures == 0 )
      return true
    end
    return false
  end
  
  def substractVisibleTreasure( t ) 
    if ( @nVisibleTreasures > 0 )
      @nVisibleTreasures -= 1
    end
  end
  
  def substractHiddenTreasure( t )
    if ( @nHiddenTreasures > 0 )
        @nHiddenTreasures -= 1
    end
  end
  
  def adjustToFitTreasureLists( v , h )
    if( @nVisibleTreasures == 0 )
      nv = 0;
    else
      nv = v.size
    end
    if ( @nHiddenTreasures == 0 )
      nh = 0
    else
      nh = h.size
    end
    res = NumericBadConsequence.new(@text,0,nv,nh);
    return res;
  end
  
  def to_s
    return super() + " NºTesoros visibles: #{@nVisibleTreasures},
     NºTesoros ocultos: #{@nHiddenTreasures}"
  end
  
end
