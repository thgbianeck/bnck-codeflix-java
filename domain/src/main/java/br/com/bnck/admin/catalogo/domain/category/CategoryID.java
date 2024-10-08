package br.com.bnck.admin.catalogo.domain.category;

import java.util.Objects;
import java.util.UUID;

import br.com.bnck.admin.catalogo.domain.Identifier;

public class CategoryID extends Identifier{
    private final String value;

    private CategoryID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static CategoryID unique() {
        return CategoryID.from(UUID.randomUUID().toString().toLowerCase());
    }

    public static CategoryID from(final String anId) {
        return new CategoryID(anId);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
