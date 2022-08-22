package dp;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position forward(int dy) {
        return new Position(x, y+dy);
    }

    public Position backward(int dy) {
        return new Position(x, y-dy);
    }

    public Position left(int dx) {return new Position(x-dx,y);}

    public Position right(int dx) {
        return new Position(x+dx, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}
