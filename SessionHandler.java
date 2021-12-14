import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SessionHandler
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class SessionHandler {
    private List<String>logs;
    private static SessionHandler instance = new SessionHandler();
    private SessionHandler(){
        logs = new ArrayList<>();

    }
    public static SessionHandler getInstance(){
        return instance;
    }

    public void addLog(String line){
        line = TimeController.getCurDate() + " "+ line;
        logs.add(line);
    }

    public void writeLogs() throws IOException {
        BackupController.writeTxt("log.txt",logs,true);
    }
    public List<String> getLogs(){
        return logs;
    }


}