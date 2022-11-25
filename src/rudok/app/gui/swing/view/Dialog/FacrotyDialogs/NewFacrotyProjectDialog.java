package rudok.app.gui.swing.view.Dialog.FacrotyDialogs;

import rudok.app.gui.swing.controller.EnableButton;
import rudok.app.gui.swing.controller.factories.newActionFactory_NIJE_NAJBOLJI_FACTORY.NewProjectFactory;
import rudok.app.gui.swing.controller.save.MyChangeFilter;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class NewFacrotyProjectDialog extends JDialog {

    public NewFacrotyProjectDialog(NewProjectFactory newProjectAction){
        this.newProjectAction = newProjectAction;
        initialise();
    }

    private NewProjectFactory newProjectAction;
    private String imageURL;

    public void initialise() {
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
        JLabel labelPresentation = new JLabel();
        JLabel labelAutor = new JLabel();
        JLabel labelImageURL = new JLabel();

        JTextField textFieldProject = new JTextField("",25);
        JTextField textFieldPresentation = new JTextField("",25);
        JTextField textFieldAutor = new JTextField("",25);
        JTextField textFieldURL = new JTextField("",25);


        JButton button = new JButton("OK");
        JButton buttonOpen = new JButton("Choose background");

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

                /*
        ovo je namenjeno da disable button ukoliko nije svako polje popunjeno
         */
        ButtonModel model = button.getModel();
        Document document1 = textFieldProject.getDocument();
        Document document2 = textFieldPresentation.getDocument();
        Document document3 = textFieldAutor.getDocument();
        Document document4 = textFieldURL.getDocument();
        EnableButton enableButton = new EnableButton(model);
        enableButton.addText(document1);
        enableButton.addText(document2);
        enableButton.addText(document3);
        enableButton.addText(document4);


        labelProject.setText("Please enter Project name:");
        labelPresentation.setText("Please enter Presentation title");
        labelAutor.setText("Please enter Autor name:");
        labelImageURL.setText("Please choose the background image");


        labelProject.setMaximumSize(new Dimension(200,30));
        labelPresentation.setMaximumSize(new Dimension(200,30));
        labelAutor.setMaximumSize(new Dimension(200,30));
        labelImageURL.setMaximumSize(new Dimension(200,30));

        textFieldProject.setMaximumSize(new Dimension(400,30));
        textFieldPresentation.setMaximumSize(new Dimension(400,30));
        textFieldAutor.setMaximumSize(new Dimension(400,30));
        textFieldURL.setMaximumSize(new Dimension(400,30));



        textFieldURL.setEditable(false);

        button.setSize(30,10);

        /*
        selektovanje pozadine za slide
         */
        buttonOpen.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new MyChangeFilter());
            if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.imageURL = jFileChooser.getSelectedFile().getAbsolutePath();
                textFieldURL.setText(imageURL);
            }
        });
        /*
        pokretanje finished metode za novi projekat
         */
        button.addActionListener(e -> {
            this.newProjectAction.finished(textFieldProject.getText(),textFieldPresentation.getText(),textFieldAutor.getText(),this.imageURL);
            MainFrame.getInstance().getjSplitPane().updateUI();
        } );

        panel.add(labelProject);
        panel.add(textFieldProject);
        panel.add(labelPresentation);
        panel.add(textFieldPresentation);
        panel.add(labelAutor);
        panel.add(textFieldAutor);
        panel.add(labelImageURL);
        panel.add(buttonOpen);
        panel.add(textFieldURL);
        panel.add(button);

        JScrollPane jScrollPane = new JScrollPane(panel);
        this.getContentPane().add(jScrollPane);
    }
}

