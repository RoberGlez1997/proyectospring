package com.crud.demo.service;

public class PingPongService implements Runnable{
    private String action;

    public PingPongService(String action) {
        this.action = action;
    }

    @Override
    public void run() {
        for(int i =0 ; i<1; i++){
            System.out.println("Action: "  + action + ":" + i);
        }

    }
}
