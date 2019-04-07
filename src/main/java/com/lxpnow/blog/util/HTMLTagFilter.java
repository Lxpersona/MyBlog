package com.lxpnow.blog.util;
//2019/3/14  16:10

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLTagFilter {

    private HTMLTagFilter(){}

    private static String reg="<([^>]*)>";

    public static String HTMLTagsFilter(String htmlText){

        Pattern pattern=Pattern.compile(reg);
        Matcher matcher=pattern.matcher(htmlText);
        htmlText=matcher.replaceAll("");
        return htmlText;
    }

}
