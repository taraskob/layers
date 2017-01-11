import java.util.ArrayList;
public class CustomFile {
    private ArrayList<String> alinput=new ArrayList<String>();
    public void setData(ArrayList<String> arlist) {
        ArrayList<String> al=new ArrayList<String>();
        al.addAll(arlist);
        alinput=al;
    }
    public ArrayList<String> getData() {
        return this.alinput;
    }
}
