import java.awt.*;

public class LVLmap16 {
    public static int [][] map16=new int [26][26];
    private static LVLPicture picture=new LVLPicture();
    public static void LVLmapcreated(){
        mapLVL1.mapLVL();
    }

    public static void renderall(Graphics2D graphics2D){
        if (game.gameover) graphics2D.drawImage(picture.getPicture(picture.getString(9)),12*16,24*16,null);
        else graphics2D.drawImage(picture.getPicture(picture.getString(8)),12*16,24*16,null);
        for (int i=0;i<map16.length;i++)
            for (int j=0; j<map16[i].length; j++){
                if (map16[i][j]==8 ||map16[i][j]==9 ) continue;
                if (map16[i][j]!=3 && map16[i][j]!=31111) graphics2D.drawImage(picture.getPicture(picture.getString(map16[i][j])),i*16,j*16,null);
            }
    }

    public static void renderforest(Graphics2D graphics2D){
        for (int i=0;i<map16.length;i++)
            for (int j=0; j<map16[i].length; j++){
                if (map16[i][j]==3 || map16[i][j]==31111) graphics2D.drawImage(picture.getPicture(picture.getString(map16[i][j])),i*16,j*16,null);
            }
    }

    public static boolean checkgo(int x,int y){
        x=x/16;
        y=y/16;

        if (map16[x][y]==0 || map16[x][y]==3 || map16[x][y]==4 || map16[x][y]==41111 || map16[x][y]==31111) return true;
        return false;
    }

    public static boolean checkbullet(int x,int y){
        x=x/16;
        y=y/16;
        if (map16[x][y]==1 || map16[x][y]==2 || map16[x][y]==21111 || map16[x][y]==8 || map16[x][y]==11111 || map16[x][y]==11100 || map16[x][y]==10011 || map16[x][y]==11010 || map16[x][y]==10101 || map16[x][y]==10001 || map16[x][y]==10010 || map16[x][y]==10100 || map16[x][y]==11000) return true;
        return false;
    }


}
