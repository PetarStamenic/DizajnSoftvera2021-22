package rudok.app.gui.swing.tree.view.elements.slide;

import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.model.woorkspace.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GroupSlideView extends JScrollPane {

    private ArrayList<RuNode> slides;

    /*
    Standardni slide view
     */
    public GroupSlideView(RuNode presentation) {
        this.slides = ((Presentation)presentation).getChildren();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanel.add(new JLabel(((Presentation)presentation).getAutor()));
        for (RuNode sl : slides){
            SlideView newslide = new SlideView((Slide)sl, ((Presentation)presentation).getImageURL(),600,400);
            newslide.setMinimumSize(new Dimension(600,400));
            newslide.setMaximumSize(new Dimension(600,400));
            newslide.setPreferredSize(new Dimension(600,400));
            jPanel.add(newslide);
            jPanel.add(new JLabel(String.valueOf(((Slide) sl).getRedniBroj())));
        }
        this.getViewport().setView(jPanel);
    }


}