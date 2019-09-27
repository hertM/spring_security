import cn.tl.maventest.domain.Permission;
import cn.tl.maventest.domain.User;
import cn.tl.maventest.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testOne() {
        User user = userMapper.findByUsername("lisi");

        System.out.println(user);

    }



    @Test
    public void testTwo() {
        List<Permission> list = userMapper.findPermissionByUsername("lisi");



        list.forEach(item -> {
            System.out.println(item.toString());

        });



    }


}
