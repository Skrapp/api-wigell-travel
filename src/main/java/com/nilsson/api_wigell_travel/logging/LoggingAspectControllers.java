package com.nilsson.api_wigell_travel.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class LoggingAspectControllers {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectControllers.class);

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void logCreate(JoinPoint joinPoint) {
        var dto = Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg.getClass().getSimpleName().endsWith("Dto"))
                .findFirst()
                .orElse(null);

        logger.info("CREATE successful in {} with: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                dto);
    }

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void logUpdate(JoinPoint joinPoint) {
        var dto = Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg.getClass().getSimpleName().endsWith("Dto"))
                .findFirst()
                .orElse(null);

        logger.info("UPDATE successful in {} with: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                dto);
    }

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.PatchMapping)")
    public void logPatch(JoinPoint joinPoint) {
        var dto = Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg.getClass().getSimpleName().endsWith("Dto"))
                .findFirst()
                .orElse(null);

        logger.info("PATCH successful in {} with: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                dto);
    }

    @AfterReturning("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void logDelete(JoinPoint joinPoint) {
        var id = Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg.getClass().getSimpleName().equals("Long"))
                .findFirst()
                .orElse(null);

        logger.info("DELETE successful in {} with id: {}",
                joinPoint.getSignature().getDeclaringTypeName(), id);
    }
}

