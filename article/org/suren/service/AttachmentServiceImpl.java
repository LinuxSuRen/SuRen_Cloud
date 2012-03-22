/**
 *
 */
package org.suren.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.AttachmentDao;
import org.suren.entity.Attachment;

/**
 * @author suren
 *
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentDao dao;
	@Override
	public void save(Attachment attachment) {
		attachment.setUploadTime(new Date());

		dao.saveAttachment(attachment);
	}
	@Override
	public List<Attachment> find(Attachment attachment) {
		return dao.findAttachment(attachment);
	}

}
