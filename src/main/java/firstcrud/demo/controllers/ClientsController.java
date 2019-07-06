package firstcrud.demo.controllers;
import java.util.List;


import firstcrud.demo.beans.Clients;
import firstcrud.demo.dao.ClientsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientsController {
    @Autowired
    ClientsDao dao;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showMainPage(){
        return "index";
    }

    @RequestMapping("/ClientsForm")
    public String showForm(Model m){
    m.addAttribute("command", new Clients());
    return "ClientsForm";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("client") Clients client)
    {
        dao.addAll(client);
        return "/redirect://ViewClients";
    }

    @RequestMapping("/ViewClients")
    public String viewClients(Model m){
        List<Clients> list=dao.getClients();
        m.addAttribute("list",list);
        return "viewClients";
    }
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.deleteAll(id);
        return "redirect:/ViewClients";
    }
    @RequestMapping(value="/EditClient/{id}")
    public String edit(@PathVariable int id, Model m){
        Clients client=dao.getClientById(id);
        m.addAttribute("command",client);
        return "ClientEditForm";
    }
    @RequestMapping(value="/EditSave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") Clients client){
        dao.update(client);
        return "redirect:/ViewClients";
    }
}

