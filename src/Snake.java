import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Position> positions;

    public Snake(int x, int y) {


        int initPositionX = x / 2;
        int initPositionY = y / 2;
        positions = new ArrayList<>();

        //I initialize this to the middle of the screen
        for(int i = 0; i < 3; i++){
            Position position = new Position(initPositionX, initPositionY - i);
            this.positions.add(position);
        }
    }

    public List<Position> getPositions() {
        return positions;
    }
}
