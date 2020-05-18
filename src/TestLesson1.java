import java.util.ArrayList;
import java.util.List;

public class TestLesson1 {


    public static void main(String[] args) {

        // Это команда 1- Кот, 2- Человек, 3 робот
        RunAndJump team[] = {
                new Human("Илья"),
                new Cat("Васька"),
                new Robot("Terminator"),
                new Human("Катя"),
        };
        // Это препятствие 1- беговая дорожка. 2- стена
        Obstacle obstacles[] = {
                new Wall(),
                new Treadmill(),
                new Wall(),
                new Treadmill(),
                new Wall(),
                new Treadmill(),
                new Wall(),
                new Treadmill(),
                new Wall(),
                new Treadmill(),
                new Wall(),
                new Treadmill(),
                new Wall(),
                new Treadmill(),
                new Wall(),
                new Treadmill()
        };


        for (RunAndJump t:team) {
            for (Obstacle o:obstacles) {
                o.take(t);
            }
        }
        DayOfWeek dayOfWeek = DayOfWeek.Thursday;
        dayOfWeek.getWorkHours();
    }
}
