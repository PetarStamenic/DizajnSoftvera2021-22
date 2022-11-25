package rudok.app.gui.swing.controller.viewControler;

import rudok.app.observer.IPublisher;
import rudok.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class ProjectViewControler implements IPublisher {

    private List<ISubscriber> subscribers = new ArrayList<>();

    public void renderProject(String string){
        notifzSubscribers(string);
    }

    public void renderProject(){
        notifzSubscribers("Heathcliff");
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
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }
}
