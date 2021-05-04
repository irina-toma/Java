public abstract class Tourist implements Comparable<Tourist> {
    abstract int getPriority();

    public int compareTo(Tourist o) {
        return this.getPriority() - o.getPriority();
    }
}
