package storex.hashindex;

public class AppendLogOffsetInfo {
    private long startPosition;
    private int offset;

    public AppendLogOffsetInfo(long startPosition, int offset) {
        this.setOffset(offset);
        this.setStartPosition(startPosition);
    }

    public long getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(long startPosition) {
        this.startPosition = startPosition;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
