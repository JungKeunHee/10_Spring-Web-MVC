package com.ohgiraffers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/lecture/*")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv) {

        mv.addObject("member", new MemberDTO("정근희", 20, '남', "서울시 동대문구"));

        mv.addObject("hello", "hi~~<h2>타임리프</h2>");

        mv.setViewName("lecture/expression");

        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv) {

        mv.addObject("num", 1);
        mv.addObject("str", "바나나");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("정그리", 4, '남', "서울시 동대문구"));
        memberList.add(new MemberDTO("줭구리", 1, '남', "서울시 성동구"));
        memberList.add(new MemberDTO("정꾸리", 4, '남', "서울시 강남구"));
        memberList.add(new MemberDTO("저엉구우리이", 4, '남', "서울시 서초구"));

        mv.addObject("memberList", memberList);

        mv.setViewName("lecture/conditional");

        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){

        SearchCriteria criteria = new SearchCriteria(1, 10, 3);

        // key, value 형식으로 저장 가능하지만, key 를 작성하지 않을 시
        // 인스턴스의 타입 = 클래스 명이 곧 키값이 된다.
        mv.addObject(criteria);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("정그리", 4, '남', "서울시 동대문구"));
        memberList.add(new MemberDTO("줭구리", 1, '남', "서울시 성동구"));
        memberList.add(new MemberDTO("정꾸리", 4, '남', "서울시 강남구"));
        memberList.add(new MemberDTO("저엉구우리이", 4, '남', "서울시 서초구"));

        mv.addObject("memberList", memberList);

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("1", new MemberDTO("정그리1", 1, '남', "서울시 동대문구1"));
        memberMap.put("2", new MemberDTO("정근희2", 2, '남', "서울시 동대문구2"));
        memberMap.put("3", new MemberDTO("정그리3", 3, '남', "서울시 동대문구3"));
        memberMap.put("4", new MemberDTO("정그리4", 4, '남', "서울시 동대문구4"));

        mv.addObject("memberMap", memberMap);

        mv.setViewName("lecture/etc");

        return mv;
    }

}
