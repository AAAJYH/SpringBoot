package com.jyh.Java并发编程的艺术;

import com.mysql.jdbc.TimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jyh
 * @date 2019/12/14
 * @description
 */

public class Priority {

    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i=0; i<10; i++) {
            int priority = i;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "THread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("Job Priority : " + job.priority + ", count " + job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int priority;
        private long jobCount;

        public Job (int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }

    }

}
