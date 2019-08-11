import org.omg.CORBA.UNKNOWN;

public class call {
    private String id;
    private double duration;
    private callsFeel callFeel;

    public call (String id, double length) {
        this.id = id;
        this.duration = length;
        callFeel = callsFeel.Unkown;
    }

    public void setCallFeel (callsFeel feel) {
        callFeel = feel;
    }

    public String getId() {
        return id;
    }

    public double getDuration() {
        return duration;
    }

    public callsFeel getCallFeel() {
        return callFeel;
    }
}
