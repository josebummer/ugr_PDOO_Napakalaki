#encoding:utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"
require_relative "prize.rb"
require_relative "monster.rb"
require_relative "bad_consequence.rb"
require_relative "treasure_kind.rb"
require_relative "treasure.rb"
require_relative "cultist.rb"


class CardDealer
  include Singleton
  
  def initialize
    @unusedMonsters = Array.new
    @usedMonsters = Array.new
    @unusedTreasures = Array.new
    @usedTreasures = Array.new
    @unusedCultists = Array.new
  end
  
  def initCultistCardDeck
        @unusedCultists << Cultist.new("Sectario",1)
        @unusedCultists << Cultist.new("Sectario",2)
        @unusedCultists << Cultist.new("Sectario",1)
        @unusedCultists << Cultist.new("Sectario",2)
        @unusedCultists << Cultist.new("Sectario",1)
        @unusedCultists << Cultist.new("Sectario",1)
  end
  
  def initTreasureCardDeck
    @unusedTreasures << Treasure.new("¡Si mi amo!" , 4 , [TreasureKind::HELMET] )
    @unusedTreasures << Treasure.new("Botas de investigacion" , 3 , [TreasureKind::SHOES] )
    @unusedTreasures << Treasure.new("Capucha de Cthulhu" , 3 , [TreasureKind::HELMET] )
    @unusedTreasures << Treasure.new("Aprueba de babas" , 2 , [TreasureKind::ARMOR] )
    @unusedTreasures << Treasure.new("Botas de lluvia acida" , 1 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Casco minero" , 2 , [TreasureKind::HELMET] )
    @unusedTreasures << Treasure.new("Ametralladora ACME" , 4 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Camiseta de ETSIIT" , 1 , [TreasureKind::ARMOR] )
    @unusedTreasures << Treasure.new("Clavo de rail ferroviario" , 3 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Cuchillo de sushi arcano" , 2 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Fez alopodo" , 3 , [TreasureKind::HELMET] )
    @unusedTreasures << Treasure.new("Hacha prehistorica" , 2 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("El aparato del Pr. Tesla" , 4 , [TreasureKind::ARMOR] )
    @unusedTreasures << Treasure.new("Gaita" , 4 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Insecticida" , 2 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Escopeta de 3 cañones" , 4 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Garabato mistico" , 2 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("La rebeca metalica" , 2 , [TreasureKind::ARMOR] )
    @unusedTreasures << Treasure.new("Lanzallamas" , 4 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Necro-comicon" , 1 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Necronomicon" , 5 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Linterna a 2 manos" , 3 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Necro-gnomicon" , 2 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Necrotelecom" , 2 , [TreasureKind::HELMET] )
    @unusedTreasures << Treasure.new("Mazo de los antiguos" , 3 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Necro-playboycon" , 3 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Porra preternatural" , 2 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Shogulador" , 1 , [TreasureKind::BOTHHANDS] )
    @unusedTreasures << Treasure.new("Varita de atizamiento" , 3 , [TreasureKind::ONEHAND] )
    @unusedTreasures << Treasure.new("Tentaculo de pega" , 2 , [TreasureKind::HELMET] )
    @unusedTreasures << Treasure.new("Zapato deja-amigos" , 1 , [TreasureKind::SHOES] )
  end
  def initMonsterCardDeck
    p1 = Prize.new(2,1)
    bc1 = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    @unusedMonsters << Monster.new("Byakhees de bonanza", 8, bc1, p1)

    p2 = Prize.new(1,1)
    bc2 = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET], Array.new)
    @unusedMonsters << Monster.new("Tenochtitlan", 2, bc2, p2)

    p3 = Prize.new(1, 1)
    bc3 = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], Array.new)
    @unusedMonsters << Monster.new("El sopor de Dunwich", 2, bc3, p3)

    p4 = Prize.new(4, 1)
    bc4 = BadConsequence.newLevelSpecificTreasures("Te atrapa para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    @unusedMonsters << Monster.new("Demonios de Magaluf", 2, bc4, p4)

    p5 = Prize.new(3, 1)
    bc5 = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 0, BadConsequence::MAXTREASURES , 0)
    @unusedMonsters << Monster.new("El gorrón en el umbral", 13, bc5, p5)

    p6 = Prize.new(2, 1)
    bc6 = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], Array.new)
    @unusedMonsters << Monster.new("H.P. Munchcraft", 6, bc6, p6)

    p7 = Prize.new(1, 1)
    bc7 = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa.Descarta la armadura visible", 0, [TreasureKind::ARMOR], Array.new)
    @unusedMonsters << Monster.new("Necrófago", 13, bc7, p7)

    p8 = Prize.new(3, 2)
    bc8 = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0)
    @unusedMonsters << Monster.new("El rey de rosado", 11, bc8, p8)

    p9 = Prize.new(1, 1)
    bc9 = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
    @unusedMonsters << Monster.new("Flecher", 2, bc9, p9)

    p10 = Prize.new(2,1)
    bc10 = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto")
    @unusedMonsters << Monster.new("Los hondos", 8, bc10, p10)

    p11 = Prize.new(2,1)
    bc11 = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2)
    @unusedMonsters << Monster.new("Semillas Cthulhu", 4, bc11, p11)

    p12 = Prize.new(2, 1)
    bc12 = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND] , Array.new)
    @unusedMonsters << Monster.new("Dameargo", 1, bc12, p12)

    p13 = Prize.new(2, 1)
    bc13 = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
    @unusedMonsters << Monster.new("Pollipolipo volante", 3, bc13, p13)

    p14 = Prize.new(3, 1)
    bc14 = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
    @unusedMonsters << Monster.new("Yskhtihyssg-Goth", 14, bc14, p14)

    p15 = Prize.new(3, 1)
    bc15 = BadConsequence.newDeath("La familia te atrapa. Estas muerto")
    @unusedMonsters << Monster.new("Familia feliz", 1, bc15, p15)

    p16 = Prize.new(2, 1)
    bc16 = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder dos niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHANDS] , Array.new)
    @unusedMonsters << Monster.new("Roboggoth", 8, bc16, p16)

    p17 = Prize.new(1, 1)
    bc17 = BadConsequence.newLevelSpecificTreasures("Te asustas en la noche. Pierdes un casco visible", 0, [TreasureKind::HELMET], Array.new)
    @unusedMonsters << Monster.new("El espia sordo", 5, bc17, p17)

    p18 = Prize.new(2, 1)
    bc18 = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
    @unusedMonsters << Monster.new("Tongue", 19, bc17, p17)

    p19 = Prize.new(2, 1)
    bc19 = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::ONEHAND , TreasureKind::BOTHHANDS] , Array.new)
    @unusedMonsters << Monster.new("Bicéfalo", 21, bc19, p19)
    
    bc20 = BadConsequence.newLevelSpecificTreasures("Pierdes 1 mano visible.",0,[TreasureKind::ONEHAND],Array.new)
    prize20 = Prize.new(3,1)
    @unusedMonsters << Monster.new("El mal indecible impronunciable.",10,bc20,prize20,-2)

    bc21 = BadConsequence.newLevelNumberOfTreasures("Pierdes tus tesoros visibles. Jajaja.",0,BadConsequence::MAXTREASURES,0)
    prize21 = Prize.new(2,1)
    @unusedMonsters << Monster.new("Testigos oculares.",6,bc21,prize21,2)

    bc22 = BadConsequence.newDeath("Hoy no es tu dia de suerte. Mueres.")
    prize22 = Prize.new(2,5)
    @unusedMonsters << Monster.new("El gran cthulhu.",6,bc22,prize22,4)

    bc23 = BadConsequence.newLevelNumberOfTreasures("Tu gobierno te recorta 2 niveles.",2,0,0);
    prize23 = Prize.new(2,1)
    @unusedMonsters << Monster.new("Serpiente Politico.",8,bc23,prize23,-2)

    bc24 = BadConsequence.newLevelSpecificTreasures("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",0,[TreasureKind::ARMOR,TreasureKind::HELMET],[TreasureKind::BOTHHANDS,TreasureKind::ONEHAND,TreasureKind::ONEHAND])
    prize24 = Prize.new(1,1)
    @unusedMonsters << Monster.new("Felpuggoth.",2,bc24,prize24,5)

    bc25 = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles.",2,0,0)
    prize25 = Prize.new(4,2)
    @unusedMonsters << Monster.new("Shoggoth.",16,bc25,prize25,-4)

    bc26 = BadConsequence.newLevelNumberOfTreasures("Pintalabios negro. Pierdes 2 niveles.",2,0,0)
    prize26 = Prize.new(1,1)
    @unusedMonsters << Monster.new("Lolitagooth.",2,bc26,prize26,3)
    
  end
  def shuffleTreasures
    @unusedTreasures.shuffle!
  end
  def shuffleCultists
    @unusedCultists.shuffle!
  end
  def shuffleMonsters
    @unusedMonsters.shuffle!
  end
  private :initTreasureCardDeck , :initMonsterCardDeck , :shuffleTreasures , :shuffleMonsters , :shuffleCultists , :initCultistCardDeck
  def nextTreasure
    if ( @unusedTreasures.empty? )
      @unusedTreasures = @usedTreasures
      @usedTreasures.clear
      @unusedTreasures.suffle!
    end
    res = @unusedTreasures[0]
    @usedTreasures << res
    @unusedTreasures.delete(res)
    return res
  end
  def Cultist nextCultist
        c = @unusedCultists[0];
        @unusedCultists.delete(c)
        return c;
  end
  def nextMonster
    if ( @unusedMonsters.empty? )
      @unusedMonsters = @usedMonsters
      @usedMonsters.clear
      @unusedMonsters.suffle!
    end
    res = @unusedMonsters[0]
    @usedMonsters << res
    @unusedMonsters.delete(res)
    return res
  end
  
  def giveTreasureBack( t )
    @usedTreasures << t
    @unusedTreasures.delete(t)
  end
  
  def giveMonsterBack( m )
    @usedMonsters << m
    @unusedMonsters.delete(m)
  end
  
  def initCards
    initTreasureCardDeck
    initMonsterCardDeck
    initCultistCardDeck
    shuffleTreasures
    shuffleMonsters
    shuffleCultists
  end
  
end
