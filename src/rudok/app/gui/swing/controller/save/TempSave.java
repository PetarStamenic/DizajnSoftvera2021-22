package rudok.app.gui.swing.controller.save;

import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.model.woorkspace.Workspace;
import rudok.app.repository.Workspace1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

public class TempSave {

    /*
    Klasa namenjana za cuvanje projekata i radne povrsine preko Unix vremena cisto radi testiranja
     */
    public void doTheThingProject(Project project){
        try {
            long unixTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            FileOutputStream fileOutputStream = new FileOutputStream("storage/temp/"+unixTime+"-temp-"+project.getName()+".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(project);
            objectOutputStream.close();
            fileOutputStream.close();
            Workspace1.getInstance().getActiveProject().setChanged(false);
            MainFrame.getInstance().getWorkspaceTree().revalidate();
        } catch (IOException i){
            i.printStackTrace();
        }

    }
    public void doTheThingWorkspace(){
        Workspace workspace = Workspace1.getInstance().getWorkspace();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("storage/WorkspaceContext.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workspace.getName());
            objectOutputStream.writeObject(workspace.getChildrenURL());
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException i){
            i.printStackTrace();
        }

    }

    public void tempSaveAll(){
        for (RuNode project : Workspace1.getInstance().getWorkspace().getChildren()) {
            doTheThingProject((Project) project);
        }
        doTheThingWorkspace();

    }


}
