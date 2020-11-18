import Models.Pizza;

import java.util.ArrayList;

public interface DBBasicMethods {

    int deleteSingle(int id);

    Pizza selectSingle(int id);

    int updateSingle(int id, Pizza pizza);

    int insertSingle(Pizza pizza);

    ArrayList<Pizza> selectAll();
}