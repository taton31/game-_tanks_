import java.awt.*;
import java.awt.image.BufferedImage;

public class bullet {
    private int speed=2;
    private int x;
    private int i=0;
    private int y;
    private int X1=-1;
    private int Y1=-1;
    private int X2=-1;
    private int Y2=-1;
    private boolean crash=false;
    private Image image=new Image("bullets.png");
    private BufferedImage UP =RESIZE.resize(image.cut(0,0,3,4),6,8);
    private BufferedImage DOWN =RESIZE.resize(image.cut(5,4,3,4),6,8);
    private BufferedImage LEFT =RESIZE.resize(image.cut(4,0,4,3),8,6);
    private BufferedImage RIGHT =RESIZE.resize(image.cut(0,5,4,3),8,6);
    private BufferedImage CRASH1 =Image.deleteblack(RESIZE.resize((new Image("texture_atlas.png")).cut(256,128,16,16),32,32));
    private BufferedImage CRASH2 =Image.deleteblack(RESIZE.resize((new Image("texture_atlas.png")).cut(272,128,16,16),32,32));
    private BufferedImage CRASH3 =Image.deleteblack(RESIZE.resize((new Image("texture_atlas.png")).cut(288,128,16,16),32,32));
    private boolean up=false;
    private boolean down=false;
    private boolean right=false;
    private boolean left=false;
    private boolean crash1=false;
    private boolean crash2=false;
    private boolean crash3=false;
    public boolean empty=false;

    public bullet(String string, int x, int y){
        if (string.equals("UP")) {
            this.x = x + 13;
            this.y = y;
            up = true;
        }
        else if (string.equals("DOWN")) {
            this.x = x + 13;
            this.y = y + 32;
            down = true;
        }
        else if (string.equals("LEFT")) {
            this.x=x;
            this.y=y+13;
            left=true;
        }
        else if (string.equals("RIGHT")) {
            this.x=x+32;
            this.y=y+12;
            right=true;
        }

    }

    public void update(){
        if (!crash) {
            if (up) y -= speed;
            else if (down) y += speed;
            else if (right) x += speed;
            else if (left) x -= speed;

            if (x>408) {x=408; crash=true;}
            else if (x<0) {x=0; crash=true;}
            else if (y>408) {y=408; crash=true;}
            else if (y<0) {y=0; crash=true;}
            else crashbullet();
            if (crash) crashbrick( );
        }
        else
        {
            if (i<6) {crash1=true; crash2=crash3=false;}
            else if (i<12) {crash2=true; crash1=crash3=false;}
            else if (i<18) {crash3=true; crash2=crash1=false;}
            else empty=true;

            i++;
        }


    }

    private void crashbullet(){

        if (up) bullcrash(0,0,5,0);
        else if (down) bullcrash(0,7,5,7);
        else if (left) bullcrash(0,0,0,5);
        else if (right) bullcrash(7,0,7,5);
    }



    public void render (Graphics2D graphics2D){
        if (empty) graphics2D.drawImage(null,x-13,y-12,null);
        else if (crash3) graphics2D.drawImage(CRASH3,x-13,y-12,null);
        else if (crash2) graphics2D.drawImage(CRASH2,x-13,y-12,null);
        else if (crash1) graphics2D.drawImage(CRASH1,x-13,y-12,null);
        else if (up) graphics2D.drawImage(UP,x,y,null);
        else if (down) graphics2D.drawImage(DOWN,x,y,null);
        else if (right) graphics2D.drawImage(RIGHT,x,y,null);
        else if (left) graphics2D.drawImage(LEFT,x,y,null);

    }

    public void bullcrash(int a, int b, int c, int d){
        {
            int newx1 = x+a;
            int newy1 = y+b;
            int newx2 = x + c;
            int newy2 = y+d;
            if (LVLmap16.checkbullet(newx1, newy1)) {
                X1 = newx1 / 16;
                Y1 = newy1 / 16;
                crash = true;
            }
            if (LVLmap16.checkbullet(newx2, newy2)) {
                X2 = newx2 / 16;
                Y2 = newy2 / 16;
                crash = true;
            }
            if (X1 == X2 && Y1 == Y2) {
                X2 = Y2 = -1;
            }
            if (X1 == -1 && Y1 == -1) {
                X1 = X2;
                X2 = -1;
                Y1 = Y2;
                Y2 = -1;
            }
        }
    }

    public void crashbrick(){

        if (X1==-1) return ;
        else if (X2==-1 && (LVLmap16.map16[X1][Y1]==2 || LVLmap16.map16[X1][Y1]==21111)) return;

        boolean check=false;

        if (LVLmap16.map16[X1][Y1]==8  ) {LVLmap16.map16[X1][Y1]=9; check=true; game.over();}
        if (up && !check) {
            if (LVLmap16.map16[X1][Y1]==11111){
                LVLmap16.map16[X1][Y1]=11100;
                check = true;
            }
            else if (LVLmap16.map16[X1][Y1]==11010){
                LVLmap16.map16[X1][Y1]=11000;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==10101){
                LVLmap16.map16[X1][Y1]=10100;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==11100 || LVLmap16.map16[X1][Y1]==10011 || LVLmap16.map16[X1][Y1]==11000 || LVLmap16.map16[X1][Y1]==10100 || LVLmap16.map16[X1][Y1]== 10010 || LVLmap16.map16[X1][Y1]== 10001){
                LVLmap16.map16[X1][Y1]=0;
                check=true;
            }

        }

        else if (down && !check) {
            if (LVLmap16.map16[X1][Y1]==11111){
                LVLmap16.map16[X1][Y1]=10011;
                check = true;
            }
            else if (LVLmap16.map16[X1][Y1]==11010){
                LVLmap16.map16[X1][Y1]=10010;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==10101){
                LVLmap16.map16[X1][Y1]=10001;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==11100 || LVLmap16.map16[X1][Y1]==10011 || LVLmap16.map16[X1][Y1]==11000 || LVLmap16.map16[X1][Y1]==10100 || LVLmap16.map16[X1][Y1]== 10010 || LVLmap16.map16[X1][Y1]== 10001){
                LVLmap16.map16[X1][Y1]=0;
                check=true;
            }

        }

        else if (right && !check) {
            if (LVLmap16.map16[X1][Y1]==11111){
                LVLmap16.map16[X1][Y1]=10101;
                check = true;
            }
            else if (LVLmap16.map16[X1][Y1]==11100){
                LVLmap16.map16[X1][Y1]=10100;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==10011){
                LVLmap16.map16[X1][Y1]=10001;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==10101 || LVLmap16.map16[X1][Y1]==11010 || LVLmap16.map16[X1][Y1]==11000 || LVLmap16.map16[X1][Y1]==10100 || LVLmap16.map16[X1][Y1]== 10010 || LVLmap16.map16[X1][Y1]== 10001){
                LVLmap16.map16[X1][Y1]=0;
                check=true;
            }

        }

        else if (left && !check) {
            if (LVLmap16.map16[X1][Y1]==11111){
                LVLmap16.map16[X1][Y1]=11010;
                check = true;
            }
            else if (LVLmap16.map16[X1][Y1]==11100){
                LVLmap16.map16[X1][Y1]=11000;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==10011){
                LVLmap16.map16[X1][Y1]=10010;
                check=true;
            }
            else if (LVLmap16.map16[X1][Y1]==10101 || LVLmap16.map16[X1][Y1]==11010 || LVLmap16.map16[X1][Y1]==11000 || LVLmap16.map16[X1][Y1]==10100 || LVLmap16.map16[X1][Y1]== 10010 || LVLmap16.map16[X1][Y1]== 10001){
                LVLmap16.map16[X1][Y1]=0;
                check=true;
            }

        }

        if (X2==-1) return;
        if (LVLmap16.map16[X2][Y2]==8  ) {LVLmap16.map16[X2][Y2]=9; check=true; game.over();}

        if (up){
            if (LVLmap16.map16[X2][Y2]==11111){
                LVLmap16.map16[X2][Y2]=11100;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==11010){
                LVLmap16.map16[X2][Y2]=11000;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==10101){
                LVLmap16.map16[X2][Y2]=10100;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==11100 || LVLmap16.map16[X2][Y2]==10011 || LVLmap16.map16[X2][Y2]==11000 || LVLmap16.map16[X2][Y2]==10100 || LVLmap16.map16[X2][Y2]== 10010 || LVLmap16.map16[X2][Y2]== 10001){
                LVLmap16.map16[X2][Y2]=0;
                return;
            }
        }

        else if (down){
            if (LVLmap16.map16[X2][Y2]==11111){
                LVLmap16.map16[X2][Y2]=10011;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==11010){
                LVLmap16.map16[X2][Y2]=10010;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==10101){
                LVLmap16.map16[X2][Y2]=10001;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==11100 || LVLmap16.map16[X2][Y2]==10011 || LVLmap16.map16[X2][Y2]==11000 || LVLmap16.map16[X2][Y2]==10100 || LVLmap16.map16[X2][Y2]== 10010 || LVLmap16.map16[X2][Y2]== 10001){
                LVLmap16.map16[X2][Y2]=0;
                return;
            }
        }

        else  if (right){
            if (LVLmap16.map16[X2][Y2]==11111){
                LVLmap16.map16[X2][Y2]=10101;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==11100){
                LVLmap16.map16[X2][Y2]=10100;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==10011){
                LVLmap16.map16[X2][Y2]=10001;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==10101 || LVLmap16.map16[X2][Y2]==11010 || LVLmap16.map16[X2][Y2]==11000 || LVLmap16.map16[X2][Y2]==10100 || LVLmap16.map16[X2][Y2]== 10010 || LVLmap16.map16[X2][Y2]== 10001){
                LVLmap16.map16[X2][Y2]=0;
                return;
            }
        }

        else if (left){
            if (LVLmap16.map16[X2][Y2]==11111){
                LVLmap16.map16[X2][Y2]=11010;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==11100){
                LVLmap16.map16[X2][Y2]=11000;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==10011){
                LVLmap16.map16[X2][Y2]=10010;
                return;
            }
            else if (LVLmap16.map16[X2][Y2]==10101 || LVLmap16.map16[X2][Y2]==11010 || LVLmap16.map16[X2][Y2]==11000 || LVLmap16.map16[X2][Y2]==10100 || LVLmap16.map16[X2][Y2]== 10010 || LVLmap16.map16[X2][Y2]== 10001){
                LVLmap16.map16[X2][Y2]=0;
                return;
            }
        }

    }

}
