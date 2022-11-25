package rudok.app.gui.swing.controller.save;

import rudok.app.gui.swing.view.MainFrame;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class MySaveFilter extends FileFilter {

    /*
    Filter koji nam omogucava da samo prikazemo direktorijume ili fajlove nase ekstenzije
     */
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(MainFrame.getInstance().getExtension()));
    }

    @Override
    public String getDescription() {
        return "Custom save file (" + MainFrame.getInstance().getExtension() + ")";
    }
}
