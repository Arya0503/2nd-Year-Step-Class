public void parseStudentRecord(String csvLine) {
    String[] fields = csvLine.split(",");

    if (fields.length != 3) {
        System.out.println("Invalid Record");
    } else {
        System.out.println("Name: " + fields[0].trim() + " | Roll No: " + fields[1].trim() + " | Dept: " + fields[2].trim());
    }
}