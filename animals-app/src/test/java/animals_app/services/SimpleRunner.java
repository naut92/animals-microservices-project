package animals_app.services;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleRunner {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        SimpleRunner sr = new SimpleRunner();
        sr.runTests();
    }

    private void runTests() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cl = Class.forName("animals_app.services.CustomerServiceImplTest");

        Constructor cst = cl.getConstructor();
        Object entity = cst.newInstance();

        Method[] methods = cl.getMethods();
        for ( Method m : methods) {
            Test annot = m.getAnnotation(Test.class);
            if(annot != null){
                m.invoke(entity);
            }
        }
    }
}
