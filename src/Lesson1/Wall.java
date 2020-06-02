package Lesson1;

public class Wall extends Obstacle{
    private int height;
    private String name;
    private int id;
    private static int count;
    private static final int rangeJump = 10; //Все cntys +- 10 метров

    public Wall() {
        this.name = "Стена №" + id;
        this.height = (int) (Math.random() * (rangeJump+1));
    }

    public void take(RunAndJump Jumpable) {
        Jumpable.jumpAction(this.height);
    }
}
