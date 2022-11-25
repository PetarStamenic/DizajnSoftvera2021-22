package rudok.app.gui.swing.tree.view.elements.slide;

import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.model.woorkspace.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SlidePreview extends JScrollPane {

    private ArrayList<RuNode> slides;
/*
Mali slide preview sa strane
 */
    public SlidePreview(RuNode presentation) {
        this.slides = ((Presentation)presentation).getChildren();
        int counter = 0;
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanel.add(new JLabel(((Presentation)presentation).getAutor()));
        for (RuNode sl : slides){
            SlideView newslide = new SlideView((Slide)sl, ((Presentation)presentation).getImageURL(),60,40);
            newslide.setMinimumSize(new Dimension(60,40));
            newslide.setMaximumSize(new Dimension(60,40));
            newslide.setPreferredSize(new Dimension(60,40));
            jPanel.add(newslide);
            jPanel.add(new JLabel(String.valueOf(((Slide) sl).getRedniBroj())));
        }
        this.getViewport().setView(jPanel);
    }


}

