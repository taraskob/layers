package layers;
import java.io.IOException;
import javax.swing.SwingUtilities;
public class MainLayers {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			 try {
				Forma form=new Forma();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
					}
		});
	}
}
