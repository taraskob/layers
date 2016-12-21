package layers;
import java.util.ArrayList;
import javax.swing.Timer;
public class Controller implements ChangeHandler {
private ArrayList<String> alstr=new ArrayList<String>();
Timer wTimer;
public void contr(String taa) {
	strToAList(taa);
	onChange();
	}

public ArrayList<String> strToAList(String taa)  {
	alstr.add(taa+"\n");
	return alstr;
}

CustomFile data=new CustomFile(alstr);
	 public void onChange() {
		  data.writeData();
	
 	    }
}
