import java.util.Arrays;

public enum SquarePosition {
    CORNER(new int[]{0, 2, 6, 8}),
    HORIZONTAL(new int[]{1,7}),
    VERTICAL(new int[]{3,5}),
    MIDDLE(new int[]{4});

    int[] squareNumbers;

    private SquarePosition(int[] squareNumbers) {
        this.squareNumbers = squareNumbers;
    }
    public int[] getSquareNumbers() {
        return squareNumbers;
    }
     static SquarePosition getSquarePosition(int squareNumber) {
        return switch (squareNumber){
            case 0, 2, 6, 8 -> SquarePosition.CORNER;
            case 1, 7 -> SquarePosition.VERTICAL;
            case 3, 5 -> SquarePosition.HORIZONTAL;
            case 4 -> SquarePosition.MIDDLE;
            default -> throw new IllegalStateException("Unexpected value: " + squareNumber);
        };
    }
}

