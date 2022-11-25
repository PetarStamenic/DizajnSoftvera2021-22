package rudok.app.gui.swing.controller.save;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CloseSaver implements WindowListener {

    /*
    Prilikom zatvaranja aplikacije cuva kontekt da bi smo mogli da ucitamo sve prilikom ponovnog pokretanja
    nudi cuvanje projekta prilikom gasenja aplikacije
     */
    TempSave tempSave = new TempSave();
    SaveProject saveProject = new SaveProject();

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
            saveProject.saveAll();
            tempSave.tempSaveAll();

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
