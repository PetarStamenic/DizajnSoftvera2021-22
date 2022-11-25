package rudok.app.gui.swing.controller;

import rudok.app.gui.swing.tree.view.elements.PresentationView;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPandeListener implements ChangeListener {

    private PresentationView presentationView;

    public TabbedPandeListener(PresentationView jTabbedPane){
        this.presentationView = jTabbedPane;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
        int selected = tabbedPane.getSelectedIndex();
        Workspace1.getInstance().setActivePresentation((Presentation) Workspace1.getInstance().getActiveProject().getChildren().get(selected));
    }

}
