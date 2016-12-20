package layers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class WriteAL {
public void saveAList(ArrayList<String> arlist) throws IOException {
//	       FileWriter writer = new FileWriter("last");
//	       for(String istr: arlist) {
//	    	   writer.write(istr);
//	    	 }
//	    	 writer.close();
	
	FileWriter outFile = new FileWriter("Data.dat");
    BufferedWriter outStream = new BufferedWriter(outFile);
    for (int k = 0; k < arlist.size(); k++)
        outStream.write(arlist.get(k));   
    outStream.close();
	    	 
	}

}
