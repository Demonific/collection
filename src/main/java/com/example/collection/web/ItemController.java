package com.example.collection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.collection.domain.Item;
import com.example.collection.domain.ItemRepository;

@Controller
public class ItemController {
	@Autowired
	private ItemRepository repository;
	
	@RequestMapping(value = "/itemlist")
	public String itemList(Model model) {
		model.addAttribute("items", repository.findAll());
		return "itemlist"; // return itemlist.html
	}
	// Palauttaa selaimeen tyhjän kirjalomakkeen
	@RequestMapping(value = "/additem", method = RequestMethod.GET)
	public String addbook(Model model) {
		model.addAttribute("item", new Item());
		return "additem";
	}
	// Tallentaa lomakkeelta lähetetyt kirjatiedot tietokantaan.
	@RequestMapping(value = "/saveitem", method = RequestMethod.POST)
	public String saveitem(Item item) {
		repository.save(item);
		return "redirect:/itemlist";
	}
    // Delete item
	 @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    // todo: suojaa delete-toiminto metoditasolla @PreAuthorize-annotaatiolla vain ADMIN-roolin omaaville käyttäjille
    public String deleteBook(@PathVariable("id") Long itemId, Model model) {
    	repository.deleteById(itemId);
        return "redirect:../itemlist";
    }     

}