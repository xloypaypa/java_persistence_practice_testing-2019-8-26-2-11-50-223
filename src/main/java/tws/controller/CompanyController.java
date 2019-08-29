package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tws.entity.Company;
import tws.entity.Employee;
import tws.mapper.CompanyMapper;
import tws.mapper.EmployeeMapper;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody Company company) {
        this.companyMapper.insert(company);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Company>> get() {
        return ResponseEntity.ok(this.companyMapper.get());
    }

}
