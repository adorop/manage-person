package by.it.academy.adorop.controller.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class FromConsoleBuilder {

    public static <T> T buildObject(Class<T> clazz) {
        Object instance = null;
        try {
            instance = clazz.newInstance();
            setFields(instance, getAllFieldsOf(clazz));
            return (T) instance;
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Some global problems occurred");
            System.exit(0);
        }
        return (T) instance;
    }

    private static void setFields(Object instance, List<Field> fields) throws IllegalAccessException {

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (!isId(field) && !isCollectionOrArray(fieldType) && !isClassFromModel(fieldType)) {
                printMessage(field);
                if (fieldType == Integer.class) {
                    field.set(instance, InputReader.readInteger());
                } else if (fieldType == String.class) {
                    field.set(instance, InputReader.readString());
                } else if (fieldType == Double.class) {
                    field.set(instance, InputReader.readDouble());
                }
            }
        }
    }

    private static boolean isId(Field field) {
        return field.getName().equals("id");
    }

    private static boolean isClassFromModel(Class<?> fieldType) {
        return fieldType.getPackage().getName().equals("by.it.academy.adorop.entities");
    }

    private static boolean isCollectionOrArray(Class<?> fieldType) {
        return fieldType == Array.class || fieldType.isInstance(Collection.class);
    }

    private static void printMessage(Field field) {
        String fieldName = field.getName();
        System.out.println(makeMessage(fieldName));
    }

    private static String makeMessage(String name) {
        StringBuilder builder = new StringBuilder(name);

        for (int i = 0; i < builder.length() - 1; i++) {
            char c = name.charAt(i);
            if (c < 'a') {
                builder.insert(i, ' ');
            }
        }
        builder.insert(0, "Insert ");
        return builder.toString().toUpperCase();
    }

    private static List<Field> getAllFieldsOf(Class clazz) {
        List<Field> fields = new LinkedList<>();

        while (clazz != Object.class) {
            fields.addAll(0, Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
