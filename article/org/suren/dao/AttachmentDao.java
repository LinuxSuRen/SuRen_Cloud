/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.suren.entity.Attachment;

/**
 * @author suren
 *
 */
public interface AttachmentDao {

	void saveAttachment(Attachment attachment);

	List<Attachment> findAttachment(Attachment attachment);
}
