package test;

import static org.junit.Assert.*;

import com.google.gson.*;
import com.zyt.api.user.UserApi;
import com.zyt.entity.doctor.PatientEntity;
import com.zyt.entity.system.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.context.transaction.TransactionConfiguration;
import javax.annotation.Resource;
/**
 * Created by ljw on 16/4/13.
 * Time 下午8:57.
 */
@SuppressWarnings("deprecation")
@WebAppConfiguration(value = "src/main")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy(
        {@ContextConfiguration(name = "parent",locations = "classpath:applicationContext.xml"),
        @ContextConfiguration(name = "child",locations = "classpath:spring-mvc.xml")
        }
        )


public class UserApiTest {

    @Autowired
    private UserApi userApi;


    @Test
    public void testGet()
    {
        PatientEntity p = userApi.recipeGet("28");
        Gson g = new Gson();
        String json = g.toJson(p);
        System.out.println(json);
    }
}
