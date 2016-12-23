#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "treasure_kind.rb"

class BadConsequence
  MAXTREASURES = 5
  attr_reader :levels
  
  def initialize(aText, someLevels)
    @text = aText
    @levels = someLevels
  end
  
  def to_s
    "Texto: #{@text}, Niveles: #{@levels}"
  end
end
