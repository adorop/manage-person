package by.it.academy.adorop.controller.utils;

import by.it.academy.adorop.controller.commands.Command;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandsContextUtil {
    private static final ClassPathXmlApplicationContext applicationContext
            = new ClassPathXmlApplicationContext(new String[]{"commands-config.xml"});

    public static Command getCommand(String beanName) {
        return (Command) applicationContext.getBean(beanName);
    }

    public static void closeContext() {
        applicationContext.close();
    }
}
