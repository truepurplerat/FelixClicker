package util;

import com.thepigrat.felixclicker.Main;

public class ProducerThread extends Thread{
    @Override
    public void run() {
        Main.game.get().generate();
        super.run();
    }
}
