import com.company.MyLinkedList;
import com.company.MyList;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by sega on 13.02.2015.
 */

public class MyTest {
    @Test
    public void testLesson() throws Exception {
        MyList list = new MyLinkedList();
        Object ob = new Object();
        Object badOb = new Object();
        Assert.assertTrue(list.size()==0);
        Assert.assertTrue(list.isEmpty());
        Assert.assertTrue(list.indexOf(ob)==-1);
        Assert.assertTrue(!list.contains(ob));
        Assert.assertTrue(list.size()==0);
        list.clear();
        list.add(ob);
        Assert.assertTrue(list.get(0)==ob);
        Assert.assertTrue(list.size()==1);
        Assert.assertTrue(!list.isEmpty());
        Assert.assertTrue(list.contains(ob));

        Assert.assertTrue(!list.contains(badOb));

        Assert.assertTrue(list.indexOf(ob)==0);
        Assert.assertTrue(list.indexOf(badOb)==-1);

        list.put(0,badOb);
        Assert.assertTrue(list.get(0)==badOb);
        Assert.assertTrue(list.size()==1);
        Assert.assertTrue(!list.contains(ob));
        Assert.assertTrue(list.contains(badOb));

        list.insert(0,ob);
        Assert.assertTrue(list.get(0)==ob);
        Assert.assertTrue(list.get(1)==badOb);
        Assert.assertTrue(list.contains(ob)&&list.contains(badOb));
        Assert.assertTrue(list.size()==2);

        Assert.assertTrue(list.remove(1)==badOb);
        Assert.assertTrue(list.remove(0)==ob);
        Assert.assertTrue(list.size()==0);


    }
}
