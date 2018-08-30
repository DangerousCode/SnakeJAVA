import javafx.geometry.Pos;

import java.util.List;

public class Food {

    private Position position;

    public Food(List<Position> positions, double xDimension, double yDimension) {
        position = generateRandomFoodPosition(positions, xDimension, yDimension);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    //Needed to validate that food is not into snake
    private Position generateRandomFoodPosition(List<Position> notDesiredPositions, double xDimension, double yDimension) {
        int xRandom = (int) (Math.random() * xDimension);
        int yRandom = (int) (Math.random() * yDimension);
        Position position = new Position(xRandom, yRandom);
        if (!notDesiredPositions.contains(position)
                && xRandom != xDimension && xRandom != 0
                && yRandom != yDimension - 1 && yRandom != 0) {
            return position;
        } else {
            return generateRandomFoodPosition(notDesiredPositions, xDimension, yDimension);
        }
    }
}
