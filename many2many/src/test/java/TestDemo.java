import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemo {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Transactional
    @Rollback(false)
    @Test
    public void testAdd(){
        User user = new User();
        user.setUserName("小张");
        user.setUserCode("xiaozhang");
        user.setUserPassword("123");
        user.setUserState("1");

        Role role = new Role();
        role.setRoleName("产品经理");
        role.setRoleMemo("高薪人群");

        user.getRoles().add(role);
        role.getUsers().add(user);
        userDao.save(user);
        //roleDao.save(role);

    }
    @Transactional
    @Rollback(false)
    @Test
    public void testRemoveRole(){
        //查询1号角色
        Role role = roleDao.findOne(7l);
        //删除1号角色
        roleDao.delete(role);

    }
    @Transactional
    @Rollback(false)
    @Test
    public void testRemoveUser(){
        //查询1号用户
        User user = userDao.findOne(3l);
        //删除1号用户
        userDao.delete(user);
    }
}
