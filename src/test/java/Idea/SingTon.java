package Idea;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/6/23
 */
public class SingTon {

    public static int count1;
    public static int count2 = 1;

    private SingTon() {
        count1++;
        count2++;
    }

    public static void main(String[] args) {
        SingTon singTon = new SingTon();
        System.out.println("count1 " + SingTon.count1);
        System.out.println("count2 " + SingTon.count2);
    }

}
