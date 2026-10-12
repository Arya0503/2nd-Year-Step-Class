class AttendanceSheet {
    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (!isPresent(name) && this.count < this.presentStudents.length) {
            this.presentStudents[this.count] = name;
            this.count++;
        }
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return this.count;
    }
}

public class AttendanceSheetMain {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}