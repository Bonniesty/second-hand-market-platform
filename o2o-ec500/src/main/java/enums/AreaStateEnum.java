package enums;

public enum AreaStateEnum {
	OFFLINE(-1, "illegal"), SUCCESS(0, "Success"), INNER_ERROR(-1001, "Fail"), EMPTY(
			-1002, "empty information");

	private int state;

	private String stateInfo;

	private AreaStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static AreaStateEnum stateOf(int index) {
		for (AreaStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
