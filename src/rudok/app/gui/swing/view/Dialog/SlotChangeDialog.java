package rudok.app.gui.swing.view.Dialog;

import rudok.app.gui.swing.controller.EnableButton;
import rudok.app.gui.swing.controller.draw.EditControler;
import rudok.app.gui.swing.controller.draw.NewSlotControlerRuDok;
import rudok.app.gui.swing.controller.save.MyChangeFilter;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class SlotChangeDialog extends JDialog {

    public SlotChangeDialog(EditControler editControler,int index){
        this.editControler = editControler;
        init(index);
    }
    private JTabbedPane tabbedPane;
    private JPanel txtPanel;
    private JPanel photoPanel;
    private JTextPane jTextPane;
    private JButton textConfirmButton;
    private ImageIcon imagePrevew;
    private JButton imageConfirmButton;
    private JButton chooseImage;
    private EditControler editControler;
    private JLabel textLabel;
    private JLabel ImageLabel;
    private String string;
    private JLabel iconLabel;
    private JCheckBox Bold;
    private JCheckBox Italic;
    private JComboBox<String> font;
    private JComboBox<Integer> size;
    private String[] fontString = {"Arial","Times New Roman"};
    private Integer[] sizeInt = {8,9,10,11,12,13,14,15,16};


    private int type;
    private Boolean bold = false;
    private Boolean italic = false;
    private String fontSTR = "Arial";
    private int sizeFont = 12;

    /*
    Omogucava promenu sadrzaja slota ukoliko ima pitanja kontaktirajte osobu koja je pisala kod tj mene
     */
    private void init(int index) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screenWidth/2,screenHeight/2);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setUndecorated(false);
        this.setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        txtPanel = new JPanel();
        photoPanel = new JPanel();
        jTextPane = new JTextPane();
        textConfirmButton = new JButton("Ok");
        imagePrevew = new ImageIcon("assets/placeholder-image.png");
        imageConfirmButton = new JButton("Ok");
        textLabel = new JLabel("Text preview:");
        ImageLabel = new JLabel("Image preview");
        chooseImage = new JButton("Choose Image");
        iconLabel = new JLabel(imagePrevew);
        Bold = new JCheckBox("Bold",false);
        Italic = new JCheckBox("Italic",false);
        font = new JComboBox<>(fontString);
        size = new JComboBox<Integer>(sizeInt);

        textConfirmButton.addActionListener(e ->{
            this.string = jTextPane.getText();
            this.bold = Bold.isSelected();
            this.italic = Italic.isSelected();
            this.fontSTR = fontString[font.getSelectedIndex()];
            this.sizeFont = (int) sizeInt[size.getSelectedIndex()];
            this.editControler.finished(string,0,bold,italic,fontSTR,sizeFont);
            MainFrame.getInstance().getjSplitPane().updateUI();
        });


        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
        left.add(Bold);
        left.add(Italic);
        left.add(font);
        left.add(size);

        this.string = jTextPane.getText();
        this.bold = Bold.isSelected();
        this.italic = Italic.isSelected();
        this.fontSTR = fontString[font.getSelectedIndex()];

        if(bold && !italic)
            jTextPane.setFont(new Font(fontSTR,Font.BOLD,sizeFont));
        if(!bold && italic)
            jTextPane.setFont(new Font(fontSTR,Font.ITALIC,sizeFont));
        if(!bold && !italic)
            jTextPane.setFont(new Font(fontSTR,Font.PLAIN,sizeFont));
        if(bold && italic)
            jTextPane.setFont(new Font(fontSTR,Font.ITALIC|Font.BOLD,sizeFont));

        txtPanel.setLayout(new BorderLayout());
        txtPanel.add(left,BorderLayout.EAST);
        txtPanel.add(textLabel,BorderLayout.NORTH);
        txtPanel.add(jTextPane,BorderLayout.CENTER);
        txtPanel.add(textConfirmButton,BorderLayout.SOUTH);

        imageConfirmButton.addActionListener(e ->{
            this.editControler.finished(string,1);
            MainFrame.getInstance().getjSplitPane().updateUI();
        });

        chooseImage.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new MyChangeFilter());
            if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.string = jFileChooser.getSelectedFile().getAbsolutePath();
                Image image = new ImageIcon(string).getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
                imagePrevew = new ImageIcon(image);
                photoPanel.remove(iconLabel);
                iconLabel = new JLabel(imagePrevew);
                photoPanel.add(iconLabel);
                photoPanel.revalidate();
                photoPanel.repaint();
            }
        });

        photoPanel.setLayout(new BorderLayout());
        photoPanel.add(ImageLabel,BorderLayout.NORTH);
        photoPanel.add(chooseImage,BorderLayout.WEST);
        photoPanel.add(iconLabel,BorderLayout.CENTER);
        photoPanel.add(imageConfirmButton,BorderLayout.SOUTH);

        textLabel.setMaximumSize(new Dimension(200,30));
        textLabel.setMinimumSize(new Dimension(200,30));
        ImageLabel.setMaximumSize(new Dimension(200,30));
        ImageLabel.setMinimumSize(new Dimension(200,30));

        textConfirmButton.setMaximumSize(new Dimension(70,30));
        textConfirmButton.setMinimumSize(new Dimension(70,30));
        imageConfirmButton.setMaximumSize(new Dimension(120,30));
        imageConfirmButton.setMinimumSize(new Dimension(120,30));
        chooseImage.setMaximumSize(new Dimension(120,30));
        chooseImage.setMinimumSize(new Dimension(120,30));

        tabbedPane.add("Edit Text",txtPanel);
        tabbedPane.add("Edit Image",photoPanel);
        tabbedPane.setSelectedIndex(index);

        tabbedPane.setVisible(true);
        jTextPane.setVisible(true);
        photoPanel.setVisible(true);

        this.getContentPane().add(tabbedPane);
    }


}
