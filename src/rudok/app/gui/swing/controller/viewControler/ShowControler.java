package rudok.app.gui.swing.controller.viewControler;

import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowControler extends MouseAdapter{

    @Override
    public void mousePressed(MouseEvent e){
            int selectedRown = MainFrame.getInstance().getWorkspaceTree().getRowForLocation(e.getX(),e.getY());
            TreePath selectedPath = MainFrame.getInstance().getWorkspaceTree().getPathForLocation(e.getX(),e.getY());
            if(selectedRown != -1 && e.getClickCount() == 2 && selectedPath != null){
                Object selectedRuNode = selectedPath.getLastPathComponent();
                MainFrame.getInstance().getActionManager().getPainControler().paint((MyTreeNode) selectedPath.getLastPathComponent());
                System.out.println(selectedRuNode.toString());
            }
        }

}
