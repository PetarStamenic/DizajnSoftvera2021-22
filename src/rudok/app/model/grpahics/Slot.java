package rudok.app.model.grpahics;

import rudok.app.gui.swing.view.MainFrame;
import rudok.app.gui.swing.view.paint_Ni_ja_nisam_siguran_kako_ovo_radi.PaintTheSlot;
import rudok.app.gui.swing.view.paint_Ni_ja_nisam_siguran_kako_ovo_radi.Painter;
import rudok.app.model.woorkspace.Slide;
import rudok.app.observer.IPublisher;
import rudok.app.observer.ISubscriber;
import rudok.app.repository.Workspace1;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Slot extends DiagramDevice implements IPublisher , Serializable {


    private transient List<ISubscriber> subscribers = new ArrayList<>();
    private Slide parent;
    private String content;
    private String config;
    private int type;
    private boolean bold;
    private boolean italic;
    private String font;
    private int size;


    public Slot(Stroke stroke, Paint paint, Point point, Dimension size) {
        super(stroke, paint, point, size);
        painter = new PaintTheSlot(this);
        subscribers.add(MainFrame.getInstance());
    }


    public void setPoint(int x, int y){
        super.setPoint(new Point(x,y));
        notifzSubscribers("Heathcliff");
    }

    @Override
    public Painter getPainter() {
        return this.painter;
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(!(subscribers.contains(subscriber))){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if(subscribers.contains(subscriber)){
            subscribers.remove(subscriber);
        }

    }

    @Override
    public void notifzSubscribers(Object notification) {
        if(subscribers == null){
            subscribers = new ArrayList<>();
            subscribers.add(MainFrame.getInstance());
        }
        Workspace1.getInstance().getActiveProject().setChanged(true);
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }

    public void setParent(Slide parent) {
        this.parent = parent;
    }


    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }
}
