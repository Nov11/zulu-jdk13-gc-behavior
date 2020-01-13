package pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -Xmx100m -Xlog:gc*
 * last applicable allocation : 5* 10m
 * oom : 6 * 10m
 *
 * -Xmx8g
 * last applicable : 678 * 4m
 * oom : 679 * 4m
 */
public class DriveZGC {
    private static final Logger logger = LoggerFactory.getLogger(DriveZGC.class);

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 2048; i++) {
            list.add(AllocationUtil.tenMega());
            logger.info("{} * 4m", i + 1);
        }

        logger.info("size : {}", list.size());
        Thread.sleep(10 * 1000);
    }
}
