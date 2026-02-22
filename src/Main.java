import java.util.Arrays;

class Main {
  GameBoard gameBoard = new GameBoard();

  public void main(String[] args){
    while (gameBoard.getNumberSquareAtPos(8,8) == null){
      this.gameBoard = new GameBoard();
    }
    System.out.println(gameBoard.toString());
  }


}
