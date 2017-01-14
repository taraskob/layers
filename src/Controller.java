import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
public class Controller {
    private List<ChangeHandler> listener = new ArrayList<>();
    private ReadSaveFile new_data=new ReadSaveFile();
    private Data data=new Data();
    private LTimerTask mytask=new LTimerTask(this);
    private Timer compTimer=new Timer(true);
    public void contr(String inputtext) {
         data.setData(inputtext);
      }
    public void addToListener(ChangeHandler changeHandler){
        listener.add(changeHandler);
    }
      {compTimer.schedule(mytask,1000,15000);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();}
    }
    public void syncro() throws IOException {
           if(!data.compareData(new_data))
            {
          onChange();
            }
         }
    public void writeData() {
        {try {
          new_data.savefile(data.getData());
             onChange();
        } catch (IOException e) {
            e.printStackTrace();
        }}
    }
    public String readData() {
        try {
          return new_data.readfile();
         } catch (IOException e) {
            e.printStackTrace();
            return "";
    }
}
    public void onChange() {
        for(ChangeHandler item:listener){
            item.onChange();
        }
    }
}
