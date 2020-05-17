public class Cat implements RunAndJump{

    private String name;
    private int run;
    private double jump;
    private static final int rangeRun = 400; //Все кошки могут пробежать +- 200 метров (800-1200 метров)
    private static final int rangeJump = 4;  //Все кошки могут прагнуть +- 1 метр (20 - 24 метров)


    public Cat(String name) {
        this.name = name;
        this.run = 800 +  (int) (Math.random() * (rangeRun+1));
        this.jump = 20 + (Math.random()* (rangeJump));
    }


    @Override
    public void jumpAction(double height) {

    }

    @Override
    public void runAction(int length) {

    }
}
