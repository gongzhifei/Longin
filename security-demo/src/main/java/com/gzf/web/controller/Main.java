package com.gzf.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static boolean is_first = true;

    public static String str = "";
    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("线程一号启动");
                Main.excute("一号");
                logger.info("线程一号结束");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("线程二号启动");
                Main.excute("二号");
                logger.info("线程二号结束");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("线程三号启动");
                Main.excute("三");
                logger.info("线程三号结束");
            }
        });


        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("线程四号启动");
                Main.excute("四号");
                logger.info("线程四号结束");
            }
        });


        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("线程五号启动");
                Main.excute("五号");
                logger.info("线程五号结束");
            }
        });



        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

    public static void excute(String name){
        if(is_first){
            str = "123";
            is_first = false;
            System.out.println(name+":"+str);
        }else{
            str = "456";
            System.out.println(name+":"+str);
        }
    }

}
