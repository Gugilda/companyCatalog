package com.cbrf.semenov.testtask.repo;

import com.cbrf.semenov.testtask.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepo extends CrudRepository<Company, Integer>  {
    Company findByName(String name);
    Company findByINN(String INN);
    Company findByOGRN(String OGRN);

    List<Company> findByNameContaining(String name);
    List<Company> findByAddressContaining(String Address);
    List<Company> findByINNContaining(String INN);
    List<Company> findByOGRNContaining(String OGRN);
}
