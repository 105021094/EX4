import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 500, frmH = 450;
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmFile = new JMenu("File");
    private JMenu jmSet = new JMenu("Set");
    private JMenu jmGame = new JMenu("Game");
    private JMenu jmAbout = new JMenu("About");
    private JMenuItem jmiExit = new JMenuItem("Exit");
    private JMenuItem jmiLoto = new JMenuItem("Loto");
    private JDesktopPane jdp = new JDesktopPane();

    private JInternalFrame jInternalFrame = new JInternalFrame();
    private Container jifCP;
    private JPanel jpn = new JPanel(new GridLayout(1,6,5,5));
    private JLabel jlbs[] = new JLabel[6];
    private int data[] = new int[6];
    private Random rnd = new Random(System.currentTimeMillis());


    public MainFrame(){
        initComp();
    }

    private void initComp(){
        this.setBounds(scrW/2-frmW/2,scrH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.setContentPane(jdp);
        jmb.add(jmFile);
        jmb.add(jmSet);
        jmb.add(jmGame);
        jmb.add(jmAbout);
        jmFile.add(jmiExit);
        jmFile.add(jmiLoto);

        jInternalFrame.setBounds(0,0,300,80);
        jifCP = jInternalFrame.getContentPane();
        jifCP.setLayout(new BorderLayout(5,5));
        jifCP.add(jpn,BorderLayout.CENTER);
        for (int i = 0;i<6;i++){
            jlbs[i] = new JLabel();
            jlbs[i].setFont(new Font(null,Font.PLAIN,22));
            jlbs[i].setBackground(Color.pink);
            jlbs[i].setHorizontalAlignment(JLabel.CENTER);
            jpn.add(jlbs[i]);
        }
        
        jmiLoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jInternalFrame);
                jInternalFrame.setVisible(true);
            }
        });

        jmiExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmiExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    }
}
