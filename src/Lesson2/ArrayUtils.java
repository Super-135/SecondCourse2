package Lesson2;

public class ArrayUtils {

    public long arraySum(String [][] array) throws ArraySizeException {

        long sum = 0;

        if (array[0].length > 4 || array.length >4) {
            throw new ArraySizeException("Размер массива больше чем 4х4");
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j].matches("[0-9]+")) {
                    sum += Integer.parseInt(array[i][j]);
                    System.out.print(array[i][j]);
                    System.out.print(",");
                }
                else {
                    throw new ArrayDataException("В array["+i+"]["+j+"]не int");
                }
            }
            System.out.println();
        }
        return sum;
    }
}
