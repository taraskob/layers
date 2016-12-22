package layers;
import java.io.IOException;
import java.util.ArrayList;
public class Controller implements ChangeHandler {
private ArrayList<String> alstr=new ArrayList<String>();
Rfile data_dat=new Rfile();

public void contr(String taa) {
	strToAList(taa+"\n");
	//compare();
	onChange();
	}
public ArrayList<String> strToAList(String taa)  {
	alstr.add(taa);
	alstr.remove(null);
	return alstr;
}
public void compare(){
	ArrayList<String> alstrtmp=new ArrayList<String>();
	alstrtmp=alstr;
	try {
	alstr = strToAList(data_dat.rf());


	if(alstr.size()!=alstrtmp.size()) {

			onChange();
			}
		} catch (IOException e) {
			e.printStackTrace();
	}
}
CustomFile data=new CustomFile(alstr);
	 public void onChange() {
		  data.writeData();
	 }
}
