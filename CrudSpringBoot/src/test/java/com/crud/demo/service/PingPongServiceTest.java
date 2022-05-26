package com.crud.demo.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.*;

class PingPongServiceTest {
    @Test
    void run2() throws InterruptedException {

        List<String> list= new ArrayList<String>();


        Semaphore pingS = new Semaphore(1);
        Semaphore pongS = new Semaphore(0);

        PingPongSemaforoService ping = new PingPongSemaforoService("PING",pingS,pongS,list);
        PingPongSemaforoService pong = new PingPongSemaforoService("PONG",pongS,pingS,list);

        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        boolean correcto=true;

        for (int i = 0; i<list.size()-1&&correcto;i++){
            if (list.get(i).equals(list.get(i+1))){
                correcto=false;
            }
        }

        System.out.println(correcto);
        assertTrue(correcto);

    }
}