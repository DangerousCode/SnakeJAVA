import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake {

    private List<Position> positions;

    public Snake(double x, double y) {


        double initPositionX = x / 2;
        double initPositionY = y / 2;
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

    public boolean moveSnake(Food food) {

        Scanner scanner = new Scanner(System.in);
        char direction = scanner.next().charAt(0);

        //Auxiliar list to know old positions
        List<Position> oldPositions = new ArrayList<>();

        for (Position position :
                positions) {
            //We need to clone this thanks to make two separate lists without reference. (sigh)
            oldPositions.add(position.clone());

        }

        switch (direction) {
            case 'w':
                //Move up
                positions.get(0).setX(
                        positions.get(0).getX() - 1);

                break;

            case 'a':

                //Move left
                positions.get(0).setY(
                        positions.get(0).getY() - 1);

                break;
            case 's':

                //Move down
                positions.get(0).setX(
                        positions.get(0).getX() + 1);

                break;
            case 'd':

                //Move down
                positions.get(0).setY(
                        positions.get(0).getY() + 1);

                break;
        }

        //If next position is equal to apple's position, we need to add head's old position
        Position headPosition = positions.get(0);
        if (headPosition.getX() == food.getPosition().getX()
                && headPosition.getY() == food.getPosition().getY()) {

            positions.add(1, oldPositions.get(0));

            return true;
        } else {
            for (int i = 1; i < positions.size(); i++) {

                positions.set(i, oldPositions.get(i - 1));

            }
        }

        return false;
    }

    public Position getHead(){
        return this.getPositions().get(0);
    }
}
