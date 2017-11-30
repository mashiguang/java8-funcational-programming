package cn.niceabc.j8fp.chepter02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercise02 {

    /*a*/
    ThreadLocal<String> varTL = ThreadLocal.withInitial(()->"hello");

    /*b*/
    ThreadLocal<DateFormat> dfTL;
    Date now = new Date();

    public Exercise02(String format) {
        dfTL = ThreadLocal.withInitial(() -> new SimpleDateFormat(format));
    }

    public void print() {
        System.out.println("["+Thread.currentThread().getName()+"]" + dfTL.get().format(now));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(2);

        Future future1 = exe.submit(() -> {
            Exercise02 clock = new Exercise02("yyyy-MM-dd HH:mm:ss");
            for (int i = 0; i < 20; i++) {
                clock.print();
            }
        });

        Future future2 = exe.submit(() -> {
            Exercise02 clock = new Exercise02("MM-dd-yyyy");
            for (int i = 0; i < 20; i++) {
                clock.print();
            }
        });

        future1.get();
        future2.get();

        exe.shutdown();
    }
}
