import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO
import ch.qos.logback.classic.filter.LevelFilter
import static ch.qos.logback.core.spi.FilterReply.ACCEPT
import static ch.qos.logback.core.spi.FilterReply.DENY


statusListener(OnConsoleStatusListener)

//Set path to the logs
def LOG_PATH="/Users/alexey.bulbenko/Downloads"
appender('Console-Appender', ConsoleAppender) {
    // Filter exclude INFO log messages from console log
    filter("ch.qos.logback.classic.filter.LevelFilter") {
        level = INFO
        onMatch = DENY
        onMismatch = ACCEPT
    }

    // Enable coloured output
    withJansi = true

    encoder(PatternLayoutEncoder) {
        pattern = "%blue(%-5level) %green(%logger{35}) - %msg %n"
    }
}

appender("File-Appender", FileAppender) {
    // File where log will be saved
    file = "${LOG_PATH}/logfile.log"

    // Filter include INFO log messages
    filter("ch.qos.logback.classic.filter.LevelFilter") {
        level = INFO
        onMatch = ACCEPT
        onMismatch = DENY
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{dd-HH:mm:ss.SSS}:%-5level[%thread]: %logger{36} - %msg%n"
        outputPatternAsHeader = true
    }
}

//logger('loggerExample.MyLogger', ERROR, ['Console-Appender'])
root(DEBUG, ['File-Appender', 'Console-Appender'])