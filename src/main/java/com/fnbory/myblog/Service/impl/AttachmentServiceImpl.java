package com.fnbory.myblog.Service.impl;

import com.fnbory.myblog.Service.AttachmentService;
import com.fnbory.myblog.dao.AttachmentMapper;
import com.fnbory.myblog.entities.Attachment;
import com.fnbory.myblog.entities.AttachmentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AttachmentServiceImpl implements AttachmentService {

	private static final String ATTACHMENTS_CACHE_NAME = "attachments";

	@Autowired
	private AttachmentMapper attachmentMapper;

	@Override
	@CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void save(Attachment attachment) throws Exception {
		attachmentMapper.insert(attachment);
	}

	@Override
	public PageInfo<Attachment> getAttachment(int page, int limit) {
		PageHelper.startPage(page, limit);
		AttachmentExample example = new AttachmentExample();
		example.setOrderByClause("id desc");
		List<Attachment> lists = attachmentMapper.selectByExample(example);
		return new PageInfo<>(lists);
	}

	@Override
	@Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findById'+#id")
	public Attachment findById(int id) {
		return attachmentMapper.selectByPrimaryKey(id);
	}

	@Override
	@CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void deleteAttachment(int id) throws Exception {
		attachmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'countAttachment'")
	public List<Attachment> countAttachment() {
		return attachmentMapper.selectByExample(null);
	}

}
