package layers;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class WriteAL {
public void saveAList(ArrayList<String> arlist) throws IOException {
	       FileWriter writer = new FileWriter("last");
	       for(String istr: arlist) {
	    	   writer.write(istr);
	    	 }
	    	 writer.close();
    	 
	}

}
