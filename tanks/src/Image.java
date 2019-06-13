import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Image {

    BufferedImage image;

    public Image(String path){
        image=loadImage.loadIMAGE(path);
    }

    public BufferedImage cut (int x, int y, int width, int height){
        return image.getSubimage(x,y,width,height);
    }

    public static boolean intersects(int A1y, int A2y, int A1x, int A2x, int B1y,  int B2y, int B1x,  int B2x) {
        return ( A1y < B2y && A2y > B1y && A2x > B1x && A1x < B2x );
    }

    public static BufferedImage deleteblack (BufferedImage im){
        BufferedImage buffer;
        int [] bufferarr;
        Graphics2D buffergraphics;
        buffer=new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
        bufferarr=((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
        buffergraphics=(Graphics2D)buffer.getGraphics();
        buffergraphics.drawImage(im,0,0,null);
        for (int i=0;i<(bufferarr).length;i++){
            if (bufferarr[i]==0xff000001 || bufferarr[i]==0xff000000) bufferarr[i]=0x00ffffff;
        }
        return buffer;
    }

}
