package pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+UseG1GC -Xmx100m -Xlog:gc*:g1gc.log:time
 * 10m * 8, oom on 9th allocation of 10m
 *
 * -Xmx8g
 * last applicable: 1364 * 4m
 * oom on 1365 * 4m
 */
public class DriveG1 {
    private static final Logger logger = LoggerFactory.getLogger(DriveG1.class);

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 2048; i++) {
            list.add(AllocationUtil.fourMega());
            logger.info("{} * 4m", i + 1);
        }

        logger.info("size : {}", list.size());
        Thread.sleep(10 * 1000);
    }
}
