package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.mapper.EmployeeMapper;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody Employee employee) {
        this.employeeMapper.insert(employee);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Employee>> get() {
        return ResponseEntity.ok(this.employeeMapper.get(3, 2));
    }

}
