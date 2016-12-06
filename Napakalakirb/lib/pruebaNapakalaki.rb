#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "prize.rb"
require_relative "monster.rb"
require_relative "bad_consequence.rb"
require_relative "treasure_kind.rb"

class PruebaNapakalaki
  
 @@monsters = Array.new
 @@MAX_VALUE = 5
 
 def self.NvMayor10
   resultado = Array.new
   @@monsters.each do |m|
     if(m.combatLevel>10)
       resultado << m
     end
   end
   return resultado
 end
 
 def self.BcLostLevel
   resultado = Array.new
   @@monsters.each do |m|
     bc = m.malrollo
     if(bc.levels != 0 && bc.nVisibleTreasures == 0 && bc.nHiddenTreasures == 0 )
       resultado << m
     end
   end
   return resultado
 end
 
   
   def self.GananciaMayor1Nivel
  resultado = Array.new
 
  @@monsters.each do |m|
    if (m.getLevelsGained > 1)
        resultado << m
    end
  end
  return resultado
 
end

def self.PierdesTesoro(tesoro)
   resultado = Array.new
   
   @@monsters.each do |m| 
     bc = m.malrollo
     if ( bc.specificVisibleTreasures.include?(tesoro) || bc.specificHiddenTreasures.include?(tesoro) )
       resultado << m
     end
   end
   return resultado
end
 
 def self.monstruos
   p1 = Prize.new(2,1)
   bc1 = BadConsequence.newLevelSpecificTreasures("Pierdes tu armaduta visible y otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
   @@monsters << Monster.new("Byakhees de bonanza", 8, bc1, p1)
   
   p2 = Prize.new(1,1)
   bc2 = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET], Array.new )
   @@monsters << Monster.new("Tenochtitlan", 2, bc2, p2)
   
   p3 = Prize.new(1, 1)
   bc3 = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], Array.new)
   @@monsters << Monster.new("El sopor de Dunwich", 2, bc3, p3)
   
   p4 = Prize.new(4, 1)
   bc4 = BadConsequence.newLevelSpecificTreasures("Te atrapa para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
   @@monsters << Monster.new("Demonios de Magaluf", 2, bc4, p4)
   
   p5 = Prize.new(3, 1)
   bc5 = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 0, @@MAX_VALUE, @@MAX_VALUE)
   @@monsters << Monster.new("El gorrón en el umbral", 13, bc5, p5)
   
   p6 = Prize.new(2, 1)
   bc6 = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], Array.new)
   @@monsters << Monster.new("H.P. Munchcraft", 6, bc6, p6)
   
   p7 = Prize.new(1, 1)
   bc7 = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa.Descarta la armadura visible", 0, [TreasureKind::ARMOR], Array.new)
   @@monsters << Monster.new("Necrófago", 13, bc7, p7)
   
   p8 = Prize.new(3, 2)
   bc8 = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0)
   @@monsters << Monster.new("El rey de rosado", 11, bc8, p8)
   
   p9 = Prize.new(1, 1)
   bc9 = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
   @@monsters << Monster.new("Flecher", 2, bc9, p9)
   
   p10 = Prize.new(2,1)
   bc10 = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto")
   @@monsters << Monster.new("Los hondos", 8, bc10, p10)

   p11 = Prize.new(2,1)
   bc11 = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2)
   @@monsters << Monster.new("Semillas Cthulhu", 4, bc11, p11)

   p12 = Prize.new(2, 1)
   bc12 = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND] , Array.new)
   @@monsters << Monster.new("Dameargo", 1, bc12, p12)

   p13 = Prize.new(2, 1)
   bc13 = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
   @@monsters << Monster.new("Pollipolipo volante", 3, bc13, p13)

   p14 = Prize.new(3, 1)
   bc14 = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
   @@monsters << Monster.new("Yskhtihyssg-Goth", 14, bc14, p14)

   p15 = Prize.new(3, 1)
   bc15 = BadConsequence.newDeath("La familia te atrapa. Estas muerto")
   @@monsters << Monster.new("Familia feliz", 1, bc15, p15)

   p16 = Prize.new(2, 1)
   bc16 = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder dos niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHANDS] , Array.new)
   @@monsters << Monster.new("Roboggoth", 8, bc16, p16)

   p17 = Prize.new(1, 1)
   bc17 = BadConsequence.newLevelSpecificTreasures("Te asustas en la noche. Pierdes un casco visible", 0, [TreasureKind::HELMET], Array.new)
   @@monsters << Monster.new("El espia sordo", 5, bc17, p17)

   p18 = Prize.new(2, 1)
   bc18 = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
   @@monsters << Monster.new("Tongue", 19, bc17, p17)
   
   p19 = Prize.new(2, 1)
   bc19 = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::ONEHAND , TreasureKind::BOTHHANDS] , Array.new)
   @@monsters << Monster.new("Bicéfalo", 21, bc19, p19)
   
 end
 
 def self.prueba
   
    p = Prize.new(5,9)
    bc = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::ONEHAND , TreasureKind::BOTHHANDS] , Array.new)
    m1 = Monster.new("Joseyo",8,bc,p)
 
   
    tesoro = "TreasureKind::ONEHAND"
    if(m1.malrollo.specificVisibleTreasures.include?(tesoro))
    puts "hola"
   end
 end
 
 PruebaNapakalaki.monstruos
 #puts PruebaNapakalaki.NvMayor10
 #puts PruebaNapakalaki.BcLostLevel
 #puts PruebaNapakalaki.GananciaMayor1Nivel
puts PruebaNapakalaki.PierdesTesoro(TreasureKind::ONEHAND)
# PruebaNapakalaki.prueba
end
 