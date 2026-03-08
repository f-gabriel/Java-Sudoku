package NewSudoku;

public class Row extends NumberContainer {
    private Row(int name, int[] occupiedNumber){
        super(name, occupiedNumber);
    }
    private Row(int name, int[] occupiedNumber, int squareNumber){}



    public Row createRow(int name, int[] occupiedNumbers) {
        if(occupiedNumbers==null || occupiedNumbers.length!=9){
            return null;
        }
        for(int number:occupiedNumbers){
            if(number<1 || number>9){
                return null;
            }
        }
        return new Row(name, occupiedNumbers);
    }
}
