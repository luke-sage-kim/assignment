package com.parser.assignment.parserEnum;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserEnum {
    public static enum Keyword {
        SELECT,
        FROM,
        WHERE,
        AND,
        LIKE,
        DELETE,
        UPDATE,
        BETWEEN,
        OR,
        REVOKE ,
        DISTINCT,
        JOIN,
        ON;

        public static Keyword findValue(String word){
            return Arrays.stream(values())
                    .filter(b -> b.toString().equals(word.toUpperCase()))
                    .findFirst()
                    .orElse(null);
        }
    }
    public static enum Function {
        MAX,
        SUM,
        COUNT,
        AVG;
        public static Function findValue(String word){
            return Arrays.stream(values())
                    .filter(b -> b.toString().equals(word.toUpperCase()))
                    .findFirst()
                    .orElse(null);
        }
    }
}
