import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ReadSaveFile {
    private File file;
    public String readfile() throws FileNotFoundException {
    StringBuilder line = new StringBuilder();
    try {
        filexists("Data.dat");
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
        try {
            String s;
            while ((s = in.readLine()) != null) {
                line.append(s);
                line.append("\n");
            }
        } finally {
            in.close();
        }
    } catch(IOException e) {
        throw new RuntimeException(e);
    }

     return line.toString();
}

    public void filexists(String fileName) throws IOException {
        file = new File(fileName);
        if (!file.exists()){
            String line="";
            FileWriter writer = new FileWriter("Data.dat");
            {
                writer.write(line);
            }
            writer.close();
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
