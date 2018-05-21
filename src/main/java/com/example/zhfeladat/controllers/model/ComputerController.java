package com.example.zhfeladat.controllers.model;

import com.example.zhfeladat.models.Computer;
import com.example.zhfeladat.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/computer")
public class ComputerController implements WebMvcConfigurer {

    private ComputerService computerService;

    @Autowired
    public void setComputerService(ComputerService computerService) {
        this.computerService = computerService;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/list")
    public ModelAndView getAll(){
        List<Computer> computerList = computerService.getAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("computerList", computerList);
        mav.setViewName("computer-list-form");

        return mav;
    }

    @GetMapping("/init")
    @ResponseBody
    public boolean createComputer(){
        Computer computer = new Computer();
        computer.setName("Computer név");
        computer.setNumber(52546);
        computer.setPrice(200000);
        computerService.add(computer);

        return true;
    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        computerService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @GetMapping("")
    public String showComputer(ComputerModel computerModel){
        return "computer-form";
    }

    @PostMapping("")
    public String saveComputer(@Valid ComputerModel computerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "computer-form";
        }

        Computer computer = new Computer();
        computer.setName(computerModel.getName());
        computer.setNumber(computerModel.getNumber());
        computer.setPrice(computerModel.getPrice());
        computerService.add(computer);

        redirectAttributes.addFlashAttribute("newComputer", computerModel);
        return "redirect:/results";
    }
}
