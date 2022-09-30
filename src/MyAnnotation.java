import com.sun.deploy.security.ValidationState;

import java.lang.annotation.*;
import java.lang.reflect.Type;

import static java.lang.annotation.ElementType.*;

@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,ANNOTATION_TYPE,PACKAGE})
public @interface MyAnnotation {
    String value() default "in";
}

@MyAnnotation(value = "in")
@MyAnnotation(value = "on")
class Persons{
    public static void main(String[] args) {

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,ANNOTATION_TYPE,PACKAGE})
@interface MyAnnotations{
    MyAnnotation[] value();
}