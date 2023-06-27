package hl.hjc.newsdemo.utils;

import hl.hjc.newsdemo.entity.Comments;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentUtils {
    private static final Map<String, String> sensitiveWordsMap = new HashMap<>();

    static {
        // 初始化敏感词汇列表
        sensitiveWordsMap.put("共产党", "*");
        sensitiveWordsMap.put("政府", "*");
        sensitiveWordsMap.put("领导人", "*");
        sensitiveWordsMap.put("天安门", "*");
        sensitiveWordsMap.put("文革", "*");
    }

    public static Boolean judgeComment(Comments comment){
        String content = comment.getCcontent();

        if (content.length() < 3 || content.length() > 1000) {
            return false;
        }


        if (containsPersonalAttack(content)) {
            return false;
        }

        if (containsExcessiveRepetition(content)) {
            return false;
        }

        return true;
    }

    private static boolean containsSensitivePoliticalInfo(String content) {
        for (String word : sensitiveWordsMap.keySet()) {
            if (content.contains(word)) {
                return true;
            }
        }

        return false;
    }

    private static boolean containsPersonalAttack(String content) {
        String pattern = "(\\battack_word1\\b|\\battack_word2\\b|\\battack_word3\\b)";
        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(content);

        return matcher.find();
    }

    private static boolean containsExcessiveRepetition(String content) {
        Double threshold = 0.8; // 80%重复率的阈值

        String normalizedContent = content.replaceAll("\\s+", ""); // 去除空白字符
        int totalChars = normalizedContent.length();
        long uniqueChars = normalizedContent.chars().distinct().count();
        double repetitionRate = (double) (totalChars - uniqueChars) / totalChars;

        return repetitionRate > threshold;
    }

    public static String censorSensitiveWords(String content) {
        for (String word : sensitiveWordsMap.keySet()) {
            String censor = sensitiveWordsMap.get(word);
            content = content.replaceAll(word, censor);
        }

        return content;
    }
}
