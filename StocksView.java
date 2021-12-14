import javax.swing.table.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @ClassName: StocksView
 * @Author: Xudong Gao
 * @Description:
 * @Date: Dec 2021
 */
public class StocksView {
    public DefaultTableModel getTableModel_4(List<Stock> stocks){
        int row_num = stocks.size();
        String[][] data = new String[row_num][4];
        int i = 0;
        for(Stock stock:stocks){
            data[i][0]= stock.getName();
            data[i][1] = stock.getCode();
            data[i][2] = Float.toString(stock.getPrice());
            DecimalFormat decimalFormat = new DecimalFormat(".00");
            data[i][3] = decimalFormat.format(stock.getChangePercent()*100)+"%";
            i++;
        }
        String[] colName = {"Name","Code","Cur_Price","ChangePer"};
        return new DefaultTableModel(data,colName);
    }
    public DefaultTableModel getTableModel_7(StockAccount account){
        List<HeldStock> stocks = account.getStocks();
        int row_num = stocks.size();
        String[][] data = new String[row_num][7];
        int i = 0;
        double totValues =0;
        for(HeldStock heldStock:stocks){
            Stock stock = heldStock.getStock();
            double value = stock.getPrice()*heldStock.getAmount();
            totValues+=value;
        }
        for(HeldStock heldStock:stocks){
            Stock stock = Admin.getInstance().getStockController().getStock(heldStock.getStock().getName());
            data[i][0]= stock.getName();
            data[i][1] = stock.getCode();
            data[i][2] = Float.toString(heldStock.getCost());
            data[i][3] = Float.toString(stock.getPrice());
            data[i][4] = Integer.toString(heldStock.getAmount());
            data[i][5] = Double.toString((stock.getPrice()*heldStock.getAmount())/(totValues+ account.getBalance()));
            data[i][6] = Float.toString((stock.getPrice()-heldStock.getCost())*heldStock.getAmount());
            i++;
        }
        String[] colName = {"Name","Code","CostPrice","CurPrice","Amount","Position","Profit"};
        return new DefaultTableModel(data,colName);
    }


}