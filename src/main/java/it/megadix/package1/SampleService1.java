package it.megadix.package1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleService1 {
    private static final Logger log = LoggerFactory.getLogger(SampleService1.class);

    public void doSomething() {
        log.debug("DEBUG message from SampleService1");
        log.info("INFO message from SampleService1");
        log.warn("WARN message from SampleService1");
    }
}
