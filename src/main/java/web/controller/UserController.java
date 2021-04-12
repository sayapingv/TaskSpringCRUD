package web.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.dao.UserDAO;
import web.model.User;
import web.model.UserCreationList;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/users")
    public String printUsers(Model model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "users";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        UserCreationList userList = new UserCreationList();
        userList.addUser(new User());

        model.addAttribute("form", userList);
        return "create";
    }

    @PostMapping("/save")
    public String saveBooks(@ModelAttribute UserCreationList form, Model model) {
        userDAO.save(form.getUsers());

        model.addAttribute("books", userDAO.getAllUsers());
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        List<User> users = new ArrayList<>();
        userDAO.getAllUsers().iterator().forEachRemaining(users::add);

        model.addAttribute("form", new UserCreationList(users));
        return "/edit";
    }

}
