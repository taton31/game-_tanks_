import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Input extends JComponent {
    private boolean[] map;
    private boolean check=true;

    public Input(){
        map=new boolean[256];

        for (int i=0; i<map.length;i++){
            final int Key=i;
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i,0,false),2*i);
            getActionMap().put(2 * i, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    map[Key]=true;
                }
            });

            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i,0,true),2*i+1);
            getActionMap().put(2 * i+1, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    map[Key]=false;
                }
            });
        }
    }

    public boolean[] getMap(){
        return Arrays.copyOf(map,map.length);
    }

    public boolean getkey(int key){
        return map[key];
    }

    public boolean GamePause(boolean per) {

        if (check && map[27]) {
            check = false;
            per = !per;
            return per;
        }
        if (!map[27]) {
            check = true;
        }
        return per;
    }
}
