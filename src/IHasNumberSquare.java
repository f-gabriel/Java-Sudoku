import java.util.List;

public interface IHasNumberSquare {

    public int getStartValue();
    public int getInputValue();
    public void setInputValue(int input_value);
    public List<Integer> getViableNumbers(List<Integer> nonViableNumbers);
}
