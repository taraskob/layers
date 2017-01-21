import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
class LayersTest {
    private Date date=new Date();
    private SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.YY kk:mm:ss");
    private Controller filectrl=new Controller();
    private Data data=new Data();
    private ReadSaveFile load_data=new ReadSaveFile();
    void create_read() throws FileNotFoundException {String testresult="Create file/Read data test result is ";
        try {
            deleteFile("Data.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String readline=filectrl.getData().readData();
     getResult(determResult(testresult,readline));}
     void write() throws FileNotFoundException {
     String testresult= "Write data test result is ";
         try {
             deleteFile("Data.dat");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
     String readline = "Test "+sdf.format(getDate())+"-/"+filectrl.getData().readData();
     filectrl.getData().saveData(readline,"");
     getResult(determResult(testresult,readline));
     }
     void syncro() throws IOException {
     ArrayList<String> alinput=new ArrayList<String>();
     String readline= "These data are synchronized - test Ok";
         try {
             deleteFile("Data.dat");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
     data.saveData(readline,"test");
     filectrl.syncro();
     filectrl.getData().saveData(readline,"test");
     getResult(filectrl.getData().readData());
     }
     Date getDate() {
     date=new Date();
     return date;
    }
     String determResult(String result,String line) {
     result += myEquals(line,filectrl.getData().readData()) ? "Ok" : "negative";
     return result;
    }
     void getResult(String testresult) {

        System.out.println(testresult);
    }

     boolean myEquals(String str1, String str2) {
    return str1 == null ? str2 == null : str1.equals(str2);
}
    public void deleteFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (file.exists()) new File(fileName).delete();
    }
}
