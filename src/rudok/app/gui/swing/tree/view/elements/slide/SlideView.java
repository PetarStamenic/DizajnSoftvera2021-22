package rudok.app.gui.swing.tree.view.elements.slide;

import rudok.app.gui.swing.controller.draw.DeleteSlotControler;
import rudok.app.gui.swing.controller.draw.EditControler;
import rudok.app.gui.swing.controller.draw.MouseMotionControler;
import rudok.app.gui.swing.controller.draw.NewSlotControler;
import rudok.app.gui.swing.view.paint_Ni_ja_nisam_siguran_kako_ovo_radi.Painter;
import rudok.app.model.grpahics.Slot;
import rudok.app.model.woorkspace.Slide;
import rudok.app.observer.ISubscriber;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import java.awt.*;

public class SlideView extends JPanel implements ISubscriber {


    private DrawArea drawArea;
    private Slide slide;
    private int ToolBarState = 0;

    EditControler editControler = new EditControler(this);
    NewSlotControler newSlotControler = new NewSlotControler(this);
    DeleteSlotControler deleteSlotControler = new DeleteSlotControler(this);
    MouseMotionControler mouseMotionControler = new MouseMotionControler(this);

    private Image backgroundImage;

/*
Prokazivanje slida sa slikom kao pozadinom
u slucaju od state za slotove dodeljujemo odredjene listenere
0 - edit
1 - new slot
2 - delete slot
3 - move slot

Draw area je Klasa koja extenduje Jpanel i sluzi nam da bi iscritali pozadinu i slotove
 */
    public SlideView(Slide sl, String imageURL,int x,int y) {
        this.slide = sl;
        this.backgroundImage = new ImageIcon(imageURL).getImage().getScaledInstance(x,y,Image.SCALE_SMOOTH);
        drawArea = new DrawArea();
        drawArea.setPreferredSize(new Dimension(x,y));
        drawArea.setMaximumSize(new Dimension(x,y));
        drawArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(drawArea,BorderLayout.CENTER);
        if(Workspace1.getInstance().getActivePresentation().getSlotStateManager().getCurrSelected() != null) {
            ToolBarState = Workspace1.getInstance().getActivePresentation().getSlotStateManager().getCurrSelected().getSelected();
        } else {
            Workspace1.getInstance().getActivePresentation().setSlotStateManager();
            ToolBarState = Workspace1.getInstance().getActivePresentation().getSlotStateManager().getCurrSelected().getSelected();
        }
        switch (ToolBarState){
            case 0:{
                drawArea.removeMouseListener(newSlotControler);
                drawArea.removeMouseListener(deleteSlotControler);
                drawArea.removeMouseListener(mouseMotionControler);
                drawArea.addMouseListener(editControler);
                this.slide = editControler.getSlideView().getSlide();
                break;
            }
            case 1:{
                drawArea.removeMouseListener(deleteSlotControler);
                drawArea.removeMouseListener(mouseMotionControler);
                drawArea.removeMouseListener(editControler);
                drawArea.addMouseListener(newSlotControler);
                this.slide = newSlotControler.getSlideView().getSlide();
                repaint();
                break;
            }
            case 2:{
                drawArea.removeMouseListener(newSlotControler);
                drawArea.removeMouseListener(mouseMotionControler);
                drawArea.removeMouseListener(editControler);
                drawArea.addMouseListener(deleteSlotControler);
                this.slide = deleteSlotControler.getSlideView().getSlide();
                break;
            }
            case 3:{
                drawArea.removeMouseListener(newSlotControler);
                drawArea.removeMouseListener(deleteSlotControler);
                drawArea.removeMouseListener(editControler);
                drawArea.addMouseListener(mouseMotionControler);
                this.slide = mouseMotionControler.getSlideView().getSlide();
                break;
            }
        }
    }

    public void setSlide(Slide slide){
        this.slide = slide;
        this.setName(slide.getName());
        this.slide.addSubscriber(this);


    }


    @Override
    public void update(Object notification) {
        repaint();
    }

    public class DrawArea extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.drawImage(backgroundImage, 0, 0, this);

            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));

            for (Slot device : slide.getSlotList()) {
                Painter painter = device.getPainter();
                painter.paint(graphics2D, device);
            }

        }
    }

    public Slide getSlide() {
        return slide;
    }


}
