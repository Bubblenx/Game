package main.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * 世界地图
 *
 * @author YMS
 * @date 2019/11/9
 */
public class Map {
    /**
     * 当前节点
     */
    private Integer size;
    /**
     * 节点
     */
    private static ArrayList<ThePoint> points = new ArrayList<>();

    /**
     * 默认构造
     */
    public Map() {
        readAll();
        size = points.size();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ArrayList<ThePoint> getPoints() {
        return points;
    }

    /**
     * 随机传一个ThePoint
     */
    public ThePoint getPoint(){
        int index = (int) Math.floor(Math.random() * size);
        return points.get(index);
    }

    public static void readAll() {
        try {
            int filename = 1;
            File file = new File("E:\\IdeaPro\\softwareWork\\src\\main\\resource/" + filename);
            while (file.exists()) {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
                ThePoint o = (ThePoint) is.readObject();
                points.add(o);
                filename++;
                file = new File("E:\\IdeaPro\\softwareWork\\src\\main\\resource/" + filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
