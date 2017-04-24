package client;


import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import alb.util.date.DateUtil;

@XmlRootElement(name = "task")
public class Task implements Comparable<Task>, Serializable {

	private static final long serialVersionUID = 7840461741626423043L;

	private Long id;

	private String title;
	private String comments;
	private Date created = DateUtil.today();
	private Date planned;
	private Date finished;

	private Long categoryId;
	private Long userId;

	@XmlElement
	public Long getId() {
		return id;
	}

	public Task setId(Long id) {
		this.id = id;
		return this;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public Task setTitle(String title) {
		this.title = title;
		return this;
	}

	@XmlElement
	public String getComments() {
		return comments;
	}

	public Task setComments(String comments) {
		this.comments = comments;
		return this;
	}

	@XmlElement
	public Date getCreated() {
		return created;
	}

	public Task setCreated(Date created) {
		this.created = created;
		return this;
	}

	@XmlElement
	public Date getPlanned() {
		return planned;
	}

	public Task setPlanned(Date planned) {
		this.planned = planned;
		return this;
	}

	@XmlElement
	public Date getFinished() {
		return finished;
	}

	public Task setFinished(Date finished) {
		this.finished = finished;
		return this;
	}

	@XmlElement
	public Long getCategoryId() {
		return categoryId;
	}

	public Task setCategoryId(Long category_id) {
		this.categoryId = category_id;
		return this;
	}

	@XmlElement
	public Long getUserId() {
		return userId;
	}

	public Task setUserId(Long user_id) {
		this.userId = user_id;
		return this;
	}

	public boolean isLate() {
		if (planned != null) {
			// return planned.before(new Date());
			return DateUtil.diffDays(new Date(), this.planned) > 0;
		} else {
			return false;
		}
	}

	public boolean isFinish() {
		if (finished != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", title=" + title + ", comments="
				+ comments + ", created=" + created + ", planned=" + planned
				+ ", finished=" + finished + ", categoryId=" + categoryId
				+ ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((finished == null) ? 0 : finished.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((planned == null) ? 0 : planned.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (finished == null) {
			if (other.finished != null)
				return false;
		} else if (!finished.equals(other.finished))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (planned == null) {
			if (other.planned != null)
				return false;
		} else if (!planned.equals(other.planned))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public int compareTo(Task o) {
		if (this.planned == null) {
			if (o.getPlanned() == null) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (o.getPlanned() == null) {
				return 1;
			}
		}
		return this.planned.compareTo(o.getPlanned());
	}

}
