/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jose
 */
public class PruebaNapakalaki {
    
    static ArrayList<Monster> monstruos = new ArrayList();
    
    static ArrayList<Monster> NvMayor10(){
        ArrayList<Monster> salida = new ArrayList();
        for( Monster m : monstruos){
            if(m.getCombatLevel()>10){
                salida.add(m);
            }
        }
        return salida;     
    }
    
    static ArrayList<Monster> BcLostLevel(){
        ArrayList<Monster> salida = new ArrayList();
        for( Monster m : monstruos){
            BadConsequence p = m.getBadConsequence();
            if(p.getLevels()>0 ){
                salida.add(m);
            }
        }
        return salida;
    }
    
    static public ArrayList<Monster>GananciaMayor1Nivel(){
            ArrayList<Monster>salida = new ArrayList();
            for( Monster m: monstruos ){
                if( (m.getLevelsGained()) > 1 )
                    salida.add(m);
                   
            }
    return salida;
    }
    
    /*static public ArrayList<Monster>PierdesTesoro(TreasureKind Tesoro){
            ArrayList<Monster>salida = new ArrayList();
            for( Monster m: monstruos ){
                if( (m.getBadConsequence().getspecificHiddenTreasures().contains(Tesoro)) || m.getBadConsequence().getspecificVisibleTreasures().contains(Tesoro))
                     salida.add(m);
            }
            return salida;
    }*/
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpecificBadConsequence bc1 = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)) );
        Prize prize1 = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, bc1,prize1));

        SpecificBadConsequence bc2 = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        Prize prize2 = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan",2,bc2,prize2));

        SpecificBadConsequence bc3 = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList());
        Prize prize3 = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich",2,bc3,prize3));

        SpecificBadConsequence bc4 = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta a 1 mano visible y a 1 mano oculta.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize4 = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magalud",2,bc4,prize4));

        NumericBadConsequence bc5 = new NumericBadConsequence("Pierdes todos tus tesoreos visibles.",0,BadConsequence.getMaxTreasures(),0);
        Prize prize5 = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral",13,bc5,prize5));

        SpecificBadConsequence bc6 = new SpecificBadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        Prize prize6 = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft",6,bc6,prize6));

        SpecificBadConsequence bc7 = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        Prize prize7 = new Prize(1,1);
        monstruos.add(new Monster("Necrófago",13,bc7,prize7));

        NumericBadConsequence bc8 = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles.",5,3,0);
        Prize prize8 = new Prize(3,2);
        monstruos.add(new Monster("El rey de rosado",11,bc8,prize8));

        NumericBadConsequence bc9 = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.",2,0,0);
        Prize prize9 = new Prize(1,1);
        monstruos.add(new Monster("Flecher",2,bc9,prize9));

        DeathBadConsequence bc10 = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",true);
        Prize prize10 = new Prize(2,1);
        monstruos.add(new Monster("Los hondos",8,bc10,prize10));

        NumericBadConsequence bc11 = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2);
        Prize prize11 = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu",4,bc11,prize11));

        SpecificBadConsequence bc12 = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        Prize prize12 = new Prize(2,1);
        monstruos.add(new Monster("Dameargo",1,bc12,prize12));

        NumericBadConsequence bc13 = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
        Prize prize13 = new Prize(2,1);
        monstruos.add(new Monster("Pollipólipo volante",3,bc13,prize13));

        DeathBadConsequence bc14 = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        Prize prize14 = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth",14,bc14,prize14));

        DeathBadConsequence bc15 = new DeathBadConsequence("La familia te atrapa. Estás muerto",true);
        Prize prize15 = new Prize(3,1);
        monstruos.add(new Monster("Familia feliz",1,bc15,prize15));

        SpecificBadConsequence bc16 = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
        Prize prize16 = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth",8,bc16,prize16));

        SpecificBadConsequence bc17 = new SpecificBadConsequence("Te asusta la noche. Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        Prize prize17 = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo",5,bc17,prize17));

        NumericBadConsequence bc18 = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        Prize prize18 = new Prize(2,1);
        monstruos.add(new Monster("Tongue",19,bc18,prize18));

        SpecificBadConsequence bc19 = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ONEHAND)),new ArrayList());
        Prize prize19 = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo",21,bc19,prize19));
        
        
        //System.out.println(PruebaNapakalaki.PierdesTesoro(TreasureKind.ONEHAND).toString());
        System.out.println(PruebaNapakalaki.GananciaMayor1Nivel().toString());
            
    }
    
}
