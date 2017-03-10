package com.scheduledemo.sdk.dal.mybatis;

import com.scheduledemo.model.JobError;
import com.scheduledemo.model.JobErrorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<K,E,X> {
  int countByExample(X example);

  int deleteByExample(X example);

  int deleteByPrimaryKey(K id);

  int insert(E record);

  int insertSelective(E record);

  List<E> selectByExample(X example);

  List<E> selectByExampleWithBLOBs(X example);

  E selectByPrimaryKey(K id);

  int updateByExampleSelective(@Param("record") E record, @Param("example") X example);

  int updateByExample(@Param("record") E record, @Param("example") X example);

  int updateByPrimaryKeySelective(E record);

  int updateByPrimaryKey(E record);

  int updateByExampleWithBLOBs(@Param("record") E record, @Param("example") X example);

  int updateByPrimaryKeyWithBLOBs(E record);

//  <T> List<E> selectByPage(PageModel<T> page);
}
