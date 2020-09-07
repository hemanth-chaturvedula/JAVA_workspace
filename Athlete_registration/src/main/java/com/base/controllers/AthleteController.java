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
    AthleteDao dao;//will inject dao from XML file    
        
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/athleteform")    
    public String showform(Model m){    
        m.addAttribute("command", new Athlete());  
        return "athleteform";   
    }    
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("athlete") Athlete athlete){    
        dao.save(athlete);    
        return "redirect:/viewathlete";//will redirect to viewemp request mapping    
    }    
    /* It provides list of employees in model object */    
    @RequestMapping("/viewemp")    
    public String viewemp(Model m){    
        List<Athlete> list=dao.getAthletes();    
        m.addAttribute("list",list);  
        return "viewathletes";    
    }    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editathlete/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Athlete athlete=dao.getAthleteById(id);    
        m.addAttribute("command", athlete);  
        return "empeditform";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("athlete") Athlete athlete){    
        dao.update(athlete);    
        return "redirect:/viewemp";    
    }    
    /* It deletes record for the given id in URL and redirects to /viewemp */    
    @RequestMapping(value="/deleteathlete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewathlete";    
    }     
}