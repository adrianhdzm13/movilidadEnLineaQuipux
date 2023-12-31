package co.quipux.utils;

import org.apache.log4j.Logger;


public class BaseConfig {

    public static Logger log;

    public BaseConfig(Class className) {
        log = Logger.getLogger(className);
    }

}
