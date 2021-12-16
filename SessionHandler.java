
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SessionHandler
 * @Author: Xudong Gao
 * @Description: This class can handle the logs produced by users.
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
    public void loadLogs(){
        logs = BackupController.readTxt("log.txt");
    }

    public void writeLogs()  {
        BackupController.writeTxt("log.txt",logs,true);
    }
    public List<String> getLogs(){
        return logs;
    }

    public void clearLogs(){
        logs.clear();
    }


}