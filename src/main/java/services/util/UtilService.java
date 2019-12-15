package services.util;

public interface UtilService {
    public static final String NAME = "UtilService";

    Integer parseIntegerFromString(String capacity);

    Boolean extractCheckBoxValue(String value);
}
