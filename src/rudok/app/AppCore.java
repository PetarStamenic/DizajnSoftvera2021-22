package rudok.app;

import rudok.app.gui.swing.controller.save.CloseSaver;
import rudok.app.gui.swing.controller.save.OpenWorkspace;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;


public class AppCore {


    public static void main(String[] args){

        MainFrame frame = MainFrame.getInstance();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new CloseSaver());

        OpenWorkspace openWorkspace = new OpenWorkspace();
        openWorkspace.doTheThing(new File("storage/WorkspaceContext.txt"));
    }

}
