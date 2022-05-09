package com.crud.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PingPongServiceTest {

    @Test
    void run() throws InterruptedException {

        PingPongService ping = new PingPongService("PING");
        PingPongService pong = new PingPongService("PONG");

        for (int i =0 ; i<10; i++) {
            Thread t1 = new Thread(ping);
            Thread t2 = new Thread(pong);
            t1.start();
            t2.start();
        }


        Thread.sleep(1000);
    }
}