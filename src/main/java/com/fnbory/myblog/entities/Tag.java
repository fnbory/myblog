package com.fnbory.myblog.entities;

import java.io.Serializable;

public class Tag implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.tag_id
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    private Integer tagId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.tag_name
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    private String tagName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.tag_url
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    private String tagUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tag
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.tag_id
     *
     * @return the value of tag.tag_id
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.tag_id
     *
     * @param tagId the value for tag.tag_id
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.tag_name
     *
     * @return the value of tag.tag_name
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.tag_name
     *
     * @param tagName the value for tag.tag_name
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.tag_url
     *
     * @return the value of tag.tag_url
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public String getTagUrl() {
        return tagUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.tag_url
     *
     * @param tagUrl the value for tag.tag_url
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    public void setTagUrl(String tagUrl) {
        this.tagUrl = tagUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed Jun 05 13:12:14 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", tagName=").append(tagName);
        sb.append(", tagUrl=").append(tagUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}