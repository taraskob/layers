import java.io.IOException;
import java.util.ArrayList;
class Data {
    private ArrayList<String> current_data=new ArrayList<String>();
    void setData() {
        current_data.add(readData());
    }
    void setData(String inputtext_a, String inputtext_b) {
       switch(current_data.size()){
          case 0:
               current_data.add(0,inputtext_a);
               current_data.add(1,inputtext_b);
               break;
           case 1:
               current_data.set(0,inputtext_a);
               current_data.add(1,inputtext_b);
               break;
           default:
               current_data.set(0,inputtext_a);
               current_data.set(1,inputtext_b);
               }
     }
     ArrayList<String> strToAList(String inputtext)  {
        ArrayList<String> al=new ArrayList<String>();
        al.add(inputtext);
        return al;
    }
    private boolean isEqual(ArrayList<String> current_data,ArrayList<String> new_data){
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
    private boolean myEquals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
    boolean compareData(Data new_data) throws IOException {
                if(isEqual(current_data,strToAList(new_data.readData()))) {
            return true;
        }
        return false;
    }
    void writeData() {
        ReadSaveFile load_data=new ReadSaveFile();
        {try {
            load_data.savefile(current_data);
        } catch (IOException e) {
            e.printStackTrace();
        }}
    }
     String readData() {
        ReadSaveFile load_data=new ReadSaveFile();
        try {
            return load_data.readfile();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
