import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Forma  implements ChangeHandler {
    private JTextArea jtexta;
    private JTextArea jtextb;
    private JButton jbtnSave;
    private Controller filectrl=new Controller();
    public Forma() throws IOException {
        JFrame jfrm=new JFrame("FORMA");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(270, 500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlabSeparator=new JLabel();
        jlabSeparator.setPreferredSize(new Dimension(200,7));
        jtexta=new JTextArea();
        jtextb=new JTextArea();
        JScrollPane jscrlpa=new JScrollPane(jtexta);
        JScrollPane jscrlpb=new JScrollPane(jtextb);
        jscrlpa.setPreferredSize(new Dimension(250,200));
        jscrlpb.setPreferredSize(new Dimension(250,200));
        jbtnSave = new JButton("Save File");
        filectrl.addToListener(this);
        jtexta.setText(filectrl.readData());
        filectrl.contr(jtexta.getText());
        jbtnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent le) {
                saveinputtext(filectrl);
             }
        });
        Container cp=jfrm.getContentPane();
        cp.add(jscrlpa);
        cp.add(jlabSeparator);
        cp.add(jscrlpb);
        cp.add(jbtnSave);
        jfrm.setVisible(true);
    }

    public void saveinputtext(Controller fcntr) {
        String jtextc=jtexta.getText()+jtextb.getText();
        if(jtextc.isEmpty())
            jtextc="";
        filectrl.contr(jtextc);
        filectrl.writeData();
    }

    @Override
    public void onChange() {
        jtexta.setText(filectrl.readData());
               }
}