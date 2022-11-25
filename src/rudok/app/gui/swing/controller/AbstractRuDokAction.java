package rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractRuDokAction extends AbstractAction {
    /*
    nasa abstraktna akcija koji svako nase dugme nasledjuje da bi dodelili sliku
     */

    public Icon loadIcon(String fileName){
        Image icon = null;
        Icon littleicon = null;
        if(fileName != null){
            icon = new ImageIcon(fileName).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            littleicon = new ImageIcon(icon);
        } else {
            System.err.println("Image not found: " + fileName);
        }
        return littleicon;
    }
}
