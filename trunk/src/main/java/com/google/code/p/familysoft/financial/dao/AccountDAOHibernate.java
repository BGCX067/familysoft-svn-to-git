package com.google.code.p.familysoft.financial.dao;


import org.springframework.stereotype.Repository;

import com.google.code.p.familysoft.core.dao.BaseDAOHibernate;
import com.google.code.p.familysoft.financial.domain.Account;


@Repository("accountDAO")
public class AccountDAOHibernate extends BaseDAOHibernate<Account, Long> implements
		AccountDAO {
	
}
