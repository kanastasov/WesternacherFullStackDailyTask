package com.westernach.user.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.westernach.user.accounts.exceptions.AccountNotFoundException;
import com.westernach.user.accounts.model.Account;
import com.westernach.user.accounts.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public String showAllAcounts(Model model) {
		model.addAttribute("listAccounts", accountService.getAllAcounts());
		return "index";

	}

	// create model attribute to bind form data
	@GetMapping("/showAccountForm")
	public String showNewAccountForm(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "newAccount";
	}

	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("account") Account account) {
		accountService.saveAccount(account);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		try {
			Account account = accountService.getAccountById(id);
			model.addAttribute("account", account);

		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		return "updateAccount";
	}

	@GetMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable(value = "id") long id) {
		accountService.deleteAccountById(id);
		return "redirect:/";
	}

}
