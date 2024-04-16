//package com.example.demo.service;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.Model.Salary;
//
//@Aspect
//@Component
//
//public class SalaryServiceAspect {
////	@Pointcut("execution(* com.example.demo.service.SalarySevice.*(..))")
////	public void employeeServiceMethods() {
////	}
//
//	@Before("execution(* com.example.demo.service.SalarySevice.*(..)) && args(salary, ..)")
//	public void before(JoinPoint joinPoint, Salary salary) {
//		System.out.println("BeforMethod " + joinPoint.getSignature() + " is about to execute.");
//		System.out.println("Creating Employee with emp_salary: " + salary.getEmp_salary() + ", employee_id: "
//				+ salary.getEmployee_id() + ", and age: " + salary.getAge());
//	}
//
//	@After("execution(* com.example.demo.service.SalarySevice.*(..)) && args(salary, ..)")
//	public void after(JoinPoint joinPoint, Salary salary) {
//		System.out.println("AfterMethod " + joinPoint.getSignature() + " is about to execute.");
//		System.out.println("Creating Employee with emp_salary: " + salary.getEmp_salary() + ", employee_id: "
//				+ salary.getEmployee_id() + ", and age: " + salary.getAge());
//	}
//
//	@AfterReturning(value = "execution(* com.example.demo.service.SalarySevice.*(..)) ", returning = "salary")
//	public void afterReturningAdvice(JoinPoint joinPoint, Salary salary)  
//	{  
//	System.out.println("After Returing method:"+joinPoint.getSignature());  
//	System.out.println(salary);  
//	}  
//
//	@Around(value = "execution(* com.example.demo.service.SalarySevice.*(..)) ")
//	public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println("Around method " + jp.getSignature().getName() + " is about to execute.");
//		try {
//			
//			Object result = jp.proceed();
//			System.out.println("Around method " + jp.getSignature().getName() + " has executed.");
//			return result;
//		} catch (Exception e) {
//			
//			throw e;
//		} finally {
//			System.out.println("Around method " + jp.getSignature().getName() + " execution completed.");
//		}
//	}
//
//	@AfterThrowing(value =  "execution(* com.example.demo.service.SalarySevice.*(..)) ", throwing = "ex")
//	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
//		System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
//		System.out.println("Exception is:" + ex.getMessage());
//	}
//}