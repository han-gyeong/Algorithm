class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        String tmp = "";
        for (String s : new_id.split("")) {
            if (Character.isAlphabetic(s.charAt(0)) || Character.isDigit(s.charAt(0)) || s.equals("-") || s.equals("_") || s.equals(".")) {
                tmp += s;
            }
        }
        new_id = tmp;
        new_id = new_id.replaceAll("[.]+", ".");

        if (new_id.startsWith(".")) {
            new_id = new_id.replaceFirst(".", "");
        }

        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.length() == 0) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);

            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        if (new_id.length() <= 2) {
            while (new_id.length() != 3) {
                new_id += String.valueOf(new_id.charAt(new_id.length() - 1));
            }
        }

        return new_id;
    }
}