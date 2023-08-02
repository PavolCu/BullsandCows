class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        if (input == null) {
            // If the input is null, return 0 as the default value
            return 0.0;
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            // If an exception occurred during parsing, return 0 as the default value
            return 0.0;
        }
    }
}