package com.crud.demo.service;

import java.util.concurrent.Semaphore;

public class PingPongGood extends Thread {
    private String movimiento;
    private static Semaphore semaforo = new Semaphore(1);

    public PingPongGood(String movimiento, Semaphore s) {
        this.movimiento = movimiento;
        this.semaforo = s;
    }
    public static void main(String[] args) {

        Thread t1 = new PingPongGood("PING", semaforo);
        Thread t2 = new PingPongGood("PONG", semaforo);



            t1.start();
            t2.start();
            try {

                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo principal del proceso interrumpido.");
            }


        System.out.println("Proceso terminado.");
    }

    public void run() {

        for (int i = 0; i < 16; i++) {

            if (movimiento.equals("PING")) {
                try {


                    System.out.println((String) (movimiento));
                    sleep(1000);



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (movimiento.equals("PONG")) {
                try {


                    System.out.println((String) (movimiento));
                    sleep(2000);





                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }

    }





}