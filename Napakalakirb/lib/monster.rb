#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "bad_consequence.rb"
require_relative "prize.rb"

class Monster
  attr_reader :name
  attr_reader :combatLevel
  attr_reader :malrollo
  
  def initialize(name , level , bc , p)
    @name = name
    @combatLevel = level
    @malrollo = bc
    @buenrollo = p
  end
  def getLevelsGained
    return @buenrollo.level
  end
  def getTreasuresGained
    return @buenrollo.treasures
  end
  def to_s
    "Nombre: #{@name}, Nivel de combate: #{@combatLevel},
    Buen rollo: #{@buenrollo}
    Mal rollo: #{@malrollo}\n"
  end
end
