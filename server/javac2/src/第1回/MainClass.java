package 第1回;

/**
 * 
 * @author kanemih
 *
 */
public class MainClass {

    public static void main(String[] args) {

        // 1人目のPersonオブジェクトを生成
        Person p1 = new Person("田中", 2, "東京");
        // 2人目のPersonオブジェクトを生成
        Person p2 = new Person("佐藤", 3, "北海道");

        System.out.println("1人目の名前:" + p1.getName() + "/学年:" + p1.getGrade() + "/出身地: " + p1.getAddress());
        System.out.println("2人目の名前は" + p2.getName() + "/学年:" + p2.getGrade() + "/出身地:" + p2.getAddress());

    }
}