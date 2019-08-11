import java.util.Random;
import java.util.Vector;

public class randomFeel implements Task  {
    Vector<call> callVec;
    public randomFeel (Vector<call> callsVec) {
        this.callVec = callsVec;
    }

    public void run () {
        doTask();
    }

    public void doTask() {
        for (call c : callVec) {
            Random r = new Random();
            int randomInt =  r.nextInt(3);
            switch (randomInt) {
                case (0):
                    c.setCallFeel(callsFeel.Positive);
                    break;
                case (1):
                    c.setCallFeel(callsFeel.Neutral);
                    break;
                case (2):
                    c.setCallFeel(callsFeel.Negative);
                    break;
                default:
                    c.setCallFeel(callsFeel.Unkown);
            }
        }
    }
}
