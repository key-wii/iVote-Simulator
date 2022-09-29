import java.util.Vector;

public final class Student {
    private String ID;

    public void init(String myId) {
        ID = myId;
    }

    public String pickAnswerRan(Vector<String> As) { 
        int ranIndex = (int)(Math.random() * As.size());
        return As.get(ranIndex);
    }
    public String getId() {
        return ID;
    }
}