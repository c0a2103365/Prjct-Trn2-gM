package 第1回;


/**
 * Personクラス
 * @author kanemih
 *
 */
public class Person {


    /**
     * 人物名
     */
    protected String name;

    /**
     * 学年
     */
    protected int grade;

    /**
     * 住所
     */
    protected String address;

    public Person(String name, int grade, String address) {
        this.name = name;
        this.grade = grade;
        this.address = address;
    }

    public Person(){
        this.name = null;
        this.grade = 0;
        this.address = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
