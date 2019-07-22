package enumerate;

/**
 * \* Author: 姬雨航
 * \* Date: 2019/7/19 14:00
 * \* Description：枚举类
 * \
 */

public enum CustomEnum {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    private CustomEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static void main(String[] args) {

        System.out.println(CustomEnum.RED.name);

    }

}
