import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class frame extends JFrame {
    public static final String Name_Game="Танчики";
    public static final int Window_Width=476;
    public static final int Window_Height=416;
    private static final int clearColor=0xff000000;


    public static JFrame window;
    public static Canvas canvas;
    public static BufferedImage bufferedImage;
    public static int[] bufferArr;
    public static Graphics bufferGraphics;

    static void created(){
        window=new JFrame(Name_Game);
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(Window_Width,Window_Height));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.getContentPane().add(SCORE.score);
        SCORE.score.setLocation(416,0);
        window.getContentPane().add(canvas);
        window.setSize(new Dimension(482,445));
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        bufferedImage=new BufferedImage(Window_Width-60,Window_Height,BufferedImage.TYPE_INT_ARGB);
        bufferGraphics=bufferedImage.getGraphics();
        bufferArr=((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();
        ((Graphics2D)bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static void clear(){
        Arrays.fill(bufferArr,clearColor);
    }

    public static void swapBuffers (){
        canvas.getGraphics().drawImage(bufferedImage,0,0,null);
        SCORE.swapBuffers();
    }

    public static Graphics2D getGraphics2D(){
        return (Graphics2D) bufferGraphics;
    }

}