package rudok.app.errorHandler;

import rudok.app.observer.IPublisher;
import rudok.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class ErrorFactory implements IPublisher {

    final private List<ISubscriber> subscribers = new ArrayList<>();

    public static ErrorFactory instance;

    private ErrorFactory(){
    }
/*
generateError pravi gresku preko erroCode koji smo proseldili i obavestava sve subscribere
 */
    public void generateError(MyError.ErrorCode errorCode, int i){
        notifzSubscribers(new MyError(errorCode));
    }

/*
ErrirFactory je singleton jer nam je potreban samo jedan i da moyemo da ga poyivamo odakle god
 */
    public static ErrorFactory getInstance(){
        if(instance == null){
            instance = new ErrorFactory();
        }
        return instance;
    }

    /*
    Implementacija mojeg IPublisher interfejsa
     */
    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(!(subscribers.contains(subscriber))){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
            subscribers.remove(subscriber);
    }

    @Override
    public void notifzSubscribers(Object notification) {
        for (ISubscriber sub : subscribers) {
            sub.update(notification);
        }
    }
}
