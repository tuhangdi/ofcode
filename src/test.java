import javafx.util.BuilderFactory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by thd on 2017/8/9
 */

public class test{
    private  String username;

    public static void main(String[] args) {
        test user = new test();
        user.username = "admin";
        uservo vo = uservo.Builder.getBuilder().append(user).build();
        uservo vo2 = uservo.Builder.getBuilder().setUsername("xiaoming").build();
        System.out.println(vo.username + vo2.username);
    }
    public static class uservo {
        public static BuilderFactory Builder;
        private String username;
        
    }
}
