package ru.maksirep.technique_registry.api.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.maksirep.technique_registry.core.error.ErrorCode;
import ru.maksirep.technique_registry.core.error.ServiceException;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);
    public static final String INCORRECT_ARGUMENT = "Некорректный формат введенного аргумента";

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        return makeResponse(ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        ex.printStackTrace();
        return makeResponse(ex.getMessage(), ErrorCode.CRITICAL);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(MethodArgumentNotValidException ex) {
        return makeResponse(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage(), ErrorCode.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return makeResponse(INCORRECT_ARGUMENT, ErrorCode.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(HttpMessageNotReadableException ex) {
        return makeResponse(INCORRECT_ARGUMENT, ErrorCode.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> makeResponse(String message, ErrorCode errorCode) {
        logger.error(message);
        return new ResponseEntity<>(new ErrorResponse(message), getHttpStatus(errorCode));
    }

    private HttpStatus getHttpStatus(ErrorCode errorCode) {
        HttpStatus httpStatus;
        switch (errorCode) {
            case NOT_FOUND:
                httpStatus = HttpStatus.NOT_FOUND;
                break;
            case CRITICAL:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            default:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
        }
        return httpStatus;
    }
}
