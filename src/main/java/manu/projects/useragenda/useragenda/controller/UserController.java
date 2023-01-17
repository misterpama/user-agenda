package manu.projects.useragenda.useragenda.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import javax.validation.Valid;
import manu.projects.useragenda.useragenda.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

  @Autowired UserRepository userRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcomePage() {
    return "welcome";
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String getAllUsers(ModelMap model) {
    model.put("paramUsers", userRepository.findAll());
//    model.addAttribute("user", new User());
    return "users";
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public String searchUsers(ModelMap model, @RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
    model.put("paramUsers", userRepository.findByNameContainingIgnoreCaseAndSurnameContainingIgnoreCase(name,
        surname));
    return "users";
  }

  @RequestMapping(value = "/add-user", method = RequestMethod.GET)
  public String showAddUserPage(ModelMap model) {
    model.addAttribute("user", new User(0, "name", "surname", "mail", "address"));
    return "user";
  }

  @RequestMapping(value = "/add-user", method = RequestMethod.POST)
  public String addUser(ModelMap model, @Valid User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("errorMessage", "Invalid email address");
      return "user";
    } else {
      userRepository.save(user);
      return "redirect:/users";
    }
  }

  @RequestMapping(value = "/update-user", method = RequestMethod.GET)
  public String showUpdateUserPage(ModelMap model, @RequestParam Integer id) {
    model.put("user", userRepository.findById(id));
    return "user";
  }

  @RequestMapping(value = "/update-user", method = RequestMethod.POST)
  public String updateUser(ModelMap model, @Valid User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("errorMessage", "Invalid email address");
      return "user";
    } else {
      userRepository.save(user);
      return "redirect:/users";
    }
  }

  @RequestMapping(value = "/delete-user", method = RequestMethod.GET)
  public String deleteUser(@RequestParam Integer id) {
    userRepository.deleteById(id);
    return "redirect:/users";
  }

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String uploadUsers(@RequestParam("file") MultipartFile file) throws IOException {
    Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
    CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader)
        .withType(User.class)
        .withIgnoreLeadingWhiteSpace(true)
        .build();
    List<User> users = csvToBean.parse();
    userRepository.saveAll(users);
    return "redirect:/users";
  }

}
