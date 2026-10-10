public String normalizeReference(String raw) {
    if (raw == null) {
        return "";
    }

    String trimmed = raw.trim();

    if (trimmed.length() < 3) {
        return trimmed.toUpperCase();
    }

    return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
}

public String validateAndFormat(String reference) {
    String normalized = normalizeReference(reference);

    if (normalized.length() != 14) {
        return "Invalid: wrong length";
    }

    for (int i = 0; i < 3; i++) {
        if (!Character.isLetter(normalized.charAt(i))) {
            return "Invalid: bank code must be 3 letters";
        }
    }

    for (int i = 3; i < 14; i++) {
        if (!Character.isDigit(normalized.charAt(i))) {
            return "Invalid: non-digit body";
        }
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[").append(normalized.substring(0, 3)).append("] DATE: ");
    sb.append(normalized.substring(3, 5)).append("/");
    sb.append(normalized.substring(5, 7)).append("/");
    sb.append(normalized.substring(7, 9)).append(" | SEQ: ");
    sb.append(normalized.substring(9, 14));

    return sb.toString();
}