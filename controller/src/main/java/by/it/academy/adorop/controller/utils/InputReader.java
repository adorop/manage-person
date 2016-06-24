package by.it.academy.adorop.controller.utils;

import by.it.academy.adorop.dao.utils.HibernateUtil;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private static Logger logger = Logger.getLogger(InputReader.class);

    private InputReader() {}

    public static String readString() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Some problems with console");
            HibernateUtil.realizeResources();
            System.exit(0);
            return null;
        }
    }

    public static Integer readInteger() {
        return Integer.valueOf(readString());

    }

    public static Double readDouble() {
        return Double.valueOf(readString());
    }
}
