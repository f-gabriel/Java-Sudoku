package Enums;

public enum SQUARE_POSITION {
    CORNER(new int[]{0, 2, 6, 8}),
    HORIZONTAL(new int[]{1,7}),
    VERTICAL(new int[]{3,5}),
    MIDDLE(new int[]{4});

    final int[] squareNumbers;

    private SQUARE_POSITION(int[] squareNumbers) {
        this.squareNumbers = squareNumbers;
    }

    public int[] getSquareNumbers() {
        return squareNumbers;
    }

    public static SQUARE_POSITION getSquarePosition(int squareNumber) {
        return switch (squareNumber){
            case 0, 2, 6, 8 -> SQUARE_POSITION.CORNER;
            case 1, 7 -> SQUARE_POSITION.VERTICAL;
            case 3, 5 -> SQUARE_POSITION.HORIZONTAL;
            case 4 -> SQUARE_POSITION.MIDDLE;
            default -> throw new IllegalStateException("Unexpected value: " + squareNumber);
        };
    }
}

