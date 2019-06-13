import java.awt.*;

public class game implements Runnable {
    private boolean pause=false;
    private static boolean running=false;
    private static float rate=60.0f;
    public static boolean gameover=false;
    private Graphics2D graphics2D;
    private Input input=new Input();
    private static Thread thread;
    private Player player=new Player(128,382);

    public game (){

        running=false;
        frame.created();
        SCORE.SCOREcreated();
        LVLmap16.LVLmapcreated();
        graphics2D=frame.getGraphics2D();
        frame.window.add(input);
    }

    public synchronized void start(){
        if (running) return;

        running=true;
        thread=new Thread(this);
        thread.start();
    }

    public static void stop(){
        if (!running) return;

        running=false;
        thread.interrupt();
        System.exit(0);

    }

    private void update (){
        player.update(input);

    }

    private void render(){
        frame.clear();
        LVLmap16.renderall(graphics2D);
        player.render(graphics2D);

        LVLmap16.renderforest(graphics2D);
        frame.swapBuffers();
    }

    public void run(){

        float delta=0f;
        long lastTime=System.nanoTime();

        while (running){
            long difference =System.nanoTime()-lastTime;
            pause=input.GamePause(pause);

            while (pause){
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pause=input.GamePause(pause);
            }

            lastTime=System.nanoTime();
            delta+=(difference*rate/1000000000);
            boolean render = false;

            while (delta>1){
                update();
                delta--;
                if (!render) render=true;
            }

            if (render) render();
            else
                try {
                Thread.sleep(1);
                }
                catch (InterruptedException e){
                e.printStackTrace();
                }
        }
    }

    public static void over(){
        gameover=true;
    }
}
