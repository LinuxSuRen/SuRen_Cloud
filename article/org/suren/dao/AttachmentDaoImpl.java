/**
 *
 */
package org.suren.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.Attachment;

/**
 * @author suren
 *
 */
@Service
public class AttachmentDaoImpl extends BaseDao<Attachment> implements
		AttachmentDao {

	/* (non-Javadoc)
	 * @see org.suren.dao.AttachmentDao#saveAttachment(org.suren.entity.Attachment)
	 */
	@Override
	public void saveAttachment(Attachment attachment) {
		this.save(attachment);
	}

	@Override
	public Class<?> setClass() {
		return Attachment.class;
	}

	@Override
	public List<Attachment> findAttachment(Attachment attachment) {
		Criteria criteria = this.getCritera();

		if(attachment != null)
		{
			if(attachment.getId() != null)
			{
				List<Attachment> attach = new ArrayList<Attachment>();

				attach.add(this.findById(attachment.getId()));

				return attach;
			}

			if(attachment.getName() != null)
			{
				criteria.add(Restrictions.like("name", "%" + attachment.getName() + "%"));
			}

			if(attachment.getRemark() != null)
			{
				criteria.add(Restrictions.like("remark", "%" + attachment.getRemark() + "%"));
			}
		}

		return this.findByCriteria(criteria);
	}

}
