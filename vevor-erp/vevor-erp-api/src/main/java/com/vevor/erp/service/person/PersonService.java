package com.vevor.erp.service.person;


import com.vevor.erp.domain.entity.person.Person;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 15:26
 */
public interface PersonService {
    /**
     * 根据id 查询人员信息
     *
     * @param id
     * @return
     */
    Person findById(Integer id);
}
