//必須
package javab.課題解答.課題1;


public class Car {
	 /**
     * 運転手の名前
     */
    private String driverName;

    /**
     * 車種
     */
    private String carType;


    /**
     * コンストラクタ
     * @param driverName
     * @param carType
     */
    public Car(String driverName, String carType) {
        this.driverName = driverName;
        this.carType = carType;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
