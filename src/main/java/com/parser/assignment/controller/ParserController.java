package com.parser.assignment.controller;

import com.parser.assignment.service.ParserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ParserController {

    private final ParserService parserService;

    @GetMapping(value = {"/","/index"})
    public  String main(){
        return  "index";
    }

// 문자열 분리처리만하고 화면단으로 보내는 방법이라  채택하지않았습니다
//    @PostMapping(value = "/v1/parser")
//    public String parser (@RequestParam("assign") String sql, Model model){
//
//        System.out.println(sql);
//        String[] words = sql.split("\\s+");
//
//        List<String> extractedWords = new ArrayList<>();
//
//        for (String word : words) {
//            if (word.contains("(") && word.contains(")")) {
//                int startIndex = word.indexOf("(");
//                int endIndex = word.indexOf(")");
//                if (endIndex > startIndex) {
//                    String firstPart = word.substring(0, startIndex);
//                    String secondPart = word.substring(startIndex + 1, endIndex);
//                    extractedWords.add(firstPart);
//                    extractedWords.add(secondPart);
//                }
//            } else {
//                extractedWords.add(word);
//            }
//        }
//
//        for (String extractedWord : extractedWords) {
//            System.out.println(extractedWord);
//        }
//
//
//        model.addAttribute("words", extractedWords);
//        return  "index";
//    }
//
// 맵방식으로 적용하였으나 맵의 키값이 중복이안되 일부 단어들이 출력이 되지않아서 채택하지않았습니다.
//    @PostMapping(value = "/v2/parser")
//    public String parser2 (@RequestParam("assign") String sql, Model model){
//        System.out.println(sql);
//        Map<String, String> result = parserService.parsingSql(sql);
//
//        for (Map.Entry<String, String> entry : result.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + value);
//        }
//        model.addAttribute("resultMap", result);
//        return  "index";
//    }


    @PostMapping(value = "/v3/parser")
    public String parser4(@RequestParam("assign") String sql, Model model) {
        List<String []> resultList = parserService.parsingSql3(sql);

        model.addAttribute("resultList", resultList);
        return "index";
    }




}
