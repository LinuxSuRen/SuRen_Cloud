/**
 *
 */
package org.suren.service;

import java.util.List;

import org.suren.entity.Attachment;

/**
 * @author suren
 *
 */
public interface AttachmentService {
	void save(Attachment attachment);

	List<Attachment> find(Attachment attachment);
}
