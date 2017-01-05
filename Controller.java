import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
public class Controller {
    private List<ChangeHandler> listener = new ArrayList<>();
    private ArrayList<String> alinput=new ArrayList<String>();
    private ReadSaveFile data_dat=new ReadSaveFile();
    private CustomFile data=new CustomFile();
    private LTimerTask mytask=new LTimerTask(this);
    private Timer compTimer=new Timer(true);
    public void contr(String inputtext) {
        this.alinput=strToAList(inputtext);
        data.setData(strToAList(inputtext));
        writeData();
     }
    public void addToListener(ChangeHandler changeHandler){
        listener.add(changeHandler);
    }
    public ArrayList<String> strToAList(String inputtext)  {
        alinput.removeAll(alinput);
        alinput.add(inputtext);
        alinput.remove(null);
        return alinput;
    }
    {compTimer.schedule(mytask,1000,20000);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();}
    }
    public void syncro(){
        ArrayList<String> aldata=new ArrayList<String>();
        aldata.removeAll(aldata);
        aldata.addAll(data.getData());
        aldata.remove(null);
        ArrayList<String> aldata_dat=new ArrayList<String>();
        try {
            aldata_dat = strToAList(data_dat.readfile());
            if(aldata.size()-aldata_dat.size()<0) {
                onChange();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onChange() {
        for(ChangeHandler item:listener){
            item.onChange();
        }
    }
    public void writeData() {
        {try {
          data_dat.savefile(data.getData());
             onChange();
        } catch (IOException e) {
            e.printStackTrace();
        }}
    }
    public String readData() {
        try {
          return data_dat.readfile();
         } catch (IOException e) {
            e.printStackTrace();
            return "";
    }
}}
