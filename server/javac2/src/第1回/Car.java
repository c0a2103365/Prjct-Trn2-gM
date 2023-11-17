package 第1回;

public class Car {
    private String driverName;
    protected String carType;

    public Car(String driverName, String carType) {
        this.driverName = driverName;
        this.carType = carType;
    }

    public void setDriverName(String driverName){
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setCarType(String carType){
        this.carType = carType;
    }

    public String getCarType() {
        return this.carType;
    }
}
