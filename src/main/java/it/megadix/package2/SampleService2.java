package it.megadix.package2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleService2 {
    private static final Logger log = LoggerFactory.getLogger(SampleService2.class);

    public void doSomething() {
        log.debug("DEBUG message from SampleService2");
        log.info("INFO message from SampleService2");
        log.warn("WARN message from SampleService2");
    }
}
