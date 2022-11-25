package rudok.app.gui.swing.tree.view.elements;

import rudok.app.gui.swing.tree.view.elements.slide.SlidePreview;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;

import javax.swing.*;
import java.awt.*;

public class ProjectView extends JPanel {

    private Project project;

    private PresentationMasterView presentationMasterView;
    private PresentationView presentationView;
    private SlidePreview slidePreview;


    public ProjectView(Project project , int i){
        init(project , i);
    }

    public void init(Project project, int presentationNumber){
        this.project = project;
        presentationView = new PresentationView(project.getChildren(),presentationNumber);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel(project.getName()));
        slidePreview = new SlidePreview((Presentation)project.getChildren().get(presentationNumber));
        presentationMasterView = new PresentationMasterView((Presentation) project.getChildren().get(presentationNumber),slidePreview,presentationView);
        slidePreview.setMinimumSize(new Dimension(100,100));
        slidePreview.setMaximumSize(new Dimension(100,100));
        this.add(presentationMasterView);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}

