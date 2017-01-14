import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class LayersTest {
    private Date date=new Date();
    private SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.YY kk:mm:ss");
    private Controller filectrl=new Controller();
    private Data data=new Data();
    private ReadSaveFile data_dat=new ReadSaveFile();
    public void create_read()
    {String testresult="Create file/Read data test result is ";
     String readline=filectrl.readData();
     getResult(determResult(testresult,readline));
    }
    public void write() {
     String testresult= "Write data test result is ";
     String readline = "Test "+sdf.format(getDate())+"-/"+filectrl.readData();
     filectrl.contr(readline);
     filectrl.writeData();
     getResult(determResult(testresult,readline));
     }
    public void syncro() {
     ArrayList<String> alinput=new ArrayList<String>();
     String readline= "These data are synchronized - test Ok";
     alinput=filectrl.strToAList(readline);
     data.setData(filectrl.strToAList(readline));
     filectrl.syncro();
     filectrl.contr(readline);
     filectrl.writeData();
     getResult(filectrl.readData());
     }
    public Date getDate() {
     date=new Date();
     return date;
    }
    public String determResult(String result,String line) {
     result += myEquals(line,filectrl.readData()) ? "Ok" : "negative";
     return result;
    }
     public void getResult(String testresult) {

        System.out.println(testresult);
    }

    public boolean myEquals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
}
