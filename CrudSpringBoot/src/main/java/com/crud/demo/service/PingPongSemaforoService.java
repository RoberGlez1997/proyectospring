package com.crud.demo.service;

import java.util.List;
import java.util.concurrent.Semaphore;

public class PingPongSemaforoService extends Thread{

    List<String> list;

    private Semaphore mine;
    private Semaphore other;


    private final String action;

    public PingPongSemaforoService(String action, Semaphore mine, Semaphore pongS, List <String> list) {
        this.action = action;
        this.mine=mine;
        this.other=pongS;
        this.list=list;


    }

    @Override
    public void run() {

        try{


            for (int i=0;i<=90;i++){




                //ESPERAR OTRO HILO
                adquire();

                System.out.println(action);

                list.add(action);

                release();

            }
        }

        catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    public void adquire() throws InterruptedException {
        mine.acquire();
    }

    public void release() {

        other.release();
    }
}
