package org.bhathiya.smilerpg.db;

/**
 * Reward Details Model
 * @author bhathiya
 *
 */
public class RewardDetails {
	private long id;
	
	private String title;
	private String subTitle;

	private int cost;
	
	private boolean isTemporary;

	public RewardDetails(long id, String title, String subTitle, int cost,
			boolean isTemporary) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.cost = cost;
		this.isTemporary = isTemporary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isTemporary() {
		return isTemporary;
	}

	public void setTemporary(boolean isTemporary) {
		this.isTemporary = isTemporary;
	}
	
	
}
