class Util {
    public static String capitalize(String str) {
        if (str == null || str.isBlank()) {
            System.out.println("Before: " + str);
            System.out.println("After: " + str);
            return str;
        }

        if (str.length() == 1) {
            String result = str.toUpperCase();
            System.out.println("Before: " + str);
            System.out.println("After: " + result);

            return str.toUpperCase();
        }
        String result = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        System.out.println("Before: " + str);
        System.out.println("After: " + result);
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);

    }
}