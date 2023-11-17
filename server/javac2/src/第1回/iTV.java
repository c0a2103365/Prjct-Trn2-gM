package 第1回;

public interface iTV {
    /**
     * 電源ON
     * @return ｓ
     */
    public boolean powerON();

    /**
     * 電源OFF
     * @return
     */
    public boolean powerOFF();

    /**
     * 音量上げる
     * @param size
     * @return
     */
    public boolean volumeUP(int size);

    /**
     * 音量下げる
     * @param size
     * @return
     */
    public boolean volumeDown(int size);


}
