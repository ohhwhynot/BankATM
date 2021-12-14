import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: BackupController
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class BackupController {
    static String fRoot = System.getProperty("user.dir") + "/ConfigFiles/";
    public static BackupController getInstance(){return instance;}
    private static BackupController instance = new BackupController();
    private BackupController(){};

    public static List<String> readTxt(String fileName) throws FileNotFoundException {
        Scanner inf = new Scanner(new File(fRoot + fileName));
        List<String> content = new ArrayList<>();
        String line;
        while (inf.hasNext()) {
            line = inf.nextLine();
            content.add(line);
        }
        return content;
    }

    public static void writeTxt(String fileName, List<String> lines, boolean isReplace) throws IOException {

        File F = new File(fRoot + fileName);
        System.out.println(fRoot + fileName);
        if (!F.exists()) {
            F.createNewFile();
        }
        FileWriter fw = null;

        try {
            fw = new FileWriter(F, !isReplace);
            for (String line : lines)
                fw.write(line + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                fw.close();
            }
        }

    }

    public StockMarket loadUpStockMarket(){
        try {
            List<String> marketInfo = readTxt("StockMarket.txt");
            return new StockMarket(marketInfo);
        }catch (IOException error){
            throw new RuntimeException(error);
        }
    }
    public void storeStockMarket(StockMarket stockMarket){
        List<String> lines = new ArrayList<>();
        lines.add(stockMarket.getCode()+"");
        for(Stock stock:stockMarket.getStocks()){
            String line = stock.getName()+" "+stock.getCode()+" "+stock.getPrice()+" "+stock.getChangePercent()+" "+
                    stock.isBought();
            lines.add(line);
        }
        try {
            writeTxt("StockMarket.txt",lines,true);
        }catch (IOException error){
            throw new RuntimeException(error);
        }
    }

}