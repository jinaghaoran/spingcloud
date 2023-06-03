package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ${8801}
 *
 * @Author jhr
 * @Date 2023/6/3
 */// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
@SpringBootApplication
public class Main8801 {
    public static void main(String[] args) {
        // 当文本光标位于高亮显示的文本处时按 Opt+Enter，
        // 可查看 IntelliJ IDEA 对于如何修正该问题的建议。
        System.out.print("Hello and welcome!");
        SpringApplication.run(Main8801.class,args);
    }
}
