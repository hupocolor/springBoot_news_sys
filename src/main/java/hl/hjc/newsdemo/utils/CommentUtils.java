package hl.hjc.newsdemo.utils;

import hl.hjc.newsdemo.entity.Comments;

public class CommentUtils {
    public static Boolean judgeComment(Comments comment){
        String content = comment.getCcontent();
        if (content.length() < 3) return false;
        if (content.length() > 1000) return false;
        return true;
    }
}
