package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            //can be used for decorator Class<? extends BaseDecorator>
            Class<?> personClass = Class.forName("org.example.Person");

            //class
            System.out.println("class name : " + personClass.getName());
            System.out.println("class access : " + personClass.accessFlags());

            //attributes
            System.out.println("class attributes : ");
            for (Field field : personClass.getDeclaredFields()) {
                System.out.println("- " + field.getName() + "type : " + field.getType());
            }

            //methods
            System.out.println("methods listing");
            for (Method method : personClass.getDeclaredMethods()) {
                System.out.println(method.getName());
            }

            //instanciate via constructor
            Constructor<?> constructor = personClass.getConstructor(
                    String.class,
                    int.class
            );

            String bob = "bob";
            int age = 42;
            Object personInstance = constructor.newInstance(bob, age);
            System.out.println(personInstance);

            //methods call
            Method sayHelloMethod = personInstance.getClass().getDeclaredMethod("sayHello");
            sayHelloMethod.setAccessible(true);
            sayHelloMethod.invoke(personInstance);


            // private field to public field
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(personInstance, "alice");
            System.out.println("after updates : " + nameField.get(personInstance));

            sayHelloMethod.setAccessible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}