package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu/*")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("list")
    public String findMenuList(Model model){

        // 전체 메뉴 조회는 MenuDTO 타입이 여러 개 이기 때문에
        // List
        List<MenuDTO> menuList = menuService.findAllMenus();
        // DB 조회 값이 잘 들어있는 지 확인용
        for (MenuDTO menu : menuList)
            System.out.println("menu = " + menu);

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("regist")
    public void registPage() {}

    /* comment.
    *   @ResponseBody 어노테이션은
    *   기존의 Controller 의 역할은 view 를 마지막에
    *   리턴하는 것이 의무이다. 하지만, @ResponseBody 는
    *   view 를 리턴하는 의무가 아닌, 데이터를
    *   리턴할 수 있게 만든다.
    *   json -> 자바스크립트 객체 표기법을 의미한다.
    * */
    @GetMapping(value = "category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {

        return menuService.findAllCategory();
    }

}
