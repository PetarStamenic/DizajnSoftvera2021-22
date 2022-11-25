package rudok.app.gui.swing.controller.save;

import rudok.app.gui.swing.view.MainFrame;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class MyChangeFilter extends FileFilter {
    /*
    klasa napravljena da bi prilikom koriscenja JFileChoosera mogli da dozvolimo samo selekciju
    .jpg .jpeg .png
     */
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".jpeg") || f.getName().toLowerCase().endsWith(".png"));
    }
/*
Prikaz u comboboxu JFilechoosera sta je sve dozvoljeno da se selektuje
 */
    @Override
    public String getDescription() {
        return "Image file(.jpg .jpeg .png)";
    }
}
