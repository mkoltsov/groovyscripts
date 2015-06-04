import java.awt.Robot;
import java.util.Random;


def FIVE_SECONDS = 5000;
def MAX_Y = 400;
def MAX_X = 400;

Robot robot = new Robot();
Random random = new Random();
while (true) {
    robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
    Thread.sleep(FIVE_SECONDS);
}

