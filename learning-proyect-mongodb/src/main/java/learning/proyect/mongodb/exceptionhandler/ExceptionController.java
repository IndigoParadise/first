package learning.proyect.mongodb.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import learning.proyect.mongodb.constants.ErrorCodes;
import learning.proyect.mongodb.exception.DeleteCustomerException;
import learning.proyect.mongodb.exception.MongoDBError;
import learning.proyect.mongodb.exception.SaveCustomerException;
import learning.proyect.mongodb.exception.SearchCustomerException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	private MongoDBError errorDB;
	@ExceptionHandler(SaveCustomerException.class)
	public ResponseEntity<Object> handleSaveCostumerException(SaveCustomerException exception,WebRequest request){
		errorDB=new MongoDBError();
		errorDB.setErrorCode(ErrorCodes.SAVE_ERROR.code);
		errorDB.setErrorDescription(ErrorCodes.SAVE_ERROR.description);
		errorDB.setPath(request.getContextPath());
		errorDB.setErrorType(exception.getClass().descriptorString());
		return new ResponseEntity<>(errorDB,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DeleteCustomerException.class)
	public ResponseEntity<Object> handleDeleteCustomerException(DeleteCustomerException exception,WebRequest request){
		errorDB=new MongoDBError();
		errorDB.setErrorCode(ErrorCodes.FIND_ERROR.code);
		errorDB.setErrorDescription(ErrorCodes.FIND_ERROR.description);
		errorDB.setPath(request.getContextPath());
		errorDB.setErrorType(exception.getClass().descriptorString());
		return new ResponseEntity<>(errorDB,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SearchCustomerException.class)
	public ResponseEntity<Object> handleSearchCustomerException(SearchCustomerException exception,WebRequest request){
		errorDB=new MongoDBError();
		errorDB.setErrorCode(ErrorCodes.FIND_ERROR.code);
		errorDB.setErrorDescription(ErrorCodes.FIND_ERROR.description);
		errorDB.setPath(request.getContextPath());
		errorDB.setErrorType(exception.getClass().descriptorString());;
		return new ResponseEntity<>(errorDB,HttpStatus.NOT_FOUND);
	}
	
}
