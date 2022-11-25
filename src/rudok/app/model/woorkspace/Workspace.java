package rudok.app.model.woorkspace;


import rudok.app.gui.swing.view.MainFrame;

import java.io.File;
import java.util.ArrayList;

public class Workspace extends  RuNodeComp{

    private File workspaceSaveFile;

    private ArrayList<String> childrenURL = new ArrayList<>();


    public Workspace(String string){
        super(string);
        this.setTYPE("WORKSPACE");
    }

    @Override
    public void addChild(RuNode child) {
        super.addChild(child);
        notifzSubscribers(child.getName());
    }

    @Override
    public void removeChild(RuNode child) {
        if(child instanceof Project) {
            super.removeChild(child);
        }
    }


    @Override
    public String toString() {
        return super.getName();
    }

    public File getWorkspaceSaveFile() {
        return workspaceSaveFile;
    }

    public void setWorkspaceSaveFile(File workspaceSaveFile) {
        this.workspaceSaveFile = workspaceSaveFile;
    }

    public ArrayList<String> getChildrenURL() {
        return childrenURL;
    }

    public void addChildrenURL(String childURL) {
        this.childrenURL.add(childURL);
    }

    public void removeChildURL(String childURL){
        childrenURL.remove(childURL);
    }
}
