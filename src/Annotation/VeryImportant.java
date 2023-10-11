package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// specifies which target this annotation can be used on ex. class
// it takes in an ElementType
// can do a list {ElementType.TYPE, ElementType.METHOD}
@Target(ElementType.TYPE)
// Keep the annotation around while code is being run at runtime
// SOURCE would be for annotations that run before code is even compiled like SuppressWarnings
// CLASS means keeps annotation through compilation then get rid of it
@Retention(RetentionPolicy.RUNTIME)
// notice @interface not class
public @interface VeryImportant {
}
