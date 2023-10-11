package Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Annotation {

    public static void main(String[] args) throws Exception{
        Cat myCat = new Cat("Stella");

        // Processing the annotation
        // Check if class is marked by the annotation
        if(myCat.getClass().isAnnotationPresent(VeryImportant.class)){
            // Code for the annotation goes here
            System.out.println("This Class is very Important");
        }
        else{
            System.out.println("Not very Important");
        }

        for(Method method : myCat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for(int i = 0; i < annotation.times(); i++) {
                    method.invoke(myCat);
                }
            }
        }

        for(Field field : myCat.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantString.class)){
                Object objectValue = field.get(myCat);
                // Casts to stringValue if it is an instanceof String
                if(objectValue instanceof String stringValue){
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}
