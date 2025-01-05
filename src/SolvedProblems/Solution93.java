package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipList = new ArrayList<>();

        findValidIps(s, "", 0, ipList);

        return ipList;
    }

    private void findValidIps(String currentString, String currentIpString, int integersAdded, List<String> ipList) {
        if (integersAdded == 4) {
            ipList.add(currentIpString);
        } else if (integersAdded == 3) {
//            1 integer left to create ip
            if (currentString.length() <= 3 && !currentString.isEmpty()) {
                if (currentString.length() == 1) {
                    findValidIps("", currentIpString + "." + currentString, integersAdded + 1, ipList);
                } else if (currentString.charAt(0) != '0' && Integer.parseInt(currentString) <= 255) {
                    findValidIps("", currentIpString + "." + currentString, integersAdded + 1, ipList);
                }
            }
        } else {
            boolean b = currentString.length() >= 3 && Integer.parseInt(currentString.substring(0, 3)) <= 255;
            if (integersAdded == 2) {
                //            2 integers left to create ip
                if (currentString.length() >= 2 && currentString.length() <= 6) {
                    if (currentString.charAt(0) == '0') {
                        findValidIps(currentString.substring(1), currentIpString + "." + currentString.substring(0, 1), integersAdded + 1, ipList);
                    } else if (b) {
                        findValidIps(currentString.substring(1), currentIpString + "." + currentString.substring(0, 1), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(2), currentIpString + "." + currentString.substring(0, 2), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(3), currentIpString + "." + currentString.substring(0, 3), integersAdded + 1, ipList);
                    } else {
                        findValidIps(currentString.substring(1), currentIpString + "." + currentString.substring(0, 1), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(2), currentIpString + "." + currentString.substring(0, 2), integersAdded + 1, ipList);
                    }
                }
            } else if (integersAdded == 1) {
                //            3 integers left to create ip
                if (currentString.length() >= 3 && currentString.length() <= 9) {
                    if (currentString.charAt(0) == '0') {
                        findValidIps(currentString.substring(1), currentIpString + "." + currentString.substring(0, 1), integersAdded + 1, ipList);
                    } else if (b) {
                        findValidIps(currentString.substring(1), currentIpString + "." + currentString.substring(0, 1), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(2), currentIpString + "." + currentString.substring(0, 2), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(3), currentIpString + "." + currentString.substring(0, 3), integersAdded + 1, ipList);
                    } else {
                        findValidIps(currentString.substring(1), currentIpString + "." + currentString.substring(0, 1), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(2), currentIpString + "." + currentString.substring(0, 2), integersAdded + 1, ipList);
                    }
                }
            } else if (integersAdded == 0) {
                //            4 integers left to create ip
                if (currentString.length() >= 4 && currentString.length() <= 12) {
                    if (currentString.charAt(0) == '0') {
                        findValidIps(currentString.substring(1), currentString.substring(0, 1), integersAdded + 1, ipList);
                    } else if (b) {
                        findValidIps(currentString.substring(1), currentString.substring(0, 1), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(2), currentString.substring(0, 2), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(3), currentString.substring(0, 3), integersAdded + 1, ipList);
                    } else {
                        findValidIps(currentString.substring(1), currentString.substring(0, 1), integersAdded + 1, ipList);
                        findValidIps(currentString.substring(2), currentString.substring(0, 2), integersAdded + 1, ipList);
                    }
                }
            }
        }
    }
}
