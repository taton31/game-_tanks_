import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player {
    private int x,y;
    private final int scale=32;
    private int animation=0;
    private Picture picture=new Picture(0,0,64,0,96,0,32,0,16,0,80,0,112,0,48,0,15,scale);
    private BufferedImage image=picture.getPicture("UP1");
    private bullet BULLET;
    private boolean BULL=false;
    private boolean up=true;
    private boolean down=false;
    private boolean right=false;
    private boolean left=false;


    public Player(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void update (Input input){
        int newy=y;
        int newx=x;

        if (BULL)
        {
            BULLET.update();
            if (BULLET.empty) {
                BULLET=null;
                BULL=false;
            }
        }

        animation++;
        if (animation==100) animation=0;

        if (animation%4==0) return;

        if (input.getkey(KeyEvent.VK_UP)) {
            newy-=2;
            image=picture.getPicture("UP"+anim());
            up=true;
            down=right=left=false;
            if (newx%16<7) newx--;
            if (newx%16>8 ) newx++;

        }
        else if (input.getkey(KeyEvent.VK_DOWN)) {
            newy+=2;
            image=picture.getPicture("DOWN"+anim());
            down=true;
            up=right=left=false;
            if (newx%16<7) newx--;
            if (newx%16>8 ) newx++;
        }
        else if (input.getkey(KeyEvent.VK_LEFT)) {
            newx-=2;
            image=picture.getPicture("LEFT"+anim());
            left=true;
            down=right=up=false;
            if (newy%16<7) newy--;
            if (newy%16>8) newy++;
        }
        else if (input.getkey(KeyEvent.VK_RIGHT)) {
            newx+=2;
            image=picture.getPicture("RIGHT"+anim());
            right=true;
            down=left=up=false;
            if (newy%16<7 ) newy--;
            if (newy%16>8) newy++;
        }

        if (!BULL && input.getkey(KeyEvent.VK_SPACE)) {
            String string=null;
            if (up) string="UP";
            else if (down) string="DOWN";
            else if (right) string="RIGHT";
            else if (left) string="LEFT";
            BULLET=new bullet(string,x,y);
            BULL=true;
        }

        if (newx<0) newx=0;
        else if (newx>frame.Window_Width-scale-60) newx=frame.Window_Width-scale-60;
        if (newy<0) newy=0;
        else if (newy>frame.Window_Height-scale) newy=frame.Window_Height-scale;

        if (input.getkey(KeyEvent.VK_UP) || input.getkey(KeyEvent.VK_DOWN) || input.getkey(KeyEvent.VK_RIGHT) || input.getkey(KeyEvent.VK_LEFT)) {
            if (up) {
                while (!LVLmap16.checkgo(newx, newy) || !LVLmap16.checkgo(newx + scale - 1, newy) || !LVLmap16.checkgo(newx + 16, newy))
                    newy++;
            }
            if (down) {
                while (!LVLmap16.checkgo(newx, newy + scale - 1) || !LVLmap16.checkgo(newx + scale - 1, newy + scale - 1) || !LVLmap16.checkgo(newx + 16, newy + scale - 1))
                    newy--;
            }
            if (right) {
                while (!LVLmap16.checkgo(newx + scale - 1, newy) || !LVLmap16.checkgo(newx + scale - 1, newy + scale - 1) || !LVLmap16.checkgo(newx + scale - 1, newy + 16))
                    newx--;
            }
            if (left) {
                while (!LVLmap16.checkgo(newx, newy) || !LVLmap16.checkgo(newx, newy + scale - 1) || !LVLmap16.checkgo(newx, newy + 16))
                    newx++;
            }
        }




        x=newx;
        y=newy;
    }

    public void render(Graphics2D graphics2D){
        if (BULL) BULLET.render(graphics2D);
        graphics2D.drawImage(image,x,y,null);
    }

    private int anim(){
        return (1+((animation*(animation+1)/2))%2);
    }

}
