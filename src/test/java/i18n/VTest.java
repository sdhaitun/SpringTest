package i18n;

import com.wyh.dao.UserDAO;
import com.wyh.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import wyh.common.BaseJunit;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

/**
 * Created by root on 2016/12/29.
 */
public class VTest extends BaseJunit {

    @Autowired
    UserDAO userMapper;

    @Test
    public void test1(){
        Locale locale = Locale.getDefault();
        locale.setDefault(new Locale("en", "US"));
        User user = new User();
//        user.setUsername("u");
        user.setPassword("p");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        if (constraintViolations != null && constraintViolations.size() > 0){
            for(ConstraintViolation<User> constraintViolation:constraintViolations) {
                System.out.println(constraintViolation.getMessageTemplate());
                System.out.println(constraintViolation.getMessage());
            }
        }
//        userMapper.saveAndFlush(user);
//        System.out.println(userMapper.saveAndFlush(user).getId());
    }

    @Test
    public void testDate() throws ParseException {
        String dateString = "2012-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = sdf.parse(dateString);
    }
}
