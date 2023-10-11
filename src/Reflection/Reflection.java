package Reflection;

import java.lang.reflect.*;

public class Reflection {

    public static void main(String[] args) throws Exception {
        Cat myCat = new Cat("Stella", 6);
        // Reflection fields
        Field[] catFields = myCat.getClass().getDeclaredFields();

        // The name is private final can we change it?
        for(Field field : catFields){
            System.out.println(field.getName());
            if(field.getName().equals("name")){
                // gets illegalAccessException because of the private final
                // get around the exception with this
                field.setAccessible(true);
                // Method  takes in an object and then what you want to change the field to
                field.set(myCat, "Jimmy McGill");
            }
        }
        System.out.println(myCat.getName());

        Method[] catMethods = myCat.getClass().getDeclaredMethods();
        for(Method method : catMethods){
            // invoke takes in the object and then any parameters
            System.out.println(method.getName());
            if(method.getName().equals("privateMethod")){
                method.setAccessible(true);
                method.invoke(myCat);
            }
            if(method.getName().equals("publicStaticMethod")){
                method.invoke(null);
            }
        }


    }
}
