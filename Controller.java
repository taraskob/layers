import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
public class Controller {
    private List<ChangeHandler> listener = new ArrayList<>();
    private ReadSaveFile data_dat=new ReadSaveFile();
    private CustomFile data=new CustomFile();
    private LTimerTask mytask=new LTimerTask(this);
    private Timer compTimer=new Timer(true);
    public void contr(String inputtext) {
         data.setData(strToAList(inputtext));
      }
    public void addToListener(ChangeHandler changeHandler){
        listener.add(changeHandler);
    }
    public ArrayList<String> strToAList(String inputtext)  {
        ArrayList<String> alinput=new ArrayList<String>();
        alinput.add(inputtext);
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
        aldata.addAll(data.getData());
        ArrayList<String> aldata_dat=new ArrayList<String>();
        try {
            aldata_dat = strToAList(data_dat.readfile());
            if(!isEqual(aldata,aldata_dat)) {
                onChange();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean isEqual(ArrayList<String> aldata,ArrayList<String> aldata_dat){
        if(aldata.size()!=aldata_dat.size()){
            return false;}
        else{

            for(int i=0;i<aldata.size();i++){

                if(! aldata.get(i).equals(aldata_dat.get(i)))
                    if(!myEquals(aldata.get(i),aldata_dat.get(i)))

                    {
                        return false;
                    }
            }
            return true;
        }}
    public boolean myEquals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
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
