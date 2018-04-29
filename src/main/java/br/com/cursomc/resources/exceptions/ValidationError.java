package br.com.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> error = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timespamp){
        super(status, msg, timespamp);
    }

    public List<FieldMessage> getErrors() {
        return error;
    }

    public void addError(String fieldName, String message) {
        error.add(new FieldMessage(fieldName, message));
    }
}
