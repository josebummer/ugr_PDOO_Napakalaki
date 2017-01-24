/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import GUI.*;
import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class PruebaPractica5 {
    
     public static void main(String[] args) {
         Napakalaki napakalakiModel = Napakalaki.getInstance();
         NapakalakiView napakalakiView = new NapakalakiView();
         Dice.createInstance(napakalakiView);
         PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
         ArrayList<String> names = namesCapture.getNames();
         napakalakiModel.initGame(names);
         napakalakiView.setNapakalaki(napakalakiModel);
         napakalakiView.showView();
     }
}
