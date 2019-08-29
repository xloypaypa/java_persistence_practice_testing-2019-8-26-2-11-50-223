package tws.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee order by id OFFSET #{startIndex} ROWS FETCH NEXT #{pageSize} ROWS ONLY")
    List<Employee> get(int startIndex, int pageSize);

    @Insert("insert into employee values (#{employee.id}, #{employee.name}, #{employee.age})")
    void insert(@Param(value = "employee") Employee employee);

}
