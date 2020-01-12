package pkg;

public class AllocationUtil {
    public static byte[] tenMega() {
        return new byte[10 * 1024 * 1024];
    }

    public static byte[] oneMega() {
        return new byte[1024 * 1024];
    }
}
