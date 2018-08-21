import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

public class Application {

    private static final int X_DIMENSION = 20;
    private static final int Y_DIMENSION = 20;
    private static Screen screen;

    public static void main(String[] args) {

        screen = new Screen(X_DIMENSION, Y_DIMENSION);
        play();

    }

    private static void play() {

        boolean winner = false;
        boolean collision = false;
        screen.generateFood();
        Snake snake = screen.getSnake();

        while(!winner && !collision){

            screen.drawScr();

            //If snake eats food, generate new food
            boolean foodEaten = snake.moveSnake(screen.getFood());
            if(foodEaten){
                screen.setFood(new Food(snake.getPositions(), X_DIMENSION, Y_DIMENSION));
            }
            collision = screen.checkCollision();

        }
        screen.drawScr();
        if (collision) {
            System.out.println("\nYou lose");
        } else {
            System.out.println("\nYou win");
        }

    }

}
