package com.fnbory.myblog.dao;

import com.fnbory.myblog.entities.Logs;
import com.fnbory.myblog.entities.LogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int countByExample(LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int deleteByExample(LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int deleteByPrimaryKey(Integer logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int insert(Logs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int insertSelective(Logs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    List<Logs> selectByExample(LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    Logs selectByPrimaryKey(Integer logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") Logs record, @Param("example") LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByExample(@Param("record") Logs record, @Param("example") LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByPrimaryKeySelective(Logs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table logs
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByPrimaryKey(Logs record);
}