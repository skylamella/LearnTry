package cn.xiaoji.lucky.vo;

/***
 * 错误信息实体类
 * @author lamella
 *
 */
public class ErrorCode {
	private String ErrorCodeName;
	private String ErrorCodeText;

	public String getErrorCodeName() {
		return ErrorCodeName;
	}

	public void setErrorCodeName(String errorCodeName) {
		ErrorCodeName = errorCodeName;
	}

	public String getErrorCodeText() {
		return ErrorCodeText;
	}

	public void setErrorCodeText(String errorCodeText) {
		ErrorCodeText = errorCodeText;
	}

}
