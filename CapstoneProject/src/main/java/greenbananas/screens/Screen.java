package greenbananas.screens;

public class Screen {
    private int type;
    private int number;
    private int x, y;
    public final static int WIDTH = 20;
    public final static int HEIGHT = 20;

    public Screen(int type, int number, int x, int y) {
        this.type = type;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
