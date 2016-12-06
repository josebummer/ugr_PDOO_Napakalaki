#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "treasure.rb"
require_relative "treasure_kind.rb"

class Prize
  attr_reader :treasures
  attr_reader :level
  
  def initialize(treasures, level)
    @treasures = treasures
    @level = level
  end
  
  def to_s
    "Tesoros ganados: #{@treasures}, Niveles ganados: #{@level}"
  end
  
end
