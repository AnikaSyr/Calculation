package com.example.budget.controller;

import com.example.budget.exception.ClientNotFoundException;
import com.example.budget.model.Client;

import com.example.budget.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addClient (Model model){
        model.addAttribute("client", new Client());
        return "client";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String handle (@Valid Client client, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors()){
            logger.error("incorrect data");
            return "client";
        }
        clientService.save(client);
        ra.addFlashAttribute("message", "The client has been saved successfully");

        return "redirect:/client/find";
    }
    @GetMapping(value = "/find")
    public String getAll(Model model){
        List<Client> clients = clientService.listAllOrderById();
        model.addAttribute("clients", clients);
        return "clients";}

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {

        try {
            Client client = clientService.get(id);
            model.addAttribute("client", client);
            return "client_edit";
        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/client/find";
        }

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {

        try {
            clientService.delete(id);

        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/client/find";

    }

}
