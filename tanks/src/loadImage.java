import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class loadImage {

    private static final String path= "art/" ;


    public static BufferedImage loadIMAGE (String path2){
        BufferedImage image=null;
        try{
            image= ImageIO.read(new File(path+path2));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

}
