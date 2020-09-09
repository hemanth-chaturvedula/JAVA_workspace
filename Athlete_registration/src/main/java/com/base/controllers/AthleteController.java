package com.base.controllers;
    
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.base.beans.Athlete;    
import com.base.dao.AthleteDao; 

@Controller
public class AthleteController {
	
    @Autowired    
    AthleteDao dao;
    
    @RequestMapping("/athleteform")    
    public String showform(Model m){    
        m.addAttribute("command", new Athlete());  
        return "athleteform";   
    }    
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("athlete") Athlete athlete){    
        dao.save(athlete);    
        return "redirect:/viewathlete";//will redirect to viewathlete request mapping    
    }    

    @RequestMapping("/viewathlete")    
    public String viewathlete(Model m){    
        List<Athlete> list=dao.getAthletes();    
        m.addAttribute("list",list);  
        return "viewathlete";    
    }    
    
    @RequestMapping(value="/editathlete/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Athlete athlete=dao.getAthleteById(id);    
        m.addAttribute("command", athlete);  
        return "athleteeditform";    
    }    

    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("athlete") Athlete athlete){    
        dao.update(athlete);    
        return "redirect:/viewathlete";    
    }    

    @RequestMapping(value="/deleteathlete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewathlete";    
    }     
}