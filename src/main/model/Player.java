package main.model;

import javafx.beans.property.*;

/**
 * 玩家
 *
 * @author YMS
 * @date 2019/11/9
 */
public class Player {

    /**
     * 姓名
     */
    private StringProperty name;
    /**
     * 性别
     */
    private StringProperty sex;

    /**
     * 职业
     */
    private StringProperty work;
    /**
     * 三围属性
     */
    private IntegerProperty power;
    private IntegerProperty speed;
    private IntegerProperty wisdom;

    /**
     * 生命
     */
    private IntegerProperty life;

    /**
     * 默认构造
     */
    public Player() {
        name = new SimpleStringProperty("咸鱼");
        sex = new SimpleStringProperty();
        work = new SimpleStringProperty();
        power = new SimpleIntegerProperty();
        speed = new SimpleIntegerProperty();
        wisdom = new SimpleIntegerProperty();
        life = new SimpleIntegerProperty(200);
    }

    public Player(String name) {
        this();
        setName(name);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSex() {
        return sex.get();
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getWork() {
        return work.get();
    }

    public StringProperty workProperty() {
        return work;
    }

    public int getPower() {
        return power.get();
    }

    public IntegerProperty powerProperty() {
        return power;
    }

    public void setPower(int power) {
        this.power.set(power);
    }

    public int getSpeed() {
        return speed.get();
    }

    public IntegerProperty speedProperty() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed.set(speed);
    }

    public int getWisdom() {
        return wisdom.get();
    }

    public IntegerProperty wisdomProperty() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom.set(wisdom);
    }

    public void setWork(String work) {
        this.work.set(work);

        /**
         * 更新三围属性
         */
        if ("法师".equals(work)) {
            wisdom.setValue(15);
            power.setValue(10);
            speed.setValue(10);
        } else if ("战士".equals(work)) {
            wisdom.setValue(10);
            power.setValue(15);
            speed.setValue(10);
        } else if ("刺客".equals(work)) {
            wisdom.setValue(10);
            power.setValue(10);
            speed.setValue(15);
        }
    }

    public int getLife() {
        return life.get();
    }

    public IntegerProperty lifeProperty() {
        return life;
    }

    public void setLife(int life) {
        this.life.set(life);
    }
}
