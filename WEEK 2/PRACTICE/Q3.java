public String validateFileExtension(String filename) {
    int dotIndex = filename.lastIndexOf('.');

    if (dotIndex == -1 || dotIndex == filename.length() - 1) {
        return "Rejected — invalid file type";
    }

    String extension = filename.substring(dotIndex + 1);

    if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("zip")) {
        return "Accepted";
    } else {
        return "Rejected — invalid file type";
    }
}