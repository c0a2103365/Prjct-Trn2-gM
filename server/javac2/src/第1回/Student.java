package 第1回;

public class Student extends Person {
	
    /**
     * 主専攻
     */
    protected String major;

    /**
     * コンストラクタ
     */
    public Student(String name, int grade, String address) {
        super(name, grade, address);
    }

    /**
     * コンストラクタ
     * @param m
     */
    public Student(String m){
    	//Person(name, grade, address)を呼び出す．
        super(null, 0, null);
        this.major =  m;

    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * オーバーライドメソッド
     * @param g
     */
    public void setGrade(int g) {
    	//4年生を超える場合の出力設定
        if(g > 4){
            System.out.println("過年度の学年です");
        }
        this.grade = g;

    }

    /**
     * オーバーライドメソッド
     * @return
     */
    public String getName(){
        System.out.println("学生のメソッドです");
        return this.name;
    }

}
