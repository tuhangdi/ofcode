import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thd on 2017/8/21
 */
public class FolderSize {
    public int[] calculateWaste(String[] files, int folderCount, int clusterSize) {
        int[] res = new int[folderCount];
        for (int i = 0; i < files.length; i++) {
            String[] temp = files[i].split(" ");
            res[Integer.valueOf(temp[0])] += (clusterSize - Integer.valueOf(temp[1]) % clusterSize);
        }
        return res;
    }

    public static void main(String[] args) {
        FolderSize f = new FolderSize();
        String[] files = {"0 155", "0 47", "1 22", "1 21"};
        int folderCount = 3;
        int clusterSize = 50;
         for (int i : f.calculateWaste(files, folderCount, clusterSize))
             System.out.println(i);
    }
}
