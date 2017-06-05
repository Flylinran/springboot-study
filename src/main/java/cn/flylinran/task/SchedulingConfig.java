package cn.flylinran.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicLong;

/**
 * author: huzunrong
 * date: 2017/6/5
 * description:
 * version: 1.0
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
    private final AtomicLong counter = new AtomicLong();

//    @Scheduled(cron = "0/20 * * * * ?")
    public void scheduled() {
        System.out.println(counter.incrementAndGet() + ">>>>>>>>>>>>>>SchedulingConfig.scheduler()");
    }
}
