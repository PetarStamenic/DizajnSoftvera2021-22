package rudok.app.gui.swing.tree.view.elements;

import rudok.app.gui.swing.tree.view.elements.slide.SlidePreview;
import rudok.app.model.woorkspace.Presentation;

import javax.swing.*;

public class PresentationMasterView extends JSplitPane {

    public PresentationMasterView(Presentation presentation, SlidePreview scrollPaneLeft, PresentationView jPaneRight){
        super(JSplitPane.HORIZONTAL_SPLIT,scrollPaneLeft,jPaneRight);
    }
}
