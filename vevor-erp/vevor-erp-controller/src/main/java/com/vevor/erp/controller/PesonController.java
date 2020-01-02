package com.vevor.erp.controller;


import com.vevor.core.service.CommonService;
import com.vevor.erp.domain.entity.person.Person;
import com.vevor.erp.service.person.PersonService;;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lichenghuai
 * @Date: 2019/12/16 15:25
 */
@Api(tags = {"人员api"})
@RestController
@RequestMapping("/person")
public class PesonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private CommonService commonService;
    @GetMapping("/aa")
    Person findById() {
        commonService.queryTest("1111");
        Person person = personService.findById(1);
        return person;
    }
    @ApiOperation(value="查找用户", notes="根据id来查找")
    @GetMapping("/{id}")
    public Person index(@PathVariable Integer id){

        Person person = personService.findById(id);
        return person;
    }

}
