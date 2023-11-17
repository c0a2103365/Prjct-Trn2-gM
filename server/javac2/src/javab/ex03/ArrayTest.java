package javab.ex03;

public class ArrayTest {

    public static void main(String[] args){
        int[] array_a = {1, 2, 3};
        System.out.println("0番目は"+ array_a[0]);

        /**ダメな例．容量を超えて値を入れることはできない．**/
       // array_a[3] = 5;
       // System.out.println(array_a[3]);

        /**良い例．既存の位置に値を上書きはできる**/
        array_a[1] = 10;
        System.out.println(array_a[1]);

        int[] array_b = new int[10];
        array_b[0] = 100;
        System.out.println(array_b[0]);
        //では，array_b[1]の値は？
        //newをすると，初期値0が入っている．
        System.out.println(array_b[1]);

        //char型も同様の宣言でOK
        char[] array_c = {'a', 'い', 'z'};
        System.out.println(array_c[1]);

        char[] array_d = new char[10];
        System.out.println(array_d[0]);
    }

}
