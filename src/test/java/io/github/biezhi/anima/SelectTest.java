package io.github.biezhi.anima;

import io.github.biezhi.anima.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author biezhi
 * @date 2018/3/13
 */
public class SelectTest extends BaseTest {

    @Test
    public void testCount() {
        System.out.println(User.count());
    }

    @Test
    public void testCountBy1() {
        long count = User.where("age > ?", 15).isNotNull("name").count();
        Assert.assertEquals(count, 7L);
    }

    @Test
    public void testFindById() {
        User user = User.findById(2);
        Assert.assertNotNull(user);
        Assert.assertEquals(Integer.valueOf(2), user.getId());
    }

    @Test
    public void testAll() {
        List<User> users = User.all();
        Assert.assertNotNull(users);
    }

    @Test
    public void testWhere() {
        List<User> users = User.where("age > ?", 15).all();
        Assert.assertNotNull(users);

        users = User.where("name is not null").all();
        Assert.assertNotNull(users);
    }

    @Test
    public void testIn() {
        List<User> users = User.in("id", 1, 2, 3).all();
        Assert.assertNotNull(users);
    }

}