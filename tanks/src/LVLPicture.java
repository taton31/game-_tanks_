import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class   LVLPicture  {
    private final int brickX=256;
    private final int brickY=0;
    private final int steelX=256;
    private final int steelY=16;
    private final int forestX=272;
    private final int forestY=32;
    private final int iceX=288;
    private final int iceY=32;
    private final int waterX1=256;
    private final int waterY1=32;
    private final int waterX2=256;
    private final int waterY2=48;
    private final int waterX3=272;
    private final int waterY3=48;
    private final int eagleX1=304;
    private final int eagleY1=32;
    private final int eagleX2=320;
    private final int eagleY2=32;
    private final int sizeInAtlas=16;
    private final int neeedSize=32;

    private Image atlas=new Image("texture_atlas.png");
    private Map pict=new HashMap<String,BufferedImage>();
    public LVLPicture(){
        pict.put("brick",RESIZE.resize(atlas.cut(brickX, brickY, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("brick1111",RESIZE.resize(atlas.cut(256, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick0011",RESIZE.resize(atlas.cut(272, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick0101",RESIZE.resize(atlas.cut(264, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick1100",RESIZE.resize(atlas.cut(288, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick1010",RESIZE.resize(atlas.cut(280, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick0001",RESIZE.resize(atlas.cut(304, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick0010",RESIZE.resize(atlas.cut(320, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick0100",RESIZE.resize(atlas.cut(296, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("brick1000",RESIZE.resize(atlas.cut(312, 64, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("steel",RESIZE.resize(atlas.cut(steelX, steelY, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("steel1111",RESIZE.resize(atlas.cut(256, 72, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("forest",Image.deleteblack(RESIZE.resize(atlas.cut(forestX, forestY, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize)));
        pict.put("forest1111",Image.deleteblack(RESIZE.resize(atlas.cut(264, 72, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2)));
        pict.put("ice",RESIZE.resize(atlas.cut(iceX, iceY, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("ice1111",RESIZE.resize(atlas.cut(272, 72, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("water1",RESIZE.resize(atlas.cut(waterX1, waterY1, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("water11111",RESIZE.resize(atlas.cut(256, 80, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("water2",RESIZE.resize(atlas.cut(waterX2, waterY2, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("water21111",RESIZE.resize(atlas.cut(264, 80, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("water3",RESIZE.resize(atlas.cut(waterX3, waterY3, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("water31111",RESIZE.resize(atlas.cut(272, 80, sizeInAtlas/2, sizeInAtlas/2),neeedSize/2,neeedSize/2));
        pict.put("eagle1",RESIZE.resize(atlas.cut(eagleX1, eagleY1, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("eagle2",RESIZE.resize(atlas.cut(eagleX2, eagleY2, sizeInAtlas, sizeInAtlas),neeedSize,neeedSize));
        pict.put("empty",null);
    }

    public BufferedImage getPicture (String string){
        return (BufferedImage) pict.get(string);
    }

    public String getString(int number){
        if (number==0) return "empty";
        else if (number==1) return "brick";
        else if (number==11111) return "brick1111";
        else if (number==11100) return "brick1100";
        else if (number==10011) return "brick0011";
        else if (number==11010) return "brick1010";
        else if (number==10101) return "brick0101";
        else if (number==10001) return "brick0001";
        else if (number==10010) return "brick0010";
        else if (number==10100) return "brick0100";
        else if (number==11000) return "brick1000";
        else if (number==2) return "steel";
        else if (number==21111) return "steel1111";
        else if (number==3) return "forest";
        else if (number==31111) return "forest1111";
        else if (number==4) return "ice";
        else if (number==41111) return "ice1111";
        else if (number==5) return "water1";
        else if (number==51111) return "water11111";
        else if (number==6) return "water2";
        else if (number==61111) return "water21111";
        else if (number==7) return "water3";
        else if (number==71111) return "water31111";
        else if (number==8) return "eagle1";
        else if (number==9) return "eagle2";
        return "";
    }

    public int getString(String name){
        if (name== "empty") return 0;
        else if (name=="brick") return 1;
        else if (name=="steel") return 2;
        else if (name=="forest") return 3;
        else if (name=="ice") return 4;
        else if (name=="water1") return 5;
        else if (name=="water2") return 6;
        else if (name == "water3") return 7;
        else if (name == "eagle1") return 8;
        else if (name == "eagle2") return 9;
        return 0;
    }

}
