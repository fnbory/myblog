package com.fnbory.myblog.dao;

import com.fnbory.myblog.entities.Theme;
import com.fnbory.myblog.entities.ThemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThemeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int countByExample(ThemeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int deleteByExample(ThemeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int insert(Theme record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int insertSelective(Theme record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    List<Theme> selectByExample(ThemeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    Theme selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") Theme record, @Param("example") ThemeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByExample(@Param("record") Theme record, @Param("example") ThemeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByPrimaryKeySelective(Theme record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table theme
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    int updateByPrimaryKey(Theme record);
}