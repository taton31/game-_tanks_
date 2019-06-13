import java.awt.*;

public class LVLmap {
public static int [][] map32_32=new int [13][13];
private static LVLPicture picture=new LVLPicture();
    public static void LVLmapcreated(){
        mapLVL1.mapLVL();
    }

    public static void renderall(Graphics2D graphics2D){
        for (int i=0;i<map32_32.length;i++)
            for (int j=0; j<map32_32[i].length; j++){
            if (map32_32[i][j]!=3) graphics2D.drawImage(picture.getPicture(picture.getString(map32_32[i][j])),i*32,j*32,null);
            }
    }

    public static void renderforest(Graphics2D graphics2D){
        for (int i=0;i<map32_32.length;i++)
            for (int j=0; j<map32_32[i].length; j++){
                if (map32_32[i][j]==3) graphics2D.drawImage(picture.getPicture(picture.getString(map32_32[i][j])),i*32,j*32,null);
            }
    }

    public static boolean checkgo(int x,int y){
        x=x/32;
        y=y/32;
        if (map32_32[x][y]==0 || map32_32[x][y]==3 || map32_32[x][y]==4) return true;
        return false;
    }

    public static boolean checkbullet(int x,int y){
        x=x/32;
        y=y/32;
        if (map32_32[x][y]==1 || map32_32[x][y]==2 || map32_32[x][y]==8) return true;
        return false;
    }
}
