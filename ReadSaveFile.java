import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ReadSaveFile {
    public String readfile() throws IOException   {
        File file = new File("Data.dat");
        FileReader fr;
        String line="";
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            line=br.readLine();
            while((br.readLine()) != null){
                line=line+br.readLine();
            }
            br.close();
            fr.close();
            if(line==null) line="";
            return line;
        } catch (FileNotFoundException e) {
            FileWriter writer = new FileWriter("Data.dat");
            {
                writer.write(line);
            }
            writer.close();
            return line;
        }
    }
    public void savefile(ArrayList<String> arlist) throws IOException {
        FileWriter writer = new FileWriter("Data.dat");
        for(String istr: arlist) {
            writer.write(istr);
        }
        writer.close();
    }
}
