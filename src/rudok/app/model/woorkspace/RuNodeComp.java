package rudok.app.model.woorkspace;

import java.util.ArrayList;

public abstract class RuNodeComp extends RuNode {

    public RuNodeComp(String string){
        super(string);

    }

    private ArrayList<RuNode> children = new ArrayList<>();




    public ArrayList<RuNode> getChildren(){
        return children;
    }

    public void addChild(RuNode child){
        this.children.add(child);
    }

    public void removeChild(RuNode child){
        if(children.contains(child)){
            children.remove(child);
            notifzSubscribers("Heathcliff");
        }
    }

    public void removeallChildren(){
        children = new ArrayList<>();
        notifzSubscribers("Heathcliff");
    }
}
