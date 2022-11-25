package rudok.app.gui.swing.tree.view.elements;

import rudok.app.gui.swing.controller.TabbedPandeListener;
import rudok.app.gui.swing.controller.state.slideshow.SlideStateToolbar;
import rudok.app.gui.swing.tree.view.elements.slide.GroupSlideView;
import rudok.app.gui.swing.tree.view.elements.slide.SlideShowView;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.gui.swing.view.toolbars.DrawStateToolbar;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.RuNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PresentationView extends JTabbedPane {

    private ArrayList<RuNode> presentations;
    private SlideStateToolbar slideStateToolbar;
    private int ActiveIndex = 0;
    private DrawStateToolbar drawStateToolbar;

/*
Omogucava odabir iymedju edit moda i slide show moda
 */
    public PresentationView(ArrayList<RuNode> presentations, int activePresentation) {
        this.ActiveIndex = activePresentation;
        this.addChangeListener(new TabbedPandeListener(this));
        this.presentations = presentations;
        for (RuNode pres : presentations) {
            String sw = ((Presentation)pres).getState();
            switch (sw) {
                case "EDIT" -> {
                    slideStateToolbar = new SlideStateToolbar();
                    JPanel jPanel = new JPanel();
                    jPanel.setLayout(new BorderLayout());
                    jPanel.add(slideStateToolbar, BorderLayout.NORTH);
                    GroupSlideView groupSlideView = new GroupSlideView(pres);
                    groupSlideView.getVerticalScrollBar().setUnitIncrement(30);
                    jPanel.add(groupSlideView, BorderLayout.CENTER);
                    MainFrame.getInstance().enableEdit();
                    this.addTab(pres.getName(), jPanel);
                }
                case "SHOW" -> {
                    MainFrame.getInstance().disableEdit();
                    slideStateToolbar = new SlideStateToolbar();
                    JPanel jPanel = new JPanel();
                    jPanel.setLayout(new BorderLayout());
                    jPanel.add(slideStateToolbar, BorderLayout.NORTH);
                    SlideShowView slideShowView = new SlideShowView(pres);
                    jPanel.add(slideShowView, BorderLayout.CENTER);
                    this.addTab(pres.getName(), jPanel);
                }
            }
        }
            this.setSelectedIndex(ActiveIndex);
    }
    public Presentation getPresentation() {
        return (Presentation) presentations.get(this.getSelectedIndex());
    }

}
