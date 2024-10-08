package com.andreitoledo.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andreitoledo.brewer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping("/cervejas/novo")
	public String novo(Model model) {
		model.addAttribute(new Cerveja());
		return "cerveja/CadastroCerveja";
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {	
			model.addAttribute(cerveja);
			return "cerveja/CadastroCerveja";			
		}
		
		// salvar no banco de dados...

		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso !");
		System.out.println(">>> sku : " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
	@RequestMapping("/cervejas/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}

}
