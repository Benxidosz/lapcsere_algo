package nqb6uo;

public class Frame implements Comparable {
    public boolean frozen;
    public int frozenCounter = 0;
    public boolean used;
    public int useTime = 0;
    public int page = -1;

    public final String id;

    public Frame(String id) {
        this.id = id;
        frozen = false;
        used = false;
    }

    public void use() {
        frozenCounter = 0;
        frozen = false;
        used = true;
        useTime = 0;
    }

    public void reset() {
        frozen = true;
        frozenCounter = 0;
        useTime = 0;
    }

    public void tick() {
        if (page >= 0) {
            ++frozenCounter;
            ++useTime;
            if (frozenCounter > 3) {
                frozen = false;
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        Frame other = (Frame) o;
        return Integer.compare(other.useTime, useTime);
    }
}
