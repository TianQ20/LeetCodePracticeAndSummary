public class state_diagram {
    public void state_diagram(int input, int content, int capacity, boolean isSealable, boolean isFull) {
        while (input + content < capacity) {
            content += input;
        }

        if (content + input >= capacity) {
            isFull = true;
        }

        if (isSealable) {
            System.out.println("is sealed");
        }
    }
}
