import java.util.Vector;

public class CallsVector {
    private Vector <call> calls;

    private static CallsVector ourInstance = new CallsVector();

    public static CallsVector getInstance() {
        return ourInstance;
    }

    private CallsVector() {
        this.calls = new Vector<>();
    }

    public Vector<call> getCalls () {
        return calls;
    }
    
    public void addCall (call c) {
        this.calls.add(c);
    }

}
