public class DSAHashEntry {
    public enum State {FREE, USED, PREVIOUSLY_USED};

    private String key;
    private Object value;
    private State state;

    public DSAHashEntry(String key, Object value) {
        this.key = key;
        this.value = value;
        this.state = State.USED;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}