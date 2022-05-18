import beans.Point;
import beans.Validator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {
    private Point point;
    @Before
    public void setUp() {
        point = new Point();
        point.setX("1");
        point.setY("1");
        point.setR("1");
    }

    @Test
    public void test1() {
        Assert.assertTrue(Validator.isValidDate(point));
    }

    @After
    public void after() {
        System.out.println("test input data");
        System.out.println(point.toJSON());
    }
}
