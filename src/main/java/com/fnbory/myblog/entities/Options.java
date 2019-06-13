package com.fnbory.myblog.entities;

import java.io.Serializable;

public class Options implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column options.option_name
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    private String optionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column options.option_value
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    private String optionValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table options
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column options.option_name
     *
     * @return the value of options.option_name
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column options.option_name
     *
     * @param optionName the value for options.option_name
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column options.option_value
     *
     * @return the value of options.option_value
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public String getOptionValue() {
        return optionValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column options.option_value
     *
     * @param optionValue the value for options.option_value
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table options
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", optionName=").append(optionName);
        sb.append(", optionValue=").append(optionValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}