package rudok.app.gui.swing.view.Dialog;

import rudok.app.gui.swing.controller.EnableButton;
import rudok.app.gui.swing.controller.draw.NewSlotControlerRuDok;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class ColorPickerDialog extends JDialog {

    public ColorPickerDialog(NewSlotControlerRuDok newSlotControler){
        this.newSlotControler = newSlotControler;
        init();
    }

    private Color color;
    private NewSlotControlerRuDok newSlotControler;
    private JButton jButtonFillColor;
    private JComboBox jComboBoxLine;
    private JTextField textFieldColor;
    private JTextField textFieldLine;
    private JTextField textFieldtest1;
    private JTextField textFieldtest2;
    private JButton button;
    private JLabel labelcolor;
    private JLabel labelLine;
    private String[] lines = new String[2];

    /*
    biramo boju slota i outline
     */
    private void init() {
        lines[0] = "puna linija";
        lines[1] = "isprekidana linija";
        textFieldtest1 = new JTextField();
        textFieldtest2 = new JTextField();
        textFieldLine = new JTextField();
        textFieldColor = new JTextField();
        textFieldtest1.setText("test1");
        textFieldtest2.setText("test2");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screenWidth/2,screenHeight/2);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setUndecorated(false);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        labelcolor =new  JLabel("Choose a color:");
        labelLine = new JLabel("Chose line style");

        jComboBoxLine = new JComboBox(lines);
        textFieldLine.setText(lines[jComboBoxLine.getSelectedIndex()]);


        jButtonFillColor = new JButton("Fill Color");
        jButtonFillColor.addActionListener(e ->{
            JColorChooser colorChooser = new JColorChooser();
            this.color = JColorChooser.showDialog(null,"Pick Fill Color:",Color.CYAN);
            textFieldColor.setText("Done");
        });

        button = new JButton("OK");

                /*
        ovo je namenjeno da disable button ukoliko nije svako polje popunjeno
         */
        ButtonModel model = button.getModel();
        Document document1 = textFieldColor.getDocument();
        Document document2 = textFieldLine.getDocument();
        Document document3 = textFieldtest1.getDocument();
        Document document4 = textFieldtest2.getDocument();
        EnableButton enableButton = new EnableButton(model);
        enableButton.addText(document1);
        enableButton.addText(document2);
        enableButton.addText(document3);
        enableButton.addText(document4);

        labelLine.setMaximumSize(new Dimension(200,30));
        labelLine.setMinimumSize(new Dimension(200,30));
        labelcolor.setMaximumSize(new Dimension(200,30));
        labelcolor.setMinimumSize(new Dimension(200,30));

        jButtonFillColor.setMaximumSize(new Dimension(70,30));
        jButtonFillColor.setMinimumSize(new Dimension(70,30));
        jComboBoxLine.setMaximumSize(new Dimension(200,30));
        jComboBoxLine.setMinimumSize(new Dimension(200,30));
        button.setMaximumSize(new Dimension(70,30));
        button.setMinimumSize(new Dimension(70,30));

    button.addActionListener(e ->

    {
        this.newSlotControler.finished(color, jComboBoxLine.getSelectedIndex());
        MainFrame.getInstance().getjSplitPane().updateUI();
    } );

        panel.add(labelcolor);
        panel.add(jButtonFillColor);
        panel.add(labelLine);
        panel.add(jComboBoxLine);
        panel.add(button);

        JScrollPane jScrollPane = new JScrollPane(panel);
        this.getContentPane().add(jScrollPane);
}


}
