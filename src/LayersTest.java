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
    void create_read()
    {String testresult="Create file/Read data test result is ";
     String readline=filectrl.readData();
     getResult(determResult(testresult,readline));
    }
     void write() {
     String testresult= "Write data test result is ";
     String readline = "Test "+sdf.format(getDate())+"-/"+filectrl.readData();
     filectrl.writeData(readline,"");
     getResult(determResult(testresult,readline));
     }
     void syncro() throws IOException {
     ArrayList<String> alinput=new ArrayList<String>();
     String readline= "These data are synchronized - test Ok";
  //   alinput=data.strToAList(readline);
     data.setData(readline,"test");
     filectrl.syncro();
     filectrl.writeData(readline,"test");
     getResult(filectrl.readData());
     }
     Date getDate() {
     date=new Date();
     return date;
    }
     String determResult(String result,String line) {
     result += myEquals(line,filectrl.readData()) ? "Ok" : "negative";
     return result;
    }
     void getResult(String testresult) {

        System.out.println(testresult);
    }

     boolean myEquals(String str1, String str2) {
    return str1 == null ? str2 == null : str1.equals(str2);
}
}
