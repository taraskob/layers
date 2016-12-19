package layers;
import javax.swing.SwingUtilities;
public class MainLayers {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			 new Forma();
					}
		});
	}
}
