package main.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 节点
 *
 * @author YMS
 * @date 2019/11/9
 */
public class ThePoint implements Serializable {

    /**
     * 人物
     */
    private String man;
    /**
     * 对话
     */
    private String[] desc = new String[2];
    /**
     * 触发事件,结构：
     * 属性 + 操作 + 操作值
     * 如：power + 9
     * speed * 2
     * 注：操作符支持 +、-、*、/
     * 有多种操作用 "," 隔开
     */
    private String op;

    /**
     * 默认构造
     */
    public ThePoint() {
        man = "袁隆平";
        desc[0] = "又完成了一个课题！";
        desc[1] = "水稻产量翻倍了！";
        op = "life + 100, wisdom + 20, power + 20, speed + 20";
    }

    public String getOp() {
        return op;
    }

    /**
     * 对事件进行对应的解析操作
     */
    public void op(Player player) {
        String[] split1 = op.trim().split(",");
        for (String s : split1) {
            String[] split2 = s.trim().split(" ");
            if (split2.length == 3) {
                switch (split2[1]) {
                    case "+":
                        if ("power".equals(split2[0])) {
                            player.setPower(player.getPower() + Integer.valueOf(split2[2]));
                        }
                        if ("speed".equals(split2[0])) {
                            player.setSpeed(player.getSpeed() + Integer.valueOf(split2[2]));
                        }
                        if ("wisdom".equals(split2[0])) {
                            player.setWisdom(player.getWisdom() + Integer.valueOf(split2[2]));
                        }
                        if ("life".equals(split2[0])) {
                            player.setLife(player.getLife() + Integer.valueOf(split2[2]) * 2);
                        }
                        break;
                    case "-":
                        if ("power".equals(split2[0])) {
                            player.setPower(player.getPower() - Integer.valueOf(split2[2]));
                        }
                        if ("speed".equals(split2[0])) {
                            player.setSpeed(player.getSpeed() - Integer.valueOf(split2[2]));
                        }
                        if ("wisdom".equals(split2[0])) {
                            player.setWisdom(player.getWisdom() - Integer.valueOf(split2[2]));
                        }
                        if ("life".equals(split2[0])) {
                            player.setLife(player.getLife() - Integer.valueOf(split2[2]) * 2);
                        }
                        break;
                    case "*":
                        if ("power".equals(split2[0])) {
                            player.setPower(player.getPower() * Integer.valueOf(split2[2]));
                        }
                        if ("speed".equals(split2[0])) {
                            player.setSpeed(player.getSpeed() * Integer.valueOf(split2[2]));
                        }
                        if ("wisdom".equals(split2[0])) {
                            player.setWisdom(player.getWisdom() * Integer.valueOf(split2[2]));
                        }
                        if ("life".equals(split2[0])) {
                            player.setLife(player.getLife() * Integer.valueOf(split2[2]));
                        }
                        break;
                    case "/":
                        if ("power".equals(split2[0])) {
                            player.setPower(player.getPower() / Integer.valueOf(split2[2]));
                        }
                        if ("speed".equals(split2[0])) {
                            player.setSpeed(player.getSpeed() / Integer.valueOf(split2[2]));
                        }
                        if ("wisdom".equals(split2[0])) {
                            player.setWisdom(player.getWisdom() / Integer.valueOf(split2[2]));
                        }
                        if ("life".equals(split2[0])) {
                            player.setLife(player.getLife() / Integer.valueOf(split2[2]));
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public String getMan() {
        return man;
    }

    public String[] getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ThePoint{" +
                "man='" + man + '\'' +
                ", desc=" + Arrays.toString(desc) +
                ", op='" + op + '\'' +
                '}';
    }
}
