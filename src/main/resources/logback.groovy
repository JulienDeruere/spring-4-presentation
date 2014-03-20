import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import static ch.qos.logback.classic.Level.*

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{yyyy-MM-dd_HH:mm:ss.SSS} %-5level %logger{36} - %msg%n"
    }
}
//appender("FILE", RollingFileAppender) {
//    file = "/home/jderuere/repository/anathec/logs/anathec.log"
//    encoder(PatternLayoutEncoder) {
//        pattern = "%d{yyyy-MM-dd_HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
//    }
//    rollingPolicy(FixedWindowRollingPolicy) {
//        fileNamePattern = "/home/jderuere/repository/anathec/logs/anathec.%i.log.zip"
//        minIndex = 1
//        maxIndex = 10
//    }
//    triggeringPolicy(SizeBasedTriggeringPolicy) {
//        maxFileSize = "2MB"
//    }
//}
logger("org.hibernate", INFO)
logger("org.hibernate.SQL", DEBUG)
logger("org.hibernate.type.descriptor.sql", ALL)
logger ("org.eclipse.persistence", DEBUG)
root(DEBUG, ["STDOUT"])