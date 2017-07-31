package br.com.cinq.spring.data.sample.exception;

public class BaseResourceException extends RuntimeException {

    private static final long serialVersionUID = 6011730611878683208L;

    private final Object[] parameters;

    public BaseResourceException(final Object... parameters) {
        super();
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return this.parameters;
    }

}
