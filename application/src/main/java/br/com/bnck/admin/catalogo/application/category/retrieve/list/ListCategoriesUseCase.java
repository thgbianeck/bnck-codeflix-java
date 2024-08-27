package br.com.bnck.admin.catalogo.application.category.retrieve.list;

import br.com.bnck.admin.catalogo.application.UseCase;
import br.com.bnck.admin.catalogo.domain.category.CategorySearchQuery;
import br.com.bnck.admin.catalogo.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase
        extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}