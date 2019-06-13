import java.awt.image.BufferedImage;

public class RESIZE {
    public static BufferedImage resize (BufferedImage image, int newWidth, int newHeight){
        BufferedImage im=new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_ARGB);
        im.getGraphics().drawImage(image,0,0,newWidth,newHeight,null);
        return im;
    }
}
