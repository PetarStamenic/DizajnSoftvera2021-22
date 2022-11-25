package rudok.app.gui.swing.controller.factories.newActionFactory_NIJE_NAJBOLJI_FACTORY;

import rudok.app.gui.swing.tree.MyTreeNode;


public class NewActionFactory {

    public NewActionFactory(){

    }

    public static TreeNodeCreator createNewTreeNode(MyTreeNode myTreeNode) throws NullPointerException{
        if(myTreeNode != null) {
            switch (myTreeNode.getRunode().getTYPE()) {
                case "WORKSPACE" -> {
                    return new NewProjectFactory();
                }
                case "PROJECT" -> {
                    return new NewPresentationFactory(myTreeNode);
                }
                case "PRESENTATION" -> {
                    return new NewSlideFactory(myTreeNode);
                }
                case "SLIDE" -> {
                    return new NewSlideFromSlideFactory(myTreeNode);
                }
            }
        }
        return null;
    }
}
