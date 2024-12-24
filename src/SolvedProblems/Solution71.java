package SolvedProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution71 {
    public String simplifyPath(String path) {
//        1. remove //
        String regex = "//"; // "(\\.\\.\\.)*[a-zA-Z_]+(\\.\\.\\.)*[aA_]*/\\.\\./"
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "/");
            matcher = pattern.matcher(path);
        }

//        2. remove /./
        regex = "/\\./";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll("/\\./", "/");
            matcher = pattern.matcher(path);
        }

//      3. remove [filename]/../
        regex = "[.]*[a-zA-Z_]+/\\.\\./";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "");
            matcher = pattern.matcher(path);
        }
//        4. remove leading /../
        regex = "^/\\.\\./";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "/");
            matcher = pattern.matcher(path);
        }

//      5. remove ending [filename]/..
        regex = "[a-zA-Z_]+/\\.\\.$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "");
            matcher = pattern.matcher(path);
        }

        regex = "/\\.$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "");
            matcher = pattern.matcher(path);
        }

        regex = "[a-zA-Z]*[.]*/\\.\\./$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "/");
            matcher = pattern.matcher(path);
        }

        regex = "[a-zA-Z]*[.]*/\\.\\.$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "/");
            matcher = pattern.matcher(path);
        }

        regex = "/$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "");
            matcher = pattern.matcher(path);
        }

        regex = "^\\.\\.$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(path);
        while (matcher.find()) {
            path = path.replaceAll(regex, "");
            matcher = pattern.matcher(path);
        }

        if (path.isEmpty() || path.charAt(0) != '/') {
            path = "/" + path;
        }


        return path;
    }
}
