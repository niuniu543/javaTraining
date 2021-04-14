package com.train.autoconfig;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class StudentService {

    public static void main(String[] arges){

        /**
         * 通过xml方式注入
         */
        ApplicationContext student=new ClassPathXmlApplicationContext("spring-student.xml");
        Student bean = student.getBean(Student.class);
        System.out.println("bean"+bean.getName()+bean.getCell());
        System.out.println("bean"+bean);

        /**
         * 通过java配置注入
         */
        ApplicationContext student1=new AnnotationConfigApplicationContext(StudentConfig.class);
        Student bean2 = (Student)student1.getBean("student");
        System.out.println("bean"+bean2);
    }

}
