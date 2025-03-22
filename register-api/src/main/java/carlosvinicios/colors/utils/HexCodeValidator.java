package carlosvinicios.colors.utils;

import java.util.regex.Pattern;

public class HexCodeValidator {
	private static final String HEX_PATTERN = "^#?([0-9a-fA-F]{6})$";

    public static boolean isValidHex(String hex) {
        if (hex == null || hex.isEmpty()){
            return false;
        }
        return Pattern.matches(HEX_PATTERN, hex);
    }
}	
