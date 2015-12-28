package com.google.code.p.familysoft.financial.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.p.familysoft.financial.dao.AccountBookDAO;
import com.google.code.p.familysoft.financial.domain.Account;
import com.google.code.p.familysoft.financial.domain.AccountBook;



@Controller
@RequestMapping(value="/accountbook")
public class AccountBookController {
	

	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new AccountBook());
		return "accountbook/create";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid AccountBook accountBook, BindingResult result) {
		if (result.hasErrors()) {
			return "accountbook/create";
		}
		accountBookDAO.makePersistent(accountBook);
		return "redirect:/accountbook/" + accountBook.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Account item = null;
		model.addAttribute(item);
		return "accountbook/view";
	}
	
	private AccountBookDAO accountBookDAO;

	public AccountBookDAO getAccountBookDAO() {
		return accountBookDAO;
	}
	
	@Autowired
	public void setAccountBookDAO(AccountBookDAO accountBookDAO) {
		this.accountBookDAO = accountBookDAO;
	}
	
	
	
}
