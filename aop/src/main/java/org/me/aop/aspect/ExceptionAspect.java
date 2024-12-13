package org.me.aop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.me.aop.exception.BookNotInDatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {

    private static final Logger log = LoggerFactory.getLogger(ExceptionAspect.class);

    @AfterThrowing(pointcut = "execution(* org.me..*.*(..))", throwing = "ex")
    public void handleDbExceptions(BookNotInDatabaseException ex) {
        logErrorsHandler(ex);
    }

    private void logErrorsHandler(BookNotInDatabaseException ex) {
        if (ex instanceof BookNotInDatabaseException bookEx) {
            log.error("there is a book type error: " + bookEx.getMessage());
        } else if (ex instanceof Exception exx) {
            log.error("there is  error: " + exx.getMessage());
        }
    }

}
