package GameObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Brick extends GameObject{
    protected final Size size = new Size(2,4);
    protected final int capacity;   // the number of people should be within the capacity
    protected List<Ball> people = new ArrayList<>();

    public Brick(int i){
        capacity = i;
    }

    public void enter(){

    }

    public void leave() {

    }
}
