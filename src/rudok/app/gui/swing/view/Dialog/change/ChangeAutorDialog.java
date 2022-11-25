package rudok.app.gui.swing.view.Dialog.change;

import rudok.app.gui.swing.controller.change.ChangeAutorAction;
import rudok.app.gui.swing.controller.EnableButton;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class ChangeAutorDialog extends JDialog{

    public ChangeAutorDialog(ChangeAutorAction changeAutorDialog){
        this.changeAutorAction = changeAutorDialog;
        initialise();
    }

    private ChangeAutorAction changeAutorAction;
    private String Name;

    public void initialise(){
        /*
        postavlja dimenzije na polovinu ekrana
         */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screenWidth/2,screenHeight/2);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setUndecorated(false);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel labelProject = new JLabel();
        JTextField textFieldProject = new JTextField("",25);

        JButton button = new JButton("OK");

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        /*
        ovo je namenjeno da disable button ukoliko nije svako polje popunjeno
         */
        ButtonModel model = button.getModel();
        Document document1 = textFieldProject.getDocument();
        Document document2 = textFieldProject.getDocument();
        Document document3 = textFieldProject.getDocument();
        Document document4 = textFieldProject.getDocument();

        EnableButton enableButton = new EnableButton(model);
        enableButton.addText(document1);
        enableButton.addText(document2);
        enableButton.addText(document3);
        enableButton.addText(document4);
        labelProject.setText("New autor:");

        labelProject.setMaximumSize(new Dimension(200,30));

        textFieldProject.setMaximumSize(new Dimension(400,30));


/*
pritiskom na dugme izvrsavamo finished metodu iz changeAutorAction
 */
        button.setSize(30,10);
        button.addActionListener(e -> this.changeAutorAction.finished(textFieldProject.getText()));

        panel.add(labelProject);
        panel.add(textFieldProject);
        panel.add(button);

        JScrollPane jScrollPane = new JScrollPane(panel);
        this.getContentPane().add(jScrollPane);
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        Name = name;
    }
}

