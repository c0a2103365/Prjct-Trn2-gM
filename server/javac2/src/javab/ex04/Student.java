package javab.ex04;

public class Student {
	/**
	 * ID
	 */
	private int id;
	/**
	 * 名前
	 */
	private String name;	
	/**
	 * 得点
	 */
	private int score;
	public Student(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
