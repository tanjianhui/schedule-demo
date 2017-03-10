package com.scheduledemo.sdk.service;

import com.scheduledemo.model.Job;
import com.scheduledemo.sdk.dal.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public abstract class BaseService<K,E,X,M extends BaseMapper<K,E,X>>{
  protected abstract M getMapper();

  public int countByExample(X example){
    return getMapper().countByExample(example);
  }

  public List<E> selectByExample(X example){
    return getMapper().selectByExample(example);
  }

  public E selectByPrimaryKey(K id){
    return getMapper().selectByPrimaryKey(id);
  }

  /*public <T> List selectByPage(PageModel<T> page){
    return getMapper().selectByPage(page);
  }*/

  @Transactional
  public int deleteByExample(X example){
    return getMapper().deleteByExample(example);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int deleteByExampleRN(X example){
    return getMapper().deleteByExample(example);
  }

  @Transactional
  public int deleteByPrimaryKey(K id){
    return getMapper().deleteByPrimaryKey(id);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int deleteByPrimaryKeyRN(K id){
    return getMapper().deleteByPrimaryKey(id);
  }

  @Transactional
  public int insert(E record){
    return getMapper().insert(record);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int insertRN(E record){
    return getMapper().insert(record);
  }

  @Transactional
  public int insertSelective(E record){
    return getMapper().insertSelective(record);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int insertSelectiveRN(E record){
    return getMapper().insertSelective(record);
  }

  @Transactional
  public int updateByExampleSelective(@Param("record") E record, @Param("example") X example){
    return getMapper().updateByExampleSelective(record,example);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int updateByExampleSelectiveRN(@Param("record") E record, @Param("example") X example){
    return getMapper().updateByExampleSelective(record,example);
  }

  @Transactional
  public int updateByExample(@Param("record") E record, @Param("example") X example){
    return getMapper().updateByExample(record,example);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int updateByExampleRN(@Param("record") E record, @Param("example") X example){
    return getMapper().updateByExample(record,example);
  }

  @Transactional
  public int updateByPrimaryKeySelective(E record){
    return getMapper().updateByPrimaryKeySelective(record);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int updateByPrimaryKeySelectiveRN(E record){
    return getMapper().updateByPrimaryKeySelective(record);
  }

  @Transactional
  public int updateByPrimaryKey(E record){
    return getMapper().updateByPrimaryKey(record);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public int updateByPrimaryKeyRN(E record){
    return getMapper().updateByPrimaryKey(record);
  }
}