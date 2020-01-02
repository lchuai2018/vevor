package com.vevor.erp.impl.person;


import com.vevor.erp.dao.PersonMapper;
import com.vevor.erp.domain.entity.person.Person;
import com.vevor.erp.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 15:26
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person findById(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }
}
