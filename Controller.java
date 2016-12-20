package layers;
import java.util.ArrayList;
public class Controller implements ChangeHandler {
private ArrayList<String> alstr=new ArrayList<String>();
public void contr(String taa) {
	strToAList(taa);
	onChange();
	}
CustomFile data=new CustomFile(alstr);

public ArrayList<String> strToAList(String taa)  {
	alstr.add(taa+"\n");
	return alstr;
}

	 public void onChange() {
		  data.writeData();
 	    }
}
