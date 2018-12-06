import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class QueryTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Transactional
    @Test
    public void testquery(){
      List<User> users= userDao.findAllByRoleName("java程序员");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Transactional
    @Test
    public void testQuery(){
      List<Role>roles=  roleDao.findAllByUserName("小李");
        for (Role role : roles) {
            System.out.println(role);
        }
    }
}
