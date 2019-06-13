import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class   Picture  {
    private Image atlas=new Image("texture_atlas.png");
    private Map pict=new HashMap<String,BufferedImage>();
    public Picture(int UPx1, int UPy1,int DOWNx1, int DOWNy1,int RIGHTx1, int RIGHTy1 , int LEFTx1, int LEFTy1,int UPx2, int UPy2,int DOWNx2, int DOWNy2,int RIGHTx2, int RIGHTy2 , int LEFTx2, int LEFTy2, int sizeInAtlas, int neeedSize){
        pict.put("UP1",Image.deleteblack(RESIZE.resize(atlas.cut(UPx1, UPy1, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("DOWN1",Image.deleteblack(RESIZE.resize(atlas.cut(DOWNx1, DOWNy1, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("RIGHT1",Image.deleteblack(RESIZE.resize(atlas.cut(RIGHTx1, RIGHTy1, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("LEFT1",Image.deleteblack(RESIZE.resize(atlas.cut(LEFTx1, LEFTy1, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("UP2",Image.deleteblack(RESIZE.resize(atlas.cut(UPx2, UPy2, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("DOWN2",Image.deleteblack(RESIZE.resize(atlas.cut(DOWNx2, DOWNy2, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("RIGHT2",Image.deleteblack(RESIZE.resize(atlas.cut(RIGHTx2, RIGHTy2, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("LEFT2",Image.deleteblack(RESIZE.resize(atlas.cut(LEFTx2, LEFTy2, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
    }

    public BufferedImage getPicture (String string){
        return (BufferedImage) pict.get(string);
    }

}
