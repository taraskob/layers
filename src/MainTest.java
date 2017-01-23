import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        LayersTest testlayers=new LayersTest();
        testlayers.create_read();
        testlayers.write();
        testlayers.syncro();
      }
}
