package com.samples;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.concurrent.BlockingQueue;


public class HZMain1 {
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        BlockingQueue<Integer> queue = hz.getQueue("q");
        Thread.sleep(1000);

        for(int i=0;i<10;i++) {
            Thread.sleep(1000);
            queue.add(i);
            System.out.println("Adding "+i+" at "+System.currentTimeMillis());
        }

        System.out.println("done"+System.currentTimeMillis());
    }
}
