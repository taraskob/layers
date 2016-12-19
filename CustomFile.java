package layers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CustomFile {
private ArrayList<String> alta=new ArrayList<String>();
private List<ChangeHandler> listener=new ArrayList<>();
private WriteAL wal=new WriteAL();
	CustomFile(ArrayList<String> arlist) {
		this.alta=arlist;
	}
	{try {
		wal.saveAList(alta);
	} catch (IOException e) {
		
		e.printStackTrace();
	}}
	 public void addToListener(ChangeHandler changeHandler){
	        listener.add(changeHandler);
	    }

	 private void onChange(){
	        for(ChangeHandler item:listener){
	            item.onChange();
	        }
	    }
}
