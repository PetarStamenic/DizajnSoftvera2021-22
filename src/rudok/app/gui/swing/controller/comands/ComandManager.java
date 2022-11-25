package rudok.app.gui.swing.controller.comands;

import rudok.app.gui.swing.view.MainFrame;

import java.util.ArrayList;

public class ComandManager {

    private ArrayList<AbstractCommant> commands = new ArrayList<>();
    private int currCom = 0;
/*
Array lista cuva sve komande koje smo imali do sada (sva kreiranja brisanja pomeranja)
 */

    /*
    dodavanje komandi prilikom koje se sve komande koje su iza trenutno (ukoliko je uradjen undo nekoliko puta)
    brisu i vise ne mozemo da radimo redo
     */
    public void addCommand(AbstractCommant commant){
        while(currCom < commands.size()){
            commands.remove(currCom);
        }
        commands.add(commant);
        redoCommand();
    }

    /*
    proverava da li postoji redo commanda ukolio postoji izvrsava je i ukljucuje undo dugme
    ukoliko je trenutna komanda na kojoj smo i poslednja u listi redo dugme se disable
     */
    public void redoCommand(){
        if(currCom<commands.size()){
            commands.get(currCom++).redoCommand();
            MainFrame.getInstance().getActionManager().getUndoCommand().setEnabled(true);
        }
        if(currCom == commands.size()){
            MainFrame.getInstance().getActionManager().getRedoCommand().setEnabled(false);
        }
    }

    /*
        proverava da li postoji undo commanda ukolio postoji izvrsava je i ukljucuje redo dugme
        ukoliko je trenutna komanda na kojoj smo i prva u listi undo dugme se disable
         */
    public void undoCommand(){
        if(currCom>0){
            MainFrame.getInstance().getActionManager().getRedoCommand().setEnabled(true);
            commands.get(--currCom).undoCommand();
        }
        if(currCom == 0){
            MainFrame.getInstance().getActionManager().getUndoCommand().setEnabled(false);
        }
    }


}
