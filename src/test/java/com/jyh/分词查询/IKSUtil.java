package com.jyh.分词查询;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyh
 * @date 2020/1/9
 * @description
 */

public class IKSUtil {

    public static List<String> getStringList(String text) throws IOException {
        StringReader stringReader = new StringReader(text);
        IKSegmenter ikSegmenter = new IKSegmenter(stringReader, true);
        Lexeme lexeme;
        List<String> s = new ArrayList<>();
        while ((lexeme = ikSegmenter.next()) != null) {
            s.add(lexeme.getLexemeText());
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            List<String> strings = getStringList("上海麻婆豆腐哈哈奥奥奥舔狗");
            System.out.println(strings);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
