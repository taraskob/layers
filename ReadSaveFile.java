import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ReadSaveFile {
public String readfile() throws IOException   {
        String line="";
        try(FileReader freader = new FileReader("Data.dat"))
        {
            int c;
            while((c=freader.read())!=-1){
                line=line+(char)c;
            }
            freader.close();
            if(line==null) line="";
            return line;
        }
        catch(FileNotFoundException e){
            FileWriter writer = new FileWriter("Data.dat");
            {
                writer.write(line);
            }
            writer.close();
            if(line==null) line="";
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
