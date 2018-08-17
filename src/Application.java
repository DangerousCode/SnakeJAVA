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
        screen.drawScr();

        while(!winner && !collision){

            screen.moveSnake();

            screen.drawScr();

            collision = screen.checkCollision();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if (collision) {
            System.out.println("Puto manco");
        } else {
            System.out.println("Mu bien campeon");
        }

    }

}
