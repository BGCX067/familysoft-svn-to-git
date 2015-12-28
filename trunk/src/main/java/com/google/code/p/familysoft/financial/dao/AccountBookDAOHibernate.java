package com.google.code.p.familysoft.financial.dao;

import org.springframework.stereotype.Repository;

import com.google.code.p.familysoft.core.dao.BaseDAOHibernate;
import com.google.code.p.familysoft.financial.domain.AccountBook;


@Repository("accountBookDAO")
public class AccountBookDAOHibernate extends BaseDAOHibernate<AccountBook, Long> implements AccountBookDAO{

}
