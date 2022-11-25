package rudok.app.gui.swing.view.Dialog.delete;

import rudok.app.gui.swing.controller.EnableButton;
import rudok.app.gui.swing.controller.delete.DeleteProjectAction;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class DeleteProjectDialog extends JDialog{

    public DeleteProjectDialog(DeleteProjectAction deleteProjectAction) throws Exception{
        this.deleteProjectAction = deleteProjectAction;
        initialise();
    }

    private DeleteProjectAction deleteProjectAction;
    private String[] projects = new String[Workspace1.getInstance().getWorkspace().getChildren().size()];

    int i = 0;

    public void initialise() throws NullPointerException{
        for(RuNode child : Workspace1.getInstance().getWorkspace().getChildren()){
            projects[i] = child.toString();
            i++;
        }
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

        JCheckBox sure = new JCheckBox("Select this if you are sure that you want to detele this project./n Projects once deleted can't be retrived");
        JComboBox jComboBox = new JComboBox(projects);

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
        labelProject.setText("Please select project:");

        labelProject.setMaximumSize(new Dimension(200,30));

        textFieldProject.setMaximumSize(new Dimension(400,30));
        jComboBox.setMaximumSize(new Dimension(400,30));

        textFieldProject.setText(jComboBox.getSelectedItem().toString());


        button.setSize(30,10);
        /*
        pritiskom na dugme pokrecemo finished metodu iz deleteProjectAction i prosledjujemo slektovani projekat i potvrdu
         */
        button.addActionListener(e -> this.deleteProjectAction.finished(jComboBox.getSelectedItem().toString(),sure.isSelected()));

        panel.add(labelProject);
        panel.add(jComboBox);
        panel.add(sure);
        panel.add(button);

        JScrollPane jScrollPane = new JScrollPane(panel);
        this.getContentPane().add(jScrollPane);
    }
}

