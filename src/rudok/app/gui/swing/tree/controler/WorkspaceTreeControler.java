package rudok.app.gui.swing.tree.controler;

import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.Slide;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class WorkspaceTreeControler implements TreeSelectionListener {

    public void valueChanged(TreeSelectionEvent e) {

        TreePath treePath = e.getPath();
        //treePath.getLastPathComponent();

        for(int i=0; i<=treePath.getPathCount(); i++){
            if(treePath.getPathComponent(i) instanceof  Project){
                Project project = (Project)treePath.getPathComponent(i);
            } else if(treePath.getPathComponent(i) instanceof Presentation){
                Presentation presentation = (Presentation)treePath.getPathComponent(i);
            } else if(treePath.getPathComponent(i) instanceof Slide){
                Slide slide = (Slide) treePath.getPathComponent(i);
            }
        break;
        }

    }
}
