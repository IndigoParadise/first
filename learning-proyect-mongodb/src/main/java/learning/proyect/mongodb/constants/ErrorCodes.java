package learning.proyect.mongodb.constants;

public enum ErrorCodes {
	SAVE_ERROR(0,"Could Not Save Customer"),
	FIND_ERROR(1,"Data provided was incorrect");
	public Integer code;
	public String description;
	private ErrorCodes(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
}
