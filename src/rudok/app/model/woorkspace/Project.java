package rudok.app.model.woorkspace;

import java.io.File;

public class Project extends RuNodeComp{

    private File file;

    public Project(RuNode parent,String string){
        super(string);
        this.setParent(parent);
        this.setTYPE("PROJECT");
    }

    @Override
    public void addChild(RuNode child) {
         super.addChild(child);
         this.setChanged(true);
         notifzSubscribers("Heathcliff");
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
