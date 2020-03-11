package jdk8.优雅的关闭资源;

public class AutoCloseTest {

    public static void main(String[] args) {
        try(Path path = new Path()) {
            path.print();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("资源已经释放了");

    }

}
