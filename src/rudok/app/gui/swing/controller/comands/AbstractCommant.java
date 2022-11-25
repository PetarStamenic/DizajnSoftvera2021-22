package rudok.app.gui.swing.controller.comands;

public abstract class AbstractCommant {
/*
Abstraktna klasa koju cemo kasnije naslediti za undo i redo
 */
    public abstract void redoCommand();

    public abstract void undoCommand();

}
