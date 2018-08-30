public class Position implements Cloneable {

    private double x;
    private double y;

    public Position (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
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
