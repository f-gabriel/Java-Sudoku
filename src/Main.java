class Main {
  GameBoard gameBoard = new GameBoard();

  public void main(String[] args){
    int i = 0;
    while (!gameBoard.isSolvable()){
      i++;
      this.gameBoard = new GameBoard();
    }
    System.out.println(i);
    System.out.println(gameBoard.toString());
  }


}
