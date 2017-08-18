package com.samples;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.concurrent.BlockingQueue;

/**
 * Created by edara on 8/9/17.
 */
public class HZMain2 {
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        BlockingQueue<Integer> q = hz.getQueue("q");
        //Thread.sleep(10000);
        while(true){
            int num = q.take();
            if (num == 10) break;
            System.out.println("Time:"+System.currentTimeMillis()+":"+num);

            Thread.sleep(100);
        }
        System.out.println("done");
    }
}
