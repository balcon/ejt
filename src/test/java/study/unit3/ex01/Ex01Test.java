package study.unit3.ex01;

import org.junit.Test;


public class Ex01Test {

    @Test
    public void test(){
        CrazyLogger crazyLogger = new CrazyLogger();

        crazyLogger.log("first log");
        crazyLogger.log("second log");
        crazyLogger.log("log about something");
        crazyLogger.log("console");
        crazyLogger.log("last log.. or not");
        crazyLogger.log("control");

        crazyLogger.printLog();

     /* 27-10-2016 : 00-03 - first log
        27-10-2016 : 00-03 - second log
        27-10-2016 : 00-03 - log about something
        27-10-2016 : 00-03 - console
        27-10-2016 : 00-03 - last log.. or not
        27-10-2016 : 00-03 - control */

        crazyLogger.findLog("con");

     /* Search result for "con":

        27-10-2016 : 00-03 - second log
        27-10-2016 : 00-03 - console
        27-10-2016 : 00-03 - control */

    }


}