package testHarness;

import dao.DaoException;
import dao.DaoException;
import dao.MoodDao;
import dao.MoodDao;
import foodmood.Mood;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author matt cano
 */
public class MoodDao_Tests {
    private MoodDao m;
    public MoodDao_Tests() throws DaoException {
        m = new MoodDao();
        runTests();
    }
    
    public void runTests() throws DaoException {
        ArrayList<Mood> moods = new ArrayList<Mood>();
        moods = m.getAllMoods();
        for(Mood md : moods){
            System.out.println(md.getMoodName());
        }
        Mood mn;
        mn = m.getMoodById(3);
        System.out.println(mn.getMoodName());
    }
}
