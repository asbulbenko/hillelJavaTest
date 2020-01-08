package loggerExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
    private static Logger logger = LoggerFactory.getLogger(MyLogger.class);
    private static final int n = 5;

    public static void main(String[] args) {
        logger.info("Introduction of different loggers in this MyLogger class");
        logger.info("This Demo example of loggers");
        logger.warn("=========== ONLY WARN LEVEL ============");
        logger.warn("Start of warning messages");
        logger.warn("Example warning count {}", n);
        for (int i = 0; i < n; i++) {
            logger.info("For loop of warnings will be executed {} times", i);
        }
        logger.warn("End of Warn messages");

        logger.error("=========== ONLY ERROR LEVEL ============");
        logger.error("Example error count {}", n);
        for (int i = 0; i < 5; i++) {
            logger.info("For loop of errors will be executed {} times", i);
        }
        try {
            logger.info("Going to divide {} by zero", n);
            int divideResult = n / 0;
        } catch (Exception e) {
            logger.error("Error dividing {} by zero", n, e);
        }
        logger.error("End of Error messages");


    }
}
