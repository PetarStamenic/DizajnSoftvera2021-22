package rudok.app.repository;

import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.Slide;
import rudok.app.model.woorkspace.Workspace;

import java.util.ArrayList;

public class Workspace1{

    private Workspace1(){
    }


    private static Workspace1 instance;
    private Workspace workspace;
    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<Presentation> presentations = new ArrayList<>();
    private ArrayList<Slide> slides = new ArrayList<>();
    private Project activeProject;
    private Presentation activePresentation;
    private Boolean busy = false;


    public static Workspace1 getInstance() {
        if(instance == null){
            instance = new Workspace1();
            instance.initialise();
        }
        return instance;
    }

    private void initialise(){
        workspace = new Workspace("Workspace");
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(ArrayList<Presentation> presentations) {
        this.presentations = presentations;
    }

    public ArrayList<Slide> getSlides() {
        return slides;
    }

    public void setSlides(ArrayList<Slide> slides) {
        this.slides = slides;
    }

    public Project getActiveProject() {
        return activeProject;
    }

    public void setActiveProject(Project activeProject) {
        this.activeProject = activeProject;
    }

    public Presentation getActivePresentation() {
        return activePresentation;
    }

    public void setActivePresentation(Presentation activePresentation) {
        this.activePresentation = activePresentation;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
        if(!busy)
        workspace.updateDate(true);
    }
}
