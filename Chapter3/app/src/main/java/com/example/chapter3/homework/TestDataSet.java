package com.example.chapter3.homework;

import java.util.ArrayList;
import java.util.List;

public class TestDataSet {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("浙大一名學生準備猝死", "1999.6w"));
        result.add(new TestData("林俊杰7月10日線上演唱会", "700.8w"));
        result.add(new TestData("西施喜提FMVP皮肤", "658.8w"));
        result.add(new TestData("足球是有什么动靜", "504.6w"));
        result.add(new TestData("世冠皮肤給到趙云不給百里", "490.8w"));
        result.add(new TestData(" b站崩了", "183.2w"));
        result.add(new TestData("豆瓣崩了", "139.4w"));
        result.add(new TestData(" 比尔盖茨承认是自己搞砸了婚姻 ", "75.6w"));
        result.add(new TestData("在搜熱搜的你", "55w"));
        result.add(new TestData("Milet什么時候有演唱会", "43w"));
        result.add(new TestData("怎樣才能輕鬆退學", "22.2w"));
        return result;
    }

}
