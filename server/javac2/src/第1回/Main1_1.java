package 第1回;

public class Main1_1 {
    public static void main(String[] args) {
        Car car=new Car("金光駿弥","普通自動車");

        car.setDriverName("Kanemitu Shunya");
        car.setCarType("軽自動車");

        System.out.println(car.getDriverName());
        System.out.println(car.getCarType());
    }
}
