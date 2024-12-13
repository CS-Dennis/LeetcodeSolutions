public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);

        sbA.reverse();
        int aLength = sbA.length();
        sbB.reverse();
        int bLength = sbB.length();

        StringBuilder result = new StringBuilder();

        boolean promote = false;
        if (aLength >= bLength) {
            for (int i = 0; i < bLength; i++) {
                if (sbA.charAt(i) == '1' && sbB.charAt(i) == '1') {
                    if (promote) {
                        result.append("1");
                    } else {
                        result.append("0");
                        promote = true;
                    }
                } else if (sbA.charAt(i) == '0' && sbB.charAt(i) == '0') {
                    if (promote) {
                        result.append("1");
                        promote = false;
                    } else {
                        result.append("0");
                    }
                } else {
                    if (promote) {
                        result.append("0");
                    } else {
                        result.append("1");
                    }
                }
            }

            for (int i = bLength; i < aLength; i++) {
                if (promote && sbA.charAt(i)=='1') {
                    result.append("0");
                } else if (promote && sbA.charAt(i)=='0') {
                    result.append("1");
                    promote = false;
                } else {
                    result.append(sbA.charAt(i));
                }
            }

            if (promote) {
                result.append("1");
            }
        } else {
            for (int i = 0; i < aLength; i++) {
                if (sbA.charAt(i) == '1' && sbB.charAt(i) == '1') {
                    if (promote) {
                        result.append("1");
                    } else {
                        result.append("0");
                        promote = true;
                    }
                } else if (sbA.charAt(i) == '0' && sbB.charAt(i) == '0') {
                    if (promote) {
                        result.append("1");
                        promote = false;
                    } else {
                        result.append("0");
                    }
                } else {
                    if (promote) {
                        result.append("0");
                    } else {
                        result.append("1");
                    }
                }
            }
            for (int i = aLength; i < bLength; i++) {
                if (promote && sbB.charAt(i) == '1') {
                    result.append("0");
                } else if (promote && sbB.charAt(i) == '0') {
                    result.append("1");
                    promote = false;
                } else {
                    result.append(sbB.charAt(i));
                }
            }

            if (promote) {
                result.append("1");
            }
        }

        return result.reverse().toString();
    }
}
