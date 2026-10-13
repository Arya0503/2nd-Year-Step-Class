import java.util.Arrays;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];
        k = k % n;

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2)));

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7)));
    }
}