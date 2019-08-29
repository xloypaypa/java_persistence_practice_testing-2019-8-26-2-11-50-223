package tws.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tws.entity.Company;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Select("select * from company")
    List<Company> get();

    @Insert("insert into company values (#{company.id}, #{company.name})")
    void insert(@Param(value = "company") Company company);

}
