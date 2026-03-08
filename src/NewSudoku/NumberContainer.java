package NewSudoku;

abstract public class NumberContainer implements INumberContainer {
    int name;
    int[] occupiedNumbers = new int[9];

    public NumberContainer(int name){
        this.name=name;
    }

    public NumberContainer(int name, int[] occupiedNumbers){
        this.name=name;
        this.occupiedNumbers=occupiedNumbers;
    }


    public int getName() {
        return name;
    }
    public int[] getOccupiedNumbers() {
        return occupiedNumbers;
    }
}
