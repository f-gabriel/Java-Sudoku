package NewSudoku;

abstract public class NineTiles {
    int name;
    int[] occupiedNumbers = new int[9];

    public NineTiles(int name){
        this.name=name;
    }

    public NineTiles(int name, int[] occupiedNumbers){
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
