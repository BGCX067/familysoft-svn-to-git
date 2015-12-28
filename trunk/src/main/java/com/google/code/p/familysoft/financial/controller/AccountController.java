package com.google.code.p.familysoft.financial.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.p.familysoft.financial.dao.AccountDAO;
import com.google.code.p.familysoft.financial.domain.Account;



@Controller
@RequestMapping(value="/account")
public class AccountController {
	

	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Account());
		return "account/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "account/createForm";
		}
		accountDAO.makePersistent(account);
		return "redirect:/account/" + account.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Account item = null;
		model.addAttribute(item);
		return "account/view";
	}
	
	private AccountDAO accountDAO;
	
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}
	
	@Autowired 
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
}
