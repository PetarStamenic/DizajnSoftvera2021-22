package rudok.app.gui.swing.view.Dialog.change;

import rudok.app.gui.swing.controller.change.ChangeBackgroundAction;
import rudok.app.gui.swing.controller.EnableButton;
import rudok.app.gui.swing.controller.save.MyChangeFilter;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class ChangeBackgroundDialog extends JDialog{

    public ChangeBackgroundDialog(ChangeBackgroundAction changeBackgroundAction){
        this.changeBackgroundAction = changeBackgroundAction;
        initialise();
    }

    private ChangeBackgroundAction changeBackgroundAction;
    private String Name;

    public void initialise(){
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
        JButton openButton = new JButton("Open");

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
        labelProject.setText("New background;");

        labelProject.setMaximumSize(new Dimension(200,30));

        textFieldProject.setMaximumSize(new Dimension(400,30));
        textFieldProject.setEditable(false);
        openButton.addActionListener(e -> {
            /*
            Pritiskom na dugme otvaramo JFileChooser kojim biramo fotografiju za pozadinu
             */
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new MyChangeFilter());
            if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.Name = jFileChooser.getSelectedFile().getAbsolutePath();
                textFieldProject.setText(Name);
            }
        });

        button.setSize(30,10);
        button.addActionListener(e ->this.changeBackgroundAction.finished(textFieldProject.getText()));

        panel.add(labelProject);
        panel.add(textFieldProject);
        panel.add(openButton);
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

