public class GameLoop implements Runnable{

    private final double updateRate = 1.0d/60.0d;
    long nextStatTime;
    int fps, ups;
    private Game game;
    private boolean running;
    GameLoop(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while (running) {
            currTime = System.currentTimeMillis();
            double lastRenderTime = (currTime - lastUpdate) / 1000d;
            accumulator += lastRenderTime;
            lastUpdate = currTime;
            if(accumulator >= updateRate) {
                while (accumulator >= updateRate) {
                    update();
                    accumulator -= updateRate;
                }
                render();
            }
            printStats();
        }
    }

    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime) {
            System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;

    }
    private void render() {
        game.render();
        fps++;
    }
}
