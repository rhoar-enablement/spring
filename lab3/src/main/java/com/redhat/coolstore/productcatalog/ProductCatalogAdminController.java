package com.redhat.coolstore.productcatalog;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductCatalogAdminController {
		
	@Autowired
	ProductRepository repository;
	
	
	@RequestMapping(value="/admin/productlist",method=GET)
	public String admin(Model model) {
		model.addAttribute("prodList", repository.findAll());
		return "productList";
	}
	
	@RequestMapping(value="/admin/product/{itemId}",method=GET)
	public String showProductForm(@PathVariable("itemId") long itemId, Model model) {
		model.addAttribute("product",repository.findOne(itemId));
		return "productForm";
	}
	
	@RequestMapping(value="/admin/product/add",method=GET)
	public String showProductForm(Model model) {
		model.addAttribute("product",new Product());
		return "productForm";
	}
	
	@RequestMapping(value="/admin/product/delete/{itemId}",method=GET)
	public String showProductForm(@PathVariable("itemId") long itemId) {
		repository.delete(itemId);
		return "redirect:/admin/productlist";
	}
	
	@RequestMapping(value="/admin/product/*",method=POST)
	public String processProductForm(@ModelAttribute("product") Product product) {
		repository.save(product);
		return "redirect:/admin/productlist";

	}
}
