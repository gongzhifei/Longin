package com.gzf.test.thread;

/**
 * @author llb
 * 子线程循环10次 接着主线程循环100
 * 接着又回到子线程循环10次 主线程循环100次
 * 如此循环50次
 */

public class ThreadStudy {

    public static void main(String[] args) {
        System.out.println("最大的"+Thread.currentThread().getName());
        final SubAndmain sm= new SubAndmain();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程："+Thread.currentThread().getName());
                for(int i=1;i<=50;i++){
                    sm.sub(i);
                }
            }
        }).start();


        for(int i=1;i<=50;i++){
            sm.main(i);
        }
    }

}

class SubAndmain {
    private boolean flag = true;

    public synchronized void sub(int i) {
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("2"+Thread.currentThread().getName());
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread" + j);
        }
        flag= false;
        this.notify();
    }

    public synchronized void main(int i) {
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("3"+Thread.currentThread().getName());
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread" + j);
        }
        flag= true;
        this.notify();
    }
}