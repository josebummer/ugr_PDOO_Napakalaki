#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "treasure_kind.rb"

class BadConsequence
  MAXTREASURES = 5
  attr_reader :levels
  attr_reader :nVisibleTreasures
  attr_reader :nHiddenTreasures
  attr_reader :death
  attr_reader :specificHiddenTreasures
  attr_reader :specificVisibleTreasures
  private_class_method :new
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @death = death
  end
  def self.newLevelNumberOfTreasures (aText, someLevels,someVisibleTreasures, someHiddenTreasures)
    new(aText,someLevels,someVisibleTreasures,someHiddenTreasures,Array.new,Array.new,false)
  end
  def self.newLevelSpecificTreasures (aText, someLevels,someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText,someLevels,0 , 0 ,someSpecificVisibleTreasures,someSpecificHiddenTreasures,false)
  end
  def self.newDeath (aText)
    new(aText,Player::MAXLEVEL,MAXTREASURES,MAXTREASURES,Array.new,Array.new,true)
  end
  def isEmpty
    if( (@nVisibleTreasures == 0 && @nHiddenTreasures == 0) && (@specificHiddenTreasures.empty? && @specificVisibleTreasures.empty?) )
      return true
    end
    return false
  end
  def substractVisibleTreasure( t ) 
    if ( @specificVisibleTreasures.include?(t.type) )
      @specificVisibleTreasures.delete(t.type)
    elsif ( @nVisibleTreasures > 0 )
      @nVisibleTreasures -= 1
    end
  end
  def substractHiddenTreasure( t )
    if ( @specificHiddenTreasures.include?(t.type) )
      @specificHiddenTreasures.delete(t.type)
    elsif ( @nHiddenTreasures > 0 )
        @nHiddenTreasures -= 1
    end
  end
  def adjustToFitTreasureLists( v , h )
    av = Array.new
    ah = Array.new
    if( @nVisibleTreasures == 0 && @nHiddenTreasures == 0 )
      v.each do |t|
        if( @specificVisibleTreasures.include?(t.type) && !av.include?(t.type))
          av << t.type;
        end
      end
      h.each do |t|
        if( @specificHiddenTreasures.include?(t.type) && !ah.include?(t.type))
            ah << t.type;
        end
      end
      res = BadConsequence.newLevelSpecificTreasures(@text,0,av,ah);
      return res;
    end
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
    res = BadConsequence.newLevelNumberOfTreasures(@text,0,nv,nh);
    return res;
  end
  def to_s
    "Texto: #{@text}, Niveles: #{@levels}, NºTesoros visibles: #{@nVisibleTreasures},
     NºTesoros ocultos: #{@nHiddenTreasures}, Muerte: #{@death}, Tesoros especificos ocultos: #{@specificHiddenTreasures},
     Tesoros especificos visibles: #{@specificVisibleTreasures}\n"
  end
end
