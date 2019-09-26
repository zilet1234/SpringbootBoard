package com.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EntityScan(
        basePackageClasses = {Jsr310JpaConverters.class},
        basePackages = {"com.general.model"}
)
@SpringBootApplication
//@EnableScheduling
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 작업 스케쥴러를 구현하려면 해당 스케쥴을 관리할 org.springframework.scheduling.TaskScheduler 빈이 등록되어 있어야 한다.
     *
     * @return ( )
     */
    @Bean
    public TaskScheduler taskScheduler(){
        return new ConcurrentTaskScheduler();
    }

    /**
     *  쓰레드 풀이 필요하다면 ThreadPoolTaskScheduler 빈을 등록하고 단일 쓰레드로 충분하다면 ConcurrentTaskScheduler 빈을 등록한다.
     *
     * @return ( )
     */
//    @Bean
//    public TaskScheduler taskSchedulerWithPoolSize() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(10);
//        return taskScheduler;
//    }
}
