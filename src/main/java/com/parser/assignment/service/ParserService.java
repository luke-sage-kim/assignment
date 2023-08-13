package com.parser.assignment.service;

import com.parser.assignment.parserEnum.ParserEnum;
import com.parser.assignment.parserEnum.ParserEnum.Function;
import com.parser.assignment.parserEnum.ParserEnum.Keyword;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.StringReader;
import java.util.*;

import static com.parser.assignment.parserEnum.ParserEnum.Keyword.findValue;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParserService {
    //맵방식을 적용한 서비스문입니다
//    public Map<String, String> parsingSql(String sql) {
//        Map<String,String> result = new LinkedHashMap<>();
//        String [] splitSql = sql.split("\\n");
//
//        StringBuilder multiCommentBuilder = new StringBuilder();
//        boolean multi = false;
//        for (String line : splitSql) {
//            System.out.println("line = " + line);
//
//            if(multiCommentBuilder.length() != 0) multiCommentBuilder.append("\n");
//            String [] splitWord = line.split("([,()\\s]+)");
//            boolean comment = false;
//            StringBuilder commentBuilder = new StringBuilder();
//
//            for (String word : splitWord) {
//                System.out.println("word = " + word);
//
//                if(word.equals("/*")) multi = true;
//                if(word.equals("*/")){
//                    multi = false;
//                    multiCommentBuilder.append(word+" ");
//                    result.put(multiCommentBuilder.toString(),"주석");
//                    continue;
//                }
//
//                if(multi == true ) {
//                    multiCommentBuilder.append(word+" ");
//                    continue;
//                }
//
//                if(word.equals("--")) comment = true;
//
//                if(comment == true){
//                    commentBuilder.append(word);
//                    continue;
//                }
//
//                if(findValue(word) != null){
//                    result.put(word,"keyword");
//                    continue;
//                } else if(Function.findValue(word) != null){
//                    result.put(word,"function");
//                    continue;
//                } else if(word.startsWith("‘")){
//                    result.put(word,"문자열");
//                    continue;
//                } else if(word.startsWith(":")){
//                    result.put(word,"Binding 변수");
//                    continue;
//                } else {
//                    result.put(word,"ETC");
//                    continue;
//                }
//
//            }
//
//            if(comment ==true) result.put(commentBuilder.toString(),"주석");
//        }
//        return result;
//    }
    public List<String[]> parsingSql3(String sql) {

        List<String []> resultList = new ArrayList<>();
        String[] splitSql = sql.split("\\n");

        StringBuilder multiCommentBuilder = new StringBuilder();
        boolean multi = false;
        for (String line : splitSql) {

            if (multiCommentBuilder.length() != 0) {
                multiCommentBuilder.append("\n");
            }
            String[] splitWord = line.split("([,()\\s]+)");
            boolean comment = false;
            StringBuilder commentBuilder = new StringBuilder();

            for (String word : splitWord) {

                if (word.equals("/*")) {
                    multi = true;
                }
                if (word.equals("*/")) {
                    multi = false;
                    multiCommentBuilder.append(word + " ");
                    resultList.add(new String[]{multiCommentBuilder.toString(), "주석"});
                    continue;
                }

                if (multi) {
                    multiCommentBuilder.append(word + " ");
                    continue;
                }

                if ("--".equals(word)) {
                    comment = true;
                }

                if (comment) {
                    commentBuilder.append(word+ " ");
                    continue;
                }
                String valueType;
                if (findValue(word) != null) {
                    valueType = "keyword";
                } else if (Function.findValue(word) != null) {
                    valueType = "function";
                } else if (word.startsWith("‘")) {
                    valueType = "문자열";
                } else if (word.startsWith(":")) {
                    valueType = "Binding 변수";
                } else {
                    valueType = "ETC";
                }
                resultList.add(new String[]{word, valueType});
            }

            if (comment == true) {
                resultList.add(new String[]{commentBuilder.toString(), "주석"});
            }
        }
        return resultList;
    }




}
