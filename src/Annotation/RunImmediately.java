package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunImmediately {
    //Initialized like a method but used like a variable
    // These parameters can only be a primitive, class type, string or array of those
    // Need default otherwise you will need to put the parameter in
    int times() default 1;
}
