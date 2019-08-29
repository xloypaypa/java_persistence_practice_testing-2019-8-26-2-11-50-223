package tws.mapper;

import org.apache.ibatis.annotations.*;
import tws.entity.Company;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "employees", javaType = List.class, column = "id", many = @Many(select = "getEmp"))
    })
    @Select("select * from company")
    List<Company> get();

    @Select("select * from employee where company_id = #{companyId}")
    List<Employee> getEmp(int companyId);

    @Insert("insert into company values (#{company.id}, #{company.name})")
    void insert(@Param(value = "company") Company company);

}
