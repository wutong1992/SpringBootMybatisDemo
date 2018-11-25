package com.example.demo2;

public class JacksonDemo {
    public static void main(String[] args) {
        String sql = "3654782\\552462";
        System.out.println(sql);
        System.out.println(sql.replaceAll("[\r\n/\\\\]+",""));
    }
}
