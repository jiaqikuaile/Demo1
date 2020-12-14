package test.macdao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import test.macentity.MailService;
import test.macentity.ScenarioDefinedModel;
import test.macentity.Subject;

//@Repository("mysqlDao")
//@MyBatisRepository
public interface MysqlDao {
  public ScenarioDefinedModel findByIdentiftCode(@Param("code")String code);
  public Subject findByIdSelectSubject(@Param("id")String id);
  public List<String> findModel(@Param("model")String[] model,@Param("scenId")String scenId);
  public MailService findMailServer(@Param("serviceId")String serviceId);
}
