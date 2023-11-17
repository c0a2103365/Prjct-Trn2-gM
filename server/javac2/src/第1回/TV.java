package 第1回;

public class TV implements iTV {
	
	/**
	 * 音量ボリューム
	 */
	private int volume;
	
	/**
	 * 電源ONなのかどうか
	 */
	private boolean isPowerON;
	
	/**
	 * コンストラクタ
	 * @param v
	 * @param power
	 */
	public TV(int v, boolean power) {
		this.volume = v;
		this.isPowerON = power;
	}

	@Override
	public boolean powerON() {
		System.out.println("PowerON@TV");
		return true;
	}

	@Override
	public boolean powerOFF() {
		System.out.println("PowerOFF@TV");
		return true;
	}

	@Override
	public boolean volumeUP(int size) {
		this.volume += size;
		return true;
	}

	@Override
	public boolean volumeDown(int size) {
		this.volume -= size;
		return true;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isPowerON() {
		return isPowerON;
	}

	public void setPowerON(boolean isPowerON) {
		this.isPowerON = isPowerON;
	}
	
	

}
