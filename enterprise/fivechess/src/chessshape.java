import java.util.HashMap;

public class chessshape {
    private HashMap<String,int[]>qixing=new HashMap<>();
    private HashMap<String,Integer>weights=new HashMap<>();
    public chessshape(){//用构造器构建的，也可以用初始代码块构建
    qixing.put("白色五连",new int[]{2,2,2,2,2});//200000
    weights.put("白色五连",1000000);
    qixing.put("白色活四",new int[]{0,2,2,2,2,0});
    weights.put("白色活四",200000);
    qixing.put("白色冲四",new int[]{1,2,2,2,2,0});//122220 022221 对称问题？
    weights.put("白色冲四",10000);
    qixing.put("白色活三",new int[]{0,2,2,2,0,0});//022200 002220 对称用方向解决
    weights.put("白色活三",10000);
    qixing.put("白色眠三",new int[]{1,2,2,2,0,0});
    weights.put("白色眠三",5000);
    qixing.put("白色活二",new int[]{0,2,2,0,0,0});
    weights.put("白色活二",5000);
    qixing.put("白色活二2",new int[]{0,0,2,2,0,0});
    weights.put("白色活二2",5000);

   //防守这个做的很垃圾
    qixing.put("黑色冲四", new int[]{2, 1, 1, 1, 1, 2});//100000
    weights.put("黑色冲四",500000);
    qixing.put("黑色眠三1", new int[]{2, 1, 1, 1, 0, 0});//必下9000
    weights.put("黑色眠三1",80000);
    qixing.put("黑色眠三2", new int[]{0, 2, 1, 1, 1, 0});//9000
    weights.put("黑色眠三2",80000);
    qixing.put("黑色活二1", new int[]{2, 1, 1, 0, 0, 0});
    weights.put("黑色活二1",3000);
    qixing.put("黑色活二2", new int[]{0, 2, 1, 1, 0, 0});
    weights.put("黑色活二2",3000);
    qixing.put("黑色活二3", new int[]{0, 0, 2, 1, 1, 0});
    weights.put("黑色活二3",3000);
    qixing.put("开始",new int[]{2,1,0,0,0,0});
    weights.put("开始",50);

        }

    public HashMap<String, int[]> getQixing() {
        return qixing;
    }

    public HashMap<String, Integer> getWeights() {
        return weights;
    }
}

