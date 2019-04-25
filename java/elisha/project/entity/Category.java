package elisha.project.entity;

public enum Category {
	
	Phone("Phone"), Laptop("Laptop"), TV("TV"), Tablet("Tablet");
	
	String categoryType;
	
	Category(String categoryType)
	{
		this.categoryType = categoryType;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	
	

}
