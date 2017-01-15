import java.io.IOException;
import java.util.ArrayList;
public class Data {
    private ArrayList<String> current_data=new ArrayList<String>();
    public void setData(String inputtext) {
        ArrayList<String> al=new ArrayList<String>();
        al.add(inputtext);
        current_data=al;
    }
    public void setData(String inputtext_a,String inputtext_b) {
        ArrayList<String> al=new ArrayList<String>();
        al.add(inputtext_a);
        al.add(inputtext_b);
        current_data=al;
    }

    public ArrayList<String> getData() {
        return this.current_data;
    }

    public ArrayList<String> strToAList(String inputtext)  {
        ArrayList<String> al=new ArrayList<String>();
        al.add(inputtext);
        return al;
    }
    public boolean isEqual(ArrayList<String> current_data,ArrayList<String> new_data){
        if(current_data.size()!=new_data.size()){
            return false;}
        else{
            for(int i=0;i<current_data.size();i++){
                if(!myEquals(current_data.get(i),new_data.get(i)))
                {
                    return false;
                }
            }
            return true;
        }}
    public boolean myEquals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
    public boolean compareData(Data new_data) throws IOException {
                if(isEqual(current_data,strToAList(new_data.readData()))) {
            return true;
        }
        return false;
    }
    public void writeData() {
        ReadSaveFile load_data=new ReadSaveFile();
        {try {
            load_data.savefile(getData());

        } catch (IOException e) {
            e.printStackTrace();
        }}
    }
    public String readData() {
        ReadSaveFile load_data=new ReadSaveFile();
        try {
            return load_data.readfile();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
