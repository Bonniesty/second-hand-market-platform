package enums;

public enum ShopStateEnum {
	CHECK(0, "Under Verifying"), OFFLINE(-1, "Invalid"), SUCCESS(1, "Success"), PASS(2, "Verified"), INNER_ERROR(-1001,
			"Inter Error"), NULL_SHOPID(-1002, "ShopId is Null"),NULL_SHOP(-1003, "shop info is empty");
	private int state;
	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

}
