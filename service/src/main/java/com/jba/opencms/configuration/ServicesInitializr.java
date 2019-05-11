package com.jba.opencms.configuration;

import com.jba.opencms.base.AbstractService;
import com.jba.opencms.dao.ifs.EntryDao;
import com.jba.opencms.dao.ifs.MenuDao;
import com.jba.opencms.menu.EntryService;
import com.jba.opencms.menu.EntryServiceImpl;
import com.jba.opencms.menu.MenuService;
import com.jba.opencms.menu.MenuServiceImpl;
import com.jba.opencms.type.menu.Entry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(DaoConfiguration.class)
@EnableTransactionManagement
public class ServicesInitializr {

    @Bean
    public MenuService menuService(MenuDao menuDao, EntryDao entryDao){
        return new MenuServiceImpl(menuDao, entryDao);
    }

    @Bean
    public EntryService entryService(EntryDao entryDao){
        return new EntryServiceImpl(entryDao);
    }
}
