package rudok.app.model.woorkspace;

import rudok.app.gui.swing.view.MainFrame;
import rudok.app.observer.IPublisher;
import rudok.app.observer.ISubscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements IPublisher , Serializable {

    private transient List<ISubscriber> subscribers = new ArrayList<>();

    private String name;
    private RuNode parent;
    private String TYPE;
    private transient Boolean changed = false;
    public Boolean update = false;

    public RuNode(String string){
        this.setName(string);
        subscribers.add(MainFrame.getInstance());
    }

    public String getName() {
        return name;
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
        if(this.subscribers == null) {
            this.subscribers = new ArrayList<>();
            this.subscribers.add(MainFrame.getInstance());
        }
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }

    public void setName(String name) {
        this.name = name;
        notifzSubscribers("Heathcliff");
    }

    public void updateDate(boolean tr){
        notifzSubscribers("Heathcliff");
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public Boolean getChanged() {
        return changed;
    }

    public void setChanged(Boolean changed) {
        this.changed = changed;
    }
}
