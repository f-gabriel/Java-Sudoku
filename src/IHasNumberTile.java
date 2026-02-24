import java.util.List;

public interface IHasNumberTile {

    public int getRealValue();
    public int getInputValue();
    public void setInputValue(int input_value);
    public List<Integer> getViableNumbers(List<Integer> nonViableNumbers);
}
