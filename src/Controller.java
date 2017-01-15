import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
public class Controller {
    private List<ChangeHandler> listener = new ArrayList<>();
    private Data data=new Data();
    private LTimerTask mytask=new LTimerTask(this);
    private Timer compTimer=new Timer(true);
    public void contr(String inputtext) {
         data.setData(inputtext);
      }
    public void contr(String inputtext_a,String inputtext_b) {
        data.setData(inputtext_a,inputtext_b);
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
        ArrayList<String> load_data=data.strToAList(readData());
           if(!data.compareData(load_data))
            {
          onChange();
            }
         }
    public void writeData() {
          data.writeData();
    }
    public String readData() {
         return data.readData();
     }
    public void onChange() {
        for(ChangeHandler item:listener){
            item.onChange();
        }
    }
}
