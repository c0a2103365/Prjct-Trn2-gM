package 第1回;

public class Main1_2 {
    public static void main(String[] args) {
        Car[] cars = new Car[2];

        Car newCar=new Car("織田信長","4WD");
        FireEngine fireCar=new FireEngine("徳川家康","ポンプ車");

        cars[0]=newCar;
        cars[1] = fireCar;

        for(int i=0;i<cars.length;i++){
            System.out.println(i+"番目:"+cars[i].getCarType());
        }
    }
}
