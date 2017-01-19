import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
class Controller {
    private List<ChangeHandler> listener = new ArrayList<>();
    private Data data=new Data();
    private LTimerTask mytask=new LTimerTask(this);
    private Timer compTimer=new Timer(true);
    void addToListener(ChangeHandler changeHandler){
        listener.add(changeHandler);
    }
      {compTimer.schedule(mytask,1000,15000);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();}
    }
     void syncro() throws IOException {
       Data new_data=new Data();
       new_data.setData();
        if(!data.compareData(new_data))
            {
              data=new_data;
              onChange();
            }
         }
    void writeData(String inputtext_a, String inputtext_b) {
          data.setData(inputtext_a,inputtext_b);
          data.writeData();
    }
    String readData() {
         return data.readData();
     }
    void onChange() {
        for(ChangeHandler item:listener){
            item.onChange();
        }
    }
}
