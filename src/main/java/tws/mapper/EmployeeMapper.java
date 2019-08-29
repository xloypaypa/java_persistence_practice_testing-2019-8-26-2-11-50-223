package tws.mapper;

import org.apache.ibatis.annotations.*;
import tws.entity.Company;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    //todo 把company弄进Employee里
    @Results(value = {
            @Result(property = "id", column = "employee_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
    })
    @Select("select e.employee_id, e.name, e.age, c.id, c.name as company_name from employee e left join company c on e.company_id = c.id")
    List<Employee> get(int startIndex, int pageSize);

    @Insert("insert into employee values (#{employee.id}, #{employee.name}, #{employee.age}, #{companyId})")
    void insert(@Param(value = "employee") Employee employee, int companyId);

}
