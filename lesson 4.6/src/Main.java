public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.doOperation(0);
        Thread deamon= main.startDeamon();//запуск демона
        main.doOperation(1);
        Thread thread= new Thread(() -> {
            main.doOperation(2);
            if (Thread.currentThread().isInterrupted()) {
                new RuntimeException("Поток 2-4 оставновлен");
            }
            main.doOperation(3);
            if (!Thread.currentThread().isInterrupted()) {
                new RuntimeException("Поток 2-4 оставновлен");
                main.doOperation(4);
            }

        });
        thread.start();
        new Thread(()->{
            main.doOperation(5);
            main.doOperation(6);
            main.doOperation(7);
        }).start();
        thread.interrupt();
        main.doOperation(8);
        main.doOperation(9);
        deamon.interrupt();// остановка демона

    }



    public void doOperation(int number) {
        System.out.println("Operation"+ number);
        String s="";
//        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            s += i;
//            sb.append(i);
        }
//        sb.toString();
//        System.out.println(s);
    }
    public Thread startDeamon() {
        Thread deamon = new Thread(() -> {
            int i=0;
            try {
            while (true) {
                i+=1;
                System.out.println("Deamon running ="+i);

                    Thread.sleep(1000);
                }
                }catch (InterruptedException e) {
                    System.out.println("Daemon stopped");
            }
        });
        deamon.start();
        return deamon;
    }
}