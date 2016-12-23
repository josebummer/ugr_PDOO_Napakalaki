#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class SpecificBadConsequence < BadConsequence
  
  attr_reader :specificHiddenTreasures
  attr_reader :specificVisibleTreasures
  
  def initialize(aText, someLevels,someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    super(aText,someLevels)
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
  end
  
  def isEmpty
    if( @specificHiddenTreasures.empty? && @specificVisibleTreasures.empty? )
      return true
    end
    return false
  end
  
  def substractVisibleTreasure( t ) 
    if ( @specificVisibleTreasures.include?(t.type) )
      @specificVisibleTreasures.delete(t.type)
    end
  end
  
  def substractHiddenTreasure( t )
    if ( @specificHiddenTreasures.include?(t.type) )
      @specificHiddenTreasures.delete(t.type)
    end
  end
  
  def adjustToFitTreasureLists( v , h )
    av = Array.new
    ah = Array.new
    v.each do |t|
      if( @specificVisibleTreasures.include?(t.type))
        av << t.type;
      end
    end
    h.each do |t|
      if( @specificHiddenTreasures.include?(t.type))
          ah << t.type;
      end
    end
    res = SpecificBadConsequence.new(@text,0,av,ah);
    return res
  end
  
  def to_s
    return super() + ", Tesoros especificos ocultos: #{@specificHiddenTreasures},
     Tesoros especificos visibles: #{@specificVisibleTreasures}\n"
  end
  
end
