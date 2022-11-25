package rudok.app.gui.swing.view.Dialog;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog {

    public InfoDialog(JFrame frame,String title) {
        super(frame,title);
        initialise();
    }

    public void initialise() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setSize(screenWidth/2,screenHeight/2);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setUndecorated(false);
        this.setLocationRelativeTo(null);
        //TODO - poslednja slika mi je od pre 4 godine kad se slikam moram da dodam svoju sliku za sad tu je medved
        ImageIcon mojaSlika = new ImageIcon("assets/Ja.jpg");
        this.getContentPane().add(new JLabel("Petar Stamenic 77/21 RN", mojaSlika ,JLabel.CENTER));
        }

    }

