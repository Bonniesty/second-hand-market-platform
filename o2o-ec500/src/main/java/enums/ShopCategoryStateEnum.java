package enums;

public enum ShopCategoryStateEnum {
	SUCCESS(0, "Create Success"), INNER_ERROR(-1001, "Fail"), EMPTY(-1002, "Area is empty");

	private int state;

	private String stateInfo;

	private ShopCategoryStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static ShopCategoryStateEnum stateOf(int index) {
		for (ShopCategoryStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
