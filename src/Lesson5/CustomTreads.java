package Lesson5;

public class CustomTreads extends Thread{
    private volatile boolean running;
    private float[] arr1;

    // При тестировании заметил что результаты массивов не равны.
    // Не равны они начиная со второй половины массива.
    // Посмотрел и понял что требуется добавить в формулу дельту для увеличения i так как раздельные массивы
    // Первый массив считается правильно с нуля до size/2
    // а вот второй в переменную i тоже подставляется 0 до size/2? а должно с size/2 до size.
    // Вот для этого и ввел дельту.
    private int delta;

    public CustomTreads(float[] arr, int delta) {
        running = false;
        this.arr1 = arr;
        this.delta = delta;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + (i+delta) / 5) * Math.cos(0.2f + (i+delta) / 5) * Math.cos(0.4f + (i+delta) / 2));
        }
        running = true;
    }
}