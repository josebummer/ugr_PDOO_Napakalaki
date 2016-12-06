/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jose
 */
public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists; 
    
    private CardDealer(){
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedCultists = new ArrayList();
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",1));
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Si mi amo!" , 4 , TreasureKind.HELMET ));
        unusedTreasures.add(new Treasure("Botas de investigacion" , 3 , TreasureKind.SHOES ));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu" , 3 , TreasureKind.HELMET ));
        unusedTreasures.add(new Treasure("Aprueba de babas" , 2 , TreasureKind.ARMOR ));
        unusedTreasures.add(new Treasure("Botas de lluvia acida" , 1 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Casco minero" , 2 , TreasureKind.HELMET ));
        unusedTreasures.add(new Treasure("Ametralladora ACME" , 4 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Camiseta de ETSIIT" , 1 , TreasureKind.ARMOR ));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario" , 3 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano" , 2 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Fez alopodo" , 3 , TreasureKind.HELMET ));
        unusedTreasures.add(new Treasure("Hacha prehistorica" , 2 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla" , 4 , TreasureKind.ARMOR ));
        unusedTreasures.add(new Treasure("Gaita" , 4 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Insecticida" , 2 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones" , 4 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Garabato mistico" , 2 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("La rebeca metalica" , 2 , TreasureKind.ARMOR ));
        unusedTreasures.add(new Treasure("Lanzallamas" , 4 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Necro-comicon" , 1 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Necronomicon" , 5 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Linterna a 2 manos" , 3 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Necro-gnomicon" , 2 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Necrotelecom" , 2 , TreasureKind.HELMET ));
        unusedTreasures.add(new Treasure("Mazo de los antiguos" , 3 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Necro-playboycon" , 3 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Porra preternatural" , 2 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Shogulador" , 1 , TreasureKind.BOTHHANDS ));
        unusedTreasures.add(new Treasure("Varita de atizamiento" , 3 , TreasureKind.ONEHAND ));
        unusedTreasures.add(new Treasure("Tentaculo de pega" , 2 , TreasureKind.HELMET ));
        unusedTreasures.add(new Treasure("Zapato deja-amigos" , 1 , TreasureKind.SHOES ));
    }
    private void initMonsterCardDeck()
    {
        BadConsequence bc1 = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)) );
        Prize prize1 = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bc1,prize1));

        BadConsequence bc2 = new BadConsequence("Embobados con el lindo primigenio te descartas tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        Prize prize2 = new Prize(1,1);
        unusedMonsters.add(new Monster("Tenochtitlan",2,bc2,prize2));

        BadConsequence bc3 = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList());
        Prize prize3 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2,bc3,prize3));

        BadConsequence bc4 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta a 1 mano visible y a 1 mano oculta.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize4 = new Prize(4,1);
        unusedMonsters.add(new Monster("Demonios de Magalud",2,bc4,prize4));

        BadConsequence bc5 = new BadConsequence("Pierdes todos tus tesoreos visibles.",0,BadConsequence.getMaxTreasures(),0);
        Prize prize5 = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",13,bc5,prize5));

        BadConsequence bc6 = new BadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        Prize prize6 = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft",6,bc6,prize6));

        BadConsequence bc7 = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        Prize prize7 = new Prize(1,1);
        unusedMonsters.add(new Monster("Necrófago",13,bc7,prize7));

        BadConsequence bc8 = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.",5,3,0);
        Prize prize8 = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado",11,bc8,prize8));

        BadConsequence bc9 = new BadConsequence("Toses los pulmones y pierdes 2 niveles.",2,0,0);
        Prize prize9 = new Prize(1,1);
        unusedMonsters.add(new Monster("Flecher",2,bc9,prize9));

        BadConsequence bc10 = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",true);
        Prize prize10 = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos",8,bc10,prize10));

        BadConsequence bc11 = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2);
        Prize prize11 = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu",4,bc11,prize11));

        BadConsequence bc12 = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        Prize prize12 = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo",1,bc12,prize12));

        BadConsequence bc13 = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
        Prize prize13 = new Prize(2,1);
        unusedMonsters.add(new Monster("Pollipólipo volante",3,bc13,prize13));

        BadConsequence bc14 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        Prize prize14 = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth",14,bc14,prize14));

        BadConsequence bc15 = new BadConsequence("La familia te atrapa. Estás muerto",true);
        Prize prize15 = new Prize(3,1);
        unusedMonsters.add(new Monster("Familia feliz",1,bc15,prize15));

        BadConsequence bc16 = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
        Prize prize16 = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth",8,bc16,prize16));

        BadConsequence bc17 = new BadConsequence("Te asusta la noche. Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        Prize prize17 = new Prize(1,1);
        unusedMonsters.add(new Monster("El espía sordo",5,bc17,prize17));

        BadConsequence bc18 = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        Prize prize18 = new Prize(2,1);
        unusedMonsters.add(new Monster("Tongue",19,bc18,prize18));

        BadConsequence bc19 = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ONEHAND)),new ArrayList());
        Prize prize19 = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicéfalo",21,bc19,prize19));
        
        BadConsequence bc20 = new BadConsequence("Pierdes 1 mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        Prize prize20 = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable.",10,bc20,prize20,-2));
        
        BadConsequence bc21 = new BadConsequence("Pierdes tus tesoros visibles. Jajaja.",0,BadConsequence.getMaxTreasures(),0);
        Prize prize21 = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares.",6,bc21,prize21,2));
        
        BadConsequence bc22 = new BadConsequence("Hoy no es tu dia de suerte. Mueres.",true);
        Prize prize22 = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu.",6,bc22,prize22,4));
        
        BadConsequence bc23 = new BadConsequence("Tu gobierno te recorta 2 niveles.",2,0,0);
        Prize prize23 = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Politico.",8,bc23,prize23,-2));
        
        BadConsequence bc24 = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.HELMET)),new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ONEHAND,TreasureKind.ONEHAND)));
        Prize prize24 = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth.",2,bc24,prize24,5));
   
    }
   
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    private void shuffleTreasures()
    {
    Collections.shuffle(unusedTreasures);
    }
   
    private void shuffleMonsters()
    {
        Collections.shuffle(unusedMonsters);
    }
   
    public static CardDealer getInstance(){
        return instance;
    }
    
    public Cultist nextCultist(){
        Cultist c = unusedCultists.get(0);
        unusedCultists.remove(c);
        return c;
    }
   
    public Treasure nextTreasure(){
        if( unusedTreasures.isEmpty() ){
            unusedTreasures = usedTreasures;
            usedTreasures.clear();
            this.shuffleTreasures();
           
        }
        Treasure t = unusedTreasures.get(0);
        usedTreasures.add(t);
        unusedTreasures.remove(t);
        return t;
       
    }
   
    public Monster nextMonster(){
        if( unusedMonsters.isEmpty() ){
            unusedMonsters = usedMonsters;
            usedMonsters.clear();
            this.shuffleMonsters();
        }
        Monster res;
        res = unusedMonsters.get(0);
        usedMonsters.add(res);
        unusedMonsters.remove(res);
        return res;
    }
   
    public void giveTreasureBack(Treasure t)
    {
        usedTreasures.add(t);
        unusedTreasures.remove(t);
    }
   
    public void giveMonsterBack(Monster m)
    {
        usedMonsters.add(m);
        unusedMonsters.remove(m);
    }
   
    public void initCards(){
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
        this.shuffleCultists();
        this.shuffleMonsters();
        this.shuffleTreasures();
    }
    
}
