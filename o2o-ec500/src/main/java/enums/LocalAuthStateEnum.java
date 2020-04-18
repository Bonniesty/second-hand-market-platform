package enums;

public enum LocalAuthStateEnum {
	LOGINFAIL(-1, "username/password incorrect"), SUCCESS(0, "Success"), NULL_AUTH_INFO(-1006,
			"Empty information"), ONLY_ONE_ACCOUNT(-1007,"only one acc allowed");

	private int state;

	private String stateInfo;

	private LocalAuthStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static LocalAuthStateEnum stateOf(int index) {
		for (LocalAuthStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
