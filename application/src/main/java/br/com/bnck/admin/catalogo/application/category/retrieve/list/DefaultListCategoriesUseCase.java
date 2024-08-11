package br.com.bnck.admin.catalogo.application.category.retrieve.list;

import java.util.Objects;

import br.com.bnck.admin.catalogo.domain.category.CategoryGateway;
import br.com.bnck.admin.catalogo.domain.category.CategorySearchQuery;
import br.com.bnck.admin.catalogo.domain.pagination.Pagination;

public class DefaultListCategoriesUseCase extends ListCategoriesUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultListCategoriesUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Pagination<CategoryListOutput> execute(final CategorySearchQuery aQuery) {
        return this.categoryGateway.findAll(aQuery)
                .map(CategoryListOutput::from);
    }
}