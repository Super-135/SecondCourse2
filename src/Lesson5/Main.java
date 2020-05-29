package Lesson5;

public class Main {

    static final int size = 10000000;
    static final int h = size/2;

    static public void arrNew1(float[] arr, int size){
        long b = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis()-b);
    }

    static public void arrNew2(float[] arr1, int size){
        float[] arr11 = new float[h];
        float[] arr12 = new float[h];

        long b = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr11, 0, h);
        System.arraycopy(arr1, h, arr12, 0, h);

        CustomTreads runUnit1 = new CustomTreads(arr11,0);
        runUnit1.start();
        CustomTreads runUnit2 = new CustomTreads(arr12,h);
        runUnit2.start();

        while (true)
            if (runUnit1.isRunning() && runUnit2.isRunning()){
                System.arraycopy(arr11, 0, arr1, 0, h);
                System.arraycopy(arr12, 0, arr1, h, h);
                System.out.println(System.currentTimeMillis()-b);
                break;
            }
    }

    public static void main(String[] args) {
        float[] arr = new float[size];
        float[] arr1 = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
            arr1[i] = 1;
        }
        System.out.println("В одном потоке");
        arrNew1(arr,size);
        System.out.println("Последний элемент массива = " + arr[size-1]);
        System.out.println("В двух потоках");
        arrNew2(arr1,size);
        System.out.println("Последний элемент массива = " + arr1[size-1]);
    }

}