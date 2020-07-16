package learning.proyect.mongodb.exception;

import java.sql.Timestamp;
import java.util.Date;

public class MongoDBError {
	
	private String errorDescription;
	private Integer errorCode;
	private String path;
	private String errorType;
	private Date date= new Date();
	private Timestamp timestamp;
	
	public MongoDBError() {
		timestamp=new Timestamp(date.getTime());
	}
	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	
	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
