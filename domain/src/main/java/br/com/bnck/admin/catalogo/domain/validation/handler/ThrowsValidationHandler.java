package br.com.bnck.admin.catalogo.domain.validation.handler;

import java.util.List;

import br.com.bnck.admin.catalogo.domain.exceptions.DomainException;
import br.com.bnck.admin.catalogo.domain.validation.Error;
import br.com.bnck.admin.catalogo.domain.validation.ValidationHandler;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public <T> T validate(final Validation<T> aValidation) {
        try {
            return aValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(new Error(ex.getMessage()));
        }
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }

}
