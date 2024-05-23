import javax.swing.*;
import java.awt.*;

public class Mpanel extends JPanel {
    public int[][] Q;
    public int x0=50,y0=50,size=50,line=19,chesssize=50;
    //重绘功能？
    public void paint(Graphics g){
        super.paint(g);
        for(int i=0;i<line;i++){
            g.setColor(Color.black);
            g.drawLine(x0,size*i+y0,(line-1)*size+x0,i*size+y0);//划横线
            g.drawLine(size*i+x0,y0,size*i+x0,(line-1)*size+y0);
        }
        //遍历绘制棋子
        for (int i=0;i<line;i++){
            for(int j=0;j<line;j++){
                if(Q[i][j]==1){
                    g.setColor(Color.black);
                    g.fillOval(i * size + x0 - chesssize / 2, j* size + y0 - chesssize / 2, chesssize, chesssize);
                }
                else if(Q[i][j]==2){
                    g.setColor(Color.white);
                    g.fillOval(i * size + x0 - chesssize / 2, j* size + y0 - chesssize / 2, chesssize, chesssize);
                }
            }

        }
    }
}
