package rudok.app.gui.swing.tree.view.elements.slide;

import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.model.woorkspace.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SlideShowView extends JPanel {

    private JPanel slidePanel;
    private JPanel buttonsPanel;
    private CardLayout cardLayout;
    private JButton btnNext;
    private JButton btnPrev;

    private RuNode presentation;
    private ArrayList<RuNode> slides;


/*
Otvara slide show mod gde slide se prikazuje posebno i ima dugmice za pomeranje
 */
    public SlideShowView(RuNode presentation){
        this.presentation = presentation;
        this.slides = ((Presentation)presentation).getChildren();
        int counter = 0;
        cardLayout = new CardLayout();
        slidePanel = new JPanel();
        buttonsPanel = new JPanel();
        btnNext = new JButton("Next >");
        btnPrev = new JButton("< Prev");

        this.setLayout(new BorderLayout());

        slidePanel.setLayout(cardLayout);

        for (RuNode sl : slides){
            SlideView newslide = new SlideView((Slide)sl, ((Presentation)presentation).getImageURL(),600,400);
            newslide.setMinimumSize(new Dimension(600,400));
            newslide.setMaximumSize(new Dimension(600,400));
            newslide.setPreferredSize(new Dimension(600,400));
            slidePanel.add(newslide);
        }

        this.add(slidePanel,BorderLayout.CENTER);

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER , 20 , 10));

        btnPrev.addActionListener(e-> cardLayout.previous(slidePanel));

        btnNext.addActionListener(e->cardLayout.next(slidePanel));

        buttonsPanel.add(btnPrev);
        buttonsPanel.add(btnNext);

        this.add(buttonsPanel,BorderLayout.SOUTH);

    }

}
