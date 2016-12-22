package layers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Rfile  {
	public String rf() throws IOException   {
		File file = new File("Data.dat");
        FileReader fr;
		try {
			fr = new FileReader(file);
			 BufferedReader br = new BufferedReader(fr);
		        String line;
		        line=br.readLine();
		        while((br.readLine()) != null){
		            line=line+br.readLine();
		        }
		        br.close();
		        fr.close();
		       
		        return line;
		} catch (FileNotFoundException e) {
			
			File filecr = new File("Data.dat");
			FileWriter writer = new FileWriter("Data.dat");
	         {
	            writer.write(" ");
	        }
	            writer.close();
			return " ";
		}
     
	}
}