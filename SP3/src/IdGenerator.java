//Johan
import java.util.ArrayList;

abstract public class IdGenerator {
    private ArrayList<Integer> ids;
    private int genRange;

    protected void initIdGenerator() {
        ids = new ArrayList<>();
        genRange = 100;
    }

    protected int getRandomId() {
        int id;
        if (ids.size() >= genRange) genRange += 100;
        do {
            id = (int) Math.floor(Math.random() * genRange);
        }
        while (!isIdUnique(id));
        return id;
    }

    private boolean isIdUnique(int _newId) {
        for (int id : ids) {
            if (id == _newId) return false;
        }
        return true;
    }
}
