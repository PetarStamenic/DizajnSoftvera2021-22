package rudok.app.gui.swing.view;

import rudok.app.gui.swing.controller.ActionManager;
import rudok.app.gui.swing.controller.comands.ComandManager;
import rudok.app.gui.swing.controller.viewControler.ShowControler;
import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.tree.model.TreeModel;
import rudok.app.gui.swing.view.toolbars.DrawStateToolbar;
import rudok.app.gui.swing.view.toolbars.EditToolBar;
import rudok.app.gui.swing.view.toolbars.FileToolbar;
import rudok.app.observer.ISubscriber;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {

    private static MainFrame instance;
    private String extension = ".txt";
    private ActionManager actionManager;
    private ComandManager comandManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private JTabbedPane toolbarPane;
    private FileToolbar fileToolbar;
    private EditToolBar editToolBar;
    private DrawStateToolbar drawStateToolbar;

    private WorskpaceTree workspaceTree;
    private TreeModel treeModel;
    private JPanel jPaneRight;
    private JSplitPane jSplitPane;

    private MainFrame() {
    }

    private void initialise() {
        actionManager = new ActionManager();
        comandManager = new ComandManager();
        actionManager.getUndoCommand().setEnabled(false);
        actionManager.getRedoCommand().setEnabled(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //It will use the def UIManaer if this fails no need to handle it
        }

        initialiseTree();
        initialiseGUI();


    }

    public void initialiseGUI() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth*2/3,screenHeight*2/3);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RuDok");

        menu = new MenuBar();
        setJMenuBar(menu);

        toolbarPane = new JTabbedPane();
        fileToolbar = new FileToolbar();
        editToolBar = new EditToolBar();
        drawStateToolbar = new DrawStateToolbar();
        toolbarPane.setVisible(true);
        toolbarPane.add("File",fileToolbar);
        toolbarPane.add("Edit",editToolBar);
        toolbarPane.add("Slot",drawStateToolbar);
        toolbarPane.setEnabledAt(2,false);
        add(toolbarPane,BorderLayout.NORTH);
        //toolBar = new Toolbar();
        //add(toolBar, BorderLayout.NORTH);

        JScrollPane scrollPaneLeft = new JScrollPane(workspaceTree);
        scrollPaneLeft.setMinimumSize(new Dimension(150, 150));

        jPaneRight = new JPanel();
        jPaneRight.setLayout(new BorderLayout());
        jPaneRight.setSize(800,1200);
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPaneLeft,jPaneRight);
        getContentPane().add(jSplitPane,BorderLayout.CENTER);
        jSplitPane.setDividerLocation(200);
        jSplitPane.setOneTouchExpandable(true);
    }

    private void initialiseTree(){
        workspaceTree = new WorskpaceTree();
        treeModel = new TreeModel(new MyTreeNode(Workspace1.getInstance().getWorkspace()));
        workspaceTree.setModel(treeModel);
        workspaceTree.addMouseListener(new ShowControler());

    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }


    public ActionManager getActionManager() {
        return actionManager;
    }

    public WorskpaceTree getWorkspaceTree() {
        return workspaceTree;
    }

    public JPanel getjPaneRight() {
        return jPaneRight;
    }

    public JSplitPane getjSplitPane() {
        return jSplitPane;
    }

    public ComandManager getComandManager() {
        return comandManager;
    }

    public String getExtension() {
        return extension;
    }

    public void disableEdit(){
        toolbarPane.setEnabledAt(2,false);
        toolbarPane.setSelectedIndex(0);
    }

    public void enableEdit(){
        toolbarPane.setEnabledAt(2,true);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof String){
            if(((String) notification).equals("Heathcliff")) {
                MyTreeNode selected = (MyTreeNode) MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
                MainFrame.getInstance().getActionManager().getPainControler().paint(selected);
                if(!Workspace1.getInstance().getBusy())
                SwingUtilities.updateComponentTreeUI(workspaceTree);
            }
            }

        }
    }

