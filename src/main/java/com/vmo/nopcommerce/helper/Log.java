package com.vmo.nopcommerce.helper;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
    private static Logger logger = LogManager.getLogger(Log.class);
    public static void info(String msg, String ...value){
        if (value.length==0){
            logger.info(msg);
        }else {
            logger.info(String.format(msg,(Object[]) value));
        }
    }
    public static void allure(String msg,String...value){
        if (value.length==0){
            info(msg);
            step(msg);
        }else {
            info(String.format(msg,(Object[]) value));
            step(String.format(msg,(Object[]) value));
        }
    }
    public static void error(String msg){
        logger.error(msg);
    }public static void debug(String msg){
        logger.debug(msg);
    }
@Step("{msg}")
    private static void step(String msg){}
}
