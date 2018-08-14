public class Screen {

    int[][] dimension;
    Snake snake;

    public Screen(int x, int y) {
        dimension = new int[x][y];
        this.snake = new Snake(x, y);
    }

    public void drawScr() {

        for (int i = 0; i < dimension.length; i++) {
            System.out.print("/");
        }
        System.out.println();
        for (int x = 0; x < dimension.length; x++) {
            for (int y = 0; y < dimension[x].length; y++) {
                if (y == 0 || y == dimension[x].length - 1) {
                    System.out.print("/");
                }

                if (snake.getPositions().get(0).getX() == x
                        && snake.getPositions().get(0).getY() == y) {
                    //If position contains snake's head (position 0 of the positions list), print o
                    System.out.print("o");
                } else if (coordinatesInSnake(x, y)) {
                    //If position exists into snake's body, print an x
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < dimension.length; i++) {
            System.out.print("/");
        }
    }

    public void play() {

        boolean winner = false;
        boolean collision = false;

        while (!winner && !collision) {

            if (coordinatesInSnake(snake.getPositions().get(0).getX(),
                    snake.getPositions().get(0).getY())) {
                //Collision with its own body
                collision = true;
            }

            if (snake.getPositions().get(0).getX() == 0
                    || snake.getPositions().get(0).getY() == 0) {
                //TODO position = max X or max Y
                //If snake collides into a wall, end of the game.
                collision = true;
            }

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

    public boolean coordinatesInSnake(int x, int y) {

        //We need a sublist to compare only body.
        for (Position position :
                snake.getPositions().subList(1, snake.getPositions().size() - 1)) {

            if (position.getX() == x
                    && position.getY() == y) {

                return true;

            }
        }

        return false;

    }

}
