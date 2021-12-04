import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: BackupController
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class BackupController {
    public static void writeTxt(String fileName, List<String> lines, boolean isReplace) throws IOException {
        String fRoot = System.getProperty("user.dir") + "/BankATM/ConfigFiles/";
        File F=new File(fRoot+fileName);
        System.out.println(fRoot+fileName);
        if(!F.exists()){
            F.createNewFile();
        }
        FileWriter fw=null;

        try {
            fw = new FileWriter(F, !isReplace);
            for(String line:lines)
                fw.write(line + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                fw.close();
            }
        }

    }
}