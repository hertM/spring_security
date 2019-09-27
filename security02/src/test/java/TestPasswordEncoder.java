import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPasswordEncoder {


    /**
     *
     * 测试他的 加密 密码
     *
     */
    public static void testPassworldEncoder() {

        //因为 PasswordEncoder 是一个抽象类 不能 new出来 所以 使用他的子类
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String s = encoder.encode("123456");

        System.out.println(s);


    }


    public static void main(String[] args) {
        testPassworldEncoder();
    }
}
