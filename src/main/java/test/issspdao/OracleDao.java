package test.issspdao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import test.issspentity.OracleEnty;
import test.macentity.ModelData;


@Repository("oracleDao")
public interface OracleDao {
 public List<String> findModel(@Param("startDate")String startDate,@Param("endDate")String endDate);
 public List<ModelData> findModelData(@Param("startDate")String startDate,@Param("endDate")String endDate,@Param("ids")String[] modelll);
 public List<String> findModelDataString(@Param("startDate")String startDate,@Param("endDate")String endDate,@Param("ids")String[] modelll);
}
