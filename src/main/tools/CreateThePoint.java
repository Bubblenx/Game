package main.tools;

import main.model.Player;
import main.model.ThePoint;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 制作节点的工具，将节点静态化，存入硬盘（持久化）
 * 为什么不使用数据库？
 * --数据库需要配置表信息及结构（懒）
 *
 * @author YMS
 * @date 2019/11/9
 */
public class CreateThePoint {
    public static void main(String[] args) {
        read();
    }


    /**
     * 创建一个新的本地ThePoint文件
     */
    public static void write() {

        ThePoint one = new ThePoint();
        String filename = "10";
        File file = new File("E:\\IdeaPro\\softwareWork\\src\\main\\resource/" + filename);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(one);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取所有本地ThePoint文件
     */
    public static void read() {
        try {
            int filename = 1;
            File file = new File("E:\\IdeaPro\\softwareWork\\src\\main\\resource/" + filename);
            while (file.exists()) {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
                ThePoint o = (ThePoint) is.readObject();
                System.out.println(new String(o.toString().getBytes(), StandardCharsets.UTF_8));
                filename++;
                file = new File("E:\\IdeaPro\\softwareWork\\src\\main\\resource/" + filename);
                ThePoint thePoint = new ThePoint();
                thePoint.op(new Player());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
