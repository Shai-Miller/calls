import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        CallsVector calls = CallsVector.getInstance();

        createCalls();

        Thread t1 = new Thread(new randomFeel(calls.getCalls()));
        t1.run();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("test.txt"));
            for (call curr : calls.getCalls()) {
                writer.write(" call id: "+curr.getId() + " call duration: " + curr.getDuration() + " call feels: " + curr.getCallFeel().toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createCalls () {
        CallsVector calls = CallsVector.getInstance();

        for (int i=0; i<10; i++) {
            int leftLimit = 48; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int j = 0; j < targetStringLength; j++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String id = buffer.toString();

            double len = ThreadLocalRandom.current().nextDouble(0, 10);
            len = (double)Math.round(len * 1000d) / 1000d;
            call c = new call(id,len);
            calls.addCall(c);
        }
    }

}
