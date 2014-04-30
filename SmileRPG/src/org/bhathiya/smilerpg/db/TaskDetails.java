package org.bhathiya.smilerpg.db;


/**
 * Task Details Model
 * 
 * @author bhathiya
 *
 */
public class TaskDetails {
	
	private long id;
	
	private String title;
	private String subTitle;
		
	private int gainPhysical;
	private int gainMental;
	private int gainSchool;
	private int gainHouse;
	private int gainSocial;
	
	private int reward;
	
	public TaskDetails(long id, String title, String subTitle,
			int gainPhysical, int gainMental, int gainSchool, int gainHouse,
			int gainSocial, int reward, boolean isTemporary) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.gainPhysical = gainPhysical;
		this.gainMental = gainMental;
		this.gainSchool = gainSchool;
		this.gainHouse = gainHouse;
		this.gainSocial = gainSocial;
		this.reward = reward;
		this.isTemporary = isTemporary;
	}

	private boolean isTemporary;

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

	public int getGainPhysical() {
		return gainPhysical;
	}

	public void setGainPhysical(int gainPhysical) {
		this.gainPhysical = gainPhysical;
	}

	public int getGainMental() {
		return gainMental;
	}

	public void setGainMental(int gainMental) {
		this.gainMental = gainMental;
	}

	public int getGainSchool() {
		return gainSchool;
	}

	public void setGainSchool(int gainSchool) {
		this.gainSchool = gainSchool;
	}

	public int getGainHouse() {
		return gainHouse;
	}

	public void setGainHouse(int gainHouse) {
		this.gainHouse = gainHouse;
	}

	public int getGainSocial() {
		return gainSocial;
	}

	public void setGainSocial(int gainSocial) {
		this.gainSocial = gainSocial;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public boolean isTemporary() {
		return isTemporary;
	}

	public void setTemporary(boolean isTemporary) {
		this.isTemporary = isTemporary;
	}

	

	
}
