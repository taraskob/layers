package layers;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
public class Forma {
	private JTextArea jtaa;
	private JTextArea jtab;
	public Forma() {
		JFrame jfrm=new JFrame("...FORMA...");
		jfrm.getContentPane().setLayout(new FlowLayout());
		jfrm.setSize(270, 467);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlabSeparator=new JLabel();
		jlabSeparator.setPreferredSize(new Dimension(200,7));
		jtaa=new JTextArea();
		jtab=new JTextArea();
		JScrollPane jscrlpa=new JScrollPane(jtaa);
		JScrollPane jscrlpb=new JScrollPane(jtab);
		jscrlpa.setPreferredSize(new Dimension(250,200));
		jscrlpb.setPreferredSize(new Dimension(250,200));
		Controller fcntr=new Controller();
		jtaa.addCaretListener(new CaretListener(){
			public void caretUpdate(CaretEvent ce) {
				if(jtaa.getText().length()>0)
			{fcntr.contr(jtaa.getText());}
				}
		});

		jtab.addCaretListener(new CaretListener(){
			public void caretUpdate(CaretEvent ce) {
				if(jtab.getText().length()>0)
			{fcntr.contr(jtab.getText());}
				}
		});

		Container cp=jfrm.getContentPane();
		cp.add(jscrlpa);
		cp.add(jlabSeparator);
		cp.add(jscrlpb);
		jfrm.setVisible(true);
	}

}
