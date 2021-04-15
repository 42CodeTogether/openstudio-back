package com.codetogether.openstudio.contorller.admin;

import com.codetogether.openstudio.config.auth.LoginUser;
import com.codetogether.openstudio.dto.auth.SessionUser;
import com.codetogether.openstudio.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin/members")
@Controller
public class MembersAdminController {

    private final MemberService memberService;

    @GetMapping("")
    public String dashboard(Model model, @LoginUser SessionUser user) {
        model.addAttribute("userName", user.getName());
        model.addAttribute("members", memberService.findAllDesc());

        return "admin/members";
    }

    @GetMapping("/update/{id}")
    public String memberUpdatePage(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.findById(id));
        return "admin/members-update";
    }

    @GetMapping("/save")
    public String memberSavePage(Model model) {
        return "admin/members-save";
    }
}