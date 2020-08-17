package com.cos.logtest.config.aop.warn;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
@Aspect
public class BindingAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(BindingAdvice.class);
	
	@Around("execution(* com.cos.logtest.controller..*Controller.*(..))")
	public Object bindingPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		Object[] args = proceedingJoinPoint.getArgs();
		
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName()+" : "; 
		String methodName = proceedingJoinPoint.getSignature().getName()+"() ";
		
		for(Object arg : args) {
			if(arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				if(bindingResult.hasErrors()) {
					Map<String, String> errorMap = new HashMap<>();
					for(FieldError error : bindingResult.getFieldErrors()) {
						log.error("에러 찍혀?");
						log.warn(type+methodName+error.getDefaultMessage());
						log.info("인포 찍혀?");
						log.debug("디버그 찍혀?");
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
				}
			}
		}	
		
		return proceedingJoinPoint.proceed();
	}
}
