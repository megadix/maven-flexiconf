package it.megadix;

import it.megadix.package1.SampleService1;
import it.megadix.package2.SampleService2;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        new SampleService1().doSomething();
        new SampleService2().doSomething();
    }
}
