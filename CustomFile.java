import java.util.ArrayList;
public class CustomFile {
    private ArrayList<String> alinput=new ArrayList<String>();
    public void setData(ArrayList<String> arlist) {
        alinput.removeAll(alinput);
        alinput.addAll(arlist);
        alinput.remove(null);
    }
    public ArrayList<String> getData() {
        return this.alinput;
    }
}
