public class Position implements Cloneable {

    private int x;
    private int y;

    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Position clone(){
        Position position = null;
        try {
            position = (Position) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        return position;
    }
}
