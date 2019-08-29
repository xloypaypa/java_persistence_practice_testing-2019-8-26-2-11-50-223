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
            @Result(property = "company", column = "company_id", one = @One(select = "tws.mapper.CompanyMapper.get"))
    })
    @Select("select * from employee e")
    List<Employee> get(int startIndex, int pageSize);

    @Insert("insert into employee values (#{employee.id}, #{employee.name}, #{employee.age}, #{companyId})")
    void insert(@Param(value = "employee") Employee employee, int companyId);

}
