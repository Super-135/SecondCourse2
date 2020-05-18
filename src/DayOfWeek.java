public enum DayOfWeek {
    Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5), Saturday(6), Sunday(7);

   private int number;

    public int getNumber() {
        return number;
    }

    DayOfWeek(int number) {
        this.number = number;
    }

    // 6-ть так как текущий день тоже считаем.
    public void getWorkHours(){
        if (this.number == 6 || this.number == 7) {
            System.out.println("Ура сегодня выходной");
        } else {
            System.out.println("До конца недели осалось "+((6-this.number)*8)+" часов");
        }

    }


}
