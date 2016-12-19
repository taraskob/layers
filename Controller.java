package layers;
import java.util.ArrayList;
public class Controller implements ChangeHandler {
private String taa_str; 
private String tab_str;
private ArrayList<String> alstr=new ArrayList<String>();
Controller(String forma_stra,String forma_strb) {
		 this.taa_str=forma_stra+"/n";
		 this.tab_str=forma_strb+"/n";
	 }

CustomFile data=new CustomFile(strToAList(taa_str,tab_str));

public ArrayList<String> strToAList(String taa_str,String tab_str)  {
	alstr.removeAll(alstr);
	alstr.add(taa_str);
	alstr.add(tab_str);
	return alstr;
}

	 public void onChange() {
 	    }
}
