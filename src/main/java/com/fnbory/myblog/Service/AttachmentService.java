package com.fnbory.myblog.Service;

import com.fnbory.myblog.entities.Attachment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AttachmentService {
    /**
     * 保存
     *
     * @param attachment
     */
    void save(Attachment attachment) throws Exception;

    /**
     * 分页查询附件
     *
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Attachment> getAttachment(int page, int limit);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Attachment findById(int id);

    /**
     * 删除
     *
     * @param id
     */
    void deleteAttachment(int id) throws Exception;

    /**
     * 所有附件
     *
     * @return
     */
    List<Attachment> countAttachment();
}
