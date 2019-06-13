import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class SCORE {
    public static final int Window_Width=60;
    public static final int Window_Height=416;
    public static BufferedImage bufferedImage;
    public static int[] bufferArr;
    public static Graphics bufferGraphics;
    public static Canvas score=new Canvas();
    private static final int clearColor=0xff303030;
    public static BufferedImage lifeimage=RESIZE.resize((loadImage.loadIMAGE("life.jpg")),16,16);
    public static int LIFE=20;
    public static int result =0;




    public static void SCOREcreated(){
        score.setSize(new Dimension(Window_Width,Window_Height));
        score.setPreferredSize(new Dimension(Window_Width,Window_Height));
        bufferedImage=new BufferedImage(Window_Width,Window_Height,BufferedImage.TYPE_INT_ARGB);
        bufferGraphics=bufferedImage.getGraphics();
        bufferArr=((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();
        ((Graphics2D)bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        ( bufferGraphics).setFont(new Font("TimesRoman", 1, 16));
        clear();
    }

    public static void swapBuffers (){
        clear();
        LIFE();
        setresult(((Graphics2D) bufferGraphics));
        score.getGraphics().drawImage(bufferedImage,0,0,null);
    }

    public static void clear(){
        Arrays.fill(bufferArr,clearColor);
    }

    public static void LIFE(){
        for (int i=0; i<LIFE; i++)
        (bufferGraphics).drawImage(lifeimage,20*(i%2)+12,15+20*(i/2),null);
    }

    public static void setresult(Graphics2D gg){
        gg.drawString(""+result,10,400);
    }
}
