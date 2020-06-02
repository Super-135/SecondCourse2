package Lesson1;

public class Treadmill extends Obstacle{

    private int length;
    private String name;
    private int id;
    private static int count;
    private static final int rangeRun = 100; //Все беговые дорожки +- 100 метров (100-300 метров)

    public Treadmill() {
        this.name = "Бегов.Дорожка №" + id;
        this.length = (int) (Math.random() * (rangeRun+1));
    }

    public void take(RunAndJump runnable) {
        runnable.runAction(this.length);
    }
}
